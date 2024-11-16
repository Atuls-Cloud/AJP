package com.ajp.labs.Lab7;

import java.util.HashMap;
public class HashMapEx {
    public static void main(String[] args) {
        // Create a HashMap
        HashMap<String, String> map = new HashMap<>();
        // Add some key-value pairs
        map.put("Name", "Atul Kumar Singh");
        map.put("College", "Ajay Kumar Garg Engineering College");
        map.put("Course", "B.Tech");
        // Display the HashMap before adding a new key-value pair
        System.out.println("HashMap before association: " + map);
        // Specify key and value to associate in HashMap
        String key = "Location";
        String value = "Ghaziabad";
        // Associate the specified value with the specified key
        map.put(key, value);
        // Display the HashMap after adding the new key-value pair
        System.out.println("HashMap after association: " + map);
    }
}
