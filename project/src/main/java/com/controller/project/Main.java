package com.controller.project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login.fxml")));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("Loginsite.css")).toExternalForm());
        stage.setTitle("Login site");
        stage.setScene(scene);
        stage.resizableProperty().setValue(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
