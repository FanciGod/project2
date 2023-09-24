package com.controller.project;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javafx.scene.*;
import java.util.Objects;

public class Login {

    @FXML
    TextField username;
    @FXML
    PasswordField password;
    @FXML
    Button loginBut;

    @FXML
    public void login(javafx.event.ActionEvent actionEvent) throws Exception {
        String uname = username.getText();
        String pword = password.getText();

        LoginController loginController = new LoginController();
        loginController.loginCheck(uname, pword, actionEvent);

    }
}
