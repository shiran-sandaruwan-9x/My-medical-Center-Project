package controlle;

import bo.BOFactory;
import bo.custom.DoctorBO;
import bo.custom.MedicineBO;
import bo.custom.PurchMedicineAndPaymentBO;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import db.DBConnection;
import dto.DoctorDTO;
import dto.PatientDTO;
import entity.Medicine;
import entity.Patient;
import entity.PatientPayment;
import entity.PlaceMedicine;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Paint;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PaymentAndMedicineFormController {
    public TableView<Medicine> tblMedicine;
    public TableColumn tblMid;
    public TableColumn tblDrugName;
    public TableColumn tblDrugDetail;
    public TableColumn tblDrugQty;
    public TableColumn tblDrugPrice;

    static MedicineBO bo= (MedicineBO) BOFactory.getBoFactory().getType(BOFactory.Type.MEDICINE);
    public Label lblId;
    public JFXTextField txtDname;
    public JFXComboBox comPaymentType;
    public Label tblType;
    public JFXTextField txtDrugQty;
    public JFXTextField txtDrugUnitPrice;
    static PurchMedicineAndPaymentBO bo1= (PurchMedicineAndPaymentBO) BOFactory.getBoFactory().getType(BOFactory.Type.PURCHPAYMENTMEDICINE);
    public Label lblPayId;
    public JFXComboBox comPatientId;
    public Label lblPatientId;
    public JFXTextField txtTotalamount;
    public TableView<PlaceMedicine> tblPlaceMedicine;
    public TableColumn colPayid;
    public TableColumn colMid;
    public TableColumn colDrugName;
    public TableColumn colMqty;
    public TableColumn colMprice;
    public JFXTextField txtCustomerTot;
    public JFXTextField txtBlance;
    public JFXComboBox comDname;
    public Label lblDname;
    public Label lblCharge;
    static DoctorBO b01= (DoctorBO) BOFactory.getBoFactory().getType(BOFactory.Type.DOCTOR);
    public void initialize() throws Exception {
        loadMedicineTable();
        tblMid.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblDrugName.setCellValueFactory(new PropertyValueFactory<>("drugName"));
        tblDrugDetail.setCellValueFactory(new PropertyValueFactory<>("drugDetail"));
        tblDrugQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        tblDrugPrice.setCellValueFactory(new PropertyValueFactory<>("drugPrice"));

        tblMedicine.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            lblId.setText(newValue.getId());
            txtDname.setText(newValue.getDrugName());
            txtDrugQty.setText(newValue.getQty()+"");
            txtDrugUnitPrice.setText(newValue.getDrugPrice()+"");
        });
        loadPayTypeCombo();
        setPayID();
        setComboPatientId();

        colPayid.setCellValueFactory(new PropertyValueFactory<>("payId"));
        colMid.setCellValueFactory(new PropertyValueFactory<>("mid"));
        colDrugName.setCellValueFactory(new PropertyValueFactory<>("dname"));
        colMqty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colMprice.setCellValueFactory(new PropertyValueFactory<>("price"));

        loadCombo();

    }

    public void loadPayTypeCombo(){
        ObservableList observableList=FXCollections.observableArrayList("CASH","VISA");
        comPaymentType.setItems(observableList);
    }

    public void loadMedicineTable() throws Exception {
        ArrayList<Medicine> arrayList=bo.getAllMedicine();

        ObservableList<Medicine> observableList= FXCollections.observableArrayList();
        for(Medicine medicine:arrayList){
            observableList.add(new Medicine(medicine.getId(),medicine.getDrugName(),medicine.getDrugDetail(),medicine.getQty(),medicine.getDrugPrice()));
        }
        tblMedicine.setItems(observableList);
    }

    public void payTypeOnAction(ActionEvent actionEvent) {
       String type= comPaymentType.getValue().toString();
       tblType.setText(type);
    }

    public void setPayID() throws Exception {
       String id= bo1.getPayID();
       id=id.split("[A-Z]")[1];
       id="P00"+(Integer.parseInt(id)+1);
       lblPayId.setText(id);
    }
    public void setComboPatientId() throws Exception {
        ArrayList<PatientDTO> arrayList=bo1.getPatientId();
        ObservableList<PatientDTO> list=FXCollections.observableArrayList();
        for(PatientDTO dto : arrayList){
        comPatientId.getItems().add(dto.getpId());


        }
       // System.out.println(arrayList);
      //  comPatientId.setItems(list);
    }

    public void setlblOnAction(ActionEvent actionEvent) {
        String id=comPatientId.getValue().toString();
        lblPatientId.setText(id);
    }

    public void addOnAction(ActionEvent actionEvent) {
      String payid=lblPayId.getText();
      String mid=lblId.getText();
      String dname=txtDname.getText();
      int qty=Integer.parseInt(txtDrugQty.getText());
      double price=Double.parseDouble(txtDrugUnitPrice.getText());
      PlaceMedicine place=new PlaceMedicine(payid,mid,dname,qty,price);

      ObservableList<PlaceMedicine> obs=FXCollections.observableArrayList();
      int res=isSelected(mid);
      if(res==-1) {
          tblPlaceMedicine.getItems().add(place);
      }else {
          new Alert(Alert.AlertType.INFORMATION,"you added", ButtonType.OK).show();
      }
    }
    public void setTot() {
        double tot=0;
        double price=Double.parseDouble(lblCharge.getText());
        for (int i = 0; i < tblPlaceMedicine.getItems().size(); i++) {
             tot += tblPlaceMedicine.getItems().get(i).getPrice();

        }
        txtTotalamount.setText((tot+price)+"");
    }

    public void printOnAction(ActionEvent actionEvent){
        try {
           /* (InputStream is=this.getClass().getResourceAsStream("report/CustomerReport.jrxml");
        JasperReport jr= JasperCompileManager.compileReport(is);
            JasperPrint js= JasperFillManager.fillReport(jr,null,DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(js);
            //JasperPrintManager.printReport(js,true);)*/

            InputStream is=this.getClass().getResourceAsStream("/report/Blank_A4.jrxml");
            JasperReport jr= JasperCompileManager.compileReport(is);
            HashMap hs=new HashMap();
            hs.put("type",tblType.getText());
            hs.put("amount",Double.parseDouble(txtTotalamount.getText()));
            hs.put("balance",Double.parseDouble(txtBlance.getText()));
            JasperPrint jp=JasperFillManager.fillReport(jr,hs,DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jp);
        } catch (JRException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    public void totOnAction(ActionEvent actionEvent) {
        setTot();
    }
    public int isSelected(String id){
        for(int i=0; i<tblPlaceMedicine.getItems().size(); i++){
            if (tblPlaceMedicine.getItems().get(i).getMid().equals(id)){
                return i;
            }
        }
        return -1;
    }

    public void placePaymentOnAction(ActionEvent actionEvent) throws Exception {
   String pid=lblPatientId.getText();
    String payid=lblPayId.getText();
     String payType=tblType.getText();
    double balanece=Double.parseDouble(txtTotalamount.getText());

     PatientPayment patient=new PatientPayment(payid,pid,payType,balanece);
        List<List<String>> lists=new ArrayList<>();
        ArrayList<PlaceMedicine> arrayList=new ArrayList<>();
        PlaceMedicine medicine=new PlaceMedicine();
        for (int i=0; i<tblPlaceMedicine.getItems().size(); i++){
            medicine=tblPlaceMedicine.getItems().get(i);
            lists.add(new ArrayList<>());
            lists.get(i).add(medicine.getPayId());
            lists.get(i).add(medicine.getMid());
            lists.get(i).add(medicine.getDname());
            lists.get(i).add(medicine.getQty()+"");
            lists.get(i).add(medicine.getPrice()+"");
            arrayList.add(medicine);
        }

        for(PlaceMedicine mid:arrayList){
            System.out.println(mid);
        }

        boolean res=bo1.PurchPaymentPatient(patient,arrayList);
        if (res){
            new Alert(Alert.AlertType.INFORMATION,"Sucess!",ButtonType.OK).show();
        }else {
            new Alert(Alert.AlertType.INFORMATION,"fail",ButtonType.OK).show();
        }

    }

    public void removeOnAction(ActionEvent actionEvent) {
        tblPlaceMedicine.getItems().removeAll(tblPlaceMedicine.getSelectionModel().getSelectedItem());

    }

    public void balanceOnAction(ActionEvent actionEvent) {
     double tot=Double.parseDouble(txtTotalamount.getText());
     double customerPay=Double.parseDouble(txtCustomerTot.getText());
     double balance=0;
       // double res=Double.parseDouble(lblCharge.getText());
     // pice=tot+res;


         balance+=(customerPay-tot);


        System.out.println(balance);
     if (balance<0){
         new Alert(Alert.AlertType.WARNING,"you can't pay please check pay amount",ButtonType.OK).show();
         txtBlance.setText("");
     }else {
         txtBlance.setText("");
         txtBlance.setText(balance+"");
     }
    }

    public void comOnAction(ActionEvent actionEvent) throws Exception {
        String name=comDname.getValue().toString();
        lblDname.setText(name);
        String fee=b01.getDocFee(name);
        lblCharge.setText(fee);
    }

    public void loadCombo() throws Exception {
        ArrayList<DoctorDTO> arrayList=b01.getDoctor();
        // ObservableList<DoctorDTO> obs= FXCollections.observableArrayList();
        for(DoctorDTO dto :arrayList){
            comDname.getItems().add(dto.getDname());
        }

    }

    public void qtyOnKeyReleased(KeyEvent keyEvent) {
        String tele=txtDrugQty.getText();
        int length=tele.length();
        String c=keyEvent.getCharacter();
        if (tele.matches("^[0-9]*$")){
            txtDrugQty.setFocusColor(Paint.valueOf("white"));
            txtDrugQty.requestFocus();
        }
        else {
            txtDrugQty.setFocusColor(Paint.valueOf("red"));
            txtDrugQty.requestFocus();
        }
    }
}
