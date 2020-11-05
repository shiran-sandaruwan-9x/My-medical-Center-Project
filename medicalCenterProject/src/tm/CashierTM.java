package tm;

import javafx.scene.control.Button;

public class CashierTM {
    private String id;
    private String name;
    private String address;
    private String telephone;
    private Button btn;

//    public CashierTM(String id, String name, String address, String telephone, javafx.scene.control.Button btn) {
//    }


    public CashierTM() {
    }

    public CashierTM(String id, String name, String address, String telephone, Button btn) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.telephone = telephone;
        this.btn = btn;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }
}
