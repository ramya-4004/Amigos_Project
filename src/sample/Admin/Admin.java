package sample.Admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Admin {
    public Button AdminLoginButton;
    public TextField AdminPassword;
    public TextField AdminUser;

    public void AdminLoginListener (ActionEvent actionEvent) {

        /*Connection conn =null;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con= DriverManager.getConnection("jdbc:mysql://localhost/Admin","root","9649726949");
            String query1="INSERT INTO AdminInfo VALUES(?,?,?)";
                PreparedStatement preStat=con.prepareStatement(query1);
                preStat.setInt(1,16);
                preStat.setString(2,AdminUser.getText());
                preStat.setString(3,AdminPassword.getText());
                preStat.executeUpdate();
            }catch(ClassNotFoundException | SQLException ex){
                ex.printStackTrace();
            }
            }

            }*/


        try {
            FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("adminlogin.fxml"));

            Parent root1 = fxmlLoader.load();
            Stage stage = (Stage) AdminLoginButton.getScene().getWindow();
            //System.out.println(root1.toString());
            stage.setScene(new Scene(root1, 600, 450));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}







