import animatefx.animation.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent parent=(FXMLLoader.load(this.getClass().getResource("/view/LoginForm.fxml")));
        primaryStage.setScene(new Scene(parent));
        primaryStage.show();
        new SlideInLeft(parent).play();
/*    primaryStage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/view/CashierChoseFrom.fxml"))));
    primaryStage.show();*/
    }
}
