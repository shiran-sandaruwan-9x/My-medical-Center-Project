package controlle;

import bo.BOFactory;
import bo.custom.DoctorBO;
import com.jfoenix.controls.JFXTextField;
import dto.DoctorDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Paint;
import tm.DoctorTM;

import java.util.ArrayList;

public class AddDoctorFormController {


    public JFXTextField txtName;
    public JFXTextField txtType;
    public JFXTextField txtInDay;
    public JFXTextField txtInTime;
    public JFXTextField txtDob;
    public JFXTextField txtTelephone;
    public JFXTextField txtQualification;
    public JFXTextField txtChannelFee;
    public JFXTextField txtEmail;
    public static DoctorBO bo= (DoctorBO) BOFactory.getBoFactory().getType(BOFactory.Type.DOCTOR);
    public TableView<DoctorTM> tblDoctor;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colDtype;
    public TableColumn colIndate;
    public TableColumn colIntime;
    public TableColumn colDdob;
    public TableColumn colTelephone;
    public TableColumn colQualification;
    public TableColumn colFee;
    public TableColumn colEmail;
    public TableColumn colDelete;
    public Label lblDocId;

    public void initialize() throws Exception {
        colId.setCellValueFactory(new PropertyValueFactory<>("did"));
        colName.setCellValueFactory(new PropertyValueFactory<>("dname"));
        colDtype.setCellValueFactory(new PropertyValueFactory<>("dtype"));
        colIndate.setCellValueFactory(new PropertyValueFactory<>("dindate"));
        colIntime.setCellValueFactory(new PropertyValueFactory<>("dintime"));
        colDdob.setCellValueFactory(new PropertyValueFactory<>("ddob"));
        colTelephone.setCellValueFactory(new PropertyValueFactory<>("dtelephone"));
        colQualification.setCellValueFactory(new PropertyValueFactory<>("dqualification"));
        colFee.setCellValueFactory(new PropertyValueFactory<>("dfee"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("demail"));
        colDelete.setCellValueFactory(new PropertyValueFactory<>("button"));
        setAllDoctor();
        setDocID();
        tblDoctor.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            lblDocId.setText(newValue.getDid());
            txtName.setText(newValue.getDname());
            txtType.setText(newValue.getDtype());
            txtInDay.setText(newValue.getDindate());
            txtInTime.setText(newValue.getDintime());
            txtDob.setText(newValue.getDdob());
            txtTelephone.setText(newValue.getDtelephone());
            txtQualification.setText(newValue.getDqualification());
            txtChannelFee.setText(newValue.getDfee()+"");
            txtEmail.setText(newValue.getDemail());
        });
    }

    public void btnaddOnAction(ActionEvent actionEvent) throws Exception {
        //String id=txtId.getText();
        String id=lblDocId.getText();
        String name=txtName.getText();
        String dtype=txtType.getText();
        String indate=txtInDay.getText();
        String intime=txtInTime.getText();
        String dob=txtDob.getText();
        String telephone=txtTelephone.getText();
        String qualification=txtQualification.getText();
        double fee=Double.parseDouble(txtChannelFee.getText());
        String email=txtEmail.getText();

        DoctorDTO dto=new DoctorDTO(id,name,dtype,indate,intime,dob,telephone,qualification,fee,email);
        boolean res=bo.addDoctor(dto);
        if (res){
            new Alert(Alert.AlertType.INFORMATION,"Doctor Added!", ButtonType.OK).show();
            setAllDoctor();
        }else {
            new Alert(Alert.AlertType.INFORMATION,"fail!",ButtonType.OK).show();
        }
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) throws Exception {
        //String id=txtId.getText();
        String id=lblDocId.getText();
        String name=txtName.getText();
        String dtype=txtType.getText();
        String indate=txtInDay.getText();
        String intime=txtInTime.getText();
        String dob=txtDob.getText();
        String telephone=txtTelephone.getText();
        String qualification=txtQualification.getText();
        double fee=Double.parseDouble(txtChannelFee.getText());
        String email=txtEmail.getText();
        DoctorDTO dto=new DoctorDTO(id,name,dtype,indate,intime,dob,telephone,qualification,fee,email);

        boolean isadded=bo.updateDoctor(dto);
        if (isadded){
            new Alert(Alert.AlertType.INFORMATION,"updated!", ButtonType.OK).show();
            setAllDoctor();
        }else {
            new Alert(Alert.AlertType.INFORMATION,"fail!",ButtonType.OK).show();
        }
    }

    public void setAllDoctor() throws Exception {
        ArrayList<DoctorDTO> arrayList=bo.getDoctor();
        ObservableList<DoctorTM> obs= FXCollections.observableArrayList();
        for (DoctorDTO dto:arrayList){
            Button button=new Button("delete");
            obs.add(new DoctorTM(dto.getDid(),dto.getDname(),dto.getDtype(),dto.getDindate(),dto.getDintime(),dto.getDdob(),dto.getDtelephone(),dto.getDqualification(),dto.getDfee(),dto.getDemail(),button));
            button.setOnAction(event -> {
                try {
                    boolean res=bo.deleteDoctor(dto.getDid());
                    if (res){
                        new Alert(Alert.AlertType.INFORMATION,"Deleted", ButtonType.OK).show();
                        setAllDoctor();
                    }else {
                        new Alert(Alert.AlertType.INFORMATION,"fail!", ButtonType.OK).show();

                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            });

        }
        tblDoctor.setItems(obs);
    }
    public void setDocID() throws Exception {
    String id=bo.getDocId();
    id=id.split("[A-Z]")[1];
    id="DOO"+(Integer.parseInt(id)+1);
    lblDocId.setText(id);
        System.out.println(id);
    }

    public void txtNameOnKeyReleased(KeyEvent keyEvent) {
        String name=txtName.getText();
        if (name.matches("^[A-z]{1,20}$") && name.length()>=3 && name.length()<=10){
            txtName.setFocusColor(Paint.valueOf("white"));
            txtName.requestFocus();
        }else{
            txtName.setFocusColor(Paint.valueOf("red"));
            txtName.requestFocus();
        }
    }

    public void txtTeleOnKeyReleased(KeyEvent keyEvent) {
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

    public void txtQualificationOnKeyReleased(KeyEvent keyEvent) {
        String address=txtQualification.getText();
        if (/*address.matches("^[A-z]$") &&*/ address.length()>=3 && address.length()<=20){
            txtQualification.setFocusColor(Paint.valueOf("white"));
            txtQualification.requestFocus();
        }else{
            txtQualification.setFocusColor(Paint.valueOf("red"));
            txtQualification.requestFocus();
        }
    }

    public void txtEmailOnKeyReleased(KeyEvent keyEvent) {
        String address=txtEmail.getText();
        if (address.matches("^[a-z]{1,20}(@)(gmail|yahoo|outlook).(com)$") /*&& address.length()>=3 && address.length()<=20*/){
            txtEmail.setFocusColor(Paint.valueOf("white"));
            txtEmail.requestFocus();
        }else{
            txtEmail.setFocusColor(Paint.valueOf("red"));
            txtEmail.requestFocus();
        }
    }

    public void txtDoctorTypeOnKeyReleased(KeyEvent keyEvent) {
        String address=txtType.getText();
        if (/*address.matches("^[A-z]$") &&*/ address.length()>=3 && address.length()<=20){
            txtType.setFocusColor(Paint.valueOf("white"));
            txtType.requestFocus();
        }else{
            txtType.setFocusColor(Paint.valueOf("red"));
            txtType.requestFocus();
        }
    }

    public void txtInTimeOnKeyReleased(KeyEvent keyEvent) {
        String address=txtInTime.getText();
        if (/*address.matches("^[A-z]$") &&*/ address.length()>=3 && address.length()<=20){
            txtInTime.setFocusColor(Paint.valueOf("white"));
            txtInTime.requestFocus();
        }else{
            txtInTime.setFocusColor(Paint.valueOf("red"));
            txtInTime.requestFocus();
        }
    }

    public void txtDobOnKeyReleased(KeyEvent keyEvent) {
        String address=txtDob.getText();
        if (/*address.matches("^[A-z]$") &&*/ address.length()==10){
            txtDob.setFocusColor(Paint.valueOf("white"));
            txtDob.requestFocus();
        }else{
            txtDob.setFocusColor(Paint.valueOf("red"));
            txtDob.requestFocus();
        }
    }

    public void txtInDayOnKeyReleased(KeyEvent keyEvent) {
        String address=txtInDay.getText();
        if (/*address.matches("^[A-z]$") &&*/ address.length()>=3 && address.length()<=20){
            txtInDay.setFocusColor(Paint.valueOf("white"));
            txtInDay.requestFocus();
        }else{
            txtInDay.setFocusColor(Paint.valueOf("red"));
            txtInDay.requestFocus();
        }
    }
}
