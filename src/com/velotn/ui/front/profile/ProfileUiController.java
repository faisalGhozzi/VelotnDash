package com.velotn.ui.front.profile;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ProfileUiController implements Initializable {

    @FXML
    private AnchorPane profileSettings;

    @Override
    public void initialize(URL location, ResourceBundle resources){
        Parent fxml = null;
        try {
            fxml = FXMLLoader.load(getClass().getResource("GeneralProfile.fxml"));
            profileSettings.getChildren().clear();
            profileSettings.getChildren().add(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void openComplaints(ActionEvent event) {

    }

    @FXML
    void openOrders(ActionEvent event) {

    }

    @FXML
    void openPassword(ActionEvent event) {

    }

    @FXML
    void openProfile(ActionEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("GeneralProfile.fxml"));
        profileSettings.getChildren().clear();
        profileSettings.getChildren().add(fxml);
    }
}
