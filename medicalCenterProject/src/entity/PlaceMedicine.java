package entity;

public class PlaceMedicine {
    private String payId;
    private String mid;
    private String dname;
    private int qty;
    private double price;

    public PlaceMedicine() {
    }

    public PlaceMedicine(String payId, String mid, String dname, int qty, double price) {
        this.payId = payId;
        this.mid = mid;
        this.dname = dname;
        this.qty = qty;
        this.price = price;
    }

    public String getPayId() {
        return payId;
    }

    public void setPayId(String payId) {
        this.payId = payId;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "PlaceMedicine{" +
                "payId='" + payId + '\'' +
                ", mid='" + mid + '\'' +
                ", dname='" + dname + '\'' +
                ", qty=" + qty +
                ", price=" + price +
                '}';
    }
}
