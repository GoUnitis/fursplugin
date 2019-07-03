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

public class Address {
    private String street;
    private String number;
    private String numberAd;
    private String town;
    private String postName;
    private String postNumber; // 4 cifre

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }

    public String getNumberAd() {
        return numberAd;
    }

    public String getTown() {
        return town;
    }

    public String getPostName() {
        return postName;
    }

    public String getPostNumber() {
        return postNumber;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setNumberAd(String numberAd) {
        this.numberAd = numberAd;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public void setPostNumber(String postNumber) {
        this.postNumber = postNumber;
    }
}