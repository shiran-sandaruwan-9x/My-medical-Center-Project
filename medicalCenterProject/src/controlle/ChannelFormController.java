package controlle;

import bo.BOFactory;
import bo.custom.DoctorBO;
import bo.custom.PurchPatiendAndChannelBO;
import bo.custom.PatientAndAppoinmentDetailBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import dto.DoctorDetailDTO;
import entity.Patient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Paint;
import tm.AppoimentTableTM;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ChannelFormController {
    public JFXComboBox comDid;
    public JFXTextField txtDName;
    public JFXTextField txtDType;
    public JFXTextField txtDdate;
    public JFXTextField txtDtime;

    static DoctorBO bo= (DoctorBO) BOFactory.getBoFactory().getType(BOFactory.Type.DOCTOR);
    public TableColumn colDname;
    public TableView<DoctorDetailDTO> tblDtable;
    public TableColumn colDid;
    public TableColumn colDtype;
    public TableColumn colDate;
    public TableColumn colDtime;
    public Label lblDoctorNo;
    static PurchPatiendAndChannelBO bo1= (PurchPatiendAndChannelBO) BOFactory.getBoFactory().getType(BOFactory.Type.PUCHCHANNEL);
    public Label lblPatientNo;
    public Label lblChannelId;
    public JFXTextField txtpName;
    public JFXTextField txtpDob;
    public JFXTextField txtpAddress;
    public JFXTextField txtpTele;
    public TableView<AppoimentTableTM> tblPatientTable;
    public JFXDatePicker txtAppoinmentDate;
    public TableColumn colPeno;
    public TableColumn colPpno;
    public TableColumn colPpname;
    public TableColumn colPpaddress;
    public TableColumn colPptele;
    public TableColumn colPdid;
    public TableColumn colPdname;
    public TableColumn colPdate;
    static PatientAndAppoinmentDetailBO bo2= (PatientAndAppoinmentDetailBO) BOFactory.getBoFactory().getType(BOFactory.Type.QUERYBO);
    public JFXButton btnAdd;
    public TextField txtAvailable;
    public Label lblDate;

    public void initialize() throws Exception {

    colDid.setCellValueFactory(new PropertyValueFactory<>("did"));
    colDname.setCellValueFactory(new PropertyValueFactory<>("dname"));
    colDtype.setCellValueFactory(new PropertyValueFactory<>("dtype"));
    colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
    colDtime.setCellValueFactory(new PropertyValueFactory<>("time"));
        setDTable();
      //  comboBoxLoad();

        tblDtable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            txtDName.setText(newValue.getDname());
            txtDdate.setText(newValue.getDate());
            txtDtime.setText(newValue.getTime());
            txtDType.setText(newValue.getDtype());
            lblDoctorNo.setText(newValue.getDid());
        });
        setPationid();
        setChannelId();

        colPeno.setCellValueFactory(new PropertyValueFactory<>("eid"));
        colPpno.setCellValueFactory(new PropertyValueFactory<>("pid"));
        colPpname.setCellValueFactory(new PropertyValueFactory<>("pname"));
        colPpaddress.setCellValueFactory(new PropertyValueFactory<>("paddress"));
        colPptele.setCellValueFactory(new PropertyValueFactory<>("ptele"));
        colPdid.setCellValueFactory(new PropertyValueFactory<>("did"));
        colPdname.setCellValueFactory(new PropertyValueFactory<>("dname"));
        colPdate.setCellValueFactory(new PropertyValueFactory<>("appdate"));

        String date="2020-09-17";
        String today= LocalDate.now().toString();
         lblDate.setText(today);
        int res= bo2.todayNoOfappoinment(date);
        if(res>2){

          new Alert(Alert.AlertType.WARNING,today+" - Today Channel is Full!", ButtonType.OK).show();

        }
        txtAvailable.setText((20)-res+"");
    }

    public void setDTable() throws Exception {
        ArrayList<DoctorDetailDTO> arrayList = bo.getTable();

        ObservableList<DoctorDetailDTO> obs= FXCollections.observableArrayList();
        for (DoctorDetailDTO dto : arrayList){
            obs.add(new DoctorDetailDTO(dto.getDid(),dto.getDname(),dto.getDtype(),dto.getDate(),dto.getTime()));

        }


       tblDtable.setItems(obs);


    }
//    public void comboBoxLoad() throws Exception {
//        comDid.getItems().clear();
//        ObservableList<DoctorDTO> list= FXCollections.observableArrayList();
//        ArrayList<DoctorDTO> arrayList = bo.getTable();
//        for(DoctorDTO r : arrayList){
//            comDid.getItems().add(r.getDid());
//        }
//    }
    public void setPationid() throws Exception {
    String id=bo1.getPatientId();
    id=id.split("[A-Z]")[1];
    id="P00"+(Integer.parseInt(id)+1);
    lblPatientNo.setText(id);
    }
    public void setChannelId() throws Exception {
    //String id=bo1.getChannelId();
   /// id=id.split("[A-Z]")[1];
   // id="E00"+(Integer.parseInt(id)+1);
    //lblChannelId.setText(id);
    }

    public void addOnAction(ActionEvent actionEvent) {
        String pid=lblPatientNo.getText();
        String pname=txtpName.getText();
        String pdob=txtpDob.getText();
        String paddress=txtpAddress.getText();
        String ptele=txtpTele.getText();
        String eid=lblChannelId.getText();
        String dname=txtDName.getText();
        String did=lblDoctorNo.getText();
        String  appdate=txtAppoinmentDate.getValue().toString();



            AppoimentTableTM tm=new AppoimentTableTM(eid,pid,pname,paddress,ptele,did,dname,appdate);

           int res=isAdded(did);
           if (res==-1){
               tblPatientTable.getItems().add(tm);
           }else {
               new Alert(Alert.AlertType.INFORMATION,"you Added!",ButtonType.OK).show();
           }



    }
//    public int isAdded(String code){
//      //  DefaultTableModel dtm= (DefaultTableModel) tblPatientTable.getColumns();
//      // for(int i = 0; i< tblPatientTable.getItems().size(); i++){
//           // String obj= (String) tblPatientTable.getColumns().get(5);
//          // Object at = dtm.getValueAt(i, 5);
//          // if (at.equals(code)){
//           //    return i;
//         //  }
//    //   }
//       return -1;
//
//    }

    public void placeChannelOnAction(ActionEvent actionEvent) throws Exception {
        List<List<String>>  arrayList=new ArrayList<>();
        AppoimentTableTM tm=new AppoimentTableTM();
        ArrayList<AppoimentTableTM> arrayList1=new ArrayList<>();
        String pid=lblPatientNo.getText();
        String pname=txtpName.getText();
        String pDob=txtpDob.getText();
        String pAddress=txtpAddress.getText();
        String pTele=txtpTele.getText();
        Patient patient=new Patient(pid,pname,pDob,pAddress,pTele);


        for (int i=0; i<tblPatientTable.getItems().size(); i++){
            tm=tblPatientTable.getItems().get(i);
            arrayList.add(new ArrayList<>());
            arrayList.get(i).add(tm.getEid());
            arrayList.get(i).add(tm.getDid());
            arrayList.get(i).add(tm.getPid());
            arrayList.get(i).add(tm.getDname());
            arrayList.get(i).add(tm.getPtele());
            arrayList1.add(tm);
        }


        for(AppoimentTableTM kk : arrayList1){
            System.out.println(kk);
        }
      boolean res= bo1.purchPatiendAndChannel(patient,arrayList1);
        if (res){
            new Alert(Alert.AlertType.INFORMATION,"Added!",ButtonType.OK).show();
        }else {
            new Alert(Alert.AlertType.INFORMATION,"fail!",ButtonType.OK).show();
        }
    }
    public int isAdded(String id) {
        for (int i = 0; i < tblPatientTable.getItems().size(); i++) {
            if (tblPatientTable.getItems().get(i).getDid().equals(id)) {
                return i;
            }

        }
        return -1;
    }

    public void removeOnAction(ActionEvent actionEvent) {
        tblPatientTable.getItems().removeAll(tblPatientTable.getSelectionModel().getSelectedItem());
    }

    public void telephoneOnKeyPressed(KeyEvent keyEvent) {

    }

    public void txtTeleOnKeyReleased(KeyEvent keyEvent) {

        String tele=txtpTele.getText();
        int length=tele.length();
        String c=keyEvent.getCharacter();
        if (tele.matches("^[0-9]*$") && tele.length()==10){
            txtpTele.setFocusColor(Paint.valueOf("white"));
            txtpTele.requestFocus();
    }
        else {
            txtpTele.setFocusColor(Paint.valueOf("red"));
            txtpTele.requestFocus();
        }

    }

    public void txtdobOnKeyReleased(KeyEvent keyEvent) {
       String date= txtpDob.getText();
       if (/*date.matches("^[0-9]{1,10}$") &&*/ date.length()==10){
           txtpDob.setFocusColor(Paint.valueOf("white"));
           txtpDob.requestFocus();
       }else {
           txtpDob.setFocusColor(Paint.valueOf("red"));
           txtpDob.requestFocus();
       }
    }

    public void addressOnKeyReleased(KeyEvent keyEvent) {
        String address=txtpAddress.getText();
        if (/*address.matches("^[A-z]$") &&*/ address.length()>=3 && address.length()<=20){
            txtpAddress.setFocusColor(Paint.valueOf("white"));
            txtpAddress.requestFocus();
        }else{
            txtpAddress.setFocusColor(Paint.valueOf("red"));
           txtpAddress.requestFocus();
        }
    }

    public void nameONkeyReleased(KeyEvent keyEvent) {
        String name=txtpName.getText();
        if (name.matches("^[A-z]{1,20}$") && name.length()>=3 && name.length()<=10){
            txtpName.setFocusColor(Paint.valueOf("white"));
            txtpName.requestFocus();
        }else{
            txtpName.setFocusColor(Paint.valueOf("red"));
            txtpName.requestFocus();
        }
    }
}
