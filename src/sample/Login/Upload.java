package sample.Login;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Upload {

    Connection con;
    @FXML
    Button upload, cancel, choose;

    @FXML
    ListView fileBox;

    File file;

    public void chooseClicked(javafx.event.ActionEvent actionEvent) {
        FileChooser fc = new FileChooser();

        file = fc.showOpenDialog(null);

        if(file != null){
            fileBox.getItems().add(file.getName());
        }
    }

    public void cancelClicked(javafx.event.ActionEvent actionEvent) {
        fileBox.getItems().clear();
        file = null;
    }

    public void uploadClicked(javafx.event.ActionEvent actionEvent) {
        try{
            if(file != null) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "Ramya@#711");
                System.out.println("Database Connection is Successful");

                String fileName = file.getName();

                InputStream in = new FileInputStream(new File(file.getAbsolutePath()));

                PreparedStatement stat = con.prepareStatement("INSERT into file_server VALUES(?, ?)");
                stat.setString(1, fileName);
                stat.setBlob(2, in);
                stat.execute();
                System.out.println("File has been uploaded");
                stat.close();
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
