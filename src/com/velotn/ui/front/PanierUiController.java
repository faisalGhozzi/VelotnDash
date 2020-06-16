package com.velotn.ui.front;

import com.velotn.entity.Commande;
import com.velotn.entity.Panier;
import com.velotn.service.ServiceCommande;
import com.velotn.service.ServicePanier;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class PanierUiController implements Initializable {

    @FXML
    private ScrollPane scrollTable;

    @FXML
    private VBox printItems;

    ServicePanier servicePanier = new ServicePanier();
    ServiceCommande serviceCommande = new ServiceCommande();
    List<Panier> paniers = new ArrayList<>();
    private final ObservableList<Panier> data = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try{
            afficher();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void afficher() throws SQLException{
        data.clear();
        paniers = servicePanier.readAll();
        data.addAll(paniers);

        Button commandAddButton = new Button("Checkout");
        commandAddButton.setStyle(
                "-fx-border-radius: 0;" +
                        "-fx-background-radius: 0;" +
                        "-fx-font-family: Raleway;" +
                        "-fx-background-color: #0d924b;" +
                        "-fx-border-color: transparent"
        );
        printItems.setAlignment(Pos.CENTER);
        HBox hBox = new HBox();
        hBox.setSpacing(50);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(new Label("Image\t"),new Label("Unitary price\t"),new Label("Quantity\t"),new Label("Total\t"),new Label("Remove Item"));
        printItems.getChildren().add(hBox);
        for(Panier panier: paniers){
            HBox hBoxx = new HBox();
            hBoxx.setSpacing(50);
            hBoxx.setAlignment(Pos.CENTER);
            Label prixUnitaire = new Label();
            Spinner<Integer> qte = new Spinner<>();
            Label prixTotal = new Label();
            Button removeButton = new Button("Remove");
            String url = "file:"+getImageFullUrl(panier.getUrl());
            Image image = new Image(url);
            ImageView imageView = new ImageView(image);
            imageView = imageSets(imageView);
            removeButton.setStyle("-fx-border-radius: 0;" +
                    "-fx-background-radius: 0;" +
                    "-fx-font-family: Raleway;" +
                    "-fx-background-color: #d52121;" +
                    "-fx-border-color: transparent"
            );
            prixUnitaire.setText(String.valueOf(panier.getPrix_unitaire())+'\t');
            prixTotal.setText(String.valueOf(panier.getPrix_total())+'\t');
            qte.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1,10,panier.getQte()));
            qte.valueProperty().addListener(((observable, oldValue, newValue) -> {
                Panier updatedPanier = new Panier(panier.getId(),newValue);
                try{
                    servicePanier.update(updatedPanier);
                    prixTotal.setText(String.valueOf(newValue*panier.getPrix_unitaire()));
                    paniers = servicePanier.readAll();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }));
            removeButton.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Panier deletePanier = new Panier(panier.getId());
                    try{
                        servicePanier.delete(deletePanier);
                        paniers = servicePanier.readAll();
                    }catch (SQLException e){
                        e.printStackTrace();
                    }
                }
            });
            hBoxx.getChildren().addAll(imageView,prixUnitaire,qte,prixTotal,removeButton);
            printItems.getChildren().add(hBoxx);
        }
        commandAddButton.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Commande commande = new Commande(LocalDate.now().plusDays(1),paniers.stream().mapToDouble(Panier::getPrix_total).sum(),paniers,Controller.getUserId());
                try{
                    serviceCommande.ajouter(commande);
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
        });

        if(!paniers.isEmpty())
            printItems.getChildren().add(commandAddButton);

        printItems.translateXProperty().bind(
                scrollTable.widthProperty().subtract(printItems.widthProperty()).divide(2)
        );
        printItems.translateYProperty().bind(
                scrollTable.heightProperty().subtract(printItems.heightProperty()).divide(2)
        );
        scrollTable.setContent(printItems);
    }

    private ImageView imageSets(ImageView imageView) {
        imageView.setFitWidth(200);
        imageView.setFitHeight(150);
        imageView.setPreserveRatio(false);
        imageView.setSmooth(true);
        imageView.setCache(true);

        return imageView;
    }

    private String getImageFullUrl(String img_url) {
        img_url= img_url.replace('/','\\');
        img_url = "C:\\wamp64\\www\\velotnWeb\\web"+img_url;
        return img_url;
    }
}
