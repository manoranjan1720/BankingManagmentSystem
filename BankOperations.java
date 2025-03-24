package com.project.bank_interface;

import java.sql.*;

public class BankOperations {
    public static void deposit(int accountId, double amount) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        try {
            conn.setAutoCommit(false);  // Start transaction
            String query = "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setDouble(1, amount);
                stmt.setInt(2, accountId);
                stmt.executeUpdate();
            }
            conn.commit();  // Commit transaction
        } catch (SQLException e) {
            conn.rollback();  // Rollback if any error occurs
            throw e;
        } finally {
            conn.setAutoCommit(true);
            conn.close();
        }
    }

    public static void withdraw(int accountId, double amount) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        try {
            conn.setAutoCommit(false);
            String query = "UPDATE accounts SET balance = balance - ? WHERE account_id = ? AND balance >= ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setDouble(1, amount);
                stmt.setInt(2, accountId);
                stmt.setDouble(3, amount);
                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected == 0) {
                    throw new SQLException("Insufficient balance");
                }
            }
            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            throw e;
        } finally {
            conn.setAutoCommit(true);
            conn.close();
        }
    }

    public static void transfer(int fromAccountId, int toAccountId, double amount) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        try {
            conn.setAutoCommit(false);
            withdraw(fromAccountId, amount);
            deposit(toAccountId, amount);
            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            throw e;
        } finally {
            conn.setAutoCommit(true);
            conn.close();
        }
    }

    public static double checkBalance(int accountId) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        String query = "SELECT balance FROM accounts WHERE account_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, accountId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getDouble("balance");
            }
            return 0;
        }
    }
}