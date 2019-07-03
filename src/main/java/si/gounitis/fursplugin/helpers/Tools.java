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
package si.gounitis.fursplugin.helpers;

import java.util.Random;

public class Tools {
    private static Random random=null;

    /**
     * generate unique message ID
     *
     * @return unique message ID
     */
    public static String getNewUiid(){
        return getRandomFourDigitHexString()+getRandomFourDigitHexString()+"-"+
                getRandomFourDigitHexString()+"-"+
                getRandomFourDigitHexString()+"-"+
                getRandomFourDigitHexString()+"-"+
                getRandomFourDigitHexString()+getRandomFourDigitHexString()+getRandomFourDigitHexString();
    }

    private static String getRandomFourDigitHexString() {
        if (random==null) {
            random = new Random();
        }
        String rv = Integer.toHexString(random.nextInt(0xffff));
        rv = String.format("%4s", rv).replace(' ', '0');
        return rv;
    }
}
