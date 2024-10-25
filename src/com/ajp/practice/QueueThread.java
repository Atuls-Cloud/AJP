package com.ajp.practice;

class Queue{
//    int x;
//    void store(int j){
//        x = j;
//        System.out.println("Produced"+x);
//    }
//    void retrieve(){
//        System.out.println("Consumed"+x);
//    }
    int x;
    boolean is_data_present = false;
    synchronized void store(int j){
        try{
            if(is_data_present==false){
                x = j;
                System.out.println("Produced"+x);
                is_data_present = true;
                notify();
            }
            else{
                wait();
            }
        }catch (Exception e){
            System.out.println("Some problem occurred");
        }
    }
    synchronized void retrieve(){
        try{
            if(is_data_present==true){
                System.out.println("Consumed"+x);
                is_data_present = false;
                notify();
            }
            else{
                wait();
            }
        }catch (Exception e){
            System.out.println("Some problem occurred");
        }
    }
}
class Producer extends Thread{
    Queue a;// reference to queue class which is pointing to queue object
    Producer(Queue q){
        a = q;
    }
    public void run(){
        for(int i=1;i<=10;i++) a.store(i);
    }
}
class Consumer extends Thread{
    Queue b;
    Consumer(Queue q){
        b = q;
    }
    public void run(){
        for(int i=1;i<=10;i++) b.retrieve();
    }
}
public class QueueThread {
    public static void main(String[] args) {
        Queue q = new Queue();
        Producer p = new Producer(q);
        Consumer c = new Consumer(q);
        p.start();
        c.start();
    }
}
