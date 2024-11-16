package com.ajp.labs.Lab7;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CricketerScores {
    public static void main(String[] args) {
        // Create a Map to store cricketer names and scores
        Map<String, Integer> cricketerScores = new HashMap<>();

        // Add cricketer names and scores
        cricketerScores.put("Virat Kohli", 120);
        cricketerScores.put("Rohit Sharma", 90);
        cricketerScores.put("MS Dhoni", 85);
        cricketerScores.put("Sachin Tendulkar", 150);
        cricketerScores.put("KL Rahul", 60);

        // Display the cricketer names and scores
        System.out.println("Cricketers and their scores: " + cricketerScores);

        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the batsman name to search for his score: ");
        String batsmanName = scanner.nextLine();

        // Check if the batsman name exists in the map and display the score
        if (cricketerScores.containsKey(batsmanName)) {
            int score = cricketerScores.get(batsmanName);
            System.out.println(batsmanName + "'s score: " + score);
        } else {
            System.out.println("Batsman not found in the records.");
        }
    }
}