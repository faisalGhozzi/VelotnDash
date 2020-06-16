package com.velotn.ui.front.products;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ProductsController implements Initializable {

    @FXML
    private Button frontAllProductBtn;

    @FXML
    private Button frontBikeProductBtn;

    @FXML
    private Button frontAccProductBtn;

    @FXML
    private Button frontPartsProductBtn;

    @FXML
    private Button frontRentProductBtn;

    @FXML
    private AnchorPane productDisplayArea;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Parent fxml = null;
        try {
            fxml = FXMLLoader.load(getClass().getResource("ProductsAll.fxml"));
            productDisplayArea.getChildren().removeAll();
            productDisplayArea.getChildren().clear();
            productDisplayArea.getChildren().add(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void loadAccessoriesProducts(ActionEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("ProductsAccessories.fxml"));
        productDisplayArea.getChildren().removeAll();
        productDisplayArea.getChildren().clear();
        productDisplayArea.getChildren().add(fxml);
    }

    @FXML
    void loadAllProducts(ActionEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("ProductsAll.fxml"));
        productDisplayArea.getChildren().removeAll();
        productDisplayArea.getChildren().clear();
        productDisplayArea.getChildren().add(fxml);
    }

    @FXML
    void loadBikesProducts(ActionEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("ProductsBikes.fxml"));
        productDisplayArea.getChildren().removeAll();
        productDisplayArea.getChildren().clear();
        productDisplayArea.getChildren().add(fxml);
    }

    @FXML
    void loadPartsProducts(ActionEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("ProductsParts.fxml"));
        productDisplayArea.getChildren().removeAll();
        productDisplayArea.getChildren().clear();
        productDisplayArea.getChildren().add(fxml);
    }

    @FXML
    void loadRentProducts(ActionEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("ProductsRent.fxml"));
        productDisplayArea.getChildren().removeAll();
        productDisplayArea.getChildren().clear();
        productDisplayArea.getChildren().add(fxml);
    }
}
