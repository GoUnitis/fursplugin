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

public class Vat {
    private String taxRate; // if invoice includes Tax - 0-99.99
    private String taxableAmmount; // if invoice includes Tax
    private String taxAmmount; // if invoice includes Tax

    public String getTaxRate() {
        return taxRate;
    }

    public String getTaxableAmmount() {
        return taxableAmmount;
    }

    public String getTaxAmmount() {
        return taxAmmount;
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
}
