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

public class GeneralProfileController implements Initializable {


    @FXML
    private AnchorPane profileInfos;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try{
            Parent fxml = FXMLLoader.load(getClass().getResource("ProfileInfo.fxml"));
            profileInfos.getChildren().clear();
            profileInfos.getChildren().add(fxml);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    void openDeactivate(ActionEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("DeactivateAccount.fxml"));
        profileInfos.getChildren().clear();
        profileInfos.getChildren().add(fxml);
    }

    @FXML
    void openInfos(ActionEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("ProfileInfo.fxml"));
        profileInfos.getChildren().clear();
        profileInfos.getChildren().add(fxml);
    }

    @FXML
    void openModify(ActionEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("ModifyProfile.fxml"));
    }


}
