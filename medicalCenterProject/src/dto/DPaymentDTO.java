package dto;

public class DPaymentDTO {
    private String payid;
    private String did;
    private int qty;
    private double fee;

    public DPaymentDTO() {
    }

    public DPaymentDTO(String payid, String did, int qty, double fee) {
        this.payid = payid;
        this.did = did;
        this.qty = qty;
        this.fee = fee;
    }

    public String getPayid() {
        return payid;
    }

    public void setPayid(String payid) {
        this.payid = payid;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "DPaymentDTO{" +
                "payid='" + payid + '\'' +
                ", did='" + did + '\'' +
                ", qty=" + qty +
                ", fee=" + fee +
                '}';
    }
}
