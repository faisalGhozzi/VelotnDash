package com.velotn.ui.front.profile;

import com.jfoenix.controls.JFXButton;
import com.velotn.entity.Groups;
import com.velotn.entity.User;
import com.velotn.service.UserService;
import com.velotn.ui.front.Controller;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

import javafx.scene.image.ImageView;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.velotn.ui.front.Controller.getUserId;

public class ProfileInfoController implements Initializable {

    @FXML
    private Button btdesac;

    @FXML
    private Label nomp;

    @FXML
    private ImageView photop;

    @FXML
    private Label descriptionLabel;

    @FXML
    private Label serieLabel;

    @FXML
    private Label artistLabel;

    @FXML
    private Label filmLabel;

    @FXML
    private Label livreLabel;

    @FXML
    private AnchorPane desactiverc;

    @FXML
    private Button ouid;

    @FXML
    private Button nod;

    private User connectedUser;
    UserService us = new UserService();
    final FileChooser fileChooser = new FileChooser();
    private Desktop desktop = Desktop.getDesktop();
    private String file_image;
    private Path pathfrom;
    private Path pathto;
    private File Current_file;

    private FileInputStream fis;
    Stage stage = new Stage();
    Scene scene;
    int id;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        connectedUser = us.getUserById(getUserId());
        nomp.setText(connectedUser.getUsername());
        descriptionLabel.setText(connectedUser.getEmail());
        //photop.setImage(new Image(getClass().getResource("../Images/" + connectedUser.getImage()).toExternalForm()));
    }

    @FXML
    void btdesac(ActionEvent event) {

    }

    //@FXML
    /*void modifierPhoto(MouseEvent event) {
        User a = new User();
        a = us.getUserById(Controller.getUserId());

        //------------------
        TextInputDialog dialog = new TextInputDialog("");
        dialog.setTitle("Modifier Photo User");
        dialog.setResizable(true);
        dialog.getDialogPane().setPrefSize(700, 320);
        dialog.setHeaderText(null);
        dialog.setGraphic(null);
        dialog.getDialogPane().setBackground(new Background(new BackgroundFill(javafx.scene.paint.Color.GREY, new CornerRadii(2), new javafx.geometry.Insets(2))));
        dialog.getDialogPane().setBorder(new Border(new BorderStroke(javafx.scene.paint.Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        javafx.scene.control.TextField textNom = new javafx.scene.control.TextField();
        textNom.setPrefWidth(300);
        textNom.setPrefHeight(40);
        textNom.setText(a.getNom());
        javafx.scene.control.TextField textBut = new TextField();
        textBut.setPrefWidth(300);
        textBut.setPrefHeight(40);
        textBut.setText(a.getPrenom());

        JFXButton upload = new JFXButton("Telecharger votre image");
        ImageView image_p = new ImageView();
        upload.setStyle("-fx-background-color: #724848; ");
        upload.setTextFill(Color.web("#e8f8ff"));
        upload.setOnMouseClicked(d -> {
            FileChooser fc = new FileChooser();
            Current_file = fc.showOpenDialog(null);
            if (Current_file != null) {
                Image images = new Image(Current_file.toURI().toString(), 100, 100, true, true);
                image_p.setImage(images);
                try {
                    fis = new FileInputStream(Current_file);
                    file_image = Current_file.getName();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ProfileGroupeController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });
        grid.add(new Label("Nom: "), 0, 0);
        grid.add(new Label("Prenom: "), 0, 1);

        grid.add(textNom, 1, 0);
        grid.add(textBut, 1, 1);

        grid.add(upload, 0, 2);
        grid.add(image_p, 1, 2);

        dialog.getDialogPane().setContent(grid);
        System.out.println("ahlan   " + a.getNom());
        // Traditional way to get the response value.
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {

            User ass = new User();
            ass.setId(Groups.getGroupe_courant());
            ass.setNom(textNom.getText());
            ass.setPrenom(textBut.getText());
            ass.setId(Controller.getUserId());


            //// upload image ///////
            try {
                ass.setImage(file_image);
                pathfrom = FileSystems.getDefault().getPath(Current_file.getPath());
                pathto = FileSystems.getDefault().getPath("C:\\wamp64\\www\\velotnproducts\\" + Current_file.getName());
                Path targetDir = FileSystems.getDefault().getPath("C:\\wamp64\\www\\velotnproducts\\");

                Files.copy(pathfrom, pathto, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException ex) {
                Logger.getLogger(ProfileGroupeController.class.getName()).log(Level.SEVERE, null, ex);
            }


            ///////////////
            us.modifierUserPhoto(ass);

            Notifications n = Notifications.create().title("Notification")
                    .text("L'utilisateur est modifié avec succées")
                    .graphic(null)
                    .position(Pos.BASELINE_LEFT)
                    .onAction((ActionEvent event1) -> {
                        System.out.println("notification");
                    });
            n.showConfirm();
            loadView("/gui/Journal.fxml");

        }
    }*/

    /*private void setNode(Node node) {
        holderPane.getChildren().clear();
        holderPane.getChildren().add((Node) node);
        FadeTransition ft = new FadeTransition(Duration.millis(1500));
        ft.setNode(node);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
    }*/

    /*private Object loadView(String path)
    {
        FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource((path)));
        AnchorPane parentContent = null;
        try {
            parentContent = fxmlLoader.load();
        } catch (IOException ex) {
            Logger.getLogger(LayoutFrontController.class.getName()).log(Level.SEVERE, null, ex);
        }
        setNode(parentContent);
        System.gc();
        return fxmlLoader.getController();
    }*/

    @FXML
    void nod(ActionEvent event) {

    }

    @FXML
    void ouid(ActionEvent event) {

    }
}
