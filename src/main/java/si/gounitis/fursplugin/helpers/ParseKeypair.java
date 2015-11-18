package si.gounitis.fursplugin.helpers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Date;

/**
 * Created by Jure on 14.11.2015.
 */
public class ParseKeypair {
    private String subjectName;
    private String issuerName;
    private BigInteger serialNumber;
    private PrivateKey privateKey;
    private PublicKey publicKey;
    private Date validTill;
    private Date validFrom;

    public ParseKeypair(String signingCertAlias) {
        try {
            KeyStore ks = KeyStore.getInstance("JKS");
            FileInputStream fis = new FileInputStream(System.getProperty("javax.net.ssl.keyStore"));
            ks.load(fis, System.getProperty("javax.net.ssl.keyStorePassword").toCharArray());
            X509Certificate cert = (X509Certificate) ks.getCertificate(signingCertAlias);
            subjectName = cert.getSubjectX500Principal().getName();
            issuerName = cert.getIssuerDN().getName();
            serialNumber = cert.getSerialNumber();
            privateKey = (PrivateKey) ks.getKey(signingCertAlias, System.getProperty("javax.net.ssl.keyStorePassword").toCharArray());
            publicKey = cert.getPublicKey();
            validTill = cert.getNotAfter();
            validFrom = cert.getNotBefore();
        } catch (KeyStoreException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (CertificateException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (UnrecoverableKeyException e) {
            throw new RuntimeException(e);
        }
    }

    public String getSubjectName() {
        return subjectName;
    }

    public String getIssuerName() {
        return issuerName;
    }

    public BigInteger getSerialNumber() {
        return serialNumber;
    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }

    public Date getValidTill() {
        return validTill;
    }

    public Date getValidFrom() {
        return validFrom;
    }
}
