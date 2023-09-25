package com.controller.project;

import entity.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import JDBCconnect.model.LoginModel;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisController {
    @FXML
    TextField userRegis;
    @FXML
    PasswordField passRegis;
    @FXML
    PasswordField confirmPass;
    @FXML
    Label warningText;

    public void regis(ActionEvent event) {
        Pattern pattern = Pattern.compile("[\\W+]");
        String registerer = userRegis.getText();
        Matcher matcher = pattern.matcher(registerer);
        if (matcher.find()) {
            warningText.setText("Please check your username again");
        } else if (!passRegis.getText().equals(confirmPass.getText())) {
            warningText.setText("Your confirm password is not match");
        } else if (userRegis.getText().equals(passRegis.getText())) {
            warningText.setText("Your username cannot match the password");
        } else {
            User user = new User(userRegis.getText(), passRegis.getText(), 2);
            LoginModel loginModel = new LoginModel();
            User usercheck = loginModel.checkAcc(userRegis.getText(), passRegis.getText());
            if (usercheck != null) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("wrong account");
                alert.setHeaderText("Account already exit");
                alert.setContentText("Please check your account");
                alert.show();
            } else {
                if (loginModel.addOne(user)) {
                    ((Node)event.getSource()).getScene().getWindow().hide();
                } else {
                    warningText.setText("Something go wrong");
                }
            }
        }

    }


}
