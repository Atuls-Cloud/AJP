package com.ajp.labs.Lab13;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CreateTableWithSelectQuery {

    public static void main(String[] args) {
        try {
            // creating Connection object
            Connection con = null;
            // Register the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // established the connection
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ajp", "root", "root");

            // printing Connection Object
            System.out.println("Connection: " + con);

            // creating statement
            Statement stmt = con.createStatement();

            String sql = "create table Employee2(eid int primary key auto_increment,name varchar(30)"
                    + " not null,address varchar(50) not null,salary int not null)";
            stmt.executeUpdate(sql);
            System.out.println("table creation done successfully");

            // select query
            String selectQuery = "select * from Employee2";

            // executing query
            ResultSet rs = stmt.executeQuery(selectQuery);

            // checking data is present or not
            while (rs.next()) {

                System.out.println("Id: " + rs.getInt(1));
                // using getString(String columnLabel) method
                System.out.println("Name:" + rs.getString("name"));
                // using getString(int columnIndex) method
                System.out.println("Address: " + rs.getString(3));
                // using getString(String columnLabel) method
                System.out.println("salary: " + rs.getString("salary"));
                System.out.println("===============================================");
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
