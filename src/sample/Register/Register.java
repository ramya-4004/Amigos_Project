package sample.Register;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Register {
    public Button RegisterButton;
    public TextField registerID;
    public  TextField registerName;
    public PasswordField registerPassword;
    public void RegisterListener(ActionEvent actionEvent){

        Connection conn =null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Ramya@#711");
            String query1="INSERT INTO users_amigos VALUES(?,?,?)";
            PreparedStatement preStat=con.prepareStatement(query1);


            preStat.setInt(1,Integer.parseInt(registerID.getText()));
            preStat.setString(2,registerName.getText());
            preStat.setString(3,registerPassword.getText());
            preStat.executeUpdate();
            preStat.close();
        }catch(ClassNotFoundException | SQLException ex){
            ex.printStackTrace();
        }
    }
}
