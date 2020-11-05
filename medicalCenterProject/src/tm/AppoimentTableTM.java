package tm;

public class AppoimentTableTM {
    private String eid;
    private String pid;
    private String pname;
    private String paddress;
    private String ptele;
    private String did;
    private String dname;
    private String appdate;

    public AppoimentTableTM() {
    }

    public AppoimentTableTM(String eid, String pid, String pname, String paddress, String ptele, String did, String dname, String appdate) {
        this.eid = eid;
        this.pid = pid;
        this.pname = pname;
        this.paddress = paddress;
        this.ptele = ptele;
        this.did = did;
        this.dname = dname;
        this.appdate = appdate;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPaddress() {
        return paddress;
    }

    public void setPaddress(String paddress) {
        this.paddress = paddress;
    }

    public String getPtele() {
        return ptele;
    }

    public void setPtele(String ptele) {
        this.ptele = ptele;
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

    public String getAppdate() {
        return appdate;
    }

    public void setAppdate(String appdate) {
        this.appdate = appdate;
    }

    @Override
    public String toString() {
        return "AppoimentTableTM{" +
                "eid='" + eid + '\'' +
                ", pid='" + pid + '\'' +
                ", pname='" + pname + '\'' +
                ", paddress='" + paddress + '\'' +
                ", ptele='" + ptele + '\'' +
                ", did='" + did + '\'' +
                ", dname='" + dname + '\'' +
                ", appdate='" + appdate + '\'' +
                '}';
    }
}
