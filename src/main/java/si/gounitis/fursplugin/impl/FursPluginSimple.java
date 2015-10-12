//********************************************************************************
//
//    About - About box class
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
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

/**
 * Created by Jure on 7.10.2015.
 */
public class FursPluginSimple implements FursPlugin{

    private static String PING_STRING="Mnogo let za tem, ko je Polkovnik Aureliano Buendia";
    private static int ID_LENGTH=36;
    private static String SOAPProtocol=SOAPConstants.SOAP_1_1_PROTOCOL;

    private static String FU_NAMESPACE="http://www.fu.gov.si/";
    private static String SIGN_ELEMENT_ID="data";

    private String url;

    public FursPluginSimple(String url) {

        this.url=url;
    }

    public void reportPremise(String uuid, Premise premise, String signingCertAlias) throws FursPluginException {

        checkInput(uuid, premise);

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
            Document businessPremiseRequest=getBusinessPremiseRequest(uuid, premise);
            businessPremiseRequest = Sign.signDocument(businessPremiseRequest, "#" + SIGN_ELEMENT_ID, "signcert");
            String businessPremiseRequestString = documentToString(businessPremiseRequest);

            soapBody.setTextContent(businessPremiseRequestString);

            // Setting SOAPAction header line
            MimeHeaders headers = soapMessage.getMimeHeaders();
            headers.addHeader("SOAPAction", "/invoices/register");

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

            return;

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
            setFinalElement(FU_NAMESPACE, "BusinessPremiseID", premise.getPremiseLabel(), doc, businessPremiseElement);

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
                setFinalElement(FU_NAMESPACE, "PostalCode", premise.getAdress().getPostNumber(), doc, addressElement);
                setFinalElement(FU_NAMESPACE, "City", premise.getAdress().getTown(), doc, addressElement);
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
                setFinalElement(FU_NAMESPACE, "NameForeign",swProvider.getTitle(), doc, softwareSupplier);
            }

            setFinalElement(FU_NAMESPACE, "SpecialNotes",premise.getAux(), doc, businessPremiseElement);

            return doc;

        } catch (ParserConfigurationException e) {
            throw new FursPluginException(e);
        }

    }

    public String issueInvoice(String id, Invoice invoice, String signingCertAlias) throws FursPluginException{

        checkInput(id, invoice);

        return null;
    }

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
