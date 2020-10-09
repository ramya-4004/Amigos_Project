package sample.Register;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Register {
    public Button RegisterButton;
    public TextField RegisterEmail;
    public  TextField RegisterUser;
    public  TextField RegisterPassword;
    public void RegisterListener(ActionEvent actionEvent){

        Connection conn =null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost/Admin","root","9649726949");
            String query1="INSERT INTO UserInfo VALUES(?,?,?,?)";
            PreparedStatement preStat=con.prepareStatement(query1);
            InputStream in = new FileInputStream("C:\\Users\\acer\\Desktop\\New Text Document (5).txt");

            preStat.setString(1,RegisterUser.getText());
            preStat.setString(2,RegisterPassword.getText());
            preStat.setString(3,RegisterEmail.getText());
            preStat.setBlob(4,in);
            preStat.executeUpdate();
        }catch(ClassNotFoundException | SQLException | FileNotFoundException ex){
            ex.printStackTrace();
        }
    }
}
