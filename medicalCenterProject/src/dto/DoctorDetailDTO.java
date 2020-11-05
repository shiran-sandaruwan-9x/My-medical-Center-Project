package dto;

public class DoctorDetailDTO {
    private String did;
    private String dname;
    private String dtype;
    private String date;
    private String time;

    public DoctorDetailDTO() {
    }

    public DoctorDetailDTO(String did) {
        this.did = did;
    }

    public DoctorDetailDTO(String did, String dname, String dtype, String date, String time) {
        this.did = did;
        this.dname = dname;
        this.dtype = dtype;
        this.date = date;
        this.time = time;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDtype() {
        return dtype;
    }

    public void setDtype(String dtype) {
        this.dtype = dtype;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
