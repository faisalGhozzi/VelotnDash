package com.velotn.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
private double x,y;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("front/HomeFront.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("back/Home.fxml"));
        primaryStage.setScene(new Scene(root));
        //set undecorated
        primaryStage.initStyle(StageStyle.UNDECORATED);

        //drag screen
        root.setOnMousePressed(event -> {
            x= event.getSceneX();
            y= event.getSceneY();
        });
        root.setOnMouseDragged(event -> {
            primaryStage.setX(event.getSceneX()-x);
            primaryStage.setY(event.getSceneY()-y);
        });
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
