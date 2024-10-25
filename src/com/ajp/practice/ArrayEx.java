package com.ajp.practice;

import java.util.Scanner;

public class ArrayEx {
    public static void main(String[] args){
        int eSum=0, oSum=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int n = sc.nextInt();
        int[] a = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
            if(a[i]%2==0)
            eSum+=a[i];
            else oSum+=a[i];
        }
        System.out.println("Even sum: "+eSum);
        System.out.println("Odd sum: "+oSum);
    }
}
