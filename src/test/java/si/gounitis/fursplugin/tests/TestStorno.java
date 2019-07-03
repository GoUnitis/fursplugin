package si.gounitis.fursplugin.tests;


import org.junit.Before;
import org.junit.Test;
import si.gounitis.fursplugin.FursPlugin;
import si.gounitis.fursplugin.FursPluginException;
import si.gounitis.fursplugin.beans.*;
import si.gounitis.fursplugin.helpers.Tools;
import si.gounitis.fursplugin.impl.FursPluginJson;

import java.util.ArrayList;
import java.util.List;

public class TestStorno {

    @Before
    public void before() {
        System.setProperty("javax.net.ssl.trustStore", "keys/keystore.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
        System.setProperty("javax.net.ssl.keyStore", "keys/keystore.jks");
        System.setProperty("javax.net.ssl.keyStorePassword", "changeit");
        //System.setProperty("javax.net.debug", "all");
    }

    @Test
    public void testInvoiceCacheRegisterStorno() {

        FursPlugin plugin= new FursPluginJson("https://blagajne-test.fu.gov.si:9002//v1/cash_registers/invoices");

        Invoice invoice = new Invoice();
        invoice.setSallesBook(false);
        invoice.setTaxNumber("10075623");
        invoice.setIssueDateTime("2015-11-22T09:55:25");
        invoice.setNumberingStructure('B');
        invoice.setPremiseId("36CF");
        invoice.setDeviceId("REG12");
        invoice.setInvoiceNumber("206");
        invoice.setInvoiceAmmount("0.00");
        invoice.setPaymentAmmount("0.00");

        List<TaxesPerSeller> taxesPerSellerList = new ArrayList<TaxesPerSeller>();
        TaxesPerSeller taxesPerSeller = new TaxesPerSeller();

        List<Vat> vatList = new ArrayList<Vat>();
        Vat vat1 = new Vat();
        vat1.setTaxRate("22.00");
        vat1.setTaxableAmmount("0.00");
        vat1.setTaxAmmount("0.00");
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
            InvoceReturnValue rv = plugin.issueInvoice(Tools.getNewUiid(), invoice, "signcert");
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
        invoice.setTaxNumber("10075623");
        invoice.setIssueDateTime("2015-11-22T09:55:25");
        invoice.setNumberingStructure('B');
        invoice.setPremiseId("36CF");
        invoice.setDeviceId("REG12");
        invoice.setInvoiceNumber("206");
        invoice.setInvoiceAmmount("50.00");
        invoice.setPaymentAmmount("58.51");

        List<TaxesPerSeller> taxesPerSellerList = new ArrayList<TaxesPerSeller>();
        TaxesPerSeller taxesPerSeller = new TaxesPerSeller();

        List<Vat> vatList = new ArrayList<Vat>();
        Vat vat1 = new Vat();
        vat1.setTaxRate("22.00");
        vat1.setTaxableAmmount("30.00");
        vat1.setTaxAmmount("6.61");
        vatList.add(vat1);
        Vat vat2 = new Vat();
        vat2.setTaxRate("9.50");
        vat2.setTaxableAmmount("20.00");
        vat2.setTaxAmmount("1.90");
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
            InvoceReturnValue rv = plugin.issueInvoice(Tools.getNewUiid(), invoice, "signcert");
            System.out.println(rv);
        } catch (FursPluginException e) {
            throw new RuntimeException(e);
        }
    }
}
