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

public class CadastralData {
    private String cadastralCommunityNumber; // 4 cifre
    private String cadastralBuildingNumber; // 5 cifer
    private String cadastralBuildingPartNumber; // 4 cifre

    public String getCadastralCommunityNumber() {
        return cadastralCommunityNumber;
    }

    public String getCadastralBuildingNumber() {
        return cadastralBuildingNumber;
    }

    public String getCadastralBuildingPartNumber() {
        return cadastralBuildingPartNumber;
    }

    public void setCadastralCommunityNumber(String cadastralCommunityNumber) {
        this.cadastralCommunityNumber = cadastralCommunityNumber;
    }

    public void setCadastralBuildingNumber(String cadastralBuildingNumber) {
        this.cadastralBuildingNumber = cadastralBuildingNumber;
    }

    public void setCadastralBuildingPartNumber(String cadastralBuildingPartNumber) {
        this.cadastralBuildingPartNumber = cadastralBuildingPartNumber;
    }
}