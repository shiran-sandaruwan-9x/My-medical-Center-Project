package dto;

public class DreportDTO {
    private String drid;
    private String dname;
    private String bname;
    private int accountNo;
    private String date;

    public DreportDTO() {
    }

    public DreportDTO(String drid, String dname, String bname, int accountNo, String date) {
        this.drid = drid;
        this.dname = dname;
        this.bname = bname;
        this.accountNo = accountNo;
        this.date = date;
    }

    public String getDrid() {
        return drid;
    }

    public void setDrid(String drid) {
        this.drid = drid;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "DreportDTO{" +
                "drid='" + drid + '\'' +
                ", dname='" + dname + '\'' +
                ", bname='" + bname + '\'' +
                ", accountNo=" + accountNo +
                ", date='" + date + '\'' +
                '}';
    }
}
