package dto;

public class BankTableDTO {
    private String dbrid;
    private String dname;
    private String bname;
    private int bno;
    private String date;
    private String payid;
    private String padrid;
    private int payqty;
    private double dcharge;

    public BankTableDTO() {
    }

    public BankTableDTO(String dbrid, String dname, String bname, int bno, String date, String payid, String padrid, int payqty, double dcharge) {
        this.dbrid = dbrid;
        this.dname = dname;
        this.bname = bname;
        this.bno = bno;
        this.date = date;
        this.payid = payid;
        this.padrid = padrid;
        this.payqty = payqty;
        this.dcharge = dcharge;
    }

    public String getDbrid() {
        return dbrid;
    }

    public void setDbrid(String dbrid) {
        this.dbrid = dbrid;
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

    public int getBno() {
        return bno;
    }

    public void setBno(int bno) {
        this.bno = bno;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPayid() {
        return payid;
    }

    public void setPayid(String payid) {
        this.payid = payid;
    }

    public String getPadrid() {
        return padrid;
    }

    public void setPadrid(String padrid) {
        this.padrid = padrid;
    }

    public int getPayqty() {
        return payqty;
    }

    public void setPayqty(int payqty) {
        this.payqty = payqty;
    }

    public double getDcharge() {
        return dcharge;
    }

    public void setDcharge(double dcharge) {
        this.dcharge = dcharge;
    }

    @Override
    public String toString() {
        return "BankTableDTO{" +
                "dbrid='" + dbrid + '\'' +
                ", dname='" + dname + '\'' +
                ", bname='" + bname + '\'' +
                ", bno=" + bno +
                ", date='" + date + '\'' +
                ", payid='" + payid + '\'' +
                ", padrid='" + padrid + '\'' +
                ", payqty=" + payqty +
                ", dcharge=" + dcharge +
                '}';
    }
}
