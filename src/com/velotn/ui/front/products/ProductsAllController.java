package com.velotn.ui.front.products;

import com.velotn.entity.Accessoire;
import com.velotn.entity.Piece_Rechange;
import com.velotn.entity.Produit;
import com.velotn.entity.Velo;
import com.velotn.service.ServicePanier;
import com.velotn.service.ServiceProduit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ProductsAllController implements Initializable {

    @FXML
    private AnchorPane showProd;

    ServiceProduit serviceProduit = new ServiceProduit();
    ServicePanier servicePanier = new ServicePanier();
    private final ObservableList<Velo> dataV = FXCollections.observableArrayList();
    private final ObservableList<Piece_Rechange> dataP = FXCollections.observableArrayList();
    private final ObservableList<Accessoire> dataA = FXCollections.observableArrayList();
    List<Produit> produits = new ArrayList<>();
    private List<Velo> velos = new ArrayList<>();
    private List<Piece_Rechange> pieces = new ArrayList<>();
    private List<Accessoire> accessoires = new ArrayList<>();
    private final ObservableList<Produit> data = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try{
            afficherProduits();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void clearDataAndAdd(){
        /*
         *  Clears the data tables and add the products needed
         */
        data.clear();
        dataA.clear();
        dataP.clear();
        dataV.clear();
        produits = serviceProduit.displayProducts();
        data.addAll(produits);
    }

    public void afficherProduits() throws SQLException{

        clearDataAndAdd();
        GridPane gridPane = new GridPane();
        for(int i = 0;i<produits.size();i++){
            for(int j=0;j<5;j++){
                Label label = new Label(produits.get(i).getNomProduit());
                Label label1 = new Label(String.valueOf(produits.get(i).getPrix()));
                Button btn = new Button("Preview");
                Button btn1 = new Button("Buy");
                HBox hBox = new HBox();
                hBox.getChildren().addAll(btn,btn1);
                VBox vBox = new VBox();
                vBox.getChildren().addAll(label,label1,hBox);
                gridPane.add(vBox,i,j,1,1);
            }
        }


        /*Button button1 = new Button("Button 1");
        Button button2 = new Button("Button 2");
        Button button3 = new Button("Button 3");
        Button button4 = new Button("Button 4");
        Button button5 = new Button("Button 5");
        Button button6 = new Button("Button 6");*/

        /*gridPane.add(button1, 0, 0, 1, 1);
        gridPane.add(button2, 1, 0, 1, 1);
        gridPane.add(button3, 2, 0, 1, 1);
        gridPane.add(button4, 0, 1, 1, 1);
        gridPane.add(button5, 1, 1, 1, 1);
        gridPane.add(button6, 2, 1, 1, 1);*/

        gridPane.translateXProperty().bind(
                showProd.widthProperty().subtract(gridPane.widthProperty()).divide(2)
        );
        gridPane.translateYProperty().bind(
                showProd.heightProperty().subtract(gridPane.heightProperty()).divide(2)
        );
        showProd.getChildren().add(gridPane);
    }
}
