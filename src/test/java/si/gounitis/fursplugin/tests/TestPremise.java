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
import si.gounitis.fursplugin.beans.Address;
import si.gounitis.fursplugin.beans.CadastralData;
import si.gounitis.fursplugin.beans.Premise;
import si.gounitis.fursplugin.beans.SwProvider;
import si.gounitis.fursplugin.helpers.Tools;
import si.gounitis.fursplugin.impl.FursPluginSimple;

public class TestPremise {
    public TestPremise() {
        System.setProperty("javax.net.ssl.trustStore", "keys/keystore.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
        System.setProperty("javax.net.ssl.keyStore", "keys/keystore.jks");
        System.setProperty("javax.net.ssl.keyStorePassword", "changeit");
        System.setProperty("javax.net.debug", "all");
    }

    @Test
    public void testPremiseRealEstate() {
        FursPlugin plugin= new FursPluginSimple("https://blagajne-test.fu.gov.si:9001/v1/cash_registers");
        //FursPlugin plugin= new FursPluginSimple("https://blagajne-test.fu.gov.si:9002/v1/cash_registers");
        //FursPlugin plugin = new FursPluginAxis2("https://blagajne-test.fu.gov.si:9002/v1/cash_registers");

        Premise premise=new Premise();
        premise.setTaxNumber("10075623");
        premise.setPremiseId("36CF"); // 1-20 znakov brez presledkov (a-z,A-Z,0-9)
        CadastralData cadastralData = new CadastralData(); // èe je nepremièen objekt
        cadastralData.setCadastralCommunityNumber("228"); // max 4 cifre - èe je nepremièen objekt
        cadastralData.setCadastralBuildingNumber("123"); // max 5 cifer - èe je nepremièen objekt
        cadastralData.setCadastralBuildingPartNumber("5"); // max 4 cifre - èe je nepremièen objekt
        premise.setCadastralData(cadastralData);
        Address address = new Address(); // èe je neprremièen objekt
        address.setStreet("Dolenjska ceta"); // èe je neprremièen objekt
        address.setNumber("5"); // èe je neprremièen objekt
        address.setNumberAd("A"); // èe je neprremièen objekt in obstaja dodatek k hišni številki
        address.setTown("Kranj");
        address.setPostName("Kranj");
        address.setPostNumber("3221");
        premise.setAdress(address);
       // premise.setMovablePremise('A'); // A – premièen objekt (npr. prevozno sredstvo, premièna stojnica) ali B – objekt na stalni lokaciji (npr. stojnica na tržnici, kiosk) ali C – posamezna elektronska naprava za izdajo raèunov ali vezana knjiga raèunov v primerih, ko zavezanec ne uporablja drugega poslovnega prostora
        premise.setPremiseValidityDate("2020-01-22"); // od kdaj je prostor registiran
        //premise.setClosePremise(true); // èe zapisramo objekt
        SwProvider swProvider = new SwProvider();
        swProvider.setVat("22222222"); // èe je slovenski dobavitelj SW
        //swProvider.setForeignTitle("Kebab gmbh, BurekStr 22, Munchen"); // èe je tuj dobavitelj SW
        premise.setSwProvider(swProvider);
        premise.setAux("To je poljuben string dolg najvec 1000 znakov. Sicer ni verjetno, da ga bo ko bral, ampak vseeno");

        try {
            plugin.registerPremise(Tools.getNewUiid(), premise, "signcert");
        } catch (FursPluginException e) {
            throw new RuntimeException(e);
        }

    }
    //@Test
    public void testPremiseMobileForegnSwDeveloper() {

        FursPlugin plugin= new FursPluginSimple("https://blagajne-test.fu.gov.si:9002/v1/cash_registers");
        //FursPlugin plugin = new FursPluginAxis2("https://blagajne-test.fu.gov.si:9002/v1/cash_registers");

        Premise premise=new Premise();
        premise.setTaxNumber("10075623");
        premise.setPremiseId("36CF"); // 1-20 znakov brez presledkov (a-z,A-Z,0-9)
        premise.setMovablePremise('A'); // A – premièen objekt (npr. prevozno sredstvo, premièna stojnica) ali B – objekt na stalni lokaciji (npr. stojnica na tržnici, kiosk) ali C – posamezna elektronska naprava za izdajo raèunov ali vezana knjiga raèunov v primerih, ko zavezanec ne uporablja drugega poslovnega prostora
        premise.setPremiseValidityDate("2015-01-22"); // od kdaj je prostor registiran
        //premise.setClosePremise(true); // èe zapisramo objekt
        SwProvider swProvider = new SwProvider();
        //swProvider.setVat("22222222"); // èe je slovenski dobavitelj SW
        swProvider.setForeignTitle("Kebab gmbh, BurekStr 22, Munchen"); // èe je tuj dobavitelj SW
        premise.setSwProvider(swProvider);
        premise.setAux("To je poljuben string dolg najvec 1000 znakov. Sicer ni verjetno, da ga bo ko bral, ampak vseeno");

        try {
            plugin.registerPremise(Tools.getNewUiid(), premise, "signcert");
        } catch (FursPluginException e) {
            throw new RuntimeException(e);
        }

    }

    //@Test
    public void testPremiseCloseAdditionalData() {

        FursPlugin plugin= new FursPluginSimple("https://blagajne-test.fu.gov.si:9002/v1/cash_registers");
        //FursPlugin plugin = new FursPluginAxis2("https://blagajne-test.fu.gov.si:9002/v1/cash_registers");

        Premise premise=new Premise();
        premise.setTaxNumber("10075623");
        premise.setPremiseId("36CF"); // 1-20 znakov brez presledkov (a-z,A-Z,0-9)
        premise.setMovablePremise('A'); // A – premièen objekt (npr. prevozno sredstvo, premièna stojnica) ali B – objekt na stalni lokaciji (npr. stojnica na tržnici, kiosk) ali C – posamezna elektronska naprava za izdajo raèunov ali vezana knjiga raèunov v primerih, ko zavezanec ne uporablja drugega poslovnega prostora
        premise.setPremiseValidityDate("2015-01-22"); // od kdaj je prostor registiran
        premise.setClosePremise(true); // èe zapisramo objekt
        SwProvider swProvider = new SwProvider();
        swProvider.setVat("22222222"); // èe je slovenski dobavitelj SW
        //swProvider.setForeignTitle("Kebab gmbh, BurekStr 22, Munchen"); // èe je tuj dobavitelj SW
        premise.setSwProvider(swProvider);
        premise.setAux("To je poljuben string dolg najvec 1000 znakov. Sicer ni verjetno, da ga bo ko bral, ampak vseeno");

        try {
            plugin.registerPremise(Tools.getNewUiid(), premise, "signcert");
        } catch (FursPluginException e) {
            throw new RuntimeException(e);
        }

    }

}
