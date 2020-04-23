package com.velotn.ui.back;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private VBox printitems = null;

    @FXML
    private AnchorPane displayArea;

    @FXML
    private ScrollPane scrollTable;

    @FXML
    private Button orderDetailsBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        scrollTable.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        Node [] nodes = new Node[10];
        for(int i = 0; i < nodes.length; i++){
            try {
                nodes[i] = FXMLLoader.load(getClass().getResource("order.fxml"));
                if(i % 2 == 0) {
                    nodes[i].setStyle("-fx-background-color: #0f0f0f");
                }
                else {
                    nodes[i].setStyle("-fx-background-color: #121212");
                }
                printitems.getChildren().add(nodes[i]);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void close_app(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    void minimize_app(MouseEvent event) {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }
}
