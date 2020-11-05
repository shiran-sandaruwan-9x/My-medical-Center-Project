package entity;

public class Patient {
    private String pId;
    private String pName;
    private String pDob;
    private String pAddress;
    private String pTelephone;

    public Patient() {
    }

    public Patient(String pId, String pName, String pDob, String pAddress, String pTelephone) {
        this.pId = pId;
        this.pName = pName;
        this.pDob = pDob;
        this.pAddress = pAddress;
        this.pTelephone = pTelephone;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpDob() {
        return pDob;
    }

    public void setpDob(String pDob) {
        this.pDob = pDob;
    }

    public String getpAddress() {
        return pAddress;
    }

    public void setpAddress(String pAddress) {
        this.pAddress = pAddress;
    }

    public String getpTelephone() {
        return pTelephone;
    }

    public void setpTelephone(String pTelephone) {
        this.pTelephone = pTelephone;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "pId='" + pId + '\'' +
                ", pName='" + pName + '\'' +
                ", pDob='" + pDob + '\'' +
                ", pAddress='" + pAddress + '\'' +
                ", pTelephone='" + pTelephone + '\'' +
                '}';
    }
}
