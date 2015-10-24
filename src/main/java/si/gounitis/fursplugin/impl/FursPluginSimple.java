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
import org.w3c.dom.NodeList;
import si.gounitis.fursplugin.FursObject;
import si.gounitis.fursplugin.FursPlugin;
import si.gounitis.fursplugin.FursPluginException;
import si.gounitis.fursplugin.beans.CadastralData;
import si.gounitis.fursplugin.beans.Invoice;
import si.gounitis.fursplugin.beans.Premise;
import si.gounitis.fursplugin.beans.SwProvider;
import si.gounitis.fursplugin.helpers.Sign;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.*;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

/**
 * Created by Jure on 7.10.2015.
 */
public class FursPluginSimple implements FursPlugin{

    private static final String PING_STRING="Mnogo let za tem, ko je Polkovnik Aureliano Buendia";
    private static final int ID_LENGTH=36;
    private static final String SOAPProtocol=SOAPConstants.SOAP_1_1_PROTOCOL;

    private static final String FU_NAMESPACE="http://www.fu.gov.si/";
    private static final String SIGN_ELEMENT_ID="data";

    private static final String SOAP_PREPEND = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
            "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xd=\"http://www.w3.org/2000/09/xmldsig#\">\n" +
            "\t<soapenv:Body>";
    private static final String SOAP_APEND ="\t</soapenv:Body>\n" +
            "</soapenv:Envelope>";

    private String url;

    public FursPluginSimple(String url) {

        this.url=url;
    }

    /**
     * register new premise (mobile or real estate) at FURS
     *
     * @param uuid - unique message ID (could be genertebd by si.gounitis.fursplugin.helpers.Tools.getNewUiid()
     * @param premise - premise data POJO
     * @param signingCertAlias - name of signing certificate in a keystore
     * @@return
     */
    public void registerPremise(String uuid, Premise premise, String signingCertAlias) throws FursPluginException {

        checkInput(uuid, premise);

        try {
            Document businessPremiseRequest=getBusinessPremiseRequest(uuid, premise);
            Document signedBusinessPremiseRequest = Sign.signDocument(businessPremiseRequest, "#"+SIGN_ELEMENT_ID, "signcert");
            String httpPayload=SOAP_PREPEND+documentToString(signedBusinessPremiseRequest)+SOAP_APEND;

            Map<String, String> httpHeaders= new HashMap<String, String>();
            httpHeaders.put("Content-Type","text/xml; charset=UTF-8");
            httpHeaders.put("SOAPAction","/invoices/register");

            String soapResponse = httpPost(this.url, httpHeaders, httpPayload);

            return;

        } catch (IOException e) {
            throw new FursPluginException(e);
        }
    }

    /**
     * issue an invoice
     *
     * @param uuid - unique message ID (could be genertebd by si.gounitis.fursplugin.helpers.Tools.getNewUiid()
     * @param invoice - invoice data POJO
     * @param salesBook - is invoice issued based on sales book invoice
     * @param premise - premise data POJO
     * @param signingCertAlias - name of signing certificate in a keystore
     * @return invoice ID
     */
    public String issueInvoice(String uuid, Invoice invoice, boolean salesBook, Premise premise, String signingCertAlias) throws FursPluginException{

        checkInput(uuid, invoice);

        try {
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            // SOAP Envelope
            MessageFactory messageFactory = MessageFactory.newInstance(SOAPProtocol);
            SOAPMessage soapMessage = messageFactory.createMessage();
            SOAPPart soapPart = soapMessage.getSOAPPart();

            SOAPEnvelope envelope = soapPart.getEnvelope();

            SOAPHeader soapHeader = envelope.getHeader();
            SOAPBody soapBody = envelope.getBody();
            Document invoiceRequest;
            if (salesBook) {
                invoiceRequest = getSalesBookInvoiceRequest(uuid, invoice, premise);
            } else {
                invoiceRequest = getInvoiceRequest(uuid, invoice, premise);
            }
            invoiceRequest = Sign.signDocument(invoiceRequest, "#" + SIGN_ELEMENT_ID, "signcert");
            String invoiceRequestString = documentToString(invoiceRequest);

            soapBody.setTextContent(invoiceRequestString);

            // Setting SOAPAction header line
            MimeHeaders headers = soapMessage.getMimeHeaders();
            headers.addHeader("SOAPAction", "/invoices");

            soapMessage.saveChanges();
            SOAPMessage soapResponse = soapConnection.call(soapMessage, this.url);

            SOAPBody responseBoddy = soapResponse.getSOAPPart().getEnvelope().getBody();
            SOAPElement businessPremiseRsponseElement = (SOAPElement) responseBoddy.getElementsByTagName("*").item(0);

            Iterator itr = businessPremiseRsponseElement.getChildElements();
            while(itr.hasNext()) {
                SOAPElement element = (SOAPElement) itr.next();
                if ("Error".equals(element.getElementName().getLocalName())) {
                    NodeList errorCause = element.getElementsByTagName("*");
                    throw new FursPluginException("Request to FURS returned Error " + ((SOAPElement)errorCause.item(0)).getTextContent()+": "+((SOAPElement)errorCause.item(1)).getTextContent());
                }
            }

            return null;

        } catch (SOAPException e) {
            throw new FursPluginException(e);
        }
    }

    /**
     * check FURS conectivity
     *
     * @return true if coection OK, false else
     */
    public void ping() throws FursPluginException{

        try {
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            // SOAP Envelope
            MessageFactory messageFactory = MessageFactory.newInstance(SOAPProtocol);
            SOAPMessage soapMessage = messageFactory.createMessage();
            SOAPPart soapPart = soapMessage.getSOAPPart();

            SOAPEnvelope envelope = soapPart.getEnvelope();
            envelope.addNamespaceDeclaration("fu", "http://www.fu.gov.si");

            SOAPHeader soapHeader = envelope.getHeader();
            SOAPBody soapBody = envelope.getBody();
            SOAPElement echoResponseElement = soapBody.addChildElement("EchoResponse","fu");
            echoResponseElement.setTextContent(PING_STRING);

            // Setting SOAPAction header line
            MimeHeaders headers = soapMessage.getMimeHeaders();
            headers.addHeader("SOAPAction", "/echo");

            soapMessage.saveChanges();
            soapConnection.call(soapMessage,this.url);

        } catch (SOAPException e) {
            throw new FursPluginException(e);
        }

    }

    private Document getBusinessPremiseRequest(String uuid, Premise premise) throws FursPluginException {

        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder =  docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElementNS(FU_NAMESPACE,"BusinessPremiseRequest");
            rootElement.setAttribute("Id",SIGN_ELEMENT_ID);
            rootElement.setIdAttribute("Id", true);  // sign BusinessPremiseRequest element
            doc.appendChild(rootElement);

            // <Header>
            Element headerElement = doc.createElementNS(FU_NAMESPACE, "Header");
            rootElement.appendChild(headerElement);

            setFinalElement(FU_NAMESPACE, "MessageID", uuid, doc, headerElement);

            DateFormat df = new SimpleDateFormat("2015-MM-dd'T'hh:mm:ss");
            String date =df.format(new Date());
            setFinalElement(FU_NAMESPACE, "DateTime", date, doc, headerElement);

            // <BusinessPremise>
            Element businessPremiseElement = doc.createElementNS(FU_NAMESPACE, "BusinessPremise");
            rootElement.appendChild(businessPremiseElement);
            setFinalElement(FU_NAMESPACE, "TaxNumber", premise.getTaxNumber(), doc, businessPremiseElement);
            setFinalElement(FU_NAMESPACE, "BusinessPremiseID", premise.getPremiseId(), doc, businessPremiseElement);

            // <BPIdentifier>
            Element bPIdentifierElement = doc.createElementNS(FU_NAMESPACE, "BPIdentifier");
            businessPremiseElement.appendChild(bPIdentifierElement);
            CadastralData cadastralData = premise.getCadastralData();
            if (cadastralData != null) { // if real estate - immobile premise
                Element realEstateBPElement = doc.createElementNS(FU_NAMESPACE, "RealEstateBP");
                bPIdentifierElement.appendChild(realEstateBPElement);

                Element propertyID = doc.createElementNS(FU_NAMESPACE, "PropertyID");
                realEstateBPElement.appendChild(propertyID);

                setFinalElement(FU_NAMESPACE, "CadastralNumber", cadastralData.getCadastralCommunityNumber(), doc, propertyID);
                setFinalElement(FU_NAMESPACE, "BuildingNumber", cadastralData.getCadastralBuildingNumber(), doc, propertyID);
                setFinalElement(FU_NAMESPACE, "BuildingSectionNumber", cadastralData.getCadastralBuildingPartNumber(), doc, propertyID);

                Element addressElement = doc.createElementNS(FU_NAMESPACE, "Address");
                realEstateBPElement.appendChild(addressElement);

                setFinalElement(FU_NAMESPACE, "Street", premise.getAdress().getStreet(), doc, addressElement);
                setFinalElement(FU_NAMESPACE, "HouseNumber", premise.getAdress().getNumber(), doc, addressElement);
                if (premise.getAdress().getNumberAd()!=null) setFinalElement(FU_NAMESPACE, "HouseNumberAdditional", premise.getAdress().getNumberAd(), doc, addressElement);
                setFinalElement(FU_NAMESPACE, "Community", premise.getAdress().getPostName(), doc, addressElement);
                setFinalElement(FU_NAMESPACE, "City", premise.getAdress().getTown(), doc, addressElement);
                setFinalElement(FU_NAMESPACE, "PostalCode", premise.getAdress().getPostNumber(), doc, addressElement);
            } else {
                setFinalElement(FU_NAMESPACE, "PremiseType", ""+premise.getMovablePremise(), doc, bPIdentifierElement);
            }

            setFinalElement(FU_NAMESPACE, "ValidityDate",premise.getPremiseValidityDate(), doc, businessPremiseElement);

            Element softwareSupplier = doc.createElementNS(FU_NAMESPACE, "SoftwareSupplier");
            businessPremiseElement.appendChild(softwareSupplier);
            SwProvider swProvider = premise.getSwProvider();
            if (swProvider.getVat()!=null) {
                setFinalElement(FU_NAMESPACE, "TaxNumber",swProvider.getVat(), doc, softwareSupplier);
            } else {
                setFinalElement(FU_NAMESPACE, "NameForeign",swProvider.getForeignTitle(), doc, softwareSupplier);
            }

            if (premise.getAux()!=null) {
                setFinalElement(FU_NAMESPACE, "SpecialNotes", premise.getAux(), doc, businessPremiseElement);
            }

            return doc;

        } catch (ParserConfigurationException e) {
            throw new FursPluginException(e);
        }

    }

    private Document getInvoiceRequest(String uuid, Invoice invoice, Premise premise) throws FursPluginException {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder =  docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElementNS(FU_NAMESPACE,"InvoiceRequest");
            rootElement.setAttribute("Id",SIGN_ELEMENT_ID);
            rootElement.setIdAttribute("Id", true);  // sign BusinessPremiseRequest element
            doc.appendChild(rootElement);

            // <Header>
            Element headerElement = doc.createElementNS(FU_NAMESPACE, "Header");
            rootElement.appendChild(headerElement);

            setFinalElement(FU_NAMESPACE, "MessageID", uuid, doc, headerElement);

            DateFormat df = new SimpleDateFormat("2015-MM-dd'T'hh:mm:ss");
            String date =df.format(new Date());
            setFinalElement(FU_NAMESPACE, "DateTime", date, doc, headerElement);

            // <Invoice>
            Element invoiceElement = doc.createElementNS(FU_NAMESPACE, "BusinessPremise");
            rootElement.appendChild(invoiceElement);
            setFinalElement(FU_NAMESPACE, "TaxNumber", premise.getTaxNumber(), doc, invoiceElement);

            return doc;
        } catch (ParserConfigurationException e) {
            throw new FursPluginException(e);
        }

    }

    private Document getSalesBookInvoiceRequest(String uuid, Invoice invoice, Premise premise) throws FursPluginException {
        return null;
    }

    private void setFinalElement(String namespace, String elementName, String elementValue, Document doc, Element parentElement) {

        Element element;
        if (namespace==null) {
            element = doc.createElement(elementName);
        } else {
            element = doc.createElementNS(FU_NAMESPACE, elementName);
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
        HttpClient httpclient = new DefaultHttpClient();
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
            DOMSource domSource = new DOMSource(doc);
            StringWriter writer = new StringWriter();
            StreamResult result = new StreamResult(writer);
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            transformer.transform(domSource, result);
            return writer.toString();
        } catch (TransformerException e) {
           throw new FursPluginException(e);
        }
    }

    private void checkInput(String id, FursObject obj) throws FursPluginException{
        if (id!=null && id.length()==ID_LENGTH && obj!=null || obj.validateData()) {
            return;
        }
        throw new FursPluginException("Not valid arguments");
    }

    private void printSoapMsg(SOAPMessage msg)  {
        try {
            System.out.print(" SOAP Message:");
            msg.writeTo(System.out);
        } catch (Exception e) {}

    }
}
