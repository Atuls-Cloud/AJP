package com.ajp.labs.Lab6;
import java.util.HashSet;
public class AppendToHashSet {
    public static void main(String[] args) {
        //Creating new HashSet of String
        HashSet<String> hashSet = new HashSet<>();
        //Adding elements to hashSet
        hashSet.add("Apple");
        hashSet.add("Banana");
        hashSet.add("Guava");
        System.out.println("Initial HashSet: "+hashSet);
        //Element that we have to append
        String elementToAppend = "Mango";
        //Appending the element to the hashSet
        hashSet.add(elementToAppend);
        //Print the hashSet
        System.out.println("Updated HashSet after append operation: "+hashSet);
    }
}
