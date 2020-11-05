package controlle;

import animatefx.animation.*;
import bo.BOFactory;
import bo.custom.PatientAndAppoinmentDetailBO;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class PationFormDashController {

    public Pane context;
    public TextField txtTodayNOappoiment;
    static PatientAndAppoinmentDetailBO bo= (PatientAndAppoinmentDetailBO) BOFactory.getBoFactory().getType(BOFactory.Type.QUERYBO);
    public Label lblDateSet;
    public JFXButton btnchannelButton;
    public AnchorPane root;
    public JFXButton btnviewPatient;
    public JFXButton btnNewuser;
    public JFXButton btnMedicine;
    public JFXButton btnLogout;
    public JFXButton btnpayment;

    public void initialize() throws Exception {
       String date="2020-09-17";
       String today= LocalDate.now().toString();
       lblDateSet.setText(today);
       int res= bo.todayNoOfappoinment(date);
        txtTodayNOappoiment.setText(res+"");
       if(res>2){
           new Alert(Alert.AlertType.WARNING,today+" - Today Channel is Full!", ButtonType.OK).show();
       }

    }


    private void setUi(String location) throws IOException {
    context.getChildren().clear();
    context.getChildren().add(FXMLLoader.load(this.getClass().getResource("/view/"+location+".fxml")));
    }

    public void pationOnAction(ActionEvent actionEvent) throws IOException {
          setUi("patientRegisterForm");
        new FadeIn(root).play();


    }

    public void channelOnAction(ActionEvent actionEvent) throws IOException {
        setUi("ChannelForm");
        //new ZoomIn().play();
    }

    public void viewPatientOnAction(ActionEvent actionEvent) throws IOException {
        setUi("ViewChannelForm");
    }

    public void newUserOnAtion(ActionEvent actionEvent) throws IOException {
        setUi("CreateUserForm");
    }

    public void medicineOnAction(ActionEvent actionEvent) throws IOException {
        setUi("AddMedicineForm");
    }

    public void logOutOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage= (Stage) this.root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/view/LoginForm.fxml"))));
        stage.centerOnScreen();

    }

    public void paymentOnAction(ActionEvent actionEvent) throws IOException {
        setUi("PaymentAndMedicineForm");
    }


    public void channelButtonOnMousemoved(MouseEvent mouseEvent) {
        new Tada(btnchannelButton).play();
    }

    public void viewpatientOnMouseMoved(MouseEvent mouseEvent) {
        new Tada(btnviewPatient).play();
    }

    public void newuserOnMouseMoved(MouseEvent mouseEvent) {
        new Tada(btnNewuser).play();
    }

    public void medicineOnMouseMoved(MouseEvent mouseEvent) {
        new Tada(btnMedicine).play();
    }

    public void logoutOnMouseMoved(MouseEvent mouseEvent) {
        new Tada(btnLogout).play();
    }

    public void paymentOnMouseMoved(MouseEvent mouseEvent) {
        new Tada(btnpayment).play();
    }
}
