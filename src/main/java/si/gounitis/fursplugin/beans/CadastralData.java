package si.gounitis.fursplugin.beans;

/**
 * Created by Jure on 8.10.2015.
 */
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