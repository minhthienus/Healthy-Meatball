package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {

    private final static String serverName = "localhost";
    private final static String dbName = "workshop1";
    private final static String portNumber = "1433";
    private final static String instance = "";
    private final static String userID = "sa";
    private final static String password = "12345";

    public static Connection getConnection() {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber
                + (instance != null && !instance.trim().isEmpty() ? "\\" + instance : "")
                + ";databaseName=" + dbName;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(url, userID, password);
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Connection error! " + ex.getMessage());
        }
        return null;
    }

    public static void main(String[] args) {
        getConnection();
    }
}
