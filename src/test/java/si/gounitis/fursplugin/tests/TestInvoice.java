//********************************************************************************
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
package si.gounitis.fursplugin.tests;

import org.junit.Test;
import si.gounitis.fursplugin.FursPlugin;
import si.gounitis.fursplugin.FursPluginException;
import si.gounitis.fursplugin.beans.*;
import si.gounitis.fursplugin.helpers.Tools;
import si.gounitis.fursplugin.impl.FursPluginJson;
import si.gounitis.fursplugin.impl.FursPluginSOAP;

import java.util.ArrayList;
import java.util.List;

public class TestInvoice {
    public TestInvoice() {
        System.setProperty("javax.net.ssl.trustStore", "keys/keystore.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
        System.setProperty("javax.net.ssl.keyStore", "keys/keystore.jks");
        System.setProperty("javax.net.ssl.keyStorePassword", "changeit");
        //System.setProperty("javax.net.debug", "all");
    }
    //@Test
    public void testInvoiceCacheRegister() {

        FursPlugin plugin= new FursPluginJson("https://blagajne-test.fu.gov.si:9002//v1/cash_registers/invoices");

        Invoice invoice = new Invoice();
        invoice.setSallesBook(false);
        invoice.setTaxNumber("10075623");
        invoice.setIssueDateTime("2015-11-22T09:55:25");
        invoice.setNumberingStructure('B');
        invoice.setPremiseId("36CF");
        invoice.setDeviceId("REG12");
        invoice.setInvoiceNumber("205");
        invoice.setInvoiceAmmount("30.00");
        invoice.setPaymentAmmount("36.61");
        List<TaxesPerSeller> taxesPerSellerList = new ArrayList<TaxesPerSeller>();
        TaxesPerSeller taxesPerSeller = new TaxesPerSeller();
        taxesPerSeller.setTaxRate("22.00");
        taxesPerSeller.setTaxableAmmount("30.00");
        taxesPerSeller.setTaxAmmount("6,61");
        taxesPerSellerList.add(taxesPerSeller);
        invoice.setTaxesPerSeller(taxesPerSellerList);
        invoice.setProtectedId("8202f0f963e37a2258b034cf8ae7bbc1");
        invoice.setAux("To je poljuben string dolg najvec 1000 znakov. Sicer ni verjetno, da ga bo ko bral, ampak vseeno");

        try {
            plugin.issueInvoice(Tools.getNewUiid(), invoice, "signcert");
        } catch (FursPluginException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testInvoiceCacheRegisterNoVat() {

        FursPlugin plugin= new FursPluginJson("https://blagajne-test.fu.gov.si:9002//v1/cash_registers/invoices");

        Invoice invoice = new Invoice();
        invoice.setSallesBook(false);
        invoice.setTaxNumber("10075623");
        invoice.setIssueDateTime("2015-11-22T09:55:25");
        invoice.setNumberingStructure('B');
        invoice.setPremiseId("36CF");
        invoice.setDeviceId("REG12");
        invoice.setInvoiceNumber("205");
        invoice.setInvoiceAmmount("30.00");
        invoice.setPaymentAmmount("30.00");
        invoice.setTaxesPerSeller(null);
        invoice.setProtectedId("8202f0f963e37a2258b034cf8ae7bbc1");
        invoice.setAux("To je poljuben string dolg najvec 1000 znakov. Sicer ni verjetno, da ga bo ko bral, ampak vseeno");

        try {
            plugin.issueInvoice(Tools.getNewUiid(), invoice, "signcert");
        } catch (FursPluginException e) {
            throw new RuntimeException(e);
        }
    }

    //@Test
    public void testInvoiceSalesBook() {

        FursPlugin plugin= new FursPluginJson("https://blagajne-test.fu.gov.si:9002//v1/cash_registers/invoices");

        Invoice invoice = new Invoice();

        try {
            plugin.issueInvoice(Tools.getNewUiid(), invoice , "signcert");
        } catch (FursPluginException e) {
            throw new RuntimeException(e);
        }


    }
}

