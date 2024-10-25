package com.ajp.labs.Lab1;

import java.util.Scanner;

public class MaxOfTwoNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first number: ");
        int num1 = sc.nextInt();
        System.out.println("Enter second number: ");
        int num2 = sc.nextInt();
        int max = num1>=num2 ? num1 : num2;
        System.out.println("Maximum is "+max);
    }
}
