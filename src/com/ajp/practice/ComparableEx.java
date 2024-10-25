package com.ajp.practice;
import java.util.ArrayList;
import java.util.Collections;
class Student implements Comparable<Student>{
    int sid;
    String sName;
    Student(int id,String name){
        this.sid = id;
        this.sName = name;
    }
    @Override
    public int compareTo(Student obj) {
        if(this.sid==obj.sid) return 0;
        else if(this.sid>obj.sid) return 1;
        else return -1;
//        return 0;
    }
}
public class ComparableEx {
    public static void main(String[] args) {
        ArrayList<Student> al = new ArrayList<>();
        al.add(new Student(01,"Atul"));
        al.add(new Student(25,"Akash"));
        al.add(new Student(12,"Anuj"));
        al.add(new Student(87,"Raj"));
        al.add(new Student(19,"Shubham"));

        Collections.sort(al);
        for(Student s: al){
            System.out.println(s.sid+" "+s.sName);
        }
    }
}
