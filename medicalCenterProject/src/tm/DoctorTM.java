package tm;


import javafx.scene.control.Button;

public class DoctorTM {
    private String did;
    private String dname;
    private String dtype;
    private String dindate;
    private String dintime;
    private String ddob;
    private String dtelephone;
    private String dqualification;
    private double dfee;
    private String demail;
    private Button button;

    public DoctorTM() {
    }

    public DoctorTM(String did, String dname, String dtype, String dindate, String dintime, String ddob, String dtelephone, String dqualification, double dfee, String demail, Button button) {
        this.did = did;
        this.dname = dname;
        this.dtype = dtype;
        this.dindate = dindate;
        this.dintime = dintime;
        this.ddob = ddob;
        this.dtelephone = dtelephone;
        this.dqualification = dqualification;
        this.dfee = dfee;
        this.demail = demail;
        this.button = button;
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

    public String getDindate() {
        return dindate;
    }

    public void setDindate(String dindate) {
        this.dindate = dindate;
    }

    public String getDintime() {
        return dintime;
    }

    public void setDintime(String dintime) {
        this.dintime = dintime;
    }

    public String getDdob() {
        return ddob;
    }

    public void setDdob(String ddob) {
        this.ddob = ddob;
    }

    public String getDtelephone() {
        return dtelephone;
    }

    public void setDtelephone(String dtelephone) {
        this.dtelephone = dtelephone;
    }

    public String getDqualification() {
        return dqualification;
    }

    public void setDqualification(String dqualification) {
        this.dqualification = dqualification;
    }

    public double getDfee() {
        return dfee;
    }

    public void setDfee(double dfee) {
        this.dfee = dfee;
    }

    public String getDemail() {
        return demail;
    }

    public void setDemail(String demail) {
        this.demail = demail;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }
}
