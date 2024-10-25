package com.ajp.practice;

class Thread1 extends Thread{
    public void  run(){
        //System.out.println("Task started...");
        for(int i=1;i<=5;i++) {
            Thread t = Thread.currentThread();
            System.out.println(t.getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //System.out.println("Task completed");
    }
}
public class ThreadEx {
    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        Thread1 t2 = new Thread1();
        Thread1 t3 = new Thread1();
        t1.setName("T1");
        t2.setName("T2");
        t3.setName("T3");
        t1.start();
        try{
            t1.join();
        }catch (Exception e){
            System.out.println(e);
        }
        t2.start();
        t3.start();
    }
}
