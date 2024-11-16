package com.ajp.labs.Lab13;

import java.sql.Connection;
import java.sql.DriverManager;
public class CreateConnection {
    public static void main(String[] args) {
        try {
            //creating Connection object
            Connection con=null;
            //Register the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //established the connection
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagementsystem",
                    "root", "root");
            //printing Connection Object
            System.out.println("Connection: "+con);

        }catch (Exception e) {
            System.out.println(e);
        }
    }
}