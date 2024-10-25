package com.ajp.labs.Lab1;

import java.util.Scanner;

public class NthBitSetOrUnset {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int num = sc.nextInt();
        System.out.println("Enter position/bit: ");
        int n = sc.nextInt();

        int i = num >> n-1;
        if((i&1)==1) System.out.println("Set");
        else System.out.println("Unset");
    }
}
