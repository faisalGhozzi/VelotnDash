package com.velotn.ui.back;

import com.velotn.entity.Commande;
import com.velotn.service.ServiceCommande;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Button btnOrders;

    @FXML
    private Button btnStats;

    @FXML
    private Button btnProducts;

    @FXML
    private Button btnGroups;

    @FXML
    private Button btnDonations;

    @FXML
    private Button btnComplaints;

    @FXML
    private Button btnSignout;

    //Panes

    @FXML
    private AnchorPane displyaArea;

    @FXML
    private ScrollPane scrollTable;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            Parent fxml = FXMLLoader.load(getClass().getResource("Orders.fxml"));
            displyaArea.getChildren().removeAll();
            displyaArea.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void close_app(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    private void minimize_app(MouseEvent event) {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    void loadComplaints(ActionEvent event) {

    }

    @FXML
    void loadDonations(ActionEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("Donations.fxml"));
        displyaArea.getChildren().removeAll();
        displyaArea.getChildren().add(fxml);
    }

    @FXML
    void loadGroups(ActionEvent event) {

    }

    @FXML
    void loadOrders(ActionEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("Orders.fxml"));
        displyaArea.getChildren().removeAll();
        displyaArea.getChildren().add(fxml);
    }

    @FXML
    void loadProducts(ActionEvent event) throws IOException{
        Parent fxml = FXMLLoader.load(getClass().getResource("Products.fxml"));
        displyaArea.getChildren().removeAll();
        displyaArea.getChildren().add(fxml);
    }

    @FXML
    void loadStats(ActionEvent event) {

    }

    @FXML
    void signout(ActionEvent event) {

    }

    /*@FXML
    private void changeview(@NotNull ActionEvent actionEvent){
        if(actionEvent.getSource() == btnOrders)
            orderPane.toFront();
        if(actionEvent.getSource() == btnStats)
            statsPane.toFront();
    }*/
}
