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
//********************************************************************

package si.gounitis.fursplugin.beans;

public class ReferenceInvoice {
    private String referenceInvoicePremiseId;
    private String referenceInvoiceDeviceId;
    private String referenceInvoiceInvoiceNumber;
    private String referenceInvoiceIssueDateTime;

    public String getReferenceInvoicePremiseId() {
        return referenceInvoicePremiseId;
    }

    public String getReferenceInvoiceDeviceId() {
        return referenceInvoiceDeviceId;
    }

    public String getReferenceInvoiceInvoiceNumber() {
        return referenceInvoiceInvoiceNumber;
    }

    public String getReferenceInvoiceIssueDateTime() {
        return referenceInvoiceIssueDateTime;
    }

    public void setReferenceInvoicePremiseId(String referenceInvoicePremiseId) {
        this.referenceInvoicePremiseId = referenceInvoicePremiseId;
    }

    public void setReferenceInvoiceDeviceId(String referenceInvoiceDeviceId) {
        this.referenceInvoiceDeviceId = referenceInvoiceDeviceId;
    }

    public void setReferenceInvoiceInvoiceNumber(String referenceInvoiceInvoiceNumber) {
        this.referenceInvoiceInvoiceNumber = referenceInvoiceInvoiceNumber;
    }

    public void setReferenceInvoiceIssueDateTime(String referenceInvoiceIssueDateTime) {
        this.referenceInvoiceIssueDateTime = referenceInvoiceIssueDateTime;
    }
}
