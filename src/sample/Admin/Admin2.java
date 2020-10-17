package sample.Admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Admin2 {
    public Button alButton;

    public void alListener(ActionEvent actionEvent){

        try{
            Stage stage = (Stage) alButton.getScene().getWindow();
            Parent root1 = null;
            root1 = FXMLLoader.load(getClass().getResource("Admin/admin.fxml"));
            System.out.println(root1.toString());
            stage.setScene(new Scene(root1,300,300));
            stage.show();
        }

        catch (IOException e){
            e.printStackTrace();
        }


    }


}
