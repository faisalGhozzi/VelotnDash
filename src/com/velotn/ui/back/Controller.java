package com.velotn.ui.back;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
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

    private static int userId;

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

    public static void setUserId(int id)
    {
        if(id == 0) return ;
        com.velotn.ui.back.Controller.userId = id ;
    }
    public static int getUserId()
    {
        return com.velotn.ui.back.Controller.userId;
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
    void loadComplaints(ActionEvent event) throws IOException{
        Parent fxml = FXMLLoader.load(getClass().getResource("Reclamation.fxml"));
        displyaArea.getChildren().removeAll();
        displyaArea.getChildren().add(fxml);
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
        Parent fxml = FXMLLoader.load(getClass().getResource("products/Products.fxml"));
        displyaArea.getChildren().removeAll();
        displyaArea.getChildren().add(fxml);
    }

    @FXML
    void loadStats(ActionEvent event) {

    }

    @FXML
    void signout(ActionEvent event) {

    }
}
