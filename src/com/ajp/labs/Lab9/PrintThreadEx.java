package com.ajp.labs.Lab9;

class NumberPrinter extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <= 4; i++) {
            System.out.println(i);
            try {
                // Pause for a short duration to simulate processing time
                Thread.sleep(500); // 500 milliseconds = 0.5 second
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted.");
            }
        }
    }
}

public class PrintThreadEx {
    public static void main(String[] args) {
        // Create a new instance of the thread
        NumberPrinter thread = new NumberPrinter();
        // Start the thread
        thread.start();
    }
}

