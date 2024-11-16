package com.ajp.labs.Lab14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ProductTrigger {
    static final String DB_URL = "jdbc:mysql://localhost:3306/ajp";
    static final String USER = "root";
    static final String PASS = "root";
    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement statement = connection.createStatement()) {

            // Define the SQL statement to create a trigger

            String createTriggerSQL = "CREATE TRIGGER update_last_modified_trigger\r\n" + "AFTER INSERT ON Products\r\n"
                    + "FOR EACH ROW\r\n" + "BEGIN\r\n"
                    + "    INSERT INTO Product_Metadata (product_id) VALUES (NEW.product_id)\r\n"
                    + "    ON DUPLICATE KEY UPDATE last_modified = CURRENT_TIMESTAMP;\r\n" + "END;";
            // Execute the SQL statement to create the trigger
            statement.executeUpdate(createTriggerSQL);

            System.out.println("Trigger created successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}