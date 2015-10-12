package si.gounitis.fursplugin.tests;

import org.junit.Test;
import si.gounitis.fursplugin.FursPlugin;
import si.gounitis.fursplugin.FursPluginException;
import si.gounitis.fursplugin.beans.Address;
import si.gounitis.fursplugin.beans.CadastralData;
import si.gounitis.fursplugin.beans.Premise;
import si.gounitis.fursplugin.beans.SwProvider;
import si.gounitis.fursplugin.impl.FursPluginAxis2;

/**
 * Created by Jure on 8.10.2015.
 */
public class TestPremise {
    public TestPremise() {
        System.setProperty("javax.net.ssl.trustStore", "keys/keystore.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
        System.setProperty("javax.net.ssl.keyStore", "keys/keystore.jks");
        System.setProperty("javax.net.ssl.keyStorePassword", "changeit");
        System.setProperty("javax.net.debug", "all");
    }

    //@Test
    public void testPremiseRealEstate() {

        Premise premise=new Premise();
        premise.setTaxNumber("12345678");
        premise.setPremiseLabel("36CF"); // 1-20 znakov brez presledkov (a-z,A-Z,0-9)
        CadastralData cadastralData = new CadastralData(); // �e je nepremi�en objekt
        cadastralData.setCadastralCommunityNumber("228"); // max 4 cifre - �e je nepremi�en objekt
        cadastralData.setCadastralBuildingNumber("123"); // max 5 cifer - �e je nepremi�en objekt
        cadastralData.setCadastralBuildingPartNumber("5"); // max 4 cifre - �e je nepremi�en objekt
        premise.setCadastralData(cadastralData);
        Address address = new Address(); // �e je neprremi�en objekt
        address.setStreet("Dolenjska ceta"); // �e je neprremi�en objekt
        address.setNumber("5"); // �e je neprremi�en objekt
        address.setNumberAd("a"); // �e je neprremi�en objekt in obstaja dodatek k hi�ni �tevilki
        address.setTown("Zabukovica");
        address.setPostName("�alec");
        address.setPostNumber("3221");
        premise.setAdress(address);
       // premise.setMovablePremise('A'); // A � premi�en objekt (npr. prevozno sredstvo, premi�na stojnica) ali B � objekt na stalni lokaciji (npr. stojnica na tr�nici, kiosk) ali C � posamezna elektronska naprava za izdajo ra�unov ali vezana knjiga ra�unov v primerih, ko zavezanec ne uporablja drugega poslovnega prostora
        premise.setPremiseValidityDate("2015-01-22"); // od kdaj je prostor registiran
        //premise.setClosePremise(true); // �e zapisramo objekt
        SwProvider swProvider = new SwProvider();
        swProvider.setVat("22222222"); // �e je slovenski dobavitelj SW
        //swProvider.setTitle("Kebab gmbh, BurekStr 22, Munchen"); // �e je tuj dobavitelj SW
        premise.setSwProvider(swProvider);
        FursPlugin plugin= new FursPluginAxis2("https://blagajne-test.fu.gov.si:9002/v1/cash_registers");
        try {
            plugin.initPremise("12345678-1234-1234-1234-123456789ABC",premise, "signcert");
        } catch (FursPluginException e) {
            throw new RuntimeException(e);
        }

    }
    //@Test
    public void testPremiseRealMobileForegnSwDeveloper() {

        Premise premise=new Premise();
        premise.setTaxNumber("12345678");
        premise.setPremiseLabel("36CF"); // 1-20 znakov brez presledkov (a-z,A-Z,0-9)
        premise.setMovablePremise('A'); // A � premi�en objekt (npr. prevozno sredstvo, premi�na stojnica) ali B � objekt na stalni lokaciji (npr. stojnica na tr�nici, kiosk) ali C � posamezna elektronska naprava za izdajo ra�unov ali vezana knjiga ra�unov v primerih, ko zavezanec ne uporablja drugega poslovnega prostora
        premise.setPremiseValidityDate("2015-01-22"); // od kdaj je prostor registiran
        //premise.setClosePremise(true); // �e zapisramo objekt
        SwProvider swProvider = new SwProvider();
        //swProvider.setVat("22222222"); // �e je slovenski dobavitelj SW
        swProvider.setTitle("Kebab gmbh, BurekStr 22, Munchen"); // �e je tuj dobavitelj SW
        premise.setSwProvider(swProvider);
        FursPlugin plugin= new FursPluginAxis2("https://blagajne-test.fu.gov.si:9002/v1/cash_registers");
        try {
            plugin.initPremise("12345678-1234-1234-1234-123456789ABC",premise, "signcert");
        } catch (FursPluginException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    public void testPremiseCloseAdditionalData() {

        Premise premise=new Premise();
        premise.setTaxNumber("12345678");
        premise.setPremiseLabel("36CF"); // 1-20 znakov brez presledkov (a-z,A-Z,0-9)
        premise.setMovablePremise('A'); // A � premi�en objekt (npr. prevozno sredstvo, premi�na stojnica) ali B � objekt na stalni lokaciji (npr. stojnica na tr�nici, kiosk) ali C � posamezna elektronska naprava za izdajo ra�unov ali vezana knjiga ra�unov v primerih, ko zavezanec ne uporablja drugega poslovnega prostora
        premise.setPremiseValidityDate("2015-01-22"); // od kdaj je prostor registiran
        premise.setClosePremise(true); // �e zapisramo objekt
        SwProvider swProvider = new SwProvider();
        swProvider.setVat("22222222"); // �e je slovenski dobavitelj SW
        //swProvider.setTitle("Kebab gmbh, BurekStr 22, Munchen"); // �e je tuj dobavitelj SW
        premise.setSwProvider(swProvider);
        premise.setAux("To je poljuben string dolg najvec 1000 znakov. Sicer ni verjetno, da ga bo ko bral, ampak vseeno");
        //FursPlugin plugin= new FursPluginAxis2("https://blagajne-test.fu.gov.si:9002/v1/cash_registers");
        FursPlugin plugin= new FursPluginAxis2("http://www.najdi.si");
        try {
            plugin.initPremise("12345678-1234-1234-1234-123456789ABC",premise, "signcert");
        } catch (FursPluginException e) {
            throw new RuntimeException(e);
        }

    }

}
