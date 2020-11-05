package controlle;

import animatefx.animation.Bounce;
import animatefx.animation.ZoomIn;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFormController {
    public JFXTextField txtName;
    public JFXPasswordField txtPswd;

    public AnchorPane root;

    public void initialize(){

    }



    public void LoginOnAction(ActionEvent actionEvent) throws IOException {
        String userName=txtName.getText().trim();
        String password=txtPswd.getText().trim();

        if(userName.length()>0 && password.length()>0){
            if(userName.equalsIgnoreCase("SHIRAN") && password.equals("1234")){

                Stage stage= (Stage) this.root.getScene().getWindow();
                stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/view/patientDashForm.fxml"))));
                stage.centerOnScreen();


            }else if(userName.equalsIgnoreCase("ADMIN") && password.equals("1234")){
              Stage stage= (Stage) this.root.getScene().getWindow();
              stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/view/DoctorDashForm.fxml"))));
              stage.centerOnScreen();
            }else {
                new Alert(Alert.AlertType.WARNING,"user name or password wrong!",ButtonType.OK).show();
            }
        }else {
            new Alert(Alert.AlertType.WARNING,"user name or password Empty!", ButtonType.OK).show();
        }



    }




}
