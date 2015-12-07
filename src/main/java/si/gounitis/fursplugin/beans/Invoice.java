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
package si.gounitis.fursplugin.beans;

import si.gounitis.fursplugin.FursObject;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Invoice implements FursObject {
    private final String  datePattern = "\\A[0-9]{4}[-][0-9]{2}[-][0-9]{2}[T][0-9]{2}[:][0-9]{2}[:][0-9]{2}\\z";

    private boolean sallesBook=false;
    private String taxNumber; // mandatory, len=8
    private String issueDateTime;
    private Character numberingStructure; // B per device, C - per premise
    private String premiseId; // mandatory, len=1-20
    private String deviceId; // mandatory, len=1-20
    private String invoiceNumber; // mandatory 1-20 digits no leading zeros
    private String customerVatNumber; // optional, len=8
    private String invoiceAmmount; // inclueding tax exluding discount, decimal dot two decimal digits
    private String returnsAmmount; // optional decimal dot two decimal digits
    private String paymentAmmount; // decimal dot two decimal digits
    private List<TaxesPerSeller> taxesPerSeller;
    private String operatorTaxNumber; // optional
    private boolean foreignOperator=false; // optional
    private boolean subsequentSubmit; // optional
    private List<ReferenceInvoice> referenceInvoice; // optional
    // private List<ReferenceSalesBook> referenceSalesBook; // optional
    private String aux; // optional - auxiliary data

    public boolean isSallesBook() {
        return sallesBook;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public String getIssueDateTime() {
        return issueDateTime;
    }

    public Character getNumberingStructure() {
        return numberingStructure;
    }

    public String getPremiseId() {
        return premiseId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public String getCustomerVatNumber() {
        return customerVatNumber;
    }

    public String getInvoiceAmmount() {
        return invoiceAmmount;
    }

    public String getReturnsAmmount() {
        return returnsAmmount;
    }

    public String getPaymentAmmount() {
        return paymentAmmount;
    }

    public List<TaxesPerSeller> getTaxesPerSeller() {
        return taxesPerSeller;
    }

    public String getOperatorTaxNumber() {
        return operatorTaxNumber;
    }

    public boolean isForeignOperator() {
        return foreignOperator;
    }

    public boolean isSubsequentSubmit() {
        return subsequentSubmit;
    }

    public List<ReferenceInvoice> getReferenceInvoice() {
        return referenceInvoice;
    }

    public String getAux() {
        return aux;
    }

    public void setSallesBook(boolean sallesBook) {
        this.sallesBook = sallesBook;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    public void setIssueDateTime(String issueDateTime) {
        this.issueDateTime = issueDateTime;
    }

    public void setNumberingStructure(Character numberingStructure) {
        this.numberingStructure = numberingStructure;
    }

    public void setPremiseId(String premiseId) {
        this.premiseId = premiseId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public void setCustomerVatNumber(String customerVatNumber) {
        this.customerVatNumber = customerVatNumber;
    }

    public void setInvoiceAmmount(String invoiceAmmount) {
        this.invoiceAmmount = invoiceAmmount;
    }

    public void setReturnsAmmount(String returnsAmmount) {
        this.returnsAmmount = returnsAmmount;
    }

    public void setPaymentAmmount(String paymentAmmount) {
        this.paymentAmmount = paymentAmmount;
    }

    public void setTaxesPerSeller(List<TaxesPerSeller> taxesPerSeller) {
        this.taxesPerSeller = taxesPerSeller;
    }

    public void setOperatorTaxNumber(String operatorTaxNumber) {
        this.operatorTaxNumber = operatorTaxNumber;
    }

    public void setForeignOperator(boolean foreignOperator) {
        this.foreignOperator = foreignOperator;
    }

    public void setSubsequentSubmit(boolean subsequentSubmit) {
        this.subsequentSubmit = subsequentSubmit;
    }

    public void setReferenceInvoice(List<ReferenceInvoice> referenceInvoice) {
        this.referenceInvoice = referenceInvoice;
    }

    public void setAux(String aux) {
        this.aux = aux;
    }

    public boolean validateData() {
        Pattern ptn;

        if (sallesBook)
            throw new RuntimeException("Sellers Book not suppotred yet. Please support project if you need sellers book implementation");
        ptn = Pattern.compile(datePattern);
        Matcher mtc = ptn.matcher(issueDateTime);
        if(!mtc.find())
            throw new RuntimeException("Date format must be yyyy-MM-ddTHH:mm:ss");


        return true;
    }
}
