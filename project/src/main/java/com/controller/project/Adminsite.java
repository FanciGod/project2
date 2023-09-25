package com.controller.project;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;


public class Adminsite {
    Stage stage = new Stage();
    @FXML
    Button outBut;

    public void regissite() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(Objects.requireNonNull(getClass().getResource("registerSite.fxml")).openStream());
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.resizableProperty().setValue(false);
        stage.show();
    }

    public void logout(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("login.fxml")));
        Scene scene = new Scene(loader.load());
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void fireBut(ActionEvent event) {
        outBut.fire();
    }


}
