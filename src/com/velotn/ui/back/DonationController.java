package com.velotn.ui.back;

import com.velotn.entity.Don;
import com.velotn.service.ServiceDon;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import org.jetbrains.annotations.NotNull;

import java.net.URL;
import java.sql.SQLException;
import java.util.*;

public class DonationController implements Initializable {

    @FXML
    private VBox printitems;

    ServiceDon serviceDon = new ServiceDon();
    List<Don> dons = new ArrayList<>();

    private final ObservableList<Don> data = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        data.clear();
        try {
            dons = serviceDon.readAll();
            data.addAll(dons);
            for (int i = 0; i<data.size();i++){
                //---------HBox Row declaration and styling for Viewing Orders------------
                HBox row = new HBox();
                row.prefHeightProperty().setValue(55);
                row.prefWidthProperty().setValue(920);
                row.spacingProperty().setValue(140);
                row.alignmentProperty().setValue(Pos.CENTER);
                row.setStyle("-fx-background-color: #121212");
                row.setOnMouseEntered(event -> row.setStyle("-fx-background-color: #332940"));
                row.setOnMouseExited(event -> {
                    row.setStyle("-fx-background-color: #121212");
                });

                //---------Labels and button declaration and styling---------------------------------
                Label lblSum = new Label(Double.toString(data.get(i).getSomme())+" TND");
                lblSum.setTextFill(Color.WHITE);
                Label lblDate = new Label(data.get(i).getDate().toString());
                lblDate.setTextFill(Color.WHITE);

                row.getChildren().addAll(lblSum, lblDate);

                printitems.getChildren().add(row);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
