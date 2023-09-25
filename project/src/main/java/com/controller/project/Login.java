package com.controller.project;


import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


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
