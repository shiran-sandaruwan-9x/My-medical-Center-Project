package controlle;

import bo.BOFactory;
import bo.custom.BankPaymentTableBO;
import db.DBConnection;
import dto.BankTableDTO;
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

public class DoctorViewFormController {

    public TableView tblBank;
    public TableColumn colDReportId;
    public TableColumn colDname;
    public TableColumn colBname;
    public TableColumn bankAccountNo;
    public TableColumn colDate;
    public TableColumn colDpayId;
    public TableColumn colDrid;
    public TableColumn colQty;
    public TableColumn colCharge;
    static BankPaymentTableBO bo= (BankPaymentTableBO) BOFactory.getBoFactory().getType(BOFactory.Type.BANKPAYMENTDETAIL);

    public void initialize() throws Exception {
        colDReportId.setCellValueFactory(new PropertyValueFactory<>("dbrid"));
        colDname.setCellValueFactory(new PropertyValueFactory<>("dname"));
        colBname.setCellValueFactory(new PropertyValueFactory<>("bname"));
        bankAccountNo.setCellValueFactory(new PropertyValueFactory<>("bno"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colDpayId.setCellValueFactory(new PropertyValueFactory<>("payid"));
        colDrid.setCellValueFactory(new PropertyValueFactory<>("padrid"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("payqty"));
        colCharge.setCellValueFactory(new PropertyValueFactory<>("dcharge"));
        loadTable();
    }

    public void loadTable() throws Exception {
        ArrayList<BankTableDTO> arrayList=bo.getDetailTable();
        ObservableList<BankTableDTO> obs= FXCollections.observableArrayList();
        for(BankTableDTO bank:arrayList){
            obs.add(new BankTableDTO(bank.getDbrid(),bank.getDname(),bank.getBname(),bank.getBno(),bank.getDate(),bank.getPayid(),bank.getPadrid(),bank.getPayqty(),bank.getDcharge()));
        }
        tblBank.setItems(obs);
    }

    public void printOnAction(ActionEvent actionEvent) throws JRException, SQLException, ClassNotFoundException {
        InputStream is=this.getClass().getResourceAsStream("/report/DoctorView.jrxml");
        JasperReport jr= JasperCompileManager.compileReport(is);
        JasperPrint js= JasperFillManager.fillReport(jr,null, DBConnection.getInstance().getConnection());
        JasperViewer.viewReport(js);
    }
}
