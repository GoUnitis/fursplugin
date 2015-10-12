package si.gounitis.fursplugin.helpers;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import si.gounitis.fursplugin.FursPluginException;

import javax.xml.crypto.MarshalException;
import javax.xml.crypto.dsig.*;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import javax.xml.crypto.dsig.keyinfo.X509Data;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;

import org.w3c.dom.Element;

import java.io.*;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Jure on 9.10.2015.
 */
public class Sign {
    private static String DIGEST_METHOD = DigestMethod.SHA256;
    // private static String SIGNATURE_METHOD = SignatureMethod.RSA_SHA1;
    private static String SIGNATURE_METHOD = "http://www.w3.org/2001/04/xmldsig-more#rsa-sha256";
    private static String SIGNATURE_TYPE = Transform.ENVELOPED;
    private static String CANONICALIZATION_METHOD = CanonicalizationMethod.INCLUSIVE;

    // referenceUri = "" for signig whole document
    public static Document signDocument(Document doc, String referenceUri, String keystoreAlias) throws Exception {
        XMLSignatureFactory fac;
        X509Certificate cert;
        KeyStore.PrivateKeyEntry keyEntry;
        KeyInfo ki;
        SignedInfo si;

        String keyStore=System.getProperty("javax.net.ssl.keyStore");
        String keyStorePassword=System.getProperty("javax.net.ssl.keyStorePassword");

        try {
            fac = XMLSignatureFactory.getInstance("DOM");

            Reference ref = fac.newReference(referenceUri, fac.newDigestMethod(DIGEST_METHOD, null),
                    Collections.singletonList(fac.newTransform(SIGNATURE_TYPE , (TransformParameterSpec) null)), null, null);

            // Create the SignedInfo.
            si = fac.newSignedInfo(fac.newCanonicalizationMethod(CANONICALIZATION_METHOD,(C14NMethodParameterSpec) null),
                            fac.newSignatureMethod(SIGNATURE_METHOD, null),Collections.singletonList(ref));

            // Load signing certificate from keystor
            KeyStore ks = KeyStore.getInstance("JKS");
            ks.load(new FileInputStream(keyStore), keyStorePassword.toCharArray());
            keyEntry = (KeyStore.PrivateKeyEntry) ks.getEntry (keystoreAlias, new KeyStore.PasswordProtection(keyStorePassword.toCharArray()));
            if (keyEntry==null) {
                throw new FursPluginException ("Kea pair "+keystoreAlias+" not found in "+keyStore);
            }
            cert = (X509Certificate) keyEntry.getCertificate();

            // Create the KeyInfo containing the X509Data.
            KeyInfoFactory kif = fac.getKeyInfoFactory();
            List x509Content = new ArrayList();
            x509Content.add(cert.getSubjectX500Principal().getName());
            x509Content.add(cert);
            X509Data xd = kif.newX509Data(x509Content);
            ki = kif.newKeyInfo(Collections.singletonList(xd));

            // Create a DOMSignContext and specify the RSA PrivateKey and
            // location of the resulting XMLSignature's parent element.
            DOMSignContext dsc = new DOMSignContext(keyEntry.getPrivateKey(), doc.getDocumentElement());

            // Create the XMLSignature, but don't sign it yet.
            XMLSignature signature = fac.newXMLSignature(si, ki);

            // Marshal, generate, and sign the enveloped signature.
            signature.sign(dsc);

            // trimming the signature to fit FURS reqirenments
            deleteX509CertificateElement(doc);
            addIssuerData(doc);

            // Output the resulting document.
            return doc;
        } catch (XMLSignatureException e) {
            throw new FursPluginException(e);
        } catch (MarshalException e) {
            throw new FursPluginException(e);
        } catch (InvalidAlgorithmParameterException e) {
            throw new FursPluginException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new FursPluginException(e);
        }
    }

    private static void addIssuerData(Document doc) {
        doc.getDocumentElement().normalize();
        Element signature = (Element) doc.getElementsByTagName("Signature").item(0);
        Element keyInfo = (Element) signature.getElementsByTagName("KeyInfo").item(0);
        Element x509Data = (Element) keyInfo.getElementsByTagName("X509Data").item(0);
        Element x509IssuerSerial = doc.createElement("X509IssuerSerial");
        x509Data.appendChild(x509IssuerSerial);
        Element x509IssuerName = doc.createElement("X509IssuerName");
        x509IssuerName.insertBefore(doc.createTextNode("CN=Tax CA Test,O=state-institutions,C=SI"), x509IssuerName.getLastChild()); //todo from cert
        x509IssuerSerial.appendChild(x509IssuerName);
        Element x509SerialNumber = doc.createElement("X509SerialNumber");
        x509SerialNumber.insertBefore(doc.createTextNode("7377981114232509707"), x509SerialNumber.getLastChild()); //todo from cert
        x509IssuerSerial.appendChild(x509SerialNumber);
    }

    private static void deleteX509CertificateElement(Document doc) {
        doc.getDocumentElement().normalize();
        Element signature = (Element) doc.getElementsByTagName("Signature").item(0);
        Element keyInfo = (Element) signature.getElementsByTagName("KeyInfo").item(0);
        Element x509Data = (Element) keyInfo.getElementsByTagName("X509Data").item(0);
        Element x509Certificate = (Element) x509Data.getElementsByTagName("X509Certificate").item(0);
        x509Certificate.getParentNode().removeChild(x509Certificate);
        System.out.println();
    }

    public static String getDigestMethod() {
        return DIGEST_METHOD;
    }

    public static String getSignatureMethod() {
        return SIGNATURE_METHOD;
    }

    public static String getSignatureType() {
        return SIGNATURE_TYPE;
    }

    public static String getCanonicalizationMethod() {
        return CANONICALIZATION_METHOD;
    }
}
