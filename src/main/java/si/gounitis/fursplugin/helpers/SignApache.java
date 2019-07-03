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

package si.gounitis.fursplugin.helpers;

import com.sun.org.apache.xml.internal.security.keys.KeyInfo;
import com.sun.org.apache.xml.internal.security.keys.content.X509Data;
import com.sun.org.apache.xml.internal.security.signature.XMLSignature;
import com.sun.org.apache.xml.internal.security.transforms.Transforms;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;

public class SignApache {
    public static Document signDocument(Document doc, String BaseURI, String keystoreAlias) throws Exception {

        com.sun.org.apache.xml.internal.security.Init.init();

        //get the private key used to sign, from the keystore
        KeyStore ks = KeyStore.getInstance("JKS");
        FileInputStream fis = new FileInputStream(System.getProperty("javax.net.ssl.keyStore"));
        ks.load(fis, System.getProperty("javax.net.ssl.keyStorePassword").toCharArray());
        PrivateKey privateKey = (PrivateKey) ks.getKey(keystoreAlias, System.getProperty("javax.net.ssl.keyStorePassword").toCharArray());

        //create basic structure of signature
        XMLSignature sig = new XMLSignature(doc, BaseURI, XMLSignature.ALGO_ID_SIGNATURE_RSA_SHA256);

        //optional, but better
        Element element = doc.getDocumentElement();
        //element.normalize();
        element.getElementsByTagName("fu:BusinessPremiseRequest").item(0).appendChild(sig.getElement()); // todo

        Transforms transforms = new Transforms(doc);
        transforms.addTransform(Transforms.TRANSFORM_ENVELOPED_SIGNATURE);

        // document to be signed
        sig.addDocument(BaseURI, transforms, "http://www.w3.org/2001/04/xmlenc#sha256");

        //Add requested fields to signature
        X509Certificate cert = (X509Certificate) ks.getCertificate(keystoreAlias);
        KeyInfo info = sig.getKeyInfo();
        X509Data data = new X509Data(doc);
        data.addIssuerSerial(cert.getIssuerDN().getName(), cert.getSerialNumber());
        data.addSubjectName(cert.getSubjectX500Principal().getName());
        info.add(data);
        //sig.addKeyInfo(cert);
        //sig.addKeyInfo(cert.getPublicKey());

        // sign it
        sig.sign(privateKey);

        return doc;
    }
}
