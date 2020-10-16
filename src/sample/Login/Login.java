package sample.Login;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.*;
import java.sql.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.Popup;





    public class Login {

    public Button login;
    public Button logout;
    public TextField LoginUser;
    public TextField LoginPassword;
    public  int flag=0;

    public void loginListener(ActionEvent event) {

        Connection conn =null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Admin", "root", "9649726949");
            String query1 = "SELECT * FROM UserInfo WHERE Name=? and Password= ?";
            PreparedStatement preStat = con.prepareStatement(query1);
            InputStream in = new FileInputStream("C:\\Users\\acer\\Desktop\\New Text Document (5).txt");

            preStat.setString(1, LoginUser.getText());
            preStat.setString(2, LoginPassword.getText());


            ResultSet rs = preStat.executeQuery();
            if (rs.next()) {
                System.out.println("username and password match");
                flag = 1;

            }
            if (flag == 1) {

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Upload.fxml"));
                Parent root1 = fxmlLoader.load();
                Stage stage = (Stage) login.getScene().getWindow();
                stage.setTitle("User Page");
                stage.setScene(new Scene(root1, 600, 450));
                stage.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText("Alert");
                alert.setContentText("Your name or password is incorrect");


                alert.showAndWait();

            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }



}
