package sample.Login;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;

import java.lang.*;
import java.sql.*;


public class Login {

    public Button login;
    public TextField ID;
    public PasswordField password;


    public void loginListener(ActionEvent event) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Ramya@#711");
            int id = Integer.parseInt(ID.getText());
            String pass = password.getText();
            System.out.println(id + " " + pass);
            String query="SELECT password FROM mydb.users_amigos WHERE id = "+id+";";
            Statement stat = con.createStatement();
            ResultSet r = stat.executeQuery(query);
            String dbPass = null;
            while(r.next()) {

                dbPass = r.getString("password");
            }
            if(dbPass.equals(pass)){
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UploadDialogBox.fxml"));
                    Parent root1 = fxmlLoader.load();
                    Stage stage = (Stage)login.getScene().getWindow();
                    stage.setTitle("User Page");
                    stage.setScene(new Scene(root1, 600, 150));
                    stage.show();
                }
                catch (Exception e){
                    e.printStackTrace();
                }

            }
            else{
                System.exit(0);
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
