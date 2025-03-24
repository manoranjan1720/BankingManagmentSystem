Bank Management System
Overview
The Bank Management System is a Java-based application designed to handle basic banking operations such as deposits, withdrawals, and fund transfers using a multi-threaded approach. The system interacts with an Oracle database to manage account balances securely.

Features
Deposit Funds: Allows customers to add money to their accounts.
Withdraw Funds: Customers can withdraw money, ensuring sufficient balance.
Transfer Funds: Enables secure fund transfers between accounts.
Multi-threaded Operations: Uses threads to handle simultaneous transactions.
Database Connectivity: Connects to an Oracle database for account management.
Project Structure
BankOperations.java

Contains methods for handling deposits, withdrawals, and transfers.
Implements transaction management to ensure data integrity.
CustomerThread.java

Implements a multi-threaded approach for banking operations.
Handles concurrent customer transactions securely.
DatabaseConnection.java

Provides a connection to the Oracle database.
Stores credentials and connection details.
MainApplication.java

The entry point of the application.
Simulates customer transactions using multiple threads.
Technologies Used
Java (JDK 8+)
JDBC (Java Database Connectivity)
Oracle Database
Multithreading
How to Run
Set up the Oracle Database

Create an accounts table with account_id and balance.
Insert sample account data.
Configure Database Connection

Update DatabaseConnection.java with valid Oracle credentials.

Compile and Run the Project

javac -d . *.java  
java com.project.bank_interface.MainApplication  
Monitor Transactions

The console displays transaction details in real-time.
Future Enhancements
Implement a Graphical User Interface (GUI).
Add user authentication for security.
Introduce interest calculations for savings accounts.
