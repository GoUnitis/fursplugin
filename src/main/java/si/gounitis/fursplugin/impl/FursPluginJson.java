package si.gounitis.fursplugin.impl;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONValue;
import org.json.simple.parser.ContainerFactory;
import org.json.simple.parser.ParseException;
import si.gounitis.fursplugin.FursPlugin;
import si.gounitis.fursplugin.FursPluginException;
import si.gounitis.fursplugin.beans.CadastralData;
import si.gounitis.fursplugin.beans.Invoice;
import si.gounitis.fursplugin.beans.Premise;
import si.gounitis.fursplugin.beans.SwProvider;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import org.apache.commons.codec.binary.Base64;
import org.json.simple.parser.JSONParser;
import si.gounitis.fursplugin.helpers.ParseKeypair;

/**
 * Created by Jure on 8.11.2015.
 */
public class FursPluginJson implements FursPlugin {
    private String url;

    /**
     * Constructor
     * @param url - webservice URL address
     */
    public FursPluginJson(String url) {

        this.url=url;
    }

    public void registerPremise(String uuid, Premise premise, String signingCertAlias) throws FursPluginException {
        Base64 base64 = new Base64();

        ParseKeypair parseKeypair = new ParseKeypair(signingCertAlias);
        String jwsHeader = getJwsHeader(parseKeypair);
        String premiseRequest = getBusinessPremiseRequest(uuid, premise);
        String token= new String(base64.encodeBase64URLSafe(jwsHeader.getBytes(StandardCharsets.UTF_8)))+
                "."+
                new String(base64.encodeBase64URLSafe(premiseRequest.getBytes(StandardCharsets.UTF_8)));

        String signedToken=sign(token,parseKeypair);
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

            System.out.println(new String(base64.decode(jwsPayload.getBytes(StandardCharsets.UTF_8)),StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new FursPluginException(e);
        } catch (ParseException e) {
            throw new FursPluginException(e);
        }
    }

    public String issueInvoice(String uuid, Invoice invoice, boolean salesBook, Premise premise, String signingCertAlias) throws FursPluginException{
        return null;
    }

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

    private String getJwsHeader(ParseKeypair parseKeypair){
        Map obj=new LinkedHashMap();
        obj.put("alg","RS256");
        obj.put("subject_name",parseKeypair.getSubjectName());
        obj.put("issuer_name",parseKeypair.getIssuerName());
        obj.put("serial",parseKeypair.getSerialNumber());

        return JSONValue.toJSONString(obj);
    }

    private String getBusinessPremiseRequest(String uuid, Premise premise) throws FursPluginException {

        Map obj=new LinkedHashMap();
        Map businessPremiseRequest = new LinkedHashMap();

        // <Header>
        Map header = new LinkedHashMap();
        header.put("MessageID", uuid);
        DateFormat df = new SimpleDateFormat("2015-MM-dd'T'hh:mm:ss");
        String date =df.format(new Date())+"Z";
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

System.out.println();
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

    private String sign(String token, ParseKeypair parseKeypair) {
        try {
            Signature sig = Signature.getInstance("SHA256withRSA");
            sig.initSign(parseKeypair.getPrivateKey());
            sig.update(token.getBytes(StandardCharsets.UTF_8));
            byte[] signature = sig.sign();
            String sign = new String(Base64.encodeBase64URLSafe(signature));
            return token+"."+sign;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (SignatureException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        }
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
}
