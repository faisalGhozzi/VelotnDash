package com.velotn.ui.front.profile;

import com.velotn.entity.User;
import com.velotn.service.UserService;
import com.velotn.ui.front.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.velotn.ui.front.Controller.getUserId;

public class DeactivateAccountController implements Initializable {

    @FXML
    private Button ouid;
    @FXML
    private Button nod;

    Stage stage = new Stage();
    Scene scene;
    int id;

    private User connectedUser;
    UserService us = new UserService();

    @FXML
    private void ouid(ActionEvent event) throws IOException {
        us.supprimerUser(id);
        Node node = (Node) event.getSource();
        stage = (Stage) node.getScene().getWindow();
        stage.close();
        scene = new Scene(FXMLLoader.load(getClass().getResource("../HomeFront.fxml")));
        stage.setScene(scene);
        stage.show();
        Controller.setUserId(0);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        connectedUser = us.getUserById(getUserId());
    }
}
