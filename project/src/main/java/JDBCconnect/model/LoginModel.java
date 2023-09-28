package JDBCconnect.model;

import JDBCconnect.connect.ConnectDTB;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginModel {
    public User checkAcc(String username, String password) {
        String sqlQuery = "SELECT * FROM project.account Where Account_name = ? and Password = ? and Is_deleted = '0'";
        try (Connection con = ConnectDTB.getJDBCConnect();
             PreparedStatement pre = con.prepareStatement(sqlQuery)) {
            pre.setString(1, username);
            pre.setString(2, password);
            ResultSet res = pre.executeQuery();
            if (res.next()) {
                User user = new User();
                user.setUsername(res.getString("Account_name"));
                user.setPassword(res.getString("Password"));
                user.setAbility(res.getInt("Role_ID"));;
                return user;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }

    public boolean addOne(User user) {
        String sql = "INSERT INTO `project`.`account` (`Account_name`, `Password`, `Role_ID`) VALUES (?, ?, '2');";
        try (Connection connection = ConnectDTB.getJDBCConnect();
             PreparedStatement pre = connection.prepareStatement(sql)) {
            pre.setString(1, user.getUsername());
            pre.setString(2, user.getPassword());
            pre.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
