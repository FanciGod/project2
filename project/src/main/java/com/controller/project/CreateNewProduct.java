package com.controller.project;

import JDBCconnect.model.AdminModel;
import entity.Category;
import entity.Product;
import entity.Supplier;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import standardized.Name.Name;
import standardized.Phone.RegexPhoneNumber;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateNewProduct implements Initializable {
    @FXML
    public TextField categoryName;
    @FXML
    public TextField newSupplierName;
    @FXML
    public DialogPane dialogSup;
    @FXML
    public TextField supPhone;
    @FXML
    public TextField supAddress;
    @FXML
    public TableView<Category> tbProGroup;
    @FXML
    public TableColumn<Category, Integer> cateId;
    @FXML
    public TableColumn<Category, String> cateName;
    @FXML
    public TableView<Supplier> tbSup;
    @FXML
    public TableColumn<Supplier, Integer> colSupID;
    public TableColumn<Supplier, String> colSupName;
    @FXML
    public TableColumn<Supplier, String> colSupAddress;
    @FXML
    public TableColumn<Supplier, String> colSupPhone;
    @FXML
    public BorderPane borderProGroup;
    @FXML
    public BorderPane borderSup;
    @FXML
    public TextField proGroupText;
    @FXML
    public TextField supplierText;
    @FXML
    public TextField proName;
    @FXML
    public TextField importPrice;
    @FXML
    public TextField sellPrice;
    @FXML
    public TextField quantity;
    public Button saveNewPro;
    public Button cancelNewPro;
    @FXML
    FontAwesomeIconView newProGroupIcon;

    @FXML
    FontAwesomeIconView newSupplierIcon;
    @FXML
    DialogPane dialogProGroup;
    AdminModel adminModel;
    ObservableList<Category> proGroupList = FXCollections.observableArrayList();
    ObservableList<Supplier> proSupList = FXCollections.observableArrayList();
    Integer index;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setProGroupData();
        cateId.setCellValueFactory(new PropertyValueFactory<>("id"));
        cateName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tbProGroup.setItems(proGroupList);

        setSupTBData();
        ImportProductSite.getDataSup(colSupID, colSupName, colSupAddress, colSupPhone, tbSup, proSupList);
    }

    private void setProGroupData() {
        adminModel = new AdminModel();
        if (adminModel.getDataProGroup() != null) {
            proGroupList.addAll(adminModel.getDataProGroup());
        }
    }

    private void setSupTBData() {
        adminModel = new AdminModel();
        if (adminModel.getDataSup() != null) {
            proSupList.addAll(adminModel.getDataSup());
        }
    }

    private void setNewProGroupOnTb(String name) {
        adminModel = new AdminModel();
        Category category = adminModel.getCategory(name);
        ObservableList<Category> categories = tbProGroup.getItems();
        categories.add(category);
        tbProGroup.setItems(categories);
    }

    private void setNewSupplierOnTb(String name, String phone) {
        adminModel = new AdminModel();
        Supplier supplier = adminModel.getSup(name, phone);
        ObservableList<Supplier> suppliers = tbSup.getItems();
        suppliers.add(supplier);
        tbSup.setItems(suppliers);
    }

    @FXML
    public void newProGroup(MouseEvent event) {
        dialogProGroup.setVisible(true);
        saveNewPro.setVisible(false);
        cancelNewPro.setVisible(false);
    }
    @FXML
    public void createNewGroup(ActionEvent event) {
        String cateName = Name.standardName(categoryName.getText());
        if (!cateName.isEmpty()) {
             adminModel = new AdminModel();
            if (adminModel.getCategory(cateName) != null) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("something wrong");
                alert.setHeaderText("Group name already exit");
                alert.setContentText("Please check again");
                alert.show();
            } else {
                if (adminModel.addNewCategory(cateName)) {
                    dialogProGroup.setVisible(false);
                    saveNewPro.setVisible(true);
                    cancelNewPro.setVisible(true);
                    setNewProGroupOnTb(cateName);
                } else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("something wrong");
                    alert.setHeaderText("Has something wrong");
                    alert.setContentText("Please check again");
                    alert.show();
                }
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Something wrong");
            alert.setHeaderText("Empty group name");
            alert.setContentText("Please check again");
            alert.show();
        }
    }
    public void cancelCreNewGroup(ActionEvent event) {
        dialogProGroup.setVisible(false);
        saveNewPro.setVisible(true);
        cancelNewPro.setVisible(true);
    }

    public void createNewSup(ActionEvent event) {
        String supName = Name.standardName(newSupplierName.getText());
        String supAdd = supAddress.getText();
        String supPhoneNum = supPhone.getText();
        if (supName.isEmpty() || supAdd.isEmpty() || supPhoneNum.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Something wrong");
            alert.setHeaderText("Your input information is empty");
            alert.setContentText("Please check again");
            alert.show();
        } else {
            if (RegexPhoneNumber.regexPhoneVN(supPhoneNum)) {
                adminModel = new AdminModel();
                if (adminModel.getSup(supName, supPhoneNum) != null) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Something wrong");
                    alert.setHeaderText("Supplier already exit");
                    alert.setContentText("Please check again");
                    alert.show();
                } else {
                    if (adminModel.addNewSup(supName, supAdd, supPhoneNum)) {
                        dialogSup.setVisible(false);
                        setNewSupplierOnTb(supName, supPhoneNum);
                    } else {
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("something wrong");
                        alert.setHeaderText("Has something wrong");
                        alert.setContentText("Please check again");
                        alert.show();
                    }
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Something wrong");
                alert.setHeaderText("Your phone number is wrong");
                alert.setContentText("Please check again");
                alert.show();
            }
        }
    }

    public void cancelCreNewSup(ActionEvent event) {
        dialogSup.setVisible(false);
        saveNewPro.setVisible(true);
        cancelNewPro.setVisible(true);
    }

    public void newSup(MouseEvent mouseEvent) {
        dialogSup.setVisible(true);
        saveNewPro.setVisible(false);
        cancelNewPro.setVisible(false);
    }

    public void displayProGroupTb(MouseEvent mouseEvent) {
        tbProGroup.setVisible(true);
        borderProGroup.setVisible(true);
        borderSup.setVisible(false);
        saveNewPro.setVisible(false);
        cancelNewPro.setVisible(false);
    }

    public void closeTbProGroup(MouseEvent mouseEvent) {
        tbProGroup.setVisible(false);
        borderProGroup.setVisible(false);
        saveNewPro.setVisible(true);
        cancelNewPro.setVisible(true);
    }


    public void closeSupTb(MouseEvent mouseEvent) {
        tbSup.setVisible(false);
        borderSup.setVisible(false);
        saveNewPro.setVisible(true);
        cancelNewPro.setVisible(true);
    }

    public void displaySupTB(MouseEvent mouseEvent) {
        tbSup.setVisible(true);
        borderSup.setVisible(true);
        borderProGroup.setVisible(false);
        saveNewPro.setVisible(false);
        cancelNewPro.setVisible(false);
    }

    public void getItemSup(MouseEvent mouseEvent) {
        String name = tbSup.getSelectionModel().getSelectedItem().getName();
        supplierText.setText(name);
    }

    public void getItemGroup(MouseEvent mouseEvent) {
        Category category = tbProGroup.getSelectionModel().getSelectedItem();
        proGroupText.setText(String.valueOf(category.getName()));
    }

    public void createNewProduct(ActionEvent event) {
        adminModel = new AdminModel();
        int categoryID = adminModel.getCategory(proGroupText.getText()).getId();
        int supplierID = adminModel.getSup(supplierText.getText(), "").getId();
        Product product = new Product(proName.getText(), Double.parseDouble(importPrice.getText()), Double.parseDouble(sellPrice.getText()), Integer.parseInt(quantity.getText()), proGroupText.getText(), supplierText.getText());
        if (adminModel.getProduct(proName.getText()) != null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Something wrong");
            alert.setHeaderText("Product already exit");
            alert.setContentText("Please check again");
            alert.show();
        } else {
            if (adminModel.createPro(product, categoryID, supplierID)) {
                ((Node)event.getSource()).getScene().getWindow().hide();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Something wrong");
                alert.setHeaderText("Something went wrong");
                alert.setContentText("Please check again");
                alert.show();
            }
        }
    }

    public void cancelCreNewProduct(ActionEvent event) {
        ((Node)event.getSource()).getScene().getWindow().hide();
    }
}
