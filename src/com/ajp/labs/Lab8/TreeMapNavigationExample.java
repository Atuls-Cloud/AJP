package com.ajp.labs.Lab8;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapNavigationExample {
    public static void main(String[] args) {
        // Initialize the TreeMap with values
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        map.put("Four", 4);
        map.put("Five", 5);

        System.out.println("TreeMap: " + map);

        // 1. Using entrySet() and enhanced for loop
        System.out.println("\nNavigating using entrySet() with for-each loop:");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        // 2. Using keySet() and iterator
        System.out.println("\nNavigating using keySet() with iterator:");
        for (String key : map.keySet()) {
            System.out.println(key + " = " + map.get(key));
        }

        // 3. Using values() and enhanced for loop to print only values
        System.out.println("\nNavigating values only using values() with for-each loop:");
        for (Integer value : map.values()) {
            System.out.println("Value = " + value);
        }

        // 4. Using forEach() with lambda expression (Java 8+)
        System.out.println("\nNavigating using forEach() with lambda expression:");
        map.forEach((key, value) -> System.out.println(key + " = " + value));

        // 5. Using descendingMap() for reverse order traversal
        System.out.println("\nNavigating in reverse order using descendingMap():");
        for (Map.Entry<String, Integer> entry : map.descendingMap().entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        // 6. Using firstEntry(), lastEntry(), higherEntry(), and lowerEntry()
        System.out.println("\nUsing firstEntry(), lastEntry(), higherEntry(), and lowerEntry():");
        System.out.println("First Entry: " + map.firstEntry());
        System.out.println("Last Entry: " + map.lastEntry());
        System.out.println("Higher Entry than 'Two': " + map.higherEntry("Two"));
        System.out.println("Lower Entry than 'Two': " + map.lowerEntry("Two"));

        // 7. Using pollFirstEntry() and pollLastEntry() to remove and get first and last entries
        System.out.println("\nUsing pollFirstEntry() and pollLastEntry():");
        System.out.println("Poll First Entry: " + map.pollFirstEntry());
        System.out.println("Poll Last Entry: " + map.pollLastEntry());
        System.out.println("Updated TreeMap after polling: " + map);
    }
}
