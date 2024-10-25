package com.ajp.labs.Lab2;

import java.util.Scanner;

public class StrongNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int n = sc.nextInt();
        int temp = n;
        int sum = 0;
        while(n!=0){
            int d = n%10;
            sum += fact(d);
            n /= 10;
        }
        if(sum==temp) System.out.println("Strong Number");
        else System.out.println("Not a Strong Number");
    }

    private static int fact(int n) {
        if(n==0) return 1;
        return n*fact(n-1);
    }
}
