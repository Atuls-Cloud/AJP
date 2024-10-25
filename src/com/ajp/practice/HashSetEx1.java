package com.ajp.practice;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class HashSetEx1 {
    public static void main(String[] args) {
        TreeSet<String> hs = new TreeSet<>();//LinkedHashSet,HashSet
        hs.add("B"); hs.add("A"); hs.add("D"); hs.add("E");  hs.add("C"); hs.add("P"); hs.add("Q"); hs.add("R");

        TreeSet<String> hs2 = new TreeSet<>();
        hs2.add("X"); hs2.add("Y"); hs2.add("Z"); hs2.add("U"); hs2.add("V"); hs2.add("A"); hs2.add("B"); hs2.add("C");

//        hs.addAll(hs2);
//        System.out.println("Union of hs and hs2 is: "+hs);

//        hs.retainAll(hs2);
//        System.out.println("Intersection of hs and hs2 is: "+hs);

        hs.removeAll(hs2);
        System.out.println("Intersection of hs and hs2 is: "+hs);
    }
}
