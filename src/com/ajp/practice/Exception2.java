package com.ajp.practice;

import java.util.Scanner;

public class Exception2 {
    public static void fun() throws ArithmeticException{
//        if(n==2)
        throw new ArithmeticException();
//        else System.out.println("The number is: "+n);
    }
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter a number: ");
//        int n = sc.nextInt();
        try{
            fun();
        }
        catch(ArithmeticException e){
            System.out.println(e);
        }
//        int[] a = {3,6,0,1,2};
//        try{
//            a[5] = a[0]/a[2];
//        }

//        catch(ArrayIndexOutOfBoundsException e){
//            e.printStackTrace();
//        }

//        catch(ArithmeticException e){
//            e.printStackTrace();
//        }
//        catch(Exception e){
//            e.printStackTrace();
//        }
//        finally {
//            System.out.println("End of  the code");
//        }
    }
}
