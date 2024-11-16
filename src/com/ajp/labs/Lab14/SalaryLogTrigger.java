package com.ajp.labs.Lab14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SalaryLogTrigger {
    static final String DB_URL = "jdbc:mysql://localhost:3306/ajp";
    static final String USER = "root";
    static final String PASS = "root";
    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement statement = connection.createStatement()) {

            // Define the SQL statement to create a trigger

            String createTriggerSQL = "CREATE TRIGGER update_salary_trigger\r\n" + "AFTER UPDATE ON employee\r\n"
                    + "FOR EACH ROW\r\n" + "BEGIN\r\n" + "    IF NEW.salary != OLD.salary THEN\r\n"
                    + "        INSERT INTO Salary_Log (employee_id, new_salary) VALUES (NEW.eid, NEW.salary);\r\n"
                    + "    END IF;\r\n" + "END;";

            // Execute the SQL statement to create the trigger
            statement.executeUpdate(createTriggerSQL);

            System.out.println("Trigger created successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}