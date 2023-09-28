package com.controller.project;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;


public class Adminsite implements Initializable {
    public TableColumn colID;
    public TableColumn colProName;
    public TableColumn colGroup;
    public TableColumn colCapPrice;
    public TableColumn colPrice;
    public TableColumn colCurrentIn;
    public TableView tbProduct;
    Stage stage = new Stage();
    @FXML
    Button outBut;
    @FXML
    BarChart barChart;

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
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void fireBut(ActionEvent event) {
        outBut.fire();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        XYChart.Series<Object, Object> series1 = new XYChart.Series<>();
        series1.setName("VND");
        series1.getData().add(new XYChart.Data<>("19/09", 1));
        series1.getData().add(new XYChart.Data<>("20/09", 20));
        series1.getData().add(new XYChart.Data<>("21/09", 14));
        series1.getData().add(new XYChart.Data<>("22/09", 12));
        series1.getData().add(new XYChart.Data<>("23/09", 11));
        barChart.getData().addAll(series1);

        colID.setCellFactory(new PropertyValueFactory<>("id"));
        colProName.setCellFactory(new PropertyValueFactory<>("proName"));
        colCapPrice.setCellFactory(new PropertyValueFactory<>("importPrice"));
        colGroup.setCellFactory(new PropertyValueFactory<>("groupProduct"));
        colPrice.setCellFactory(new PropertyValueFactory<>("sellPrice"));
        colCurrentIn.setCellFactory(new PropertyValueFactory<>(""));
    }



    
}
