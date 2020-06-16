package com.velotn.ui.back.products;

import com.velotn.entity.Accessoire;
import com.velotn.entity.Piece_Rechange;
import com.velotn.service.ServiceProduit;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

public class ProductAddPiecesController {

    ServiceProduit sp = new ServiceProduit();

    @FXML
    private TextField TF_nomProd;

    @FXML
    private TextField TF_description;

    @FXML
    private TextField TF_marque;

    @FXML
    private TextField TF_type;

    @FXML
    private TextField TF_prix;

    @FXML
    private TextField TF_quantite;

    @FXML
    private Button buttonAdd;

    @FXML
    private TextField NomImage;

    @FXML
    private Button ImageProduit;

    @FXML
    void ajouter(ActionEvent event) {
        sp.insetPieceR(new Piece_Rechange(TF_nomProd.getText(), TF_description.getText(), Float.parseFloat(TF_prix.getText()), Integer.parseInt(TF_quantite.getText()), TF_marque.getText(), TF_type.getText(),NomImage.getText()));

    }

    @FXML
    private String selectImage()
    {
        final FileChooser image = new FileChooser();
        image.setTitle("Choisir une image ");
        String path = image.showOpenDialog(ImageProduit.getScene().getWindow()).getName();
        NomImage.setText(path);
        return "http://localhost/velotnproducts/"+path;
    }
}
