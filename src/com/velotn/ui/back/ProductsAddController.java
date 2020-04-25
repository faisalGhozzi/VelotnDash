package com.velotn.ui.back;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ProductsAddController implements Initializable {

    @FXML
    private AnchorPane addProductsDisplayPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try{
            Parent fxml = FXMLLoader.load(getClass().getResource("ProductAddBike.fxml"));
            addProductsDisplayPane.getChildren().removeAll();
            addProductsDisplayPane.getChildren().add(fxml);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    void openAddAccessories(ActionEvent event) throws IOException{
        Parent fxml = FXMLLoader.load(getClass().getResource("ProductAddAccessories.fxml"));
        addProductsDisplayPane.getChildren().removeAll();
        addProductsDisplayPane.getChildren().add(fxml);
    }

    @FXML
    void openAddBikes(ActionEvent event) throws IOException{
        Parent fxml = FXMLLoader.load(getClass().getResource("ProductAddBike.fxml"));
        addProductsDisplayPane.getChildren().removeAll();
        addProductsDisplayPane.getChildren().add(fxml);
    }

    @FXML
    void openAddParts(ActionEvent event) throws IOException{
        Parent fxml = FXMLLoader.load(getClass().getResource("ProductAddPieces.fxml"));
        addProductsDisplayPane.getChildren().removeAll();
        addProductsDisplayPane.getChildren().add(fxml);
    }
}
