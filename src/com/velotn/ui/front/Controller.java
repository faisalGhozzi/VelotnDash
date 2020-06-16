package com.velotn.ui.front;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public static AnchorPane holderPane;

    Stage stage= new Stage();

    @FXML
    private VBox sidemenu;

    @FXML
    private Button btnShop;

    @FXML
    private Button btnEvents;

    @FXML
    private Button btnProfile;

    @FXML
    private Button btnGroups;

    @FXML
    private Button btnDonate;

    @FXML
    private Button btnComplaints;

    @FXML
    private Button btnSignin;

    @FXML
    private Button btnLogout;

    @FXML
    private Button btnWish;

    @FXML
    private Button btnCart;

    @FXML
    private AnchorPane displyaArea;

    private static int userId;

    public static void setUserId(int id)
    {
        if(id == 0) return ;
        Controller.userId = id ;
    }
    public static int getUserId()
    {
        return Controller.userId;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(this.getUserId()==0){
            sidemenu.getChildren().removeAll(btnProfile,btnLogout,btnCart,btnWish,btnComplaints);
        }else{
            sidemenu.getChildren().removeAll(btnSignin);
        }

        try{
            Parent fxml = FXMLLoader.load(getClass().getResource("./products/Products.fxml"));
            displyaArea.getChildren().clear();
            displyaArea.getChildren().setAll(fxml);
        }catch (IOException e){
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
    void openShop(ActionEvent event) {
        try{
            Parent fxml = FXMLLoader.load(getClass().getResource("./products/Products.fxml"));
            displyaArea.getChildren().clear();
            displyaArea.getChildren().setAll(fxml);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    void showDonate(ActionEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("DonUi.fxml"));
        displyaArea.getChildren().clear();
        displyaArea.getChildren().add(fxml);
    }

    @FXML
    void showEvents(ActionEvent event) {

    }

    @FXML
    void showGroups(ActionEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("./groups/GroupeUi.fxml"));
        displyaArea.getChildren().clear();
        displyaArea.getChildren().add(fxml);

    }

    @FXML
    void showProfile(ActionEvent event) {

    }

    @FXML
    void showSignin(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);
        Node node =(Node)event.getSource();
        stage = (Stage)node.getScene().getWindow();
        stage.close();
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }

    @FXML
    void showLogout(ActionEvent event) {
        this.setUserId(0);
        sidemenu.getChildren().removeAll(btnLogout,btnSignin,btnProfile,btnShop,btnComplaints,btnDonate,btnEvents,btnGroups,btnCart,btnWish);
        sidemenu.getChildren().addAll(btnShop,btnEvents,btnGroups,btnDonate,btnSignin);
    }

    @FXML
    void showWish(ActionEvent event) {
    }

    @FXML
    void showCart(ActionEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("PanierUi.fxml"));
        displyaArea.getChildren().clear();
        displyaArea.getChildren().add(fxml);
    }
}
