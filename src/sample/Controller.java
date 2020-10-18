package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.stage.Stage;
import sample.Login.Login;

import java.io.IOException;
import java.sql.SQLOutput;

public class Controller {
    public Button loginButton;
    public Button adminButton;
    public Button registerButton;

    public void clickListener(ActionEvent actionEvent){

        Stage stage = (Stage) loginButton.getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("Login/userPage.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(root, 600,500));

    }

    public void adminListener(ActionEvent actionEvent){
        Stage stage = (Stage) adminButton.getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("Admin/admin.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(root, 300,300));

    }
    public void registerListener(ActionEvent actionEvent){
        Stage stage = (Stage) registerButton.getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("Register/register.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(root, 300,300));
    }


}
