package com.ajp.practice;

import java.util.Scanner;

public class Array2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int n = sc.nextInt();
        int[] a = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        System.out.println("Even elements are: ");
        for(int i=0;i<n;i++){
            if(a[i]%2==0) System.out.print(a[i]+" ");
        }
        System.out.println();
        System.out.println("Odd elements are: ");
        for(int i=0;i<n;i++){
            if(a[i]%2!=0) System.out.print(a[i]+" ");
        }
    }
}
