package sample.Login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.List;

public class Upload {


    @FXML
    private ListView fileView = new ListView();
    @FXML
    private TextArea message = new TextArea(null);
    @FXML
    private Button logout;

    public void selectSingleFile(ActionEvent event){
        FileChooser fc = new FileChooser();

        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("PDF Files", "*.pdf"),
                new FileChooser.ExtensionFilter("Word Files", "*.doc"),
                new FileChooser.ExtensionFilter("Zip Files", "*.zip")
        );

        File file =fc.showOpenDialog(null);


        if(file != null){
            fileView.getItems().add(file.getName());

        }
    }


    public void selectMultiFile(ActionEvent actionEvent) {
        FileChooser fc = new FileChooser();

        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("PDF Files", "*.pdf"),
                new FileChooser.ExtensionFilter("Word Files", "*.doc"),
                new FileChooser.ExtensionFilter("Zip Files", "*.zip")
        );

        List<File> files = fc.showOpenMultipleDialog(null);
        if(files != null){
                for(int i = 0; i < files.size(); i++){
                    fileView.getItems().add(files.get(i).getName());
                }

        }

    }

    public void logoutActionListener(ActionEvent actionEvent) {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Upload.fxml"));
            Parent root2 = fxmlLoader.load();
            Stage stage = (Stage)logout.getScene().getWindow();
            Scene scene = new Scene(root2, 500, 450);
            stage.setScene(scene);
            stage.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
