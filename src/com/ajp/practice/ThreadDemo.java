package com.ajp.practice;

import java.util.Scanner;

class Demo1 extends Thread{
//class Demo1 implements Runnable{
    public void run(){
        Thread t = Thread.currentThread();
        String name = t.getName();
        if(name.equals("ADD")) add();
        else printNum();
    }
    public void add(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Addition started.....");
        System.out.println("Enter first num: ");
        int a = sc.nextInt();
        System.out.println("Enter second num: ");
        int b = sc.nextInt();
        int c = a+b;
        System.out.println("Addition is: "+c);
        System.out.println("Addition Completed......");
    }
//}
//class Demo2 extends Thread{
//class Demo2 implements Runnable{
    public void printNum(){
        System.out.println("Task started...");
        for(int i=1;i<=5;i++) {
            System.out.println(i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Task completed");
    }
}
public class ThreadDemo {
    public static void main(String[] args) {
        Demo1 d1 = new Demo1();
        Demo1 d2 = new Demo1();
        d1.setName("ADD");
        d2.setName("NUM");
        d1.start();
        d2.start();
//        Demo2 d2 = new Demo2();

        //using thread........................
//        d1.start();
//        d2.start();
        //using runnable interface.......................
//        Thread t1 = new Thread(d1);
//        Thread t2 = new Thread(d2);
//        t1.start();
//        t2.start();
    }
}
