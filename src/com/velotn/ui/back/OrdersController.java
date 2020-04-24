package com.velotn.ui.back;

import com.velotn.entity.Commande;
import com.velotn.service.ServiceCommande;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class OrdersController implements Initializable {

    //Main VBox elements Home.FXML
    @FXML
    private VBox printitems = null;

    ServiceCommande serviceCommande = new ServiceCommande();
    List<Commande> commandes = new ArrayList<>();

    private final ObservableList<Commande> data = FXCollections.observableArrayList();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        data.clear();
        try {
            commandes =serviceCommande.readAll() ;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        data.addAll(commandes);
        for(int i = 0; i < data.size(); i++){

            //---------HBox Row declaration and styling for Viewing Orders------------
            HBox row = new HBox();
            row.prefHeightProperty().setValue(55);
            row.prefWidthProperty().setValue(920);
            row.spacingProperty().setValue(188);
            row.alignmentProperty().setValue(Pos.CENTER);
            row.setStyle("-fx-background-color: #121212");
            row.setOnMouseEntered(event -> row.setStyle("-fx-background-color: #332940"));
            row.setOnMouseExited(event -> {
                row.setStyle("-fx-background-color: #121212");
            });

            //---------Labels and button declaration and styling---------------------------------
            Label lblUsername = new Label(data.get(i).getUsername());
            lblUsername.setTextFill(Color.WHITE);
            Label lblDate = new Label(data.get(i).getDate().toString());
            lblDate.setTextFill(Color.WHITE);
            Label lblPrice = new Label(Double.toString(data.get(i).getPrix())+" TND");
            lblPrice.setTextFill(Color.WHITE);
            Button buttonOrderDetails = new Button("Details");
            buttonOrderDetails.setTextFill(Color.WHITE);
            buttonOrderDetails.setStyle("-fx-background-color: transparent;" +
                    "-fx-background-radius: 20;" +
                    "-fx-border-color: #2a73ff;"+
                    "-fx-border-radius: 20");

            row.getChildren().addAll(lblUsername,lblDate,lblPrice,buttonOrderDetails);

            printitems.getChildren().add(row);
        }
    }
}
