package com.project.bank_interface;

public class MainApplication {
    public static void main(String[] args) {
        // Simulating customer requests
        CustomerThread customer1 = new CustomerThread(2, "deposit", 1000, 0);
        CustomerThread customer2 = new CustomerThread(2, "withdraw", 500, 0);
        CustomerThread customer3 = new CustomerThread(4, "transfer", 20, 2);

        customer1.start();
        customer3.start();
        customer2.start();
        
    }
}
