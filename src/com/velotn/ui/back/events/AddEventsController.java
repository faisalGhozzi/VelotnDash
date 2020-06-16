package com.velotn.ui.back.events;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTimePicker;
import com.velotn.entity.Evenement;
import com.velotn.service.ServiceEvenement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ResourceBundle;

public class AddEventsController implements Initializable {

    @FXML
    private TextField nom;

    @FXML
    private JFXTimePicker heure;

    @FXML
    private JFXDatePicker date;

    @FXML
    private TextArea description;

    @FXML
    private Button btnajouterE;

    ServiceEvenement se = new ServiceEvenement();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    void ajouterEvenement(ActionEvent event) throws SQLException {
        DatePicker tmpdated= date;
        String dated= tmpdated.getValue().toString();
        se.ajouter(new Evenement(nom.getText(), Time.valueOf(heure.getValue()), Date.valueOf(dated),description.getText()));
        SendMail.sendMail("omartb.24@gmail.com", "Test", "Test");
        // listeEvenements();
    }
}
