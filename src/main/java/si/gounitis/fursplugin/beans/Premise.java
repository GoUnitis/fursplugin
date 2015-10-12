package si.gounitis.fursplugin.beans;

import si.gounitis.fursplugin.FursObject;

/**
 * Created by Jure on 7.10.2015.
 */
public class Premise implements FursObject {
    private String taxNumber; // mandatory, len=8
    private String premiseLabel; // mandatory, len=1-20
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

    public String getPremiseLabel() {
        return premiseLabel;
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

    public void setPremiseLabel(String premiseLabel) {
        this.premiseLabel = premiseLabel;
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
