package controlle;

import bo.BOFactory;
import bo.custom.PatientAndAppoinmentDetailBO;
import db.DBConnection;
import dto.PatientAndAppoimentDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;

public class  ViewChannelFormController {
    static PatientAndAppoinmentDetailBO bo= (PatientAndAppoinmentDetailBO) BOFactory.getBoFactory().getType(BOFactory.Type.QUERYBO);
    public TableView<PatientAndAppoimentDTO> tblPatientAndAppinment;
    public TableColumn colPid;
    public TableColumn colPname;
    public TableColumn colPdob;
    public TableColumn colPaddress;
    public TableColumn colPtelephone;
    public TableColumn colEid;
    public TableColumn colDid;
    public TableColumn colDpid;
    public TableColumn colDname;
    public TableColumn colDdate;

    public void initialize() throws Exception {

        colPid.setCellValueFactory(new PropertyValueFactory<>("pid"));
        colPname.setCellValueFactory(new PropertyValueFactory<>("name"));
        colPdob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colPaddress.setCellValueFactory(new PropertyValueFactory<>("adddress"));
        colPtelephone.setCellValueFactory(new PropertyValueFactory<>("ptele"));
        colEid.setCellValueFactory(new PropertyValueFactory<>("eid"));
        colDid.setCellValueFactory(new PropertyValueFactory<>("did"));
        colDpid.setCellValueFactory(new PropertyValueFactory<>("dpid"));
        colDname.setCellValueFactory(new PropertyValueFactory<>("aname"));
        colDdate.setCellValueFactory(new PropertyValueFactory<>("date"));
        setTableAll();
    }


    public void setTableAll() throws Exception {
        ArrayList<PatientAndAppoimentDTO> arrayList=bo.getPatientAndAppoinment();
        ObservableList<PatientAndAppoimentDTO> observableList= FXCollections.observableArrayList();
        for(PatientAndAppoimentDTO dto : arrayList){
            observableList.add(new PatientAndAppoimentDTO(dto.getPid(),dto.getName(),dto.getDob(),dto.getAdddress(),dto.getPtele(),dto.getEid(),dto.getDid(),dto.getDpid(),dto.getAname(),dto.getDate()));
        }
        tblPatientAndAppinment.setItems(observableList);
        System.out.println(arrayList);
    }

    public void printOnAction(ActionEvent actionEvent) throws JRException, SQLException, ClassNotFoundException {
        InputStream is=this.getClass().getResourceAsStream("/report/ReportPatient.jrxml");
        JasperReport jr= JasperCompileManager.compileReport(is);
        JasperPrint js= JasperFillManager.fillReport(jr,null, DBConnection.getInstance().getConnection());
        JasperViewer.viewReport(js);
    }
}
