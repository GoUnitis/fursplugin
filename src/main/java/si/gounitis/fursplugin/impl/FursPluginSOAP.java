//********************************************************************************
//
//    Copyright (C) 2015  GoUnitis, Jurij Zelic s.p.
//
//    This program is free software; you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation; either version 2 of the License, or
//    (at your option) any later version.
//
//    This program is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU Lesser General Public License for more details.
//
//********************************************************************************
//    Revision history:
//        12.10.2015: J. Zelic - First Version
//********************************************************************************
package si.gounitis.fursplugin.impl;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import si.gounitis.fursplugin.FursObject;
import si.gounitis.fursplugin.FursPlugin;
import si.gounitis.fursplugin.FursPluginException;
import si.gounitis.fursplugin.beans.CadastralData;
import si.gounitis.fursplugin.beans.Invoice;
import si.gounitis.fursplugin.beans.Premise;
import si.gounitis.fursplugin.beans.SwProvider;
import si.gounitis.fursplugin.helpers.Sign;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import si.gounitis.fursplugin.helpers.SignApache;

public class FursPluginSOAP implements FursPlugin{

    private static final String PING_STRING="Mnogo let za tem, ko je Polkovnik Aureliano Buendia";
    private static final int ID_LENGTH=36;

    private static final String FU_NAMESPACE="http://www.fu.gov.si/";
    private static final String SOAPENV_NAMESPACE="http://schemas.xmlsoap.org/soap/envelope/";
    private static final String SOAPENV_NAMESPACE_PREFIX="soapenv";
    private static final String FU_NAMESPACE_PREFIX="fu";
    private static final String SIGN_ELEMENT_ID="data";

    private static final String SOAP_PREPEND = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
            "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xd=\"http://www.w3.org/2000/09/xmldsig#\">\n" +
            "\t<soapenv:Body>";
    private static final String SOAP_APPEND ="\t</soapenv:Body>\n" +
            "</soapenv:Envelope>";

    private String url;

    /**
     * Constructor
      * @param url - webservice URL address
     */
    public FursPluginSOAP(String url) {

        this.url=url;
    }

    /**
     * register new premise (mobile or real estate) at FURS
     *
     * @param uuid - unique message ID (could be genertebd by si.gounitis.fursplugin.helpers.Tools.getNewUiid()
     * @param premise - premise data POJO
     * @param signingCertAlias - name of signing certificate in a keystore
     */
    public void registerPremise(String uuid, Premise premise, String signingCertAlias) throws FursPluginException {

        checkInput(uuid, premise);

        try {
            Document businessPremiseRequest=getBusinessPremiseRequest(uuid, premise);
            Document signedBusinessPremiseRequest = SignApache.signDocument(businessPremiseRequest, "#" + SIGN_ELEMENT_ID, "signcert");
            documentToFile(signedBusinessPremiseRequest,"temp/dokument.xml");



            System.out.println(documentToString(signedBusinessPremiseRequest));

            Map<String, String> httpHeaders= new HashMap<String, String>();
            httpHeaders.put("Content-Type","text/xml; charset=UTF-8");
            httpHeaders.put("SOAPAction","/invoices/register");

            String soapResponse = httpPost(this.url, httpHeaders, documentToString(signedBusinessPremiseRequest));
            System.out.println(soapResponse);


        } catch (IOException e) {
            throw new FursPluginException(e);
        } catch (Exception e) {
            throw new FursPluginException(e);
        }

    }

    private void parsePremiseResponse(SOAPMessage reply) throws FursPluginException {
        try {
            SOAPPart soapPart = reply.getSOAPPart();
            SOAPEnvelope envelope = soapPart.getEnvelope();
            SOAPBody body = envelope.getBody();
            Document businessPremiseResponse = body.getOwnerDocument();
        }  catch (SOAPException e) {
            throw new FursPluginException(e);
        }

    }

    /**
     * issue an invoice
     *
     * @param uuid - unique message ID (could be genertebd by si.gounitis.fursplugin.helpers.Tools.getNewUiid()
     * @param invoice - invoice data POJO
     * @param signingCertAlias - name of signing certificate in a keystore
     * @return invoice ID
     */
    public String issueInvoice(String uuid, Invoice invoice, String signingCertAlias) throws FursPluginException{
        checkInput(uuid, invoice);

        try {
            Document invoiceRequest=getInvoiceRequest(uuid, invoice);
            Document signedInvoiceRequest = Sign.signDocument(invoiceRequest, "#"+SIGN_ELEMENT_ID, "signcert");
            String httpPayload=SOAP_PREPEND+documentToString(signedInvoiceRequest)+SOAP_APPEND;

            Map<String, String> httpHeaders= new HashMap<String, String>();
            httpHeaders.put("Content-Type","text/xml; charset=UTF-8");
            httpHeaders.put("SOAPAction","/invoices");

            String soapResponse = httpPost(this.url, httpHeaders, httpPayload);

            // check signature
            // todo
            // check error value
            // todo
            // extract id
            // todo

            return null;

        } catch (IOException e) {
            throw new FursPluginException(e);
        }

    }

    /**
     * check FURS connectivity
     */
    public void ping() throws FursPluginException{

        try {
            String httpPayload=SOAP_PREPEND+"<fu:EchoResponse xmlns:fu=\"http://www.fu.gov.si/\">"+PING_STRING+"</fu:EchoResponse>"+SOAP_APPEND;

            Map<String, String> httpHeaders= new HashMap<String, String>();
            httpHeaders.put("Content-Type","text/xml; charset=UTF-8");
            httpHeaders.put("SOAPAction","/echo");

            String soapResponse = httpPost(this.url, httpHeaders, httpPayload);

            return;

        } catch (IOException e) {
            throw new FursPluginException(e);
        }

    }

    private Document getBusinessPremiseRequest(String uuid, Premise premise) throws FursPluginException {

        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder =  docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElementNS(SOAPENV_NAMESPACE,SOAPENV_NAMESPACE_PREFIX+":Envelope");
            doc.appendChild(rootElement);

            Element bodyElement = setElement(new QName(SOAPENV_NAMESPACE, "Header", SOAPENV_NAMESPACE_PREFIX), doc, rootElement);

            Element businessPremiseRequestElement = setElement(new QName(FU_NAMESPACE, "BusinessPremiseRequest", FU_NAMESPACE_PREFIX), doc, bodyElement);

            businessPremiseRequestElement.setAttribute("Id",SIGN_ELEMENT_ID);
            businessPremiseRequestElement.setIdAttribute("Id", true);  // sign BusinessPremiseRequest element

            // <Header>
            Element headerElement = setElement(new QName(FU_NAMESPACE, "Header", FU_NAMESPACE_PREFIX), doc, businessPremiseRequestElement);

            setFinalElement(new QName(FU_NAMESPACE, "MessageID", FU_NAMESPACE_PREFIX), uuid, doc, headerElement);

            DateFormat df = new SimpleDateFormat("2015-MM-dd'T'hh:mm:ss");
            String date =df.format(new Date());
            setFinalElement(new QName(FU_NAMESPACE, "DateTime", FU_NAMESPACE_PREFIX), date, doc, headerElement);

            // <BusinessPremise>
            Element businessPremiseElement = setElement(new QName(FU_NAMESPACE, "BusinessPremise", FU_NAMESPACE_PREFIX), doc, businessPremiseRequestElement);
            setFinalElement(new QName(FU_NAMESPACE, "TaxNumber", FU_NAMESPACE_PREFIX), premise.getTaxNumber(), doc, businessPremiseElement);
            setFinalElement(new QName(FU_NAMESPACE, "BusinessPremiseID", FU_NAMESPACE_PREFIX), premise.getPremiseId(), doc, businessPremiseElement);

            // <BPIdentifier>
            Element bPIdentifierElement = setElement(new QName(FU_NAMESPACE, "BPIdentifier", FU_NAMESPACE_PREFIX), doc, businessPremiseElement);
            CadastralData cadastralData = premise.getCadastralData();
            if (cadastralData != null) { // if real estate - immobile premise
                Element realEstateBPElement = setElement(new QName(FU_NAMESPACE, "RealEstateBP", FU_NAMESPACE_PREFIX), doc, bPIdentifierElement);

                Element propertyID = setElement(new QName(FU_NAMESPACE, "PropertyID", FU_NAMESPACE_PREFIX), doc, realEstateBPElement);

                setFinalElement(new QName(FU_NAMESPACE, "CadastralNumber", FU_NAMESPACE_PREFIX), cadastralData.getCadastralCommunityNumber(), doc, propertyID);
                setFinalElement(new QName(FU_NAMESPACE, "BuildingNumber", FU_NAMESPACE_PREFIX), cadastralData.getCadastralBuildingNumber(), doc, propertyID);
                setFinalElement(new QName(FU_NAMESPACE, "BuildingSectionNumber", FU_NAMESPACE_PREFIX), cadastralData.getCadastralBuildingPartNumber(), doc, propertyID);

                Element addressElement = setElement(new QName(FU_NAMESPACE, "Address", FU_NAMESPACE_PREFIX), doc, realEstateBPElement);

                setFinalElement(new QName(FU_NAMESPACE, "Street", FU_NAMESPACE_PREFIX), premise.getAdress().getStreet(), doc, addressElement);
                setFinalElement(new QName(FU_NAMESPACE, "HouseNumber", FU_NAMESPACE_PREFIX), premise.getAdress().getNumber(), doc, addressElement);
                if (premise.getAdress().getNumberAd()!=null) setFinalElement(new QName(FU_NAMESPACE, "HouseNumberAdditional", FU_NAMESPACE_PREFIX), premise.getAdress().getNumberAd(), doc, addressElement);
                setFinalElement(new QName(FU_NAMESPACE, "Community", FU_NAMESPACE_PREFIX), premise.getAdress().getPostName(), doc, addressElement);
                setFinalElement(new QName(FU_NAMESPACE, "City", FU_NAMESPACE_PREFIX), premise.getAdress().getTown(), doc, addressElement);
                setFinalElement(new QName(FU_NAMESPACE, "PostalCode", FU_NAMESPACE_PREFIX), premise.getAdress().getPostNumber(), doc, addressElement);
            } else {
                setFinalElement(new QName(FU_NAMESPACE, "PremiseType", FU_NAMESPACE_PREFIX), ""+premise.getMovablePremise(), doc, bPIdentifierElement);
            }

            setFinalElement(new QName(FU_NAMESPACE, "ValidityDate", FU_NAMESPACE_PREFIX),premise.getPremiseValidityDate(), doc, businessPremiseElement);

            Element softwareSupplier = setElement(new QName(FU_NAMESPACE, "SoftwareSupplier", FU_NAMESPACE_PREFIX), doc, businessPremiseElement);
            SwProvider swProvider = premise.getSwProvider();
            if (swProvider.getVat()!=null) {
                setFinalElement(new QName(FU_NAMESPACE, "TaxNumber", FU_NAMESPACE_PREFIX),swProvider.getVat(), doc, softwareSupplier);
            } else {
                setFinalElement(new QName(FU_NAMESPACE, "NameForeign", FU_NAMESPACE_PREFIX),swProvider.getForeignTitle(), doc, softwareSupplier);
            }

            if (premise.getAux()!=null) {
                setFinalElement(new QName(FU_NAMESPACE, "SpecialNotes", FU_NAMESPACE_PREFIX), premise.getAux(), doc, businessPremiseElement);
            }

            return doc;

        } catch (ParserConfigurationException e) {
            throw new FursPluginException(e);
        }

    }

    private Document getInvoiceRequest(String uuid, Invoice invoice) throws FursPluginException {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder =  docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElementNS(FU_NAMESPACE,"InvoiceRequest");
            rootElement.setAttribute("Id",SIGN_ELEMENT_ID);
            rootElement.setIdAttribute("Id", true);  // sign BusinessPremiseRequest element
            doc.appendChild(rootElement);

            // <Header>
            Element headerElement = setElement(new QName(FU_NAMESPACE, "Header", FU_NAMESPACE_PREFIX), doc, rootElement);

            setFinalElement(new QName(FU_NAMESPACE, "MessageID", FU_NAMESPACE_PREFIX), uuid, doc, headerElement);

            DateFormat df = new SimpleDateFormat("2015-MM-dd'T'hh:mm:ss");
            String date =df.format(new Date());
            setFinalElement(new QName(FU_NAMESPACE, "DateTime", FU_NAMESPACE_PREFIX), date, doc, headerElement);

            // <Invoice>
            Element invoiceElement = setElement(new QName(FU_NAMESPACE, "BusinessPremise", FU_NAMESPACE_PREFIX), doc, rootElement);

            // todo

            return doc;
        } catch (ParserConfigurationException e) {
            throw new FursPluginException(e);
        }

    }

    private Document getSalesBookInvoiceRequest(String uuid, Invoice invoice, Premise premise) throws FursPluginException {
        return null;
    }

    private Element setElement(QName elementName, Document doc, Element parentElement) {
        Element element;
        if (elementName.getNamespaceURI()==null) {
            element = doc.createElement(elementName.getLocalPart());
        } else {
            element = doc.createElementNS(elementName.getNamespaceURI(), elementName.getPrefix()+":"+elementName.getLocalPart());
        }
        parentElement.appendChild(element);
        return element;
    }

    private void setFinalElement(QName elementName, String elementValue, Document doc, Element parentElement) {
        Element element;
        if (elementName.getNamespaceURI()==null) {
            element = doc.createElement(elementName.getLocalPart());
        } else {
            element = doc.createElementNS(elementName.getNamespaceURI(), elementName.getPrefix()+":"+elementName.getLocalPart());
        }
        element.setTextContent(elementValue);
        parentElement.appendChild(element);
    }

    private String httpPost(String url, Map<String, String> httpHeaders, String httpPayload) throws IOException {

        HttpPost httppost = new HttpPost(url);

        // Request parameters and other properties.
        StringEntity stringentity=new StringEntity(httpPayload,"UTF-8");
        stringentity.setChunked(true);
        httppost.setEntity(stringentity);
        for (Map.Entry<String, String> entry : httpHeaders.entrySet()) {
            httppost.addHeader(entry.getKey(), entry.getValue());
        }
        //Execute and get the response.
        HttpClient httpclient = HttpClients.createSystem();
        HttpResponse response = httpclient.execute(httppost);
        if (response.getStatusLine().getStatusCode()!=200) {
            throw new IOException("Server returned error "+response.getStatusLine());
        }
        HttpEntity entity = response.getEntity();

        if(entity!=null) {
            return EntityUtils.toString(entity);
        }
        throw new IOException("Soap server returned null");
    }

    private String documentToString(Document doc) throws FursPluginException {

        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            //transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            StringWriter writer = new StringWriter();
            transformer.transform(new DOMSource(doc), new StreamResult(writer));
            return writer.toString();
        } catch (TransformerException e) {
            throw new FursPluginException(e);
        }
    }

    private void documentToFile(Document doc, String file) throws TransformerException, IOException {
        OutputStream os = new FileOutputStream(file);
        Transformer trans = TransformerFactory.newInstance()
                .newTransformer();
        trans.transform(new DOMSource(doc), new StreamResult(os));
        os.flush();
        os.close();
    }


    private void checkInput(String id, FursObject obj) throws FursPluginException{
        if (id!=null && id.length()==ID_LENGTH && obj!=null || obj.validateData()) {
            return;
        }
        throw new FursPluginException("Invalid arguments");
    }
}
