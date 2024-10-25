package com.ajp.practice;

import java.util.Scanner;

public class Employees {
    int id;
//    String name;
//    float salary;
//    Employee(int id, String name, float salary){
//        this.id=id;
//        this.name=name;
//        this.salary=salary;
//    }
    private void getInfo(){
        Scanner sc = new Scanner(System.in);
        id = sc.nextInt();
//        name = name;
//        salary = salary;
    }
    void show(){
        System.out.println("Employee id is: "+id);
    }
}

class EmpInfo{
    public static void main(String[] args) {
        Employees e = new Employees();
        e.show();
    }
}