package si.gounitis.fursplugin.beans;

/**
 * Created by Jure on 8.10.2015.
 */
public class SwProvider {
    private String vat; // if slovenian provider
    private String title; // name + address if not slovenan provider

    public String getVat() {
        return vat;
    }

    public String getTitle() {
        return title;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}