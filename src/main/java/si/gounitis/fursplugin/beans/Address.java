package si.gounitis.fursplugin.beans;

/**
 * Created by Jure on 8.10.2015.
 */
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