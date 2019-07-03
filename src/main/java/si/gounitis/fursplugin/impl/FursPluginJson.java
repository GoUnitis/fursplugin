//********************************************************************************
//
//    Copyright (C) 2015  GoUnitis, Jurij Zelic s.p.
//
//    This program is free software; you can redistribute it and/or modify
//    it under the terms of the GNU Lesser General Public License as published by
//    the Free Software Foundation; either version 2.1 of the License, or
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

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ContainerFactory;
import org.json.simple.parser.ParseException;
import si.gounitis.fursplugin.FursObject;
import si.gounitis.fursplugin.FursPlugin;
import si.gounitis.fursplugin.FursPluginException;
import si.gounitis.fursplugin.beans.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import org.apache.commons.codec.binary.Base64;
import org.json.simple.parser.JSONParser;
import si.gounitis.fursplugin.helpers.ParseKeypair;

public class FursPluginJson implements FursPlugin {
    private static final String invoiceDateFormat="yyyy-MM-dd'T'HH:mm:ss";
    private static final String zoiDateFormat="dd.MM.yyyy HH:mm:ss";

    private static final int ID_LENGTH=36;

    private String url;

    /**
     * Constructor
     * @param url - webservice URL address
     */
    public FursPluginJson(String url) {

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
        Base64 base64 = new Base64();

        ParseKeypair parseKeypair = new ParseKeypair(signingCertAlias);
        String jwsHeader = getJwsHeader(parseKeypair);
        String premiseRequest = getBusinessPremiseRequest(uuid, premise);
        String token= new String(base64.encodeBase64URLSafe(jwsHeader.getBytes(StandardCharsets.UTF_8)))+
                "."+
                new String(base64.encodeBase64URLSafe(premiseRequest.getBytes(StandardCharsets.UTF_8)));

        String signedToken=generateToken(token, parseKeypair);
        String jsonRequest="{\"token\" :\""+signedToken+"\"}";
        try {
            Map<String, String> httpHeaders= new HashMap<String, String>();
            httpHeaders.put("Content-Type","application/json; charset=UTF-8");

            String jsonResponse=httpPost(url,httpHeaders,jsonRequest);

            JSONParser parser = new JSONParser();
            Map json = (Map)parser.parse(jsonResponse, getContainerFactory());
            String responseToken= (String) json.get("token");
            //checkSignature(responseToken);
            String jwsPayload=getJwsPayload(responseToken);

            //System.out.println(new String(base64.decode(jwsPayload.getBytes(StandardCharsets.UTF_8)),StandardCharsets.UTF_8));

            invoiceParseResult(new String(base64.decode(jwsPayload.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8), ResponseType.PREMISE);

        } catch (IOException e) {
            throw new FursPluginException(e);
        } catch (ParseException e) {
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
    public InvoceReturnValue issueInvoice(String uuid, Invoice invoice, String signingCertAlias) throws FursPluginException{
        Base64 base64 = new Base64();

        checkInput(uuid, invoice);

        ParseKeypair parseKeypair = new ParseKeypair(signingCertAlias);
        String jwsHeader = getJwsHeader(parseKeypair);
        InvoceReturnValue invoceRequest = getInvoice(uuid, invoice, parseKeypair);
        String token= new String(base64.encodeBase64URLSafe(jwsHeader.getBytes(StandardCharsets.UTF_8)))+
                "."+
                new String(base64.encodeBase64URLSafe(invoceRequest.getInvoiceReq().getBytes(StandardCharsets.UTF_8)));

        String signedToken=generateToken(token, parseKeypair);
        String jsonRequest="{\"token\" :\""+signedToken+"\"}";
        try {
            Map<String, String> httpHeaders= new HashMap<String, String>();
            httpHeaders.put("Content-Type","application/json; charset=UTF-8");

            String jsonResponse=httpPost(url,httpHeaders,jsonRequest);

            JSONParser parser = new JSONParser();
            Map json = (Map)parser.parse(jsonResponse, getContainerFactory());
            String responseToken= (String) json.get("token");
            //checkSignature(responseToken);
            String jwsPayload=getJwsPayload(responseToken);
            
            //System.out.println(new String(base64.decode(jwsPayload.getBytes(StandardCharsets.UTF_8)),StandardCharsets.UTF_8));
            
            String result = invoiceParseResult(new String(base64.decode(jwsPayload.getBytes(StandardCharsets.UTF_8)),StandardCharsets.UTF_8),ResponseType.INVOICE);
            invoceRequest.setUniqueInvoiceID(result);
            return invoceRequest;
        } catch (IOException e) {
            throw new FursPluginException(e);
        } catch (ParseException e) {
            throw new FursPluginException(e);
        }
    }

    /**
     * check FURS connectivity
     */
    public void ping() throws FursPluginException{
        Map<String, String> httpHeaders= new HashMap<String, String>();
        httpHeaders.put("Content-Type","application/json; charset=UTF-8");

        String jsonRequest="{\"EchoRequest\":\"furs\"}";
        try {
            String jsonResponse=httpPost(url,httpHeaders,jsonRequest);
        } catch (IOException e) {
            throw new FursPluginException(e);
        }
    }

    private InvoceReturnValue getInvoice(String uuid, Invoice invoice,ParseKeypair parseKeypair) {
        InvoceReturnValue invoceReturnValue = new InvoceReturnValue();
        Map obj=new LinkedHashMap();
        Map invoiceRequest = new LinkedHashMap();

        // <Header>
        Map header = new LinkedHashMap();
        header.put("MessageID", uuid);
        DateFormat df = new SimpleDateFormat("2015-MM-dd'T'hh:mm:ss");
        String date =df.format(new Date());
        header.put("DateTime", date);
        invoiceRequest.put("Header",header);

        // <Invoice>
        Map invoiceMap = new LinkedHashMap();
        invoiceMap.put("TaxNumber", Integer.parseInt(invoice.getTaxNumber()));
        invoiceMap.put("IssueDateTime", invoice.getIssueDateTime());
        invoiceMap.put("NumberingStructure", ""+invoice.getNumberingStructure());
        // <InvoiceIdentifier>
        Map invoiceIdentifier = new LinkedHashMap();
        invoiceIdentifier.put("BusinessPremiseID",invoice.getPremiseId());
        invoiceIdentifier.put("ElectronicDeviceID",invoice.getDeviceId());
        invoiceIdentifier.put("InvoiceNumber",invoice.getInvoiceNumber());
        invoiceMap.put("InvoiceIdentifier",invoiceIdentifier);

        if (invoice.getInvoiceAmmount()!=null) invoiceMap.put("InvoiceAmount",Float.parseFloat(invoice.getInvoiceAmmount()));
        if (invoice.getPaymentAmmount()!=null) invoiceMap.put("PaymentAmount",Float.parseFloat(invoice.getPaymentAmmount()));

        if (invoice.getTaxesPerSeller()!=null) {
            List taxPerSeller = new LinkedList();
            Map m0 = new LinkedHashMap();
            List vat= new LinkedList();
            for (TaxesPerSeller tps:invoice.getTaxesPerSeller()) {
                Map vatContent = new LinkedHashMap();
                for (Vat vt: tps.getVat()) {
                    vatContent.put("TaxRate", Float.parseFloat(vt.getTaxRate()));
                    vatContent.put("TaxableAmount", Float.parseFloat(vt.getTaxableAmmount()));
                    vatContent.put("TaxAmount", Float.parseFloat(vt.getTaxAmmount()));
                    vat.add(vatContent);
                }
            }
            m0.put("VAT", vat);
            if (invoice.getInvoiceAmmount()!=null) m0.put("ExemptVATTaxableAmount", Float.parseFloat(invoice.getInvoiceAmmount()));
            taxPerSeller.add(m0);
            invoiceMap.put("TaxesPerSeller", taxPerSeller);

        } else {
            List taxPerSeller = new LinkedList();
            Map m0 = new LinkedHashMap();
            m0.put("ExemptVATTaxableAmount", Float.parseFloat(invoice.getInvoiceAmmount()));
            taxPerSeller.add(m0);
            invoiceMap.put("TaxesPerSeller", taxPerSeller);
        }
        if (invoice.getOperatorTaxNumber()!=null ) invoiceMap.put("OperatorTaxNumber",invoice.getOperatorTaxNumber());
        String zoi=getProtectedId(invoice, parseKeypair);
        invoiceMap.put("ProtectedID",zoi);
        // <ReferenceInvoice>
        if (invoice.getReferenceInvoice()!=null) {
            List li0 = new LinkedList();
            Map referenceInvoice = new LinkedHashMap();
            Map referenceInvoiceIdentifier= new LinkedHashMap();
            referenceInvoiceIdentifier.put("BusinessPremiseID",invoice.getReferenceInvoice().getReferenceInvoicePremiseId());
            referenceInvoiceIdentifier.put("ElectronicDeviceID",invoice.getReferenceInvoice().getReferenceInvoiceDeviceId());
            referenceInvoiceIdentifier.put("InvoiceNumber",invoice.getReferenceInvoice().getReferenceInvoiceInvoiceNumber());

            referenceInvoice.put("ReferenceInvoiceIdentifier",referenceInvoiceIdentifier);
            referenceInvoice.put("ReferenceInvoiceIssueDateTime",invoice.getReferenceInvoice().getReferenceInvoiceIssueDateTime());
            li0.add(referenceInvoice);
            invoiceMap.put("ReferenceInvoice", li0);
        }

        invoiceMap.put("SpecialNotes",invoice.getAux());

        invoiceRequest.put("Invoice",invoiceMap);

        obj.put("InvoiceRequest",invoiceRequest);

        //System.out.println(JSONValue.toJSONString(obj));
        invoceReturnValue.setZoi(zoi);
        invoceReturnValue.setInvoiceReq(JSONValue.toJSONString(obj));
        return invoceReturnValue;
    }

    private String getBusinessPremiseRequest(String uuid, Premise premise) throws FursPluginException {

        Map obj=new LinkedHashMap();
        Map businessPremiseRequest = new LinkedHashMap();

        // <Header>
        Map header = new LinkedHashMap();
        header.put("MessageID", uuid);
        DateFormat df = new SimpleDateFormat("2015-MM-dd'T'hh:mm:ss");
        String date =df.format(new Date());
        header.put("DateTime", date);
        businessPremiseRequest.put("Header",header);

        // <BusinessPremise>
        Map businessPremise = new LinkedHashMap();
        businessPremise.put("TaxNumber", Integer.parseInt(premise.getTaxNumber()));
        businessPremise.put("BusinessPremiseID",  premise.getPremiseId());

        // <BPIdentifier>
        CadastralData cadastralData = premise.getCadastralData();
        if (cadastralData != null) {
            Map bPIdentifier = new LinkedHashMap();
            Map propertyID = new LinkedHashMap();
            propertyID.put("CadastralNumber", Integer.parseInt(cadastralData.getCadastralCommunityNumber()));
            propertyID.put("BuildingNumber",Integer.parseInt(cadastralData.getCadastralBuildingNumber()));
            propertyID.put("BuildingSectionNumber",Integer.parseInt(cadastralData.getCadastralBuildingPartNumber()));
            Map realEstateBP = new LinkedHashMap();
            realEstateBP.put("PropertyID", propertyID);
            bPIdentifier.put("RealEstateBP", realEstateBP);
            Map address = new LinkedHashMap();
            address.put("Street",premise.getAdress().getStreet());
            address.put("HouseNumber", premise.getAdress().getNumber());
            if (premise.getAdress().getNumberAd()!=null) address.put("HouseNumberAdditional",premise.getAdress().getNumberAd());
            address.put("Community", premise.getAdress().getPostName());
            address.put("City", premise.getAdress().getTown());
            address.put("PostalCode", premise.getAdress().getPostNumber());
            realEstateBP.put("Address", address);
            businessPremise.put("BPIdentifier", bPIdentifier);
        } else {
            Map bPIdentifier = new LinkedHashMap();
            bPIdentifier.put("PremiseType", premise.getMovablePremise());
            businessPremise.put("BPIdentifier", bPIdentifier);
        }
        businessPremise.put("ValidityDate",premise.getPremiseValidityDate());
        if (premise.getClosePremise()) businessPremise.put("ClosingTag","Z");
        SwProvider swProvider = premise.getSwProvider();
        List  softwareSupplier = new LinkedList();
        Map m1 = new LinkedHashMap();
        if (swProvider.getVat()!=null) {
            m1.put("TaxNumber",Integer.parseInt(swProvider.getVat()));
        } else {
            m1.put("NameForeign",swProvider.getForeignTitle());
        }
        softwareSupplier.add(m1);
        businessPremise.put("SoftwareSupplier",softwareSupplier);

        businessPremise.put("SpecialNotes",premise.getAux());
        businessPremiseRequest.put("BusinessPremise",businessPremise);

        obj.put("BusinessPremiseRequest",businessPremiseRequest);
        return JSONValue.toJSONString(obj);
    }

    private String getJwsHeader(ParseKeypair parseKeypair){
        Map obj=new LinkedHashMap();
        obj.put("alg","RS256");
        obj.put("subject_name",parseKeypair.getSubjectName());
        obj.put("issuer_name",parseKeypair.getIssuerName());
        obj.put("serial",parseKeypair.getSerialNumber());

        return JSONValue.toJSONString(obj);
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

    private String getJwsPayload(String responseToken) {
        String tmp=responseToken.substring(responseToken.indexOf(".")+1);
        tmp=tmp.substring(0,tmp.indexOf("."));
        return tmp;
    }

    private void checkSignature(String token) {

        try {
            Base64 base64 = new Base64();
            JSONParser parser = new JSONParser();

            String jwsHeader=token.substring(0,token.indexOf("."));
            String tmp = token.substring(token.indexOf(".")+1);
            String body = tmp.substring(0,tmp.indexOf("."));
            String jwsHeaderDecoded = new String(base64.decode(jwsHeader.getBytes(StandardCharsets.UTF_8)),StandardCharsets.UTF_8);
            Map json = (Map)parser.parse(jwsHeaderDecoded, getContainerFactory());
            List<String> keyarray= (List<String> ) json.get("x5c");
            byte[] key=base64.decode(keyarray.get(0).getBytes(StandardCharsets.UTF_8));
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(key);
            PublicKey publicKey = KeyFactory.getInstance("RSA").generatePublic(x509EncodedKeySpec);
            Signature sig = Signature.getInstance("SHA256withRSA");
            sig.initVerify(publicKey);
            boolean verifies = sig.verify((jwsHeader+"."+body).getBytes(StandardCharsets.UTF_8));

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        } catch (SignatureException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        System.out.println();
    }

    private String generateToken(String token, ParseKeypair parseKeypair) {
        try {
            String sign = new String(Base64.encodeBase64URLSafe(sign(token,parseKeypair)));
            return token+"."+sign;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (SignatureException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        }
    }

    private String getProtectedId(Invoice invoice, ParseKeypair parseKeypair) {

        try {
            SimpleDateFormat invFrm = new SimpleDateFormat(invoiceDateFormat);
            SimpleDateFormat zoiFrm = new SimpleDateFormat(zoiDateFormat);
            Date invDate = invFrm.parse(invoice.getIssueDateTime());
            String dateZoiType=zoiFrm.format(invDate);
            String tmp = invoice.getTaxNumber()+dateZoiType+invoice.getInvoiceNumber()+invoice.getPremiseId()+invoice.getDeviceId()+invoice.getInvoiceAmmount();
            byte[] signed = sign ( tmp, parseKeypair);
            return DigestUtils.md5Hex(signed);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        } catch (SignatureException e) {
            throw new RuntimeException(e);
        } catch (java.text.ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private byte[] sign(String value, ParseKeypair parseKeypair) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Signature sig = Signature.getInstance("SHA256withRSA");
        sig.initSign(parseKeypair.getPrivateKey());
        sig.update(value.getBytes(StandardCharsets.UTF_8));
        return sig.sign();
    }

    private String invoiceParseResult(String jwsPayload, ResponseType type) {
        JSONObject obj = (JSONObject) JSONValue.parse(jwsPayload);
        JSONObject response;
        if (ResponseType.INVOICE.equals(type)) {
            response = (JSONObject) obj.get("InvoiceResponse");
        } else {
            response = (JSONObject) obj.get("BusinessPremiseResponse");
        }
        JSONObject error = (JSONObject) response.get("Error");
        if (error!=null)
            throw new RuntimeException("ERROR " + error.get("ErrorCode") + "-" + error.get("ErrorMessage"));

        return (String) response.get("UniqueInvoiceID");
    }

    private ContainerFactory getContainerFactory() {
        ContainerFactory containerFactory = new ContainerFactory() {
            public List creatArrayContainer() {
                return new LinkedList();
            }
            public Map createObjectContainer() {
                return new LinkedHashMap();
            }
        };
        return containerFactory;
    }

    private void checkInput(String id, FursObject obj) throws FursPluginException{
        if (id!=null && id.length()==ID_LENGTH && obj!=null && obj.validateData()) {
            return;
        }
        throw new FursPluginException("Invalid arguments");
    }

    private enum ResponseType {
        INVOICE, PREMISE
    }
}
