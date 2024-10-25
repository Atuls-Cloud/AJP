package com.ajp.practice;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Student2{
    int id;
    String name;
    Student2(int id, String name){
        this.id =id;
        this.name=name;
    }
    @Override
    public String toString(){
        return id+"  "+name;
    }
}
class CompareId implements Comparator<Student2>{

    @Override
    public int compare(Student2 o1, Student2 o2) {
        return o1.id- o2.id;
    }
}
class CompareName implements Comparator<Student2>{
    @Override
    public int compare(Student2 o1, Student2 o2) {
        return o1.name.compareTo(o2.name);
//        if(o1.name==o2.name) return 0;
//        else if(o1.name>o2.name) return ;
//        else return -1;
    }
}
public class ComparatorEx {
    public static void main(String[] args) {
        ArrayList<Student2> al = new ArrayList<>();
        al.add(new Student2(11,"Allu"));
        al.add(new Student2(25,"Kallu"));
        al.add(new Student2(12,"Sallu"));
        al.add(new Student2(87,"Raj"));
        al.add(new Student2(19,"Shubham"));
        Collections.sort(al,new CompareName());
        for(int i=0;i<al.size();i++)
            System.out.println(al.get(i));
        System.out.println("________________________");
        Collections.sort(al,new CompareId());
        for(int i=0;i<al.size();i++)
            System.out.println(al.get(i));
//        for(Student2 s: al){
//            System.out.println(s.id+" "+s.name);
//        }
    }
}
