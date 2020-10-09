package sample.Admin;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Admin {
    public Button AdminLoginButton;
    public TextField AdminPassword;
    public  TextField AdminUser;
    public void AdminLoginListener(ActionEvent actionEvent){

        Connection conn =null;
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

            }








