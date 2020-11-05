package dto;

public class PatientDTO {
    private String pId;

    public PatientDTO() {
    }

    public PatientDTO(String pId) {
        this.pId = pId;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    @Override
    public String toString() {
        return "PatientDTO{" +
                "pId='" + pId + '\'' +
                '}';
    }
}
