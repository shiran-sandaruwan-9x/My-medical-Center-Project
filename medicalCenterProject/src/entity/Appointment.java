package entity;

public class Appointment {
    private String eid;
    private String did;
    private String pid;
    private String dname;
    private String date;

    public Appointment() {
    }

    public Appointment(String eid, String did, String pid, String dname, String date) {
        this.eid = eid;
        this.did = did;
        this.pid = pid;
        this.dname = dname;
        this.date = date;
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

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "eid='" + eid + '\'' +
                ", did='" + did + '\'' +
                ", pid='" + pid + '\'' +
                ", dname='" + dname + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
