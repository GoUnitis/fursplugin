package si.gounitis.fursplugin.tests;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import si.gounitis.fursplugin.FursPlugin;
import si.gounitis.fursplugin.FursPluginException;
import si.gounitis.fursplugin.beans.*;
import si.gounitis.fursplugin.helpers.Tools;
import si.gounitis.fursplugin.impl.FursPluginJson;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource("classpath:test.properties")
public class TestStorno {

    @Value("${issuer.vat}")
    public String issuerVat;

    @Value("${issuer.signcert.alias}")
    public String signingCertAlias;

    @Value("${truststore.location}")
    public String truststoreLocation;

    @Value("${truststore.pass}")
    public String truststorePass;

    @Value("${keystore.location}")
    public String keystoreLocation;

    @Value("${keystore.pass}")
    public String keystorePass;

    @Before
    public void before() {
        System.setProperty("javax.net.ssl.trustStore", truststoreLocation);
        System.setProperty("javax.net.ssl.trustStorePassword", truststorePass);
        System.setProperty("javax.net.ssl.keyStore", keystoreLocation);
        System.setProperty("javax.net.ssl.keyStorePassword", keystorePass);
        //System.setProperty("javax.net.debug", "all");
    }

    @Test
    public void testInvoiceCacheRegisterStorno() {

        FursPlugin plugin= new FursPluginJson("https://blagajne-test.fu.gov.si:9002//v1/cash_registers/invoices");

        Invoice invoice = new Invoice();
        invoice.setSallesBook(false);
        invoice.setTaxNumber(issuerVat);
        invoice.setIssueDateTime("2015-11-22T09:55:25");
        invoice.setNumberingStructure('B');
        invoice.setPremiseId("36CF");
        invoice.setDeviceId("REG12");
        // ce operator ima slo ds - sicer nastavis invoice.setForeignOperator(true);
        invoice.setOperatorTaxNumber("41125029");
        invoice.setCustomerVatNumber("38409747"); // optional - if invoice with VAT
        invoice.setInvoiceNumber("206");
        invoice.setInvoiceAmmount("-50.00");
        invoice.setPaymentAmmount("-50.00");

        // if You do not add taxesPerSellerList it is assumed thad issuer is not VAT liable
        List<TaxesPerSeller> taxesPerSellerList = new ArrayList<TaxesPerSeller>();
        TaxesPerSeller taxesPerSeller = new TaxesPerSeller();

        List<Vat> vatList = new ArrayList<Vat>();
        Vat vat1 = new Vat();
        vat1.setTaxRate("22.00");
        vat1.setTaxableAmmount("-20.00");
        vat1.setTaxAmmount("-4.44");
        vatList.add(vat1);
        Vat vat2 = new Vat();
        vat2.setTaxRate("9.50");
        vat2.setTaxableAmmount("-30.00");
        vat2.setTaxAmmount("-2.85");
        vatList.add(vat2);

        taxesPerSeller.setVat(vatList);
        taxesPerSellerList.add(taxesPerSeller);
        invoice.setTaxesPerSeller(taxesPerSellerList);

        ReferenceInvoice referenceInvoice = new ReferenceInvoice();
        referenceInvoice.setReferenceInvoiceDeviceId("REG12");
        referenceInvoice.setReferenceInvoiceInvoiceNumber("205");
        referenceInvoice.setReferenceInvoiceIssueDateTime("2015-11-22T09:55:25");
        referenceInvoice.setReferenceInvoicePremiseId("36CF");

        invoice.setReferenceInvoice(referenceInvoice);

        invoice.setAux("To je poljuben string dolg najvec 1000 znakov. Sicer ni verjetno, da ga bo ko bral, ampak vseeno");

        try {
            InvoceReturnValue rv = plugin.issueInvoice(Tools.getNewUiid(), invoice, signingCertAlias);
            System.out.println(rv);
        } catch (FursPluginException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testInvoiceCacheRegisterPartialStorno() {

        FursPlugin plugin= new FursPluginJson("https://blagajne-test.fu.gov.si:9002//v1/cash_registers/invoices");

        Invoice invoice = new Invoice();
        invoice.setSallesBook(false);
        invoice.setTaxNumber(issuerVat);
        invoice.setIssueDateTime("2015-11-22T09:55:25");
        invoice.setNumberingStructure('B');
        invoice.setPremiseId("36CF");
        invoice.setDeviceId("REG12");
        // ce operator ima slo ds - sicer nastavis invoice.setForeignOperator(true);
        invoice.setOperatorTaxNumber("41125029");
        invoice.setCustomerVatNumber("38409747"); // optional - if invoice with VAT
        invoice.setInvoiceNumber("206");
        invoice.setInvoiceAmmount("-20.00");
        invoice.setPaymentAmmount("-20.00");

        // if You do not add taxesPerSellerList it is assumed thad issuer is not VAT liable
        List<TaxesPerSeller> taxesPerSellerList = new ArrayList<TaxesPerSeller>();
        TaxesPerSeller taxesPerSeller = new TaxesPerSeller();

        List<Vat> vatList = new ArrayList<Vat>();
        Vat vat1 = new Vat();
        vat1.setTaxRate("22.00");
        vat1.setTaxableAmmount("-20.00");
        vat1.setTaxAmmount("-4.44");
        vatList.add(vat1);

        taxesPerSeller.setVat(vatList);
        taxesPerSellerList.add(taxesPerSeller);
        invoice.setTaxesPerSeller(taxesPerSellerList);

        ReferenceInvoice referenceInvoice = new ReferenceInvoice();
        referenceInvoice.setReferenceInvoiceDeviceId("REG12");
        referenceInvoice.setReferenceInvoiceInvoiceNumber("205");
        referenceInvoice.setReferenceInvoiceIssueDateTime("2015-11-22T09:55:25");
        referenceInvoice.setReferenceInvoicePremiseId("36CF");

        invoice.setReferenceInvoice(referenceInvoice);

        invoice.setAux("To je poljuben string dolg najvec 1000 znakov. Sicer ni verjetno, da ga bo ko bral, ampak vseeno");

        try {
            InvoceReturnValue rv = plugin.issueInvoice(Tools.getNewUiid(), invoice, signingCertAlias);
            System.out.println(rv);
        } catch (FursPluginException e) {
            throw new RuntimeException(e);
        }
    }
}
