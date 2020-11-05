package entity;

public class PatientPayment {
    private String payid;
    private String pid;
    private String payType;
    private double balance;

    public PatientPayment() {
    }

    public PatientPayment(String payid, String pid, String payType, double balance) {
        this.payid = payid;
        this.pid = pid;
        this.payType = payType;
        this.balance = balance;
    }

    public String getPayid() {
        return payid;
    }

    public void setPayid(String payid) {
        this.payid = payid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
