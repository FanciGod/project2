package JDBCconnect.model;

import JDBCconnect.connect.ConnectDTB;
import com.controller.project.Adminsite;
import entity.Purchase;
import entity.Supplier;
import entity.User;

import java.sql.*;
import java.util.Calendar;

public class ImportProductModel {
    AdminModel adminModel;
    LoginModel loginModel;
    public boolean importPurchase(String purchaseName, String supplierName, String account, String password) {
        adminModel = new AdminModel();
        loginModel = new LoginModel();
        User user = loginModel.checkAcc(account, password);
        Supplier supplier = adminModel.getSup(supplierName, "");
        Calendar calendar = Calendar.getInstance();
        java.util.Date date1 = calendar.getTime();
        java.sql.Date date = new Date(date1.getTime());
        String sql = "INSERT INTO `project`.`purchase` (`Purchase_name`, `Supplier_ID`, `Account_ID`, `Create_time`) VALUES (?, ?, ?, ?)";
        try (Connection connection = ConnectDTB.getJDBCConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, purchaseName);
            preparedStatement.setInt(2, supplier.getId());
            preparedStatement.setInt(3, user.getId());
            preparedStatement.setDate(4, date);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Purchase getPurchase(String purchaseName) {
        Purchase purchase;
        String sql = "SELECT * FROM project.purchase where Purchase_name = ?";
        try (Connection connection = ConnectDTB.getJDBCConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, purchaseName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                purchase = new Purchase();
                purchase.setPurchaseName(resultSet.getNString("Purchase_name"));
                purchase.setPurchaeId(resultSet.getInt("Purchase_ID"));
                purchase.setAccountId(resultSet.getInt("Account_ID"));
                purchase.setSupplierId(resultSet.getInt("Supplier_ID"));
                purchase.setCreateTime((java.util.Date) resultSet.getDate("Create_time"));
                return purchase;
            }
            else
                return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean importPurchaseDetail(int purchaseId, int productId, int quantity, long totalPrice) {
        String sql = "INSERT INTO `project`.`purchase_detail` (`Purchase_ID`, `Product_ID`, `Quantity`, `Total_price`) VALUES (?, ?, ?, ?)";
        try (Connection connection = ConnectDTB.getJDBCConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, purchaseId);
            preparedStatement.setInt(2, productId);
            preparedStatement.setInt(3, quantity);
            preparedStatement.setDouble(4, totalPrice);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
