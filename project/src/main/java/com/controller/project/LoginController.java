package com.controller.project;

import entity.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;


import JDBCconnect.model.LoginModel;


public class LoginController {

    @FXML
    protected void loginCheck(String username, String password, ActionEvent event) throws IOException {
        LoginModel loginModel = new LoginModel();
        User user = loginModel.checkAcc(username, password);
        if (user != null && user.getAbility() == 1) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("adminsite.fxml"));
            Scene scene = new Scene(loader.load());
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("adminsite.css")).toExternalForm());
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            stage.setTitle("admin site");
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.resizableProperty().setValue(false);
            stage.show();
        } else if (user != null && user.getAbility() > 1) {
            System.out.println("user site");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("usersite.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            stage.setTitle("employee site");
            stage.setScene(scene);
            stage.resizableProperty().setValue(false);
            stage.show();
        } else if (user == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("wrong account");
            alert.setHeaderText("Account not found");
            alert.setContentText("Please check your account");
            alert.show();
        }

    }
}
