package sample.controllers;

import connector.Commander;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * @author Arthur Kupriyanov
 */
public class AddNoticeController {

    @FXML
    private Button addButton;

    @FXML
    private TextArea text;

    @FXML
    void addNotice(ActionEvent event) {
        if (text.textProperty().toString() != null){
            String status = new Commander().addNotification(text.textProperty().getValue());
            if (status.replace("\n","").trim().equals("200")) {
                System.out.println("closeing ...");
                Stage stage = (Stage) addButton.getScene().getWindow();
                stage.close();
            }
        }
    }
}
