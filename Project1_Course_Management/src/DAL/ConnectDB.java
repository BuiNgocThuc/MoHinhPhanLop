package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    private static Connection conn = null;

    static private String host, port, dbName, dbUser, dbPassword;

    public ConnectDB() {
        host = "localhost";
        port = "3306";
        dbName = "school";
        dbUser = "root";
        dbPassword = "";
    }

    public Connection getConnectDB() {
        String dbPath = "jdbc:mysql://" + host + ":" + port + "/" + dbName;
        try {
            conn = DriverManager.getConnection(dbPath, dbUser, dbPassword);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }

    public void closeConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        ConnectDB connDB = new ConnectDB();
//        connDB.getConnectDB();
//        connDB.closeConnection(conn);
//    }
}
