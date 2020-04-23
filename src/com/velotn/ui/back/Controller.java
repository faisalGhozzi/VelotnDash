package com.velotn.ui.back;

import com.velotn.entity.Commande;
import com.velotn.service.ServiceCommande;
import javafx.beans.binding.IntegerBinding;
import javafx.beans.binding.StringBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    //Main VBox elements Home.FXML
    @FXML
    private VBox printitems = null;

    @FXML
    private Button btnOrders;

    @FXML
    private Button btnStats;

    @FXML
    private Button btnProducts;

    @FXML
    private Button btnDonations;

    @FXML
    private Button btnComplaints;

    @FXML
    private Button btnSignout;

    //Order.fxml elemnts

    @FXML
    private Label lblUsername;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblPrice;

    @FXML
    private Button orderDetailsBtn;

    //Panes

    @FXML
    private AnchorPane statsPane;

    @FXML
    private AnchorPane orderPane;

    @FXML
    private ScrollPane scrollTable;

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
        Node [] nodes = new Node[data.size()];
        for(int i = 0; i < nodes.length; i++){
            try {

                final int j = i;

                nodes[i] = FXMLLoader.load(getClass().getResource("order.fxml"));
                nodes[i].setOnMouseEntered( event -> nodes[j].setStyle("-fx-background-color: #332940"));
                nodes[i].setOnMouseExited(event -> {
                    if(j % 2 == 0) {
                        nodes[j].setStyle("-fx-background-color: #0f0f0f");
                    }
                    else {
                        nodes[j].setStyle("-fx-background-color: #121212");
                    }
                });
                if(i % 2 == 0) {
                    nodes[i].setStyle("-fx-background-color: #0f0f0f");
                }
                else {
                    nodes[i].setStyle("-fx-background-color: #121212");
                }
                lblUsername.setText(Integer.toString(data.get(i).getId()));
                lblDate.setText(data.get(i).getDate().toString());
                lblPrice.setText(Double.toString(data.get(i).getPrix()));
                printitems.getChildren().add(nodes[i]);

            } catch (IOException e) {
                e.printStackTrace();
            }
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
    private void changeview(@NotNull ActionEvent actionEvent){
        if(actionEvent.getSource() == btnOrders)
            orderPane.toFront();
        if(actionEvent.getSource() == btnStats)
            statsPane.toFront();
    }
}
