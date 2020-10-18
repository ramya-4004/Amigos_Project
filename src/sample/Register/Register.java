package sample.Register;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
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
<<<<<<< HEAD


            preStat.setInt(1,Integer.parseInt(registerID.getText()));
            preStat.setString(2,registerName.getText());
            preStat.setString(3,registerPassword.getText());
            preStat.executeUpdate();
            preStat.close();
        }catch(ClassNotFoundException | SQLException ex){
=======
            InputStream in = new FileInputStream("C:\\Users\\acer\\Desktop\\New Text Document (5).txt");
            if(RegisterUser.getText().equals("")||RegisterPassword.getText().equals("")||RegisterEmail.getText().equals(""))
            {   Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText("Alert");
                alert.setContentText("User,Password and Email cannot be empty");


                alert.showAndWait();

            }
            else {

                preStat.setString(1, RegisterUser.getText());
                preStat.setString(2, RegisterPassword.getText());
                preStat.setString(3, RegisterEmail.getText());
                preStat.setBlob(4, in);
                preStat.executeUpdate();
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText("Congratulations");
                alert.setContentText("You have successfully registered");


                alert.showAndWait();
            }
        }catch(ClassNotFoundException | SQLException | FileNotFoundException ex){
>>>>>>> ddefb07084cd511a7a8ffd694de18b970251f243
            ex.printStackTrace();
        }
    }
}
