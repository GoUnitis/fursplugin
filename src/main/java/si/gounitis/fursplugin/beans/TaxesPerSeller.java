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

import java.util.List;

public class TaxesPerSeller {
    private String sellerTaxNumber;
    private List<Vat> vat; // if zavezanec za DDV
    private String otherTaxesAmmount; // optional
    private String exemptVatTaxebleAmmount; // optional
    private String reverseVatTaxebleAmmount; // optional
    private String notaxebleAmmount; // optional
    private String specialTaxRulesAmmount; // optional

    public String getSellerTaxNumber() {
        return sellerTaxNumber;
    }

    public void setSellerTaxNumber(String sellerTaxNumber) {
        this.sellerTaxNumber = sellerTaxNumber;
    }

    public List<Vat> getVat() {
        return vat;
    }

    public void setVat(List<Vat> vat) {
        this.vat = vat;
    }

    public String getOtherTaxesAmmount() {
        return otherTaxesAmmount;
    }

    public void setOtherTaxesAmmount(String otherTaxesAmmount) {
        this.otherTaxesAmmount = otherTaxesAmmount;
    }

    public String getExemptVatTaxebleAmmount() {
        return exemptVatTaxebleAmmount;
    }

    public void setExemptVatTaxebleAmmount(String exemptVatTaxebleAmmount) {
        this.exemptVatTaxebleAmmount = exemptVatTaxebleAmmount;
    }

    public String getReverseVatTaxebleAmmount() {
        return reverseVatTaxebleAmmount;
    }

    public void setReverseVatTaxebleAmmount(String reverseVatTaxebleAmmount) {
        this.reverseVatTaxebleAmmount = reverseVatTaxebleAmmount;
    }

    public String getNotaxebleAmmount() {
        return notaxebleAmmount;
    }

    public void setNotaxebleAmmount(String notaxebleAmmount) {
        this.notaxebleAmmount = notaxebleAmmount;
    }

    public String getSpecialTaxRulesAmmount() {
        return specialTaxRulesAmmount;
    }

    public void setSpecialTaxRulesAmmount(String specialTaxRulesAmmount) {
        this.specialTaxRulesAmmount = specialTaxRulesAmmount;
    }
}
