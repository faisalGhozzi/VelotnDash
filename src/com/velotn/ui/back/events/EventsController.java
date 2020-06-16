package com.velotn.ui.back.events;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EventsController implements Initializable {

    @FXML
    private AnchorPane displayPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    void loadAddEvents(ActionEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("addEvents.fxml"));
        displayPane.getChildren().clear();
        displayPane.getChildren().add(fxml);
    }

    @FXML
    void loadViewEvents(ActionEvent event) throws IOException{
        Parent fxml = FXMLLoader.load(getClass().getResource("viewEvents.fxml"));
        displayPane.getChildren().clear();
        displayPane.getChildren().add(fxml);
    }
}
