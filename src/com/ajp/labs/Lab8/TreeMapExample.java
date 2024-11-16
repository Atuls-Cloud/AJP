package com.ajp.labs.Lab8;

import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args) {
        // Initialize the TreeMap with values
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("One", 1);
        map.put("Three", 3);
        map.put("Two", 2);

        System.out.println("Original TreeMap: " + map);

        // Remove and retrieve the value associated with the specified key
        String keyToRemove = "Two";
        Integer removedValue = map.remove(keyToRemove);

        System.out.println("Removed value = " + removedValue);

        // Check if another entry exists and remove it if present
        String checkKey = "Three";
        Integer removedEntry = map.remove(checkKey);
        boolean isRemoved = (map.remove(checkKey) == null);

        System.out.println("Is the entry {" + checkKey + "=" + removedEntry + "} removed? " + isRemoved);

        // Display the updated TreeMap
        System.out.println("Updated TreeMap: " + map);
    }
}
