package com.velotn.ui.front.groups;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GroupeUiController implements Initializable {

    @FXML
    private AnchorPane groupsDisplayArea;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    void loadAddGroup(ActionEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("ajouterGroupe.fxml"));
        groupsDisplayArea.getChildren().clear();
        groupsDisplayArea.getChildren().add(fxml);

    }

    @FXML
    void loadDisplayGroups(ActionEvent event) throws IOException{
        Parent fxml = FXMLLoader.load(getClass().getResource("afficherGroupe.fxml"));
        groupsDisplayArea.getChildren().clear();
        groupsDisplayArea.getChildren().add(fxml);
    }
}
