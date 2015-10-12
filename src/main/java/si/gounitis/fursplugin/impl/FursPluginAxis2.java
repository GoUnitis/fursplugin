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

import org.apache.axis2.AxisFault;
import org.apache.axis2.databinding.types.PositiveInteger;
import org.w3.www._2000._09.xmldsig.*;
import si.gounitis.fursplugin.*;
import si.gounitis.fursplugin.beans.CadastralData;
import si.gounitis.fursplugin.beans.Invoice;
import si.gounitis.fursplugin.beans.Premise;
import si.gounitis.fursplugin.beans.SwProvider;
import si.gounitis.fursplugin.helpers.Sign;
import si.gov.fu.www.*;

import javax.activation.DataHandler;
import javax.mail.util.ByteArrayDataSource;
import java.math.BigInteger;
import org.apache.axis2.databinding.types.URI;
import java.nio.charset.StandardCharsets;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Jure on 7.10.2015.
 */
public class FursPluginAxis2 implements FursPlugin{

    private static String PING_STRING="Mnogo let za tem, ko je Polkovnik Aureliano Buendia �akal, da ga usmrte";
    private static int ID_LENGTH=36;

    private String url;

    public FursPluginAxis2(String url) {
        this.url=url;
    }

    public void registerPremise(String uuid, Premise premise, String signingCertAlias) throws FursPluginException {

        String signElemetId="burek";

        checkInput(uuid, premise);

        try {
            FiscalVerificationServiceStub stub = new FiscalVerificationServiceStub(url);

            BusinessPremiseRequest businessPremiseRequest = new BusinessPremiseRequest();
            // set header
            HeaderType header=new HeaderType();
            UUIDType uuidt = new UUIDType();
            uuidt.setUUIDType(uuid);
            header.setMessageID(uuidt);
            DateTime date = new DateTime();
            Calendar now = Calendar.getInstance();
            date.setDateTime(now);
            header.setDateTime(date);
            businessPremiseRequest.setHeader(header);
            businessPremiseRequest.setBusinessPremise( getPremise (premise));
            businessPremiseRequest.setId(signElemetId);
            businessPremiseRequest.setSignature(signPremiseRequest(businessPremiseRequest,  signElemetId));

            // send it
            BusinessPremiseResponse businessPremiseResponse = stub.businessPremise(businessPremiseRequest);

            // check the answer
            ErrorType error = businessPremiseResponse.getError();
            SignatureType ResponseSignature = businessPremiseResponse.getSignature();

            return;

        } catch (AxisFault e) {
            throw new FursPluginException(e);
        } catch (RemoteException e) {
            throw new FursPluginException(e);
        }
    }

    private BusinessPremiseType getPremise(Premise premise) throws FursPluginException {
        BusinessPremiseType businessPremise = new BusinessPremiseType();

        TaxNumberType taxNumber = new TaxNumberType();
        PositiveInteger intTax = new PositiveInteger(premise.getTaxNumber());
        taxNumber.setTaxNumberType(intTax);
        businessPremise.setTaxNumber(taxNumber);

        BusinessPremiseIDType premiseID = new BusinessPremiseIDType();
        premiseID.setBusinessPremiseIDType(premise.getPremiseId());
        businessPremise.setBusinessPremiseID(premiseID);

        BPIdentifierType bpIdentifier = new BPIdentifierType();
        CadastralData cadastralData = premise.getCadastralData();
        if (cadastralData != null) { // if real estate - immobile premise
            RealEstateBPType bp = new RealEstateBPType();

            PropertyIDType pit = new PropertyIDType();
            CadastralNumber_type1 cn= new CadastralNumber_type1();
            cn.setCadastralNumber_type0(new BigInteger(cadastralData.getCadastralCommunityNumber()));
            pit.setCadastralNumber(cn);
            BuildingNumber_type1 bn = new BuildingNumber_type1();
            bn.setBuildingNumber_type0(new BigInteger(cadastralData.getCadastralBuildingNumber()));
            pit.setBuildingNumber(bn);
            BuildingSectionNumber_type1 sn = new BuildingSectionNumber_type1();
            sn.setBuildingSectionNumber_type0(new BigInteger(cadastralData.getCadastralBuildingPartNumber()));
            pit.setBuildingSectionNumber(sn);
            bp.setPropertyID(pit);

            AddressType at = new AddressType();
            Street_type1 st = new Street_type1();
            st.setStreet_type0(premise.getAdress().getStreet());
            at.setStreet(st);
            HouseNumber_type1 hn = new HouseNumber_type1();
            hn.setHouseNumber_type0(premise.getAdress().getNumber());
            at.setHouseNumber(hn);
            if (premise.getAdress().getNumberAd()!=null) {
                HouseNumberAdditional_type1 hna = new HouseNumberAdditional_type1();
                hna.setHouseNumberAdditional_type0(premise.getAdress().getNumberAd());
                at.setHouseNumberAdditional(hna);
            }
            Community_type1 co = new Community_type1(); //naselje
            co.setCommunity_type0(premise.getAdress().getTown());
            at.setCommunity(co); // pošta
            City_type1 ci= new City_type1();
            ci.setCity_type0(premise.getAdress().getPostName());
            at.setCity(ci);
            PostalCode_type1 pc = new PostalCode_type1();
            pc.setPostalCode_type0(premise.getAdress().getPostNumber());
            at.setPostalCode(pc);

            bp.setAddress(at);
            bpIdentifier.setRealEstateBP(bp);
        } else { // if mobile premise - without address and cadastral data
            if ('A' == premise.getMovablePremise()) {
                bpIdentifier.setPremiseType(OtherPremiseType.A);
            } else if ('B' == premise.getMovablePremise()) {
                bpIdentifier.setPremiseType(OtherPremiseType.B);
            } else if ('C' == premise.getMovablePremise()) {
                bpIdentifier.setPremiseType(OtherPremiseType.C);
            }
        }
        businessPremise.setBPIdentifier(bpIdentifier);

        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date javaDate = df.parse(premise.getPremiseValidityDate());
            si.gov.fu.www.Date fursDate = new si.gov.fu.www.Date();
            fursDate.setDate(javaDate);
            businessPremise.setValidityDate(fursDate);
        } catch (ParseException e) {
            throw new FursPluginException(e);
        }


        if (premise.getClosePremise()) businessPremise.setClosingTag(ClosingTagType.Z);

        SwProvider swProvider = premise.getSwProvider();
        SoftwareSupplierType swSuplier = new SoftwareSupplierType();
        if (swProvider.getVat()!=null) {
            TaxNumberType tn = new TaxNumberType();
            PositiveInteger pi = new PositiveInteger(swProvider.getVat());
            tn.setTaxNumberType(pi);
            swSuplier.setTaxNumber(tn);
        } else if (swProvider.getForeignTitle()!=null) {
            NameForeign_type1 nf = new NameForeign_type1();
            nf.setNameForeign_type0(swProvider.getForeignTitle());
            swSuplier.setNameForeign(nf);
        }
        businessPremise.addSoftwareSupplier(swSuplier);

        String aux = premise.getAux();
        if (aux != null) {
            SpecialNotes_type5 sn = new SpecialNotes_type5();
            sn.setSpecialNotes_type4(aux);
            businessPremise.setSpecialNotes(sn);
        }

        return businessPremise;
    }

    private SignatureType signPremiseRequest(BusinessPremiseRequest businessPremiseRequest, String id) throws FursPluginException {
        SignatureType requestSinature = new SignatureType();

        SignatureValueType svt = new SignatureValueType();

        String signature="QCZyHtQi3PF7sFS0/vlbaHy1kNUr7B/SII6eqT9sUznm8Zm7xGu88J+Kvqei7lC/YhxIXoLPVay7Y+9d\n" +
                "PM729GPaldETkWEZaiPXhHIuWT/0VfPohFW7qet5Ar4N2uvtKygztiOtjABl3jPacrdjgqERbIjc/bF3q8dEOHqcKn/i6TVor\n" +
                "ObDEXnA0ZmAdmr4Q11f3nxo7P6dDaLmZzhvmNGniHN/B+NmAaZcb2d/NmQn\n" +
                "SCn1GB58y42rgka/LoltL0iN9gqyRgn\n" +
                "oV4QXLkJj7tRsXTMywmZqKaa5F8VIlx6mvgw5rhkBSVU5Qnu+2qg6v0kfR46Tpm7vIodR8YkTsw==";
        DataHandler dh = new DataHandler(new ByteArrayDataSource(signature.getBytes(StandardCharsets.UTF_8),"utf-8"));
        svt.setBase64Binary(dh);
        requestSinature.setSignatureValue(svt);

        requestSinature.setSignedInfo(setSignatureInfo());
        requestSinature.setKeyInfo(getKeyInfo());
        return requestSinature;
    }

    private KeyInfoType getKeyInfo() {
        KeyInfoType ki = new KeyInfoType();
        KeyInfoTypeChoice kitc = new KeyInfoTypeChoice();
        X509DataType x509d = new X509DataType();
        X509DataTypeSequence x509ds = new X509DataTypeSequence();
        X509DataTypeChoice_type0 x509dc = new X509DataTypeChoice_type0();
        x509dc.setX509SubjectName("CN=TESTNO PODJETJE 182,SERIALNUMBER=1,OU=10075623,OU=DavPotRacTEST,O=state-institutions,C=SI");
        x509ds.setX509DataTypeChoice_type0(x509dc);
        x509d.addX509DataTypeSequence(x509ds);
        kitc.setX509Data(x509d);
        ki.addKeyInfoTypeChoice(kitc);
        return ki;
    }

    private SignedInfoType setSignatureInfo() throws FursPluginException {

        try {
            SignedInfoType sit = new SignedInfoType();
            CanonicalizationMethodType cmt = new CanonicalizationMethodType();
            cmt.setAlgorithm(new URI(Sign.getCanonicalizationMethod()));
            sit.setCanonicalizationMethod(cmt);
            SignatureMethodType smt = new SignatureMethodType();
            smt.setAlgorithm(new URI(Sign.getSignatureMethod()));
            sit.setSignatureMethod(smt);
            ReferenceType ref = new ReferenceType();
            DigestMethodType dm = new DigestMethodType();
            dm.setAlgorithm(new URI(Sign.getDigestMethod()));
            ref.setDigestMethod(dm);
            ref.setURI(new URI("#burek"));
            DigestValueType dv = new DigestValueType();
            DataHandler dh = new DataHandler(new ByteArrayDataSource("0BpBFww14RJoiKeMwl5KnaR0DPGiRM0gUbfPETqgUgc=".getBytes(StandardCharsets.UTF_8),"utf-8"));
            dv.setDigestValueType(dh);
            ref.setDigestValue(dv);
            sit.addReference(ref);
            return sit;
        } catch (URI.MalformedURIException e) {
            throw new FursPluginException(e);
        }
    }

    public String issueInvoice(String id, Invoice invoice, String signingCertAlias) throws FursPluginException{

        checkInput(id, invoice);

        return null;
    }

    public void ping() throws FursPluginException{
        try {
            FiscalVerificationServiceStub stub = new FiscalVerificationServiceStub(url);

            EchoRequest echoRequest = new EchoRequest();
            echoRequest.setEchoRequest(PING_STRING);
            EchoResponse echoResponse= stub.echo(echoRequest);
            echoResponse.getEchoResponse();

        } catch (AxisFault e) {
            throw new FursPluginException(e);
        } catch (RemoteException e) {
            throw new FursPluginException(e);
        }
    }

    private void checkInput(String id, FursObject obj) throws FursPluginException{
        if (id!=null && id.length()==ID_LENGTH && obj!=null || obj.validateData()) {
            return;
        }
        throw new FursPluginException("Not valid arguments");
    }
}
