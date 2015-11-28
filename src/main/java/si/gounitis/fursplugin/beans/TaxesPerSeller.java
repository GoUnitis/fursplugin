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
package si.gounitis.fursplugin.beans;

public class TaxesPerSeller {
    private String sellerTaxNumber;
    private String taxRate; // if invoice includes Tax - 0-99.99
    private String taxableAmmount; // if invoice includes Tax
    private String taxAmmount; // if invoice includes Tax
    private String flatRateRate; // if invoice includes the amount of the settled flat-rate compensation (pavšalno nadomastilo)
    private String flatRateTaxableAmmount; // if invoice includes the amount of the settled flat-rate compensation (pavšalno nadomastilo)
    private String flatRateAmmount; // if invoice includes the amount of the settled flat-rate compensation (pavšalno nadomastilo)
    private String otherTaxesAmmount; // optional
    private String exemptVatTaxebleAmmount; // optional
    private String reverseVatTaxebleAmmount; // optional
    private String notaxebleAmmount; // optional
    private String specialTaxRulesAmmount; // optional

    public String getSellerTaxNumber() {
        return sellerTaxNumber;
    }

    public String getTaxRate() {
        return taxRate;
    }

    public String getTaxableAmmount() {
        return taxableAmmount;
    }

    public String getTaxAmmount() {
        return taxAmmount;
    }

    public String getFlatRateRate() {
        return flatRateRate;
    }

    public String getFlatRateTaxableAmmount() {
        return flatRateTaxableAmmount;
    }

    public String getFlatRateAmmount() {
        return flatRateAmmount;
    }

    public String getOtherTaxesAmmount() {
        return otherTaxesAmmount;
    }

    public String getExemptVatTaxebleAmmount() {
        return exemptVatTaxebleAmmount;
    }

    public String getReverseVatTaxebleAmmount() {
        return reverseVatTaxebleAmmount;
    }

    public String getNotaxebleAmmount() {
        return notaxebleAmmount;
    }

    public String getSpecialTaxRulesAmmount() {
        return specialTaxRulesAmmount;
    }

    public void setSellerTaxNumber(String sellerTaxNumber) {
        this.sellerTaxNumber = sellerTaxNumber;
    }

    public void setTaxRate(String taxRate) {
        this.taxRate = taxRate;
    }

    public void setTaxableAmmount(String taxableAmmount) {
        this.taxableAmmount = taxableAmmount;
    }

    public void setTaxAmmount(String taxAmmount) {
        this.taxAmmount = taxAmmount;
    }

    public void setFlatRateRate(String flatRateRate) {
        this.flatRateRate = flatRateRate;
    }

    public void setFlatRateTaxableAmmount(String flatRateTaxableAmmount) {
        this.flatRateTaxableAmmount = flatRateTaxableAmmount;
    }

    public void setFlatRateAmmount(String flatRateAmmount) {
        this.flatRateAmmount = flatRateAmmount;
    }

    public void setOtherTaxesAmmount(String otherTaxesAmmount) {
        this.otherTaxesAmmount = otherTaxesAmmount;
    }

    public void setExemptVatTaxebleAmmount(String exemptVatTaxebleAmmount) {
        this.exemptVatTaxebleAmmount = exemptVatTaxebleAmmount;
    }

    public void setReverseVatTaxebleAmmount(String reverseVatTaxebleAmmount) {
        this.reverseVatTaxebleAmmount = reverseVatTaxebleAmmount;
    }

    public void setNotaxebleAmmount(String notaxebleAmmount) {
        this.notaxebleAmmount = notaxebleAmmount;
    }

    public void setSpecialTaxRulesAmmount(String specialTaxRulesAmmount) {
        this.specialTaxRulesAmmount = specialTaxRulesAmmount;
    }
}
