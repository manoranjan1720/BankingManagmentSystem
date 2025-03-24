package com.project.bank_interface;

import java.sql.*;

public class DatabaseConnection {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "C##USER1";
        String password = "PRINCE";
        return DriverManager.getConnection(url, user, password);
    }
}
