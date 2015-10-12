package si.gounitis.fursplugin.tests;

import org.junit.Test;
import si.gounitis.fursplugin.FursPlugin;
import si.gounitis.fursplugin.FursPluginException;
import si.gounitis.fursplugin.impl.FursPluginAxis2;
import si.gounitis.fursplugin.impl.FursPluginSimple;

import static org.junit.Assert.assertEquals;

/**
 * Created by Jure on 7.10.2015.
 */
public class TestPing {

    @Test
    public void testPing() {
        System.setProperty("javax.net.ssl.trustStore","keys/keystore.jks");
        System.setProperty("javax.net.ssl.trustStorePassword","changeit");
        System.setProperty("javax.net.ssl.keyStore","keys/keystore.jks");
        System.setProperty("javax.net.ssl.keyStorePassword","changeit");
        FursPlugin plugin = new FursPluginSimple("https://blagajne-test.fu.gov.si:9002/v1/cash_registers");
        //FursPlugin plugin = new FursPluginAxis2("https://blagajne-test.fu.gov.si:9002/v1/cash_registers");
        try {
            plugin.ping();
        } catch (FursPluginException e) {
            throw new RuntimeException(e);
        }
    }
}
