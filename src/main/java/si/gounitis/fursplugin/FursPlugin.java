package si.gounitis.fursplugin;

import si.gounitis.fursplugin.beans.Invoice;
import si.gounitis.fursplugin.beans.Premise;

/**
 * Created by Jure on 7.10.2015.
 */
public interface FursPlugin {
    public String initPremise(String id, Premise premise, String signingCertAlias) throws FursPluginException;
    public String issueInvoice(String id, Invoice invoice, String signingCertAlias) throws FursPluginException;
    public void ping() throws FursPluginException;
}
