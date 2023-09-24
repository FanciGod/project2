package JDBCconnect.connect;


import java.net.HttpURLConnection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import JDBCconnect.config.EConfig;

public class ConnectDTB {
    public static Connection getJDBCConnect() {
        java.sql.Connection con = null;
        String connectionURL = "jdbc:mysql://" + EConfig.HOSTNAME.getDTB()
                + ":" + EConfig.PORT.getDTB() + "/"
                + EConfig.DBNAME.getDTB();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException exception) {
            System.out.println("Cannot find your JDBC driver");
            return con;
        }

        try {
            con = DriverManager.getConnection(connectionURL, EConfig.USERNAME.getDTB(), EConfig.PASSWORD.getDTB());
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check again");
            return con;
        }
        return con;
    }

//    public static void main(String[] args) {
//        System.out.println(getJDBCConnect());
//    }
}
