package com.ajp.practice;

import java.util.Scanner;

public class Array6 {
    public static void main(String[] args) {
        int cnt=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] even = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
            if(a[i]%2==0){
                even[cnt]=a[i];
                cnt++;
            }
        }
        System.out.println("Even elements are: ");
        for(int i=0;i<cnt;i++){
            System.out.print(even[i]+" ");
        }
    }
}
