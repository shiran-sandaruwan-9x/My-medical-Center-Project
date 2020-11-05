package controlle;

import bo.BOFactory;
import bo.custom.CashierBO;
import bo.custom.impl.CashierBOImpl;
import com.jfoenix.controls.JFXTextField;
import entity.Cashier;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TouchEvent;
import javafx.scene.paint.Paint;
import tm.CashierTM;

import java.util.ArrayList;
import java.util.Collections;

public class CreateUserFormController {
    public JFXTextField txtId;
    public JFXTextField txtName;
    public JFXTextField txtAddress;
    public JFXTextField txtTelephone;

    static CashierBO bo= (CashierBO) BOFactory.getBoFactory().getType(BOFactory.Type.CASHIER);
    public TableView<CashierTM> tblCashier;
    public TableColumn tblid;
    public TableColumn tblName;
    public TableColumn tblAddress;
    public TableColumn tblSalary;
    public TableColumn tblDeleteBtn;
   // public TableView<CashierTM> t



    public void initialize() throws Exception {
        tblid.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tblAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        tblSalary.setCellValueFactory(new PropertyValueFactory<>("telephone"));
        tblDeleteBtn.setCellValueFactory(new PropertyValueFactory<>("btn"));

        LoadAllCashier();

        tblCashier.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            txtId.setText(newValue.getId());
            txtName.setText(newValue.getName());
            txtAddress.setText(newValue.getAddress());
            txtTelephone.setText(newValue.getTelephone());
        });
    }

    public void LoadAllCashier() throws Exception {

            ArrayList<Cashier> arrayList=bo.getAllCashier();
            ObservableList<CashierTM> observableList=FXCollections.observableArrayList();
            for(Cashier cashier: arrayList){
                Button btn=new Button("delete");
                observableList.add(new CashierTM(cashier.getId(),cashier.getName(),cashier.getAddress(),cashier.getTelephone(),btn));

                btn.setOnAction(event -> {
                    try {
                        boolean res=bo.CashierDelete(cashier.getId());
                        if(res){
                            new Alert(Alert.AlertType.INFORMATION,"deleted",ButtonType.OK).show();
                            LoadAllCashier();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                });
                  tblCashier.setItems(observableList);

            }




    }

    public void deleteCashier(){

    }

    public void addCashierOnAction(ActionEvent actionEvent) {
        String id=txtId.getText();
        String name=txtName.getText();
        String address=txtAddress.getText();
        String telephone=txtTelephone.getText();

        Cashier cashier=new Cashier(id,name,address,telephone);
        try {
            boolean res= bo.addCashier(cashier);
            if(res){
                new Alert(Alert.AlertType.INFORMATION,"Cashier added!", ButtonType.OK).show();
                LoadAllCashier();
            }else{
                new Alert(Alert.AlertType.ERROR,"Fail!",ButtonType.OK).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateOnAction(ActionEvent actionEvent) throws Exception {
     String id=txtId.getText();
     String name=txtName.getText();
     String address=txtAddress.getText();
     String telephone=txtTelephone.getText();
     Cashier cashier=new Cashier(id,name,address,telephone);
     boolean res=bo.updateCashier(cashier);

     if(res){
         new Alert(Alert.AlertType.INFORMATION,"Updated!",ButtonType.OK).show();
         LoadAllCashier();
     }else{
         new Alert(Alert.AlertType.INFORMATION,"update fail!",ButtonType.OK).show();
     }
    }


    public void clearOnAction(ActionEvent actionEvent) {
        txtId.setText("");
        txtName.setText("");
        txtAddress.setText("");
        txtTelephone.setText("");
    }

    public void txtNoOnKeyRelesed(KeyEvent keyEvent) {
        String address=txtId.getText();
        if (/*address.matches("^[A-z]$") &&*/ address.length()>=3 && address.length()<=10){
            txtId.setFocusColor(Paint.valueOf("white"));
            txtId.requestFocus();
        }else{
            txtId.setFocusColor(Paint.valueOf("red"));
            txtId.requestFocus();
        }
    }

    public void txtNameOnKeyRelesed(KeyEvent keyEvent) {
        String name=txtName.getText();
        if (name.matches("^[A-z]{1,20}$") && name.length()>=3 && name.length()<=10){
            txtName.setFocusColor(Paint.valueOf("white"));
            txtName.requestFocus();
        }else{
            txtName.setFocusColor(Paint.valueOf("red"));
            txtName.requestFocus();
        }
    }

    public void txtAddressOnKeyRelesed(KeyEvent keyEvent) {
        String address=txtAddress.getText();
        if (/*address.matches("^[A-z]$") &&*/ address.length()>=3 && address.length()<=20){
            txtAddress.setFocusColor(Paint.valueOf("white"));
            txtAddress.requestFocus();
        }else{
            txtAddress.setFocusColor(Paint.valueOf("red"));
            txtAddress.requestFocus();
        }
    }

    public void txtTelephoneOnKeyRelesed(KeyEvent keyEvent) {
        String tele=txtTelephone.getText();
        int length=tele.length();
        String c=keyEvent.getCharacter();
        if (tele.matches("^[0-9]*$") && tele.length()==10){
            txtTelephone.setFocusColor(Paint.valueOf("white"));
            txtTelephone.requestFocus();
        }
        else {
            txtTelephone.setFocusColor(Paint.valueOf("red"));
            txtTelephone.requestFocus();
        }
    }
}
