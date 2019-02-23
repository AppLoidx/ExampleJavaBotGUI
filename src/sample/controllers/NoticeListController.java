package sample.controllers;

/**
 * @author Arthur Kupriyanov
 */
import connector.Commander;
import javafx.animation.RotateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;


public class NoticeListController {

    @FXML
    private ListView<String> listView;

    @FXML
    private ImageView addButtonImage;

    @FXML
    private Button addButton;

    @FXML
    void dacaca(ActionEvent event) {

    }

    @FXML private Button updateButton;
    @FXML private Button deleteButton;

    @FXML
    void update(ActionEvent event) {
        ObservableList<String> list = FXCollections.observableList(new Commander().getNotificationsList());
        listView.setItems(list);
    }

    @FXML
    void delete(ActionEvent event){
        String selectedItem = listView.getSelectionModel().getSelectedItem();
        if (selectedItem!=null) {
            System.out.println(new Commander().deleteNotification(selectedItem.hashCode()));
            update(new ActionEvent());
        }
    }

    @FXML
    void add(ActionEvent event){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("../fxmls/add-notice-window.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
