package dto;

public class PatientAndAppoimentDTO {
    private String pid;
    private String name;
    private String dob;
    private String adddress;
    private String ptele;
    private String eid;
    private String did;
    private String dpid;
    private String aname;
    private String date;

    public PatientAndAppoimentDTO() {
    }

    public PatientAndAppoimentDTO(String pid, String name, String dob, String adddress, String ptele, String eid, String did, String dpid, String aname, String date) {
        this.pid = pid;
        this.name = name;
        this.dob = dob;
        this.adddress = adddress;
        this.ptele = ptele;
        this.eid = eid;
        this.did = did;
        this.dpid = dpid;
        this.aname = aname;
        this.date = date;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAdddress() {
        return adddress;
    }

    public void setAdddress(String adddress) {
        this.adddress = adddress;
    }

    public String getPtele() {
        return ptele;
    }

    public void setPtele(String ptele) {
        this.ptele = ptele;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getDpid() {
        return dpid;
    }

    public void setDpid(String dpid) {
        this.dpid = dpid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
