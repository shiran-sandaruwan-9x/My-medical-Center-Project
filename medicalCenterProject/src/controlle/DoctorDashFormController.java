package controlle;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class DoctorDashFormController {
    public Pane setPane;
    public AnchorPane root;

    public void initialize(){

    }

    public void setUi(String location) throws IOException {
        setPane.getChildren().clear();
        setPane.getChildren().add(FXMLLoader.load(this.getClass().getResource("/view/"+location+".fxml")));
    }

    public void doctorAddOnAction(ActionEvent actionEvent) throws IOException {
        setUi("AddDoctorForm");
    }

    public void doctorDetailsOnAction(ActionEvent actionEvent) throws IOException {
        setUi("DoctorViewForm");
    }

    public void doctorPaymentOnAction(ActionEvent actionEvent) throws IOException {
        setUi("DoctorPayMentForm");
    }

    public void LogoutOnAction(ActionEvent actionEvent) {
        Stage stage= (Stage) this.root.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/view/LoginForm.fxml"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.centerOnScreen();
    }
}
