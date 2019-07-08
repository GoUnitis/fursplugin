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
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import si.gounitis.fursplugin.FursPlugin;
import si.gounitis.fursplugin.FursPluginException;
import si.gounitis.fursplugin.beans.Address;
import si.gounitis.fursplugin.beans.CadastralData;
import si.gounitis.fursplugin.beans.Premise;
import si.gounitis.fursplugin.beans.SwProvider;
import si.gounitis.fursplugin.helpers.Tools;
import si.gounitis.fursplugin.impl.FursPluginJson;

@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource("classpath:test.properties")
public class TestPremise {

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
    public void testPremiseRealEstate() {
        FursPlugin plugin= new FursPluginJson("https://blagajne-test.fu.gov.si:9002/v1/cash_registers/invoices/register");

        Premise premise=new Premise();
        premise.setTaxNumber(issuerVat);
        premise.setPremiseId("36CF"); // 1-20 znakov brez presledkov (a-z,A-Z,0-9)
        CadastralData cadastralData = new CadastralData(); // �e je nepremi�en objekt
        cadastralData.setCadastralCommunityNumber("228"); // max 4 cifre - �e je nepremi�en objekt
        cadastralData.setCadastralBuildingNumber("123"); // max 5 cifer - �e je nepremi�en objekt
        cadastralData.setCadastralBuildingPartNumber("5"); // max 4 cifre - �e je nepremi�en objekt
        premise.setCadastralData(cadastralData);
        Address address = new Address(); // �e je neprremi�en objekt
        address.setStreet("Dolenjska ceta"); // �e je neprremi�en objekt
        address.setNumber("5"); // �e je neprremi�en objekt
        address.setNumberAd("A"); // �e je neprremi�en objekt in obstaja dodatek k hi�ni �tevilki
        address.setTown("Kranj");
        address.setPostName("Kranj");
        address.setPostNumber("3221");
        premise.setAdress(address);
       // premise.setMovablePremise('A'); // A � premi�en objekt (npr. prevozno sredstvo, premi�na stojnica) ali B � objekt na stalni lokaciji (npr. stojnica na tr�nici, kiosk) ali C � posamezna elektronska naprava za izdajo ra�unov ali vezana knjiga ra�unov v primerih, ko zavezanec ne uporablja drugega poslovnega prostora
        premise.setPremiseValidityDate("2020-01-22"); // od kdaj je prostor registiran
        //premise.setClosePremise(true); // �e zapisramo objekt
        SwProvider swProvider = new SwProvider();
        swProvider.setVat("72114916"); // �e je slovenski dobavitelj SW
        //swProvider.setForeignTitle("Kebab gmbh, BurekStr 22, Munchen"); // �e je tuj dobavitelj SW
        premise.setSwProvider(swProvider);
        premise.setAux("To je poljuben string dolg najvec 1000 znakov. Sicer ni verjetno, da ga bo ko bral, ampak vseeno");

        try {
            plugin.registerPremise(Tools.getNewUiid(), premise, signingCertAlias);
        } catch (FursPluginException e) {
            throw new RuntimeException(e);
        }

    }

    //@Test
    public void testPremiseMobileForegnSwDeveloper() {

        //FursPlugin plugin= new FursPluginSOAP("https://blagajne-test.fu.gov.si:9002/v1/cash_registers");
        FursPlugin plugin= new FursPluginJson("https://blagajne-test.fu.gov.si:9002/v1/cash_registers/invoices/register");

        Premise premise=new Premise();
        premise.setTaxNumber(issuerVat);
        premise.setPremiseId("36CF"); // 1-20 znakov brez presledkov (a-z,A-Z,0-9)
        premise.setMovablePremise('A'); // A � premi�en objekt (npr. prevozno sredstvo, premi�na stojnica) ali B � objekt na stalni lokaciji (npr. stojnica na tr�nici, kiosk) ali C � posamezna elektronska naprava za izdajo ra�unov ali vezana knjiga ra�unov v primerih, ko zavezanec ne uporablja drugega poslovnega prostora
        premise.setPremiseValidityDate("2015-01-22"); // od kdaj je prostor registiran
        //premise.setClosePremise(true); // �e zapisramo objekt
        SwProvider swProvider = new SwProvider();
        //swProvider.setVat("72114916"); // �e je slovenski dobavitelj SW
        swProvider.setForeignTitle("Kebab gmbh, BurekStr 22, Munchen"); // �e je tuj dobavitelj SW
        premise.setSwProvider(swProvider);
        premise.setAux("To je poljuben string dolg najvec 1000 znakov. Sicer ni verjetno, da ga bo ko bral, ampak vseeno");

        try {
            plugin.registerPremise(Tools.getNewUiid(), premise, signingCertAlias);
        } catch (FursPluginException e) {
            throw new RuntimeException(e);
        }

    }

    //@Test
    public void testPremiseCloseAdditionalData() {

        //FursPlugin plugin= new FursPluginSOAP("https://blagajne-test.fu.gov.si:9002/v1/cash_registers");
        FursPlugin plugin= new FursPluginJson("https://blagajne-test.fu.gov.si:9002/v1/cash_registers/invoices/register");

        Premise premise=new Premise();
        premise.setTaxNumber(issuerVat);
        premise.setPremiseId("36CF"); // 1-20 znakov brez presledkov (a-z,A-Z,0-9)
        premise.setMovablePremise('A'); // A � premi�en objekt (npr. prevozno sredstvo, premi�na stojnica) ali B � objekt na stalni lokaciji (npr. stojnica na tr�nici, kiosk) ali C � posamezna elektronska naprava za izdajo ra�unov ali vezana knjiga ra�unov v primerih, ko zavezanec ne uporablja drugega poslovnega prostora
        premise.setPremiseValidityDate("2015-01-22"); // od kdaj je prostor registiran
        premise.setClosePremise(true); // �e zapisramo objekt
        SwProvider swProvider = new SwProvider();
        swProvider.setVat("72114916"); // �e je slovenski dobavitelj SW
        //swProvider.setForeignTitle("Kebab gmbh, BurekStr 22, Munchen"); // �e je tuj dobavitelj SW
        premise.setSwProvider(swProvider);
        premise.setAux("To je poljuben string dolg najvec 1000 znakov. Sicer ni verjetno, da ga bo ko bral, ampak vseeno");

        try {
            plugin.registerPremise(Tools.getNewUiid(), premise, signingCertAlias);
        } catch (FursPluginException e) {
            throw new RuntimeException(e);
        }

    }

}
