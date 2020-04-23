package com.velotn.ui.back;

import com.velotn.entity.Commande;
import com.velotn.service.ServiceCommande;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
        //Node [] nodes = new Node[data.size()];
        for(int i = 0; i < data.size(); i++){

            //---------HBox Row declaration and styling for Viewing Orders------------
            HBox row = new HBox();
            row.prefHeightProperty().setValue(55);
            row.prefWidthProperty().setValue(920);
            row.spacingProperty().setValue(200);
            row.alignmentProperty().setValue(Pos.CENTER);
            if(i % 2 == 0)
                row.setStyle("-fx-background-color: #0f0f0f");
            else
                row.setStyle("-fx-background-color: #121212");

            row.setOnMouseEntered(event -> row.setStyle("-fx-background-color: #332940"));
            row.setOnMouseExited(event -> {
                /*if(i % 2 == 0)
                    row.setStyle("-fx-background-color: #0f0f0f");
                else
                    row.setStyle("-fx-background-color: #121212");*/
            });



            //---------Labels and button declaration and styling---------------------------------
            Label lblUsername = new Label(Integer.toString(data.get(i).getId()));
            lblUsername.setTextFill(Color.WHITE);
            Label lblDate = new Label(data.get(i).getDate().toString());
            lblDate.setTextFill(Color.WHITE);
            Label lblPrice = new Label(Double.toString(data.get(i).getPrix()));
            lblPrice.setTextFill(Color.WHITE);
            Button buttonOrderDetails = new Button("Details");
            buttonOrderDetails.setTextFill(Color.WHITE);
            buttonOrderDetails.setStyle("-fx-background-color: transparent;" +
                                        "-fx-background-radius: 20;" +
                                        "-fx-border-color: #2a73ff;"+
                                        "-fx-border-radius: 20");

            row.getChildren().addAll(lblUsername,lblDate,lblPrice,buttonOrderDetails);

            printitems.getChildren().add(row);
            /*try {

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
                lblUsername = new Label(Integer.toString(data.get(i).getId()));
                lblDate = new Label(data.get(i).getDate().toString());
                lblPrice = new Label(Double.toString(data.get(i).getPrix()));
                lblUsername.setText(Integer.toString(data.get(i).getId()));
                lblDate.setText(data.get(i).getDate().toString());
                lblPrice.setText(Double.toString(data.get(i).getPrix()));

                printitems.getChildren().add(nodes[i]);

            } catch (IOException e) {
                e.printStackTrace();
            }*/
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
