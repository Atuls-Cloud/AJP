package com.ajp.practice;

import java.util.Scanner;

public class Array4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int n = sc.nextInt();
        int[] a = new int[n];
        System.out.println("Enter "+n+" elements of array: ");
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        System.out.println("Enter element to find: ");
        int ele = sc.nextInt();
        for(int i=0;i<n;i++) {
            if (a[i] == ele) System.out.println("Found");
            break;
        }
        System.out.println("Not Found");
    }
}
