package com.ajp.practice;

import java.util.Scanner;

public class Array3 {
    public static void main(String[] args) {
        int cnt=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int n = sc.nextInt();
        int[] a = new int[n];
        System.out.println("Enter "+n+" elements of array: ");
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        System.out.println("Enter element to find occurences ");
        int ele = sc.nextInt();
        for(int i=0;i<n;i++){
            if(a[i]==ele) cnt++;
        }
        System.out.println("Occurence of "+ele+" is: "+cnt);
    }
}
