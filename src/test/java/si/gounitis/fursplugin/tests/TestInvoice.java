package si.gounitis.fursplugin.tests;
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

import org.junit.Test;
import si.gounitis.fursplugin.FursPlugin;
import si.gounitis.fursplugin.FursPluginException;
import si.gounitis.fursplugin.beans.*;
import si.gounitis.fursplugin.impl.FursPluginSimple;

public class TestInvoice {
    public TestInvoice() {
        System.setProperty("javax.net.ssl.trustStore", "keys/keystore.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
        System.setProperty("javax.net.ssl.keyStore", "keys/keystore.jks");
        System.setProperty("javax.net.ssl.keyStorePassword", "changeit");
        //System.setProperty("javax.net.debug", "all");
    }

    @Test
    public void testInvoice() {

        FursPlugin plugin= new FursPluginSimple("https://blagajne-test.fu.gov.si:9002/v1/cash_registers");
        //FursPlugin plugin = new FursPluginAxis2("https://blagajne-test.fu.gov.si:9002/v1/cash_registers");

        Premise premise=new Premise();
        premise.setTaxNumber("12345678");
        premise.setPremiseId("36CF"); // 1-20 znakov brez presledkov (a-z,A-Z,0-9)

        Invoice invoice = new Invoice();

        try {
            plugin.issueInvoice("12345678-1234-1234-1234-123456789ABC", invoice, premise, "signcert");
        } catch (FursPluginException e) {
            throw new RuntimeException(e);
        }


    }
}

