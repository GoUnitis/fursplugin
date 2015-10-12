package si.gounitis.fursplugin.beans;

import si.gounitis.fursplugin.FursObject;

/**
 * Created by Jure on 7.10.2015.
 */
public class Invoice implements FursObject {
    private String taxNumber; // mandatory, len=8

    public boolean validateData() {
        return true;
    }
}
