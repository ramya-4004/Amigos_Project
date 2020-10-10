package sample.Login;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;

import java.lang.*;


public class Login {

    public Button login;
    public Button logout;

    public void loginListener(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = (Stage)login.getScene().getWindow();
            stage.setTitle("User Page");
            stage.setScene(new Scene(root1, 300, 400));
            stage.show();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public void logoutActionListener(ActionEvent event){
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
            Parent root2 = fxmlLoader.load();
            Stage stage = (Stage)logout.getScene().getWindow();
            Scene scene = new Scene(root2, 300, 300);
            stage.setScene(scene);
            stage.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }


}
