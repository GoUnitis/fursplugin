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

import si.gounitis.fursplugin.FursObject;

public class Premise implements FursObject {
    private String taxNumber; // mandatory, len=8
    private String premiseId; // mandatory, len=1-20
    private CadastralData cadastralData; // mandatory if imovable premises
    private Address adress; // mandatory if imovable premises
    private char movablePremise; // mandatory if movable premises
    private String premiseValidityDate; // mandatory - format LLLL-MM-DD
    private boolean closePremise=false; // set it to Z if premisse is to be closed
    private SwProvider swProvider; // mandatory
    private String aux; // optional - auxiliary data

    public boolean validateData() {
        return true;
    }

    // getters and setters

    public String getTaxNumber() {
        return taxNumber;
    }

    public String getPremiseId() {
        return premiseId;
    }

    public CadastralData getCadastralData() {
        return cadastralData;
    }

    public Address getAdress() {
        return adress;
    }

    public char getMovablePremise() {
        return movablePremise;
    }

    public String getPremiseValidityDate() {
        return premiseValidityDate;
    }

    public boolean getClosePremise() {
        return closePremise;
    }

    public SwProvider getSwProvider() {
        return swProvider;
    }

    public String getAux() {
        return aux;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    public void setPremiseId(String premiseId) {
        this.premiseId = premiseId;
    }

    public void setCadastralData(CadastralData cadastralData) {
        this.cadastralData = cadastralData;
    }

    public void setAdress(Address adress) {
        this.adress = adress;
    }

    public void setMovablePremise(char movablePremise) {
        this.movablePremise = movablePremise;
    }

    public void setPremiseValidityDate(String premiseValidityDate) {
        this.premiseValidityDate = premiseValidityDate;
    }

    public void setClosePremise(boolean closePremise) {
        this.closePremise = closePremise;
    }

    public void setSwProvider(SwProvider swProvider) {
        this.swProvider = swProvider;
    }

    public void setAux(String aux) {
        this.aux = aux;
    }
}
