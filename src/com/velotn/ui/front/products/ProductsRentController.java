package com.velotn.ui.front.products;

import com.velotn.entity.*;
import com.velotn.service.ServicePanier;
import com.velotn.service.ServiceProduit;
import com.velotn.ui.front.Controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ProductsRentController implements Initializable {

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
        velos = serviceProduit.displayVelos();
        data.addAll(velos);
    }

    public void afficherProduits() throws SQLException{

        clearDataAndAdd();
        GridPane gridPane = new GridPane();
        for(int i = 0;i<velos.size();i++){
            Label label = new Label(velos.get(i).getNomProduit());
            label.setStyle("-fx-font-family: Quicksand;" +
                    "-fx-font-size: 30px;");
            String url = "file:"+getImageFullUrl(velos.get(i).getImg_url());
            Image image = new Image(url);
            ImageView imageView = new ImageView(image);
            imageView = imageSets(imageView);
            Label label1 = new Label(String.valueOf(velos.get(i).getPrix())+" TND");
            label1.setStyle("-fx-font-family: Quicksand;" +
                    "-fx-font-size: 30px");
            Button btn = new Button("Preview");
            Button btn1 = new Button("Buy");
            HBox hBox = new HBox();
            VBox vBox = new VBox();
            if(Controller.getUserId() == 0){
                btn.setStyle(   "-fx-background-radius: 0;" +
                        "-fx-border-color: transparent;" +
                        "-fx-border-width: 0;" +
                        "-fx-background-color: #bb8cfc;" +
                        "-fx-font-size: 14px;" +
                        "-fx-text-fill: #ffffff;" +
                        "-fx-pref-height: 40;" +
                        "-fx-pref-width: 200;"
                );

                hBox.setAlignment(Pos.CENTER);
                hBox.setSpacing(0);
                hBox.getChildren().addAll(btn);
                vBox.setAlignment(Pos.CENTER);
                vBox.getChildren().addAll(label,imageView,label1,hBox);
                gridPane.addColumn(i,vBox);
            }else{
                btn.setStyle(   "-fx-background-radius: 0;" +
                        "-fx-border-color: transparent;" +
                        "-fx-border-width: 0;" +
                        "-fx-background-color: #bb8cfc;" +
                        "-fx-font-size: 14px;" +
                        "-fx-text-fill: #ffffff;" +
                        "-fx-pref-height: 40;" +
                        "-fx-pref-width: 100;"
                );
                btn1.setStyle(   "-fx-background-radius: 0;" +
                        "-fx-border-color: transparent;" +
                        "-fx-border-width: 0;" +
                        "-fx-background-color: #B3EFB2;" +
                        "-fx-font-size: 14px;" +
                        "-fx-text-fill: #ffffff;" +
                        "-fx-pref-height: 40;" +
                        "-fx-pref-width: 100;"
                );
                /*btn1.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        Panier panier = new Panier(produits.get(i).getId(),1,produits.get(i).getPrix(),)
                    }
                });*/
                hBox.setAlignment(Pos.CENTER);
                hBox.setSpacing(0);
                hBox.getChildren().addAll(btn,btn1);
                vBox.setAlignment(Pos.CENTER);
                vBox.getChildren().addAll(label,imageView,label1,hBox);
                gridPane.addColumn(i,vBox);
            }
        }

        gridPane.setHgap(50);
        gridPane.setVgap(50);
        gridPane.translateXProperty().bind(
                showProd.widthProperty().subtract(gridPane.widthProperty()).divide(2)
        );
        gridPane.translateYProperty().bind(
                showProd.heightProperty().subtract(gridPane.heightProperty()).divide(2)
        );
        showProd.getChildren().add(gridPane);
    }

    private String getImageFullUrl(String img_url) {
        img_url= img_url.replace('/','\\');
        img_url = "C:\\wamp64\\www\\velotnWeb\\web"+img_url;
        return img_url;
    }

    private ImageView imageSets(ImageView imageView) {
        imageView.setFitWidth(200);
        imageView.setFitHeight(150);
        imageView.setPreserveRatio(false);
        imageView.setSmooth(true);
        imageView.setCache(true);

        return imageView;
    }
}
