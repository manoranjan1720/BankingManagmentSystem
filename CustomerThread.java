package com.project.bank_interface;

import java.sql.*;

public class CustomerThread extends Thread {
    private int customerId;
    private String operation;
    private double amount;
    private int toAccountId;

    public CustomerThread(int customerId, String operation, double amount, int toAccountId) {
        this.customerId = customerId;
        this.operation = operation;
        this.amount = amount;
        this.toAccountId = toAccountId;
    }

    @Override
    public void run() {
        try {
            if (operation.equals("deposit")) {
                BankOperations.deposit(customerId, amount);
                System.out.println("Deposited " + amount + " to customer " + customerId);
            } else if (operation.equals("withdraw")) {
                BankOperations.withdraw(customerId, amount);
                System.out.println("Withdrew " + amount + " from customer " + customerId);
            } else if (operation.equals("transfer")) {
                BankOperations.transfer(customerId, toAccountId, amount);
                System.out.println("Transferred " + amount + " from customer " + customerId + " to customer " + toAccountId);
            }
        } catch (SQLException e) {
            System.out.println("Error during transaction: " + e.getMessage());
        }
    }
}
