package com.ajp.labs.Lab10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CustomerDatabaseInsert {
    // Database URL, username, and password
    private static final String DB_URL = "jdbc:mysql://localhost:3306/ajp";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get customer details
        System.out.println("Enter customer name:");
        String name = scanner.nextLine();

        System.out.println("Enter customer email:");
        String email = scanner.nextLine();

        System.out.println("Enter customer phone number:");
        String phone = scanner.nextLine();

        System.out.println("Enter customer address:");
        String address = scanner.nextLine();

        // Insert customer data into the database
        insertCustomerData(name, email, phone, address);

        scanner.close();
    }

    public static void insertCustomerData(String name, String email, String phone, String address) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // Step 1: Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish the connection
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Step 3: Prepare SQL statement
            String insertQuery = "INSERT INTO customers (name, email, phone, address) VALUES (?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(insertQuery);

            // Set the values for each placeholder in the SQL query
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, phone);
            preparedStatement.setString(4, address);

            // Step 4: Execute the query
            int rowsInserted = preparedStatement.executeUpdate();

            // Display result
            if (rowsInserted > 0) {
                System.out.println("Customer data inserted successfully!");
            } else {
                System.out.println("Failed to insert customer data.");
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

