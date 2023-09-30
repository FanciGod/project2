package JDBCconnect.model;

import JDBCconnect.connect.ConnectDTB;
import entity.Category;
import entity.Product;
import entity.Supplier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;

public class AdminModel {
    public List<Product> getDataProduct() {
        Product product;
        List<Product> productList = new ArrayList<>();
        String sql = "SELECT *, project.category.Name as cateName, project.supplier.Name as supName\n" +
                "FROM project.product \n" +
                "join project.category on product.Category_ID = category.Category_ID\n" +
                "join project.supplier on product.Supplier_ID = supplier.Supplier_ID\n" +
                "Where product.Is_deleted = 0;";
        try (Connection connection = ConnectDTB.getJDBCConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                product = new Product();
                product.setId(resultSet.getInt("Product_ID"));
                product.setProName(resultSet.getString("Name"));
                product.setSellPrice(resultSet.getDouble("Sell_price"));
                product.setImportPrice(resultSet.getDouble("Import_price"));
                product.setCategory(resultSet.getString("cateName"));
                product.setQuantity(resultSet.getInt("Quantity"));
                product.setDescription(resultSet.getString("Description"));
                product.setSupplier(resultSet.getString("supName"));
                productList.add(product);
            }
            if (productList.isEmpty()) {
                return null;
            } else
                return productList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Product getProduct(String name) {
        Product product;
        String sql = "SELECT *, project.category.Name as cateName, project.supplier.Name as supName\n" +
                "FROM project.product \n" +
                "join project.category on product.Category_ID = category.Category_ID\n" +
                "join project.supplier on product.Supplier_ID = supplier.Supplier_ID\n" +
                "Where product.Name = ? and Is_deleted = '0'";
        try (Connection connection = ConnectDTB.getJDBCConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                product = new Product();
                product.setId(resultSet.getInt("Product_ID"));
                product.setProName(resultSet.getString("Name"));
                product.setSellPrice(resultSet.getDouble("Sell_price"));
                product.setImportPrice(resultSet.getDouble("Import_price"));
                product.setCategory(resultSet.getString("cateName"));
                product.setQuantity(resultSet.getInt("Quantity"));
                product.setDescription(resultSet.getString("Description"));
                product.setSupplier(resultSet.getString("supName"));
                return product;
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean createPro(Product product, int categoryId, int supplierId) {
        String sql = "INSERT INTO `project`.`product` (`Name`, `Sell_price`, `Import_price`, `Quantity`, `Category_ID`, `Supplier_ID`) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = ConnectDTB.getJDBCConnect();
             PreparedStatement pre = connection.prepareStatement(sql)) {
            pre.setString(1, product.getProName());
            pre.setDouble(2, product.getSellPrice());
            pre.setDouble(3,product.getImportPrice());
            pre.setInt(4,product.getQuantity());
            pre.setInt(5,categoryId);
            pre.setInt(6,supplierId);
            pre.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean addNewCategory(String name) {
        String sql = "INSERT INTO `project`.`category` (`Name`) VALUES (?)";
        try (Connection connection = ConnectDTB.getJDBCConnect();
             PreparedStatement pre = connection.prepareStatement(sql)) {
            pre.setString(1, name);
            pre.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public Category getCategory(String name) {
        String sql = "SELECT * FROM project.category where Name = ?";
        try (Connection connection = ConnectDTB.getJDBCConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Category(resultSet.getInt("Category_ID"),resultSet.getString("Name"));
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean addNewSup(String name, String address, String phone) {
        String sql = "INSERT INTO `project`.`supplier` (`Name`, `Address`, `Phone`) VALUES (?, ?, ?)";
        try (Connection connection = ConnectDTB.getJDBCConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, address);
            preparedStatement.setString(3, phone);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Supplier getSup(String name, String phone) {
        String sql = "SELECT * FROM project.supplier where Name = ? or Phone = ?";
        try (Connection connection = ConnectDTB.getJDBCConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, phone);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Supplier(resultSet.getInt("Supplier_ID"),resultSet.getString("Name"), resultSet.getString("Address"),
                        resultSet.getString("Phone"));
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Category> getDataProGroup() {
        Category category;
        List<Category> categoryList = new ArrayList<>();
        String sql = "SELECT * FROM project.category";
        try (Connection connection = ConnectDTB.getJDBCConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery();) {
            while (resultSet.next()) {
                category = new Category();
                category.setId(resultSet.getInt("Category_ID"));
                category.setName(resultSet.getString("Name"));
                categoryList.add(category);
            }
            return categoryList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Supplier> getDataSup() {
        Supplier supplier;
        List<Supplier> supplierList = new ArrayList<>();
        String sql ="SELECT * FROM project.supplier";
        try (Connection connection = ConnectDTB.getJDBCConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery();) {
            while (resultSet.next()) {
                supplier = new Supplier();
                supplier.setId(resultSet.getInt("Supplier_ID"));
                supplier.setName(resultSet.getString("Name"));
                supplier.setAddress(resultSet.getString("Address"));
                supplier.setPhone(resultSet.getString("Phone"));
                supplierList.add(supplier);
            }
            return supplierList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
