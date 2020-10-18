package sample.Admin;


import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class Adminlogin implements Initializable {@FXML
private TableView<ModelTable> table;
    @FXML
    private TableColumn<ModelTable,Integer> col_id;
    @FXML
    private TableColumn<ModelTable,String> col_name;
    @FXML
    private TableColumn<ModelTable,String> col_pass;

    ObservableList<ModelTable> oblist = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Connection con = null;
        try {
            con = DBConnection.getConnection();
            ResultSet rs= con.createStatement().executeQuery("select * from users");
            while ((rs.next())){
                oblist.add(new ModelTable(rs.getString("id"),rs.getString("name"),rs.getString("pass")));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_pass.setCellValueFactory(new PropertyValueFactory<>("pass"));

        table.setItems(oblist);

    }
}




