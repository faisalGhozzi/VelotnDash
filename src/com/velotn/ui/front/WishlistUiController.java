package com.velotn.ui.front;

import com.velotn.entity.Panier;
import com.velotn.entity.Wishlist;
import com.velotn.service.WishlistService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class WishlistUiController implements Initializable {

    @FXML
    private ScrollPane scrollTable;

    @FXML
    private VBox printItems;

    WishlistService wishlistService = new WishlistService();

    List<Wishlist> wishlists = new ArrayList<>();
    private final ObservableList<Wishlist> data = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try{
            afficher();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void afficher() throws SQLException{
        data.clear();
        wishlists = wishlistService.readAll();
        data.addAll(wishlists);

        printItems.setAlignment(Pos.CENTER);
        HBox hBox = new HBox();
        hBox.setSpacing(50);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(new Label("Image\t"),new Label("Product"),new Label("Unitary price\t"),new Label("Remove Item"));
        printItems.getChildren().add(hBox);
        for(Wishlist wishlist: wishlists){
            HBox hBoxx = new HBox();
            hBoxx.setSpacing(50);
            hBoxx.setAlignment(Pos.CENTER);
            Label prod = new Label();
            Label prixUnitaire = new Label();
            Button removeButton = new Button("Remove");
            String url = "file:"+getImageFullUrl(wishlist.getUrl());
            Image image = new Image(url);
            ImageView imageView = new ImageView(image);
            imageView = imageSets(imageView);
            removeButton.setStyle("-fx-border-radius: 0;" +
                    "-fx-background-radius: 0;" +
                    "-fx-font-family: Raleway;" +
                    "-fx-background-color: #d52121;" +
                    "-fx-border-color: transparent"
            );
            prod.setText(wishlist.getNomProd());
            prixUnitaire.setText(String.valueOf(wishlist.getPrix()));
            removeButton.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Wishlist deleteWishlist = new Wishlist(wishlist.getId());
                    try{
                        wishlistService.delete(deleteWishlist);
                        data.clear();
                        wishlists = wishlistService.readAll();
                        data.addAll(wishlists);
                    }catch (SQLException e){
                        e.printStackTrace();
                    }
                }
            });
            hBoxx.getChildren().addAll(imageView,prod,prixUnitaire,removeButton);
            printItems.getChildren().add(hBoxx);
        }
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
