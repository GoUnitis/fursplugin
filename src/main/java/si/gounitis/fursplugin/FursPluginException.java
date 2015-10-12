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
package si.gounitis.fursplugin;

/**
 * Created by Jure on 8.10.2015.
 */
public class FursPluginException extends Exception{
    public FursPluginException() {
        super();
    }

    public FursPluginException(String message) {
        super(message);
    }

    public FursPluginException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public FursPluginException(Throwable throwable) {
        super(throwable);
    }

}
