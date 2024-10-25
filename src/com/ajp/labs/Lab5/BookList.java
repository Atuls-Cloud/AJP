package com.ajp.labs.Lab5;

import java.util.ArrayList;

class Book{
    private int bookId;
    private String bookName;
    private String authorName;
    public Book(int bookId, String bookName, String authorName){
        this.authorName=authorName;
        this.bookId=bookId;
        this.bookName=bookName;
    }
    @Override
    public String toString() {
        return bookId+" "+bookName+" by "+authorName;
    }
}
public class BookList {
    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book(101,"Java 8","Jack"));
        books.add(new Book(112,"C Fundamentals","Jille"));
        books.add(new Book(203,"Python","PyGuru"));
        System.out.println("----------All Books are----------");
        for (Book bk:books) {
            System.out.println(bk);
        }
    }
}
