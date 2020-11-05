package controlle;

import bo.BOFactory;
import bo.custom.MedicineBO;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import entity.Medicine;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Paint;
import tm.MedicineTM;

import java.util.ArrayList;

public class AddMedicineFormController {
    public JFXTextField txtid;
    public JFXTextField txtdrugQty;
    public JFXTextField txtdrugName;
    public JFXTextArea txtdrugDetail;
    public JFXTextField txtDrugPrice;

    static MedicineBO bo= (MedicineBO) BOFactory.getBoFactory().getType(BOFactory.Type.MEDICINE);
    public TableView<MedicineTM> tblMedicine;
    public TableColumn tblId;
    public TableColumn tblName;
    public TableColumn tblDetails;
    public TableColumn tblQty;
    public TableColumn tblPrice;
    public TableColumn tblDelete;

    public void initialize() throws Exception {
        tblId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblName.setCellValueFactory(new PropertyValueFactory<>("drugName"));
        tblDetails.setCellValueFactory(new PropertyValueFactory<>("drugDetail"));
        tblQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        tblPrice.setCellValueFactory(new PropertyValueFactory<>("drugPrice"));
        tblDelete.setCellValueFactory(new PropertyValueFactory<>("btn"));

        getMedicine();

        tblMedicine.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            txtid.setText(newValue.getId());
            txtdrugName.setText(newValue.getDrugName());
            txtdrugDetail.setText(newValue.getDrugDetail());
            txtdrugQty.setText(newValue.getQty()+"");
            txtDrugPrice.setText(newValue.getDrugPrice()+"");
        });

    }

    public void AddOnAction(ActionEvent actionEvent) throws Exception {
        String id=txtid.getText();
        String name=txtdrugName.getText();
        String detail=txtdrugDetail.getText();
        int qty=Integer.parseInt(txtdrugQty.getText());
        double price=Double.parseDouble(txtDrugPrice.getText());

        Medicine medicine=new Medicine(id,name,detail,qty,price);
        boolean res= bo.addMedicine(medicine);
        if(res){
            new Alert(Alert.AlertType.INFORMATION,"added!", ButtonType.OK).show();
            getMedicine();
        }else{
            new Alert(Alert.AlertType.ERROR,"fail!",ButtonType.OK).show();
        }
    }

    public void getMedicine() throws Exception {
        ArrayList<Medicine> arrayList=bo.getAllMedicine();
        ObservableList<MedicineTM> observableList= FXCollections.observableArrayList();

        for (Medicine medicine : arrayList){
            Button btn=new Button("delete");
            observableList.add(new MedicineTM(medicine.getId(),medicine.getDrugName(),medicine.getDrugDetail(),medicine.getQty(),medicine.getDrugPrice(),btn));
            btn.setOnAction(event -> {
                try {
                   boolean res= bo.deleteMedicine(medicine.getId());
                   if (res){
                       new Alert(Alert.AlertType.INFORMATION,"medicine deleted!",ButtonType.OK).show();
                       getMedicine();
                       txtid.setText("");
                       txtdrugName.setText("");
                       txtdrugDetail.setText("");
                       txtdrugQty.setText("");
                       txtDrugPrice.setText("");
                   }else {
                       new Alert(Alert.AlertType.ERROR,"fail!",ButtonType.OK).show();
                   }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            });

        }
        tblMedicine.setItems(observableList);
    }

    public void updateOnAction(ActionEvent actionEvent) throws Exception {
        String id=txtid.getText();
        String name=txtdrugName.getText();
        String detail=txtdrugDetail.getText();
        int qty=Integer.parseInt(txtdrugQty.getText());
        double price=Double.parseDouble(txtDrugPrice.getText());
        Medicine medicine=new Medicine(id,name,detail,qty,price);
       boolean res =bo.updateMedicine(medicine);
       if (res){
           new Alert(Alert.AlertType.INFORMATION,"updated!",ButtonType.OK).show();
           getMedicine();
       }else{
           new Alert(Alert.AlertType.INFORMATION,"fail",ButtonType.OK).show();
       }
    }

    public void clearOnAction(ActionEvent actionEvent) {
        txtid.setText("");
        txtdrugName.setText("");
        txtdrugDetail.setText("");
        txtdrugQty.setText("");
        txtDrugPrice.setText("");
    }

    public void txtIdOnKeyRelesed(KeyEvent keyEvent) {
        String address=txtid.getText();
        if (/*address.matches("^[A-z]$") &&*/ address.length()>=3 && address.length()<=10){
            txtid.setFocusColor(Paint.valueOf("white"));
            txtid.requestFocus();
        }else{
            txtid.setFocusColor(Paint.valueOf("red"));
            txtid.requestFocus();
        }
    }

    public void txtQtyOnKeyRelesed(KeyEvent keyEvent) {
        String tele=txtdrugQty.getText();
        int length=tele.length();
        String c=keyEvent.getCharacter();
        if (tele.matches("^[0-9]*$") && tele.length()<=10){
            txtdrugQty.setFocusColor(Paint.valueOf("white"));
            txtdrugQty.requestFocus();
        }
        else {
            txtdrugQty.setFocusColor(Paint.valueOf("red"));
            txtdrugQty.requestFocus();
        }
    }

    public void txtUnitPriceOnKeyRelesed(KeyEvent keyEvent) {

    }

    public void txtDetailOnKeyRelesed(KeyEvent keyEvent) {
        String address=txtdrugDetail.getText();
        if (/*address.matches("^[A-z]$") &&*/ address.length()>=3 && address.length()<=20){
            txtdrugDetail.setFocusColor(Paint.valueOf("white"));
            txtdrugDetail.requestFocus();
        }else{
            txtdrugDetail.setFocusColor(Paint.valueOf("red"));
            txtdrugDetail.requestFocus();
        }
    }

    public void txtNameOnKeyRelesed(KeyEvent keyEvent) {
        String address=txtdrugName.getText();
        if (/*address.matches("^[A-z]$") &&*/ address.length()>=3 && address.length()<=15){
            txtdrugName.setFocusColor(Paint.valueOf("white"));
            txtdrugName.requestFocus();
        }else{
            txtdrugName.setFocusColor(Paint.valueOf("red"));
            txtdrugName.requestFocus();
        }

    }
}
