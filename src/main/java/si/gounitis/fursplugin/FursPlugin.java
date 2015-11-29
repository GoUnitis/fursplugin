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
package si.gounitis.fursplugin;

import si.gounitis.fursplugin.beans.Invoice;
import si.gounitis.fursplugin.beans.Premise;

public interface FursPlugin {
    /**
     * register new premise (mobile or real estate) at FURS
     *
     * @param uuid - unique message ID (could be genertebd by si.gounitis.fursplugin.helpers.Tools.getNewUiid()
     * @param premise - premise data POJO
     * @param signingCertAlias - name of signing certificate in a keystore
     * @@return
     */
    void registerPremise(String uuid, Premise premise, String signingCertAlias) throws FursPluginException;

    /**
     * issue an invoice
     *
     * @param uuid - unique message ID (could be genertebd by si.gounitis.fursplugin.helpers.Tools.getNewUiid()
     * @param invoice - invoice data POJO
     * @param signingCertAlias - name of signing certificate in a keystore
     * @return invoice ID
     */
    String issueInvoice(String uuid, Invoice invoice, String signingCertAlias) throws FursPluginException;

    /**
     * check FURS conectivity
     *
     * @return true if coection OK, false else
     */
    void ping() throws FursPluginException;
}
