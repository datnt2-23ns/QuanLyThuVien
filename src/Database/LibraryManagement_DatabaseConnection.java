package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LibraryManagement_DatabaseConnection {
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=LibraryManagement";
    private static final String USER = "sa"; // Thay đổi thành tài khoản SQL Server của bạn
    private static final String PASSWORD = "td19092005"; // Thay đổi thành mật khẩu của bạn

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
