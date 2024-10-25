package com.ajp.labs.Lab2;

public class User {
    int id;
    String name;
    User(int id, String name){
        this.name = name;
        this.id = id;
    }
}
class Employee1 extends User{
    double salary;
    Employee1(int id, String name) {
        super(id, name);
    }

    double calculateAnnualSalary(double salary){
        return 12*salary;
    }

    public static void main(String[] args) {
        Employee1 emp = new Employee1(24,"Atul");
        double annSalary = emp.calculateAnnualSalary(150000);
        System.out.println("Annual salary is: "+annSalary);
    }
}
