package com.ajp.labs.Lab15;

import java.sql.*;
import java.util.Scanner;

public class DataInsertion
{
    public static void main(String[] args) throws Exception
    {
        Scanner sc=new Scanner(System.in);

        //taking input from user
        System.out.println("Enter Department Id:");
        int id=Integer.parseInt(String.valueOf(sc.nextInt()));
        System.out.println("Enter Department name:");
        sc.nextLine();
        String name=sc.next();
        System.out.println("Enter location:");
        String location=sc.next();

        //registering driver class
        Class.forName("com.mysql.cj.jdbc.Driver");

        //Establishing connection
        Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/ajp","root","root");

        //creating sql query
        String sql="insert into department values(?,?,?)";
        PreparedStatement statement=connection.prepareStatement(sql);

        //set the values
        statement.setInt(1,id);
        statement.setString(2,name);
        statement.setString(3,location);

        //executing the statement
        statement.executeUpdate();
        System.out.println("New Record inserted");

        //closing the connection
        connection.close();
    }

}