package com.controller.project;


import JDBCconnect.model.AdminModel;
import entity.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.function.Predicate;


public class Adminsite implements Initializable {
    @FXML
    public TextField searchTb;
    @FXML
    public BorderPane newProductSreen;
    @FXML
    public BorderPane categoryScreen;
    @FXML
    public AnchorPane dashboardScreen;
    @FXML
    public TableView<Product> tbCategory;
    @FXML
    public TableColumn<Product, Integer> colIdCate;
    @FXML
    public TableColumn<Product, String> colProNameCate;
    @FXML
    public TableColumn<Product, String> colGroupCate;
    @FXML
    public TableColumn<Product, Double> colCapPriceCate;
    @FXML
    public TableColumn<Product, Double> colPriceCate;
    @FXML
    public TableColumn<Product, Integer> colCurrentInCate;
    @FXML
    public TextField searchTbCate;

    @FXML
    private TableColumn<Product, Double> colCapPrice;

    @FXML
    private TableColumn<Product, Integer> colCurrentIn;

    @FXML
    private TableColumn<Product, Integer> colGroup;

    @FXML
    private TableColumn<Product, Integer> colID;

    @FXML
    private TableColumn<Product, Double> colPrice;

    @FXML
    private TableColumn<Product, String> colProName;
    @FXML
    TableView<Product> tbProduct;
    Stage stage = new Stage();
    FXMLLoader loader;
    @FXML
    Button outBut;
    @FXML
    BarChart barChart;
    final ObservableList<Product> proList = FXCollections.observableArrayList();

    public void regissite() throws IOException {
        loader = new FXMLLoader();
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

    public void fireBut() {
        outBut.fire();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //init barchart
        XYChart.Series<Object, Object> series1 = new XYChart.Series<>();
        series1.setName("VND");
        series1.getData().add(new XYChart.Data<>("19/09", 1));
        series1.getData().add(new XYChart.Data<>("20/09", 20));
        series1.getData().add(new XYChart.Data<>("21/09", 14));
        series1.getData().add(new XYChart.Data<>("22/09", 12));
        series1.getData().add(new XYChart.Data<>("23/09", 11));
        barChart.getData().addAll(series1);

        //init Product table
        getProductData();
        colID.setCellValueFactory(new PropertyValueFactory<Product, Integer>("id"));
        colProName.setCellValueFactory(new PropertyValueFactory<Product, String>("proName"));
        colCapPrice.setCellValueFactory(new PropertyValueFactory<Product, Double>("importPrice"));
        colGroup.setCellValueFactory(new PropertyValueFactory<>("category"));
        colPrice.setCellValueFactory(new PropertyValueFactory<Product, Double>("sellPrice"));
        colCurrentIn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("quantity"));
        tbProduct.setItems(proList);
        searchFilter();

        colIdCate.setCellValueFactory(new PropertyValueFactory<Product, Integer>("id"));
        colProNameCate.setCellValueFactory(new PropertyValueFactory<Product, String>("proName"));
        colCapPriceCate.setCellValueFactory(new PropertyValueFactory<Product, Double>("importPrice"));
        colGroupCate.setCellValueFactory(new PropertyValueFactory<>("category"));
        colPriceCate.setCellValueFactory(new PropertyValueFactory<Product, Double>("sellPrice"));
        colCurrentInCate.setCellValueFactory(new PropertyValueFactory<Product, Integer>("quantity"));
        tbCategory.setItems(proList);
        searchFilterCate();
    }

    @SuppressWarnings("NumberFormat")
    private void searchFilter() {
        FilteredList<Product> filterSearch = new FilteredList<>(proList, e -> true);
        searchTb.setOnKeyReleased(e -> {


            searchTb.textProperty().addListener((observable, oldValue, newValue) -> {
                filterSearch.setPredicate((Predicate<? super Product>) cust -> {
                    if (newValue == null) {
                        return true;
                    }
                    String toLowerCaseFilter = newValue.toLowerCase();
                    if (cust.getProName().toLowerCase().contains(toLowerCaseFilter)) {
                        return true;
                    } else if (cust.getCategory().toLowerCase().contains(toLowerCaseFilter)) {
                        return true;
                    } else if (newValue.matches("-?\\d+(\\.\\d+)?")) {
                        if (cust.getSellPrice() == Double.parseDouble(newValue)) {
                            return true;
                        } else if (cust.getImportPrice() == Double.parseDouble(newValue)) {
                            return true;
                        }
                    }
                    return false;
                });
            });

            SortedList<Product> products = new SortedList<>(filterSearch);
            products.comparatorProperty().bind(tbProduct.comparatorProperty());
            tbProduct.setItems(products);
        });
    }

    private void searchFilterCate() {
        FilteredList<Product> filterSearch = new FilteredList<>(proList, e -> true);
        searchTbCate.setOnKeyReleased(e -> {


            searchTbCate.textProperty().addListener((observable, oldValue, newValue) -> {
                filterSearch.setPredicate((Predicate<? super Product>) cust -> {
                    if (newValue == null) {
                        return true;
                    }
                    String toLowerCaseFilter = newValue.toLowerCase();
                    if (cust.getProName().toLowerCase().contains(toLowerCaseFilter)) {
                        return true;
                    } else if (cust.getCategory().toLowerCase().contains(toLowerCaseFilter)) {
                        return true;
                    } else if (newValue.matches("-?\\d+(\\.\\d+)?")) {
                        if (cust.getSellPrice() == Double.parseDouble(newValue)) {
                            return true;
                        } else if (cust.getImportPrice() == Double.parseDouble(newValue)) {
                            return true;
                        }
                    }
                    return false;
                });
            });

            SortedList<Product> products = new SortedList<>(filterSearch);
            products.comparatorProperty().bind(tbCategory.comparatorProperty());
            tbCategory.setItems(products);
        });
    }

    private void getProductData() {
        AdminModel adminModel = new AdminModel();
        if (adminModel.getDataProduct() != null) {
            proList.addAll(adminModel.getDataProduct());
        }
    }

    public void creatNewProduct(ActionEvent event) {
        try {
            loader = new FXMLLoader();
            Pane root = loader.load(Objects.requireNonNull(this.getClass().getResource("createNewProduct.fxml")).openStream());
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Create new");
            stage.centerOnScreen();
            stage.show();
        } catch (IOException ignore) {
        }
    }



    public void refreshTb(ActionEvent event) {
        AdminModel adminModel = new AdminModel();
        List<Product> productList = adminModel.getDataProduct();
        Product product = productList.get(productList.size()-1);
        ObservableList<Product> products = tbProduct.getItems();
        if (productList.size() > products.size()) {
            products.add(product);
            tbProduct.setItems(products);
        }
    }

    public void displayDashboard(){
        dashboardScreen.setVisible(true);
        categoryScreen.setVisible(false);
        newProductSreen.setVisible(false);
    };

    public void displayCategory(){
        dashboardScreen.setVisible(false);
        categoryScreen.setVisible(true);
        newProductSreen.setVisible(false);
    };

    public void displayNewProduct(){
        dashboardScreen.setVisible(false);
        categoryScreen.setVisible(false);
        newProductSreen.setVisible(true);
    };
}
