package sample.controllers;

/**
 * @author Arthur Kupriyanov
 */
import connector.Commander;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.util.Map;

public class NoticeListController {

    @FXML
    private ListView<String> listView;

    @FXML
    void dacaca(ActionEvent event) {

    }
    @FXML
    private Button updateButton;


    @FXML
    void update(ActionEvent event) {
        ObservableList<String> list = FXCollections.observableList(new Commander().getNotificationsList());
        listView.setItems(list);
    }

}
