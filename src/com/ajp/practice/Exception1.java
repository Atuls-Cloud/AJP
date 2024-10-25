package com.ajp.practice;

import java.util.Scanner;

public class Exception1 {
    public static void main(String[] args) {
        int a,b,c;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a: ");
        a = sc.nextInt();
        System.out.println("Enter b: ");
        b = sc.nextInt();
        try{
            c=a/b;
            System.out.println("C: "+c);
        }
        catch(ArithmeticException e){
            System.out.println("Arithemetic Error: "+e);
        }
        System.out.println("End code");

    }
}
