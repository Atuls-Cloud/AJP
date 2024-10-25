package com.ajp.labs.Lab5;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseListofString {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("C");
        strings.add("Python");
        strings.add("JavaScript");
        strings.add("Java");
        System.out.println("List Before reversal: "+strings);
        Collections.reverse(strings);
        System.out.println("List After reversal: "+strings);
    }
}
