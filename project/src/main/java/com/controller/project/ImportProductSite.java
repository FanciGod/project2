package com.controller.project;

import JDBCconnect.model.AdminModel;
import JDBCconnect.model.ImportProductModel;
import entity.ImportProduct;
import entity.Product;
import entity.Purchase;
import entity.Supplier;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.PrimitiveIterator;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class ImportProductSite implements Initializable {

    @FXML
    public Button saveChangeBut;
    @FXML
    public AnchorPane billImportProduct;
    @FXML
    public TableView<Supplier> tbSup;
    @FXML
    public TableColumn<Supplier, Integer> colSupID;
    @FXML
    public TableColumn<Supplier, String> colSupName;
    @FXML
    public TableColumn<Supplier, String> colSupAddress;
    @FXML
    public TableColumn<Supplier, String> colSupPhone;
    @FXML
    public TextField billText;
    @FXML
    public TextField supText;
    @FXML
    public Label priceText;
    @FXML
    public Button removeBut;
    @FXML
    Button cancelImportBut;

    @FXML
    TableColumn<Product, String> colCategoryInven;

    @FXML
    TableColumn<Product, Double> colPriceInven;

    @FXML
    TableColumn<ImportProduct, Double> colProIdImport;

    @FXML
    TableColumn<Product, Integer> colProIdInven;

    @FXML
    TableColumn<ImportProduct, String> colProImportName;

    @FXML
    TableColumn<ImportProduct, Double> colProImportPrice;

    @FXML
    TableColumn<ImportProduct, Integer> colProImportQuantity;

    @FXML
    TableColumn<Product, String> colProNameInven;

    @FXML
    TableColumn<Product, Integer> colQuantityInven;

    @FXML
    TableColumn<ImportProduct, Long> colTotalPrice;

    @FXML
    Button importProBut;

    @FXML
    TextField searchImportTb;

    @FXML
    TextField searchInvenTb;

    @FXML
    TableView<ImportProduct> tbImportProduct;

    @FXML
    TableView<Product> tbProductInventory;

    ObservableList<Product> productObservableList = FXCollections.observableArrayList();
    ObservableList<ImportProduct> importProductObservableList = FXCollections.observableArrayList();

    ObservableList<Supplier> proSupList = FXCollections.observableArrayList();

    AdminModel adminModel;

    ImportProductModel importProductModel;
    private String username;
    private String password;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getDataForTbInven();
        colProIdInven.setCellValueFactory(new PropertyValueFactory<>("id"));
        colProNameInven.setCellValueFactory(new PropertyValueFactory<>("proName"));
        colCategoryInven.setCellValueFactory(new PropertyValueFactory<>("category"));
        colPriceInven.setCellValueFactory(new PropertyValueFactory<>("importPrice"));
        colQuantityInven.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        tbProductInventory.setItems(productObservableList);

        colProIdImport.setCellValueFactory(new PropertyValueFactory<>("id"));
        colProImportName.setCellValueFactory(new PropertyValueFactory<>("proName"));
        colProImportPrice.setCellValueFactory(new PropertyValueFactory<>("importPrice"));
        colProImportQuantity.setCellValueFactory(new PropertyValueFactory<>("quantityImport"));
        colTotalPrice.setCellValueFactory(new PropertyValueFactory<>("totalPriceImport"));
        tbImportProduct.setItems(null);

        getDataForTbSup();
        getDataSup(colSupID, colSupName, colSupAddress, colSupPhone, tbSup, proSupList);
    }

    static void getDataSup(TableColumn<Supplier, Integer> colSupID, TableColumn<Supplier, String> colSupName, TableColumn<Supplier, String> colSupAddress, TableColumn<Supplier, String> colSupPhone, TableView<Supplier> tbSup, ObservableList<Supplier> proSupList) {
        colSupID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colSupName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colSupAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colSupPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        tbSup.setItems(proSupList);
    }

    private void getDataForTbInven() {
        adminModel = new AdminModel();
        if (adminModel.getDataProduct() != null) {
            productObservableList.addAll(adminModel.getDataProduct());
        }
    }

    private void getDataForTbSup() {
        adminModel = new AdminModel();
        if (adminModel.getDataSup() != null) {
            proSupList.addAll(adminModel.getDataSup());
        }
    }

    @FXML
    public void saveImportProduct(ActionEvent event) {
        if (tbProductInventory.isVisible()) {
            tbProductInventory.setVisible(false);
            searchInvenTb.setVisible(false);
            saveChangeBut.setVisible(false);
            removeBut.setVisible(false);
            billImportProduct.setVisible(true);
            Long totalPriceBill = 0L;
            ObservableList<ImportProduct> tempTable = tbImportProduct.getItems();
            if (tempTable != null) {
                for (ImportProduct x : tempTable) {
                    if (! x.getQuantityImport().getText().isEmpty()) {
                        totalPriceBill += x.getTotalPriceImport();
                    }
                }
                priceText.setText(String.valueOf(totalPriceBill));
            }
        } else {
            importProductModel = new ImportProductModel();
            if (importProductModel.importPurchase(billText.getText(), supText.getText(), "admin", "1")) {
                ObservableList<ImportProduct> tempTable = tbImportProduct.getItems();
                Purchase purchase;
                for (ImportProduct x : tempTable) {
                    purchase = importProductModel.getPurchase(billText.getText());
                    if (importProductModel.importPurchaseDetail(purchase.getPurchaeId(), x.getId(), x.getQuantity(), Long.parseLong(priceText.getText()))) {
                        ((Node)event.getSource()).getScene().getWindow().hide();
                    } else {
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Something wrong");
                        alert.setHeaderText("something wrong in your bill");
                        alert.setContentText("Please check again");
                        alert.show();
                    }
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Something wrong");
                alert.setHeaderText("something wrong in your bill");
                alert.setContentText("Please check again");
                alert.show();
            }
        }
    }

    public void cancelImportProduct(ActionEvent event) {
        if (tbProductInventory.isVisible()) {
            ((Node)event.getSource()).getScene().getWindow().hide();
        } else {
            tbImportProduct.setVisible(true);
            tbProductInventory.setVisible(true);
            searchImportTb.setVisible(true);
            searchInvenTb.setVisible(true);
            saveChangeBut.setVisible(true);
            billImportProduct.setVisible(false);
            removeBut.setVisible(true);
        }
    }

    public void takeProduct(MouseEvent mouseEvent) {
        int flag = 0;
        Product product = tbProductInventory.getSelectionModel().getSelectedItem();
        ImportProduct importProduct = new ImportProduct();
        importProduct.setProName(product.getProName());
        importProduct.setId(product.getId());
        importProduct.setImportPrice(product.getImportPrice());
        importProduct.setQuantityImport(new TextField("1"));
        importProduct.setTotalPriceImport();
        for (ImportProduct x : importProductObservableList) {
            if (x.getProName().equals(importProduct.getProName())) {
                flag = 1;
            }
        }
        if (flag == 0) {
            importProductObservableList.add(importProduct);
        }
        tbImportProduct.setItems(importProductObservableList);
    }

    public void changeQuantityImportPro(ActionEvent event) {
        ObservableList<ImportProduct> tempTable = tbImportProduct.getItems();
        for (ImportProduct x : tempTable) {
            if (! x.getQuantityImport().getText().isEmpty()) {
                x.setTotalPriceImport();
                tbImportProduct.setItems(tempTable);
                tbImportProduct.refresh();
            }
        }
    }

    public void displayTbSup(MouseEvent mouseEvent) {
        tbSup.setVisible(true);
    }

    public void getItemSup(MouseEvent mouseEvent) {
        String name = tbSup.getSelectionModel().getSelectedItem().getName();
        supText.setText(name);
    }

    public void closeTbSup(MouseEvent mouseEvent) {
        tbSup.setVisible(false);
    }

    public void takeDataAccount(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void removeImportProduct(ActionEvent event) {
        int selectedId = tbImportProduct.getSelectionModel().getSelectedIndex();
        tbImportProduct.getItems().remove(selectedId);
    }


}
