package controlle;

import bo.BOFactory;
import bo.custom.DoctorBO;
import bo.custom.DpaymentBO;
import bo.custom.DreportBO;
import bo.custom.PurchDoctorPaymentBO;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.sun.deploy.ref.AppRef;
import dao.DAOFactory;
import db.DBConnection;
import dto.DPaymentDTO;
import dto.DoctorDTO;
import dto.DreportDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Paint;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.io.InputStream;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class DoctorPayMentFormController {
    public Label lblReportId;

    static DreportBO bo= (DreportBO) BOFactory.getBoFactory().getType(BOFactory.Type.DREPORT);
    static DoctorBO b01= (DoctorBO) BOFactory.getBoFactory().getType(BOFactory.Type.DOCTOR);
    static DpaymentBO bo3= (DpaymentBO) BOFactory.getBoFactory().getType(BOFactory.Type.DPAYMENT);
    static PurchDoctorPaymentBO bo4= (PurchDoctorPaymentBO) BOFactory.getBoFactory().getType(BOFactory.Type.PURCHDOCTOR);
    public Label lblDpayID;
    public JFXComboBox comDname;
    public Label lblDname;
    public Label lblDate;
    public Label lblDocCharge;
    public JFXTextField txtQty;
    public Label lblBalance;
    public TableView tblPayment;
    public TableColumn colDpayId;
    public TableColumn colDrid;
    public TableColumn colQty;
    public TableColumn colCharge;
    public JFXTextField txtBanakName;
    public JFXTextField txtAccountNo;

    public void initialize() throws Exception {
        setReportId();
        setPayId();
        loadCombo();
        setDate();
        setTableAll();
        colDpayId.setCellValueFactory(new PropertyValueFactory<>("payid"));
        colDrid.setCellValueFactory(new PropertyValueFactory<>("did"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colCharge.setCellValueFactory(new PropertyValueFactory<>("fee"));
    }

    public void setReportId() throws Exception {
    String id=bo.reportId();
    id=id.split("[A-Z]")[1];
    id="B00"+(Integer.parseInt(id)+1);
    lblReportId.setText(id);
    }
    public void setPayId()throws Exception{
        String id=bo.reportId();
        id=id.split("[A-Z]")[1];
        id="M00"+(Integer.parseInt(id)+2);
        lblDpayID.setText(id);
    }
    public void loadCombo() throws Exception {
        ArrayList<DoctorDTO> arrayList=b01.getDoctor();
       // ObservableList<DoctorDTO> obs= FXCollections.observableArrayList();
        for(DoctorDTO dto :arrayList){
            comDname.getItems().add(dto.getDname());
        }

    }
    public void setDate(){
        String date= LocalDate.now().toString();
        lblDate.setText(date);
    }



    public void comOnAction(ActionEvent actionEvent) throws Exception {
        String name=comDname.getValue().toString();
        lblDname.setText(name);
        String fee=b01.getDocFee(name);
        lblDocCharge.setText(fee);
    }
    public void setTableAll() throws Exception {
     ArrayList<DPaymentDTO> arrayList=bo3.getAllDpayment();
     ObservableList<DPaymentDTO> obs=FXCollections.observableArrayList();
     for(DPaymentDTO dto:arrayList){
         obs.add(new DPaymentDTO(dto.getPayid(),dto.getDid(),dto.getQty(),dto.getFee()));
     }
     tblPayment.setItems(obs);
    }
    public void docFullChargeOnAction(ActionEvent actionEvent) {
        double free=Double.parseDouble(lblDocCharge.getText());
        double qty=Double.parseDouble(txtQty.getText());
        double sum=free*qty;
        lblBalance.setText(sum+"");

    }

    public void placePaymentOnAction(ActionEvent actionEvent) throws Exception {
        String reportId=lblReportId.getText();
        String dname=lblDname.getText();
        String bname=txtBanakName.getText();
        int accountNo=Integer.parseInt(txtAccountNo.getText());
        String date=lblDate.getText();

        String payid=lblDpayID.getText();
        int qty=Integer.parseInt(txtQty.getText());
        double balance=Double.parseDouble(lblBalance.getText());

        DreportDTO dto1=new DreportDTO(reportId,dname,bname,accountNo,date);
        DPaymentDTO dto2=new DPaymentDTO(payid,reportId,qty,balance);
        boolean res=bo4.purchDoctor(dto1,dto2);
        if (res){
            new Alert(Alert.AlertType.INFORMATION,"payment sucess!", ButtonType.OK).show();
            setTableAll();
        }else{
            new Alert(Alert.AlertType.INFORMATION,"payment fail!", ButtonType.OK).show();
        }

    }

    public void printOnAction(ActionEvent actionEvent) throws JRException, SQLException, ClassNotFoundException {
        InputStream is=this.getClass().getResourceAsStream("/report/DoctorPayment.jrxml");
        JasperReport jr= JasperCompileManager.compileReport(is);
        HashMap hs=new HashMap();
        hs.put("dname",lblDname.getText());
        hs.put("bname",txtBanakName.getText());
        hs.put("date",lblDate.getText());
        hs.put("account",Integer.parseInt(txtAccountNo.getText()));
        hs.put("charge",Double.parseDouble(lblBalance.getText()));
        JasperPrint jp= JasperFillManager.fillReport(jr,hs, DBConnection.getInstance().getConnection());
        JasperViewer.viewReport(jp);
    }

    public void txtBankNameOnKeyReleased(KeyEvent keyEvent) {
        String name=txtBanakName.getText();
        if (name.matches("^[A-z]{1,20}$") && name.length()>=2 && name.length()<=16){
            txtBanakName.setFocusColor(Paint.valueOf("white"));
            txtBanakName.requestFocus();
        }else{
            txtBanakName.setFocusColor(Paint.valueOf("red"));
            txtBanakName.requestFocus();
        }
    }

    public void txtAccountOnKeyReleased(KeyEvent keyEvent) {
        String tele=txtAccountNo.getText();
        int length=tele.length();
        String c=keyEvent.getCharacter();
        if (tele.matches("^[0-9]*$") && tele.length()<=20){
            txtAccountNo.setFocusColor(Paint.valueOf("white"));
            txtAccountNo.requestFocus();
        }
        else {
            txtAccountNo.setFocusColor(Paint.valueOf("red"));
            txtAccountNo.requestFocus();
        }
    }

    public void txtQtyOnKeyReleased(KeyEvent keyEvent) {
        String tele=txtQty.getText();
        int length=tele.length();
        String c=keyEvent.getCharacter();
        if (tele.matches("^[0-9]*$")){
            txtQty.setFocusColor(Paint.valueOf("white"));
            txtQty.requestFocus();
        }
        else {
            txtQty.setFocusColor(Paint.valueOf("red"));
            txtQty.requestFocus();
        }
    }
}
