package com.velotn.ui.back.products;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ProductsController implements Initializable {

    @FXML
    private AnchorPane productDisplayArea;

    @FXML
    void loadAddProducts(ActionEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("ProductsAdd.fxml"));
        productDisplayArea.getChildren().removeAll();
        productDisplayArea.getChildren().add(fxml);
    }

    @FXML
    void loadViewProducts(ActionEvent event) throws IOException{
        Parent fxml = FXMLLoader.load(getClass().getResource("ProductsView.fxml"));
        productDisplayArea.getChildren().removeAll();
        productDisplayArea.getChildren().add(fxml);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try{
            Parent fxml = FXMLLoader.load(getClass().getResource("ProductsView.fxml"));
            productDisplayArea.getChildren().removeAll();
            productDisplayArea.getChildren().add(fxml);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
