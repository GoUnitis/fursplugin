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

public class TestInvoice {

    @Before
    public void before() {
        System.setProperty("javax.net.ssl.trustStore", "keys/keystore.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
        System.setProperty("javax.net.ssl.keyStore", "keys/keystore.jks");
        System.setProperty("javax.net.ssl.keyStorePassword", "changeit");
        //System.setProperty("javax.net.debug", "all");
    }

    @Test
    public void testInvoiceCacheRegister() {

        FursPlugin plugin= new FursPluginJson("https://blagajne-test.fu.gov.si:9002//v1/cash_registers/invoices");

        Invoice invoice = new Invoice();
        invoice.setSallesBook(false);
        invoice.setTaxNumber("10075623");
        invoice.setIssueDateTime("2015-11-22T09:55:25");
        invoice.setNumberingStructure('B');
        invoice.setPremiseId("36CF");
        invoice.setDeviceId("REG12");
        // ce operator ima slo ds - sicer nastavis invoice.setForeignOperator(true);
        invoice.setOperatorTaxNumber("41125029");
        invoice.setCustomerVatNumber("38409747"); // optional - if invoice with VAT
        invoice.setInvoiceNumber("205");
        invoice.setInvoiceAmmount("50.00");
        invoice.setPaymentAmmount("50.00");

        // if You do not add taxesPerSellerList it is assumed thad issuer is not VAT liable
        List<TaxesPerSeller> taxesPerSellerList = new ArrayList<TaxesPerSeller>();
        TaxesPerSeller taxesPerSeller = new TaxesPerSeller();

        List<Vat> vatList = new ArrayList<Vat>();
        Vat vat1 = new Vat();
        vat1.setTaxRate("22.00");
        vat1.setTaxableAmmount("20.00");
        vat1.setTaxAmmount("4.44");
        vatList.add(vat1);
        Vat vat2 = new Vat();
        vat2.setTaxRate("9.50");
        vat2.setTaxableAmmount("30.00");
        vat2.setTaxAmmount("2.85");
        vatList.add(vat2);

        taxesPerSeller.setVat(vatList);
        taxesPerSellerList.add(taxesPerSeller);
        invoice.setTaxesPerSeller(taxesPerSellerList);
        invoice.setAux("To je poljuben string dolg najvec 1000 znakov. Sicer ni verjetno, da ga bo ko bral, ampak vseeno");

        try {
            InvoceReturnValue rv = plugin.issueInvoice(Tools.getNewUiid(), invoice, "signcert");
            System.out.println(rv);
        } catch (FursPluginException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testInvoiceCacheRegisterNotVatLiable() {

        FursPlugin plugin= new FursPluginJson("https://blagajne-test.fu.gov.si:9002//v1/cash_registers/invoices");

        Invoice invoice = new Invoice();
        invoice.setSallesBook(false);
        invoice.setTaxNumber("10075623");
        invoice.setIssueDateTime("2015-11-22T09:55:25");
        invoice.setNumberingStructure('B');
        invoice.setPremiseId("36CF");
        invoice.setDeviceId("REG12");
        invoice.setForeignOperator(true);
        invoice.setInvoiceNumber("205");
        invoice.setInvoiceAmmount("30.00");
        invoice.setPaymentAmmount("30.00");
        invoice.setTaxesPerSeller(null);
        invoice.setAux("To je poljuben string dolg najvec 1000 znakov. Sicer ni verjetno, da ga bo ko bral, ampak vseeno");

        try {
            InvoceReturnValue rv = plugin.issueInvoice(Tools.getNewUiid(), invoice, "signcert");
            System.out.println(rv);
        } catch (FursPluginException e) {
            throw new RuntimeException(e);
        }
    }

    //@Test
    public void testInvoiceSalesBook() {

        FursPlugin plugin= new FursPluginJson("https://blagajne-test.fu.gov.si:9002//v1/cash_registers/invoices");

        Invoice invoice = new Invoice();

        try {
            InvoceReturnValue rv = plugin.issueInvoice(Tools.getNewUiid(), invoice, "signcert");
            System.out.println(rv);
        } catch (FursPluginException e) {
            throw new RuntimeException(e);
        }


    }
}

