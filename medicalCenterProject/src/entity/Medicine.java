package entity;

public class Medicine {
    private String id;
    private String drugName;
    private String drugDetail;
    private int qty;
    private double drugPrice;

    public Medicine() {
    }

    public Medicine(String id, String drugName, String drugDetail, int qty, double drugPrice) {
        this.id = id;
        this.drugName = drugName;
        this.drugDetail = drugDetail;
        this.qty = qty;
        this.drugPrice = drugPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getDrugDetail() {
        return drugDetail;
    }

    public void setDrugDetail(String drugDetail) {
        this.drugDetail = drugDetail;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getDrugPrice() {
        return drugPrice;
    }

    public void setDrugPrice(double drugPrice) {
        this.drugPrice = drugPrice;
    }
}
