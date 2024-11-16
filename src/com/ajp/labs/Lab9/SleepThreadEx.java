package com.ajp.labs.Lab9;

class NumberPrint extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
            try {
                // Pause for 500 milliseconds between numbers
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted.");
            }
        }
    }
}
public class SleepThreadEx {
    public static void main(String[] args) {
        // Create an instance of the thread
        NumberPrint thread = new NumberPrint();
        // Start the thread
        thread.start();
    }
}