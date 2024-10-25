package com.ajp.practice;

import java.util.ArrayList;
import java.util.Collections;

public class CollectionsEx {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(50);
        list.add(20);
        list.add(7);
        list.add(35);
//        Collections.swap(list,0,4);
//        Collections.reverse(list);
        Collections.sort(list);
        System.out.println(list);
    }
}
