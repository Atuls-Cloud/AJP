package com.ajp.labs.Lab10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CustomerDatabaseDelete {
    // Database URL, username, and password
    private static final String DB_URL = "jdbc:mysql://localhost:3306/ajp";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get customer ID to delete
        System.out.println("Enter customer ID to delete:");
        int customerId = scanner.nextInt();

        // Delete customer data from the database
        deleteCustomerData(customerId);

        scanner.close();
    }

    public static void deleteCustomerData(int customerId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // Step 1: Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish the connection
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Step 3: Prepare SQL statement
            String deleteQuery = "DELETE FROM customers WHERE id = ?";
            preparedStatement = connection.prepareStatement(deleteQuery);

            // Set the value for the placeholder in the SQL query
            preparedStatement.setInt(1, customerId);

            // Step 4: Execute the query
            int rowsDeleted = preparedStatement.executeUpdate();

            // Display result
            if (rowsDeleted > 0) {
                System.out.println("Customer data deleted successfully!");
            } else {
                System.out.println("No customer found with the given ID.");
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

