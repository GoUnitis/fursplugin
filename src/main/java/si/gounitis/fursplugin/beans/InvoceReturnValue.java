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
package si.gounitis.fursplugin.beans;

public class InvoceReturnValue {
    private String uniqueInvoiceID;
    private String zoi;
    private String invoiceReq;

    public String getUniqueInvoiceID() {
        return uniqueInvoiceID;
    }

    public void setUniqueInvoiceID(String uniqueInvoiceID) {
        this.uniqueInvoiceID = uniqueInvoiceID;
    }

    public String getZoi() {
        return zoi;
    }

    public void setZoi(String zoi) {
        this.zoi = zoi;
    }

    public String getInvoiceReq() {
        return invoiceReq;
    }

    public void setInvoiceReq(String invoiceReq) {
        this.invoiceReq = invoiceReq;
    }

    @Override
    public String toString() {
        return "InvoceReturnValue{" +
                "uniqueInvoiceID='" + uniqueInvoiceID + '\'' +
                ", zoi='" + zoi + '\'' +
                '}';
    }
}
