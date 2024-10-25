package com.ajp.labs.Lab6;
import java.util.Stack;
public class StackPushPop {
    public static void main(String[] args) {
        //Creating a new stack of integer
        Stack<Integer> stack = new Stack<>();
        //Pushing 10 elements
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);
        stack.push(70);
        stack.push(80);
        stack.push(90);
        stack.push(100);
        //Display stack
        System.out.println("Stack Elements after push operation: "+stack);
        //Removing 4 elements from stack
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        //Display stack after removal
        System.out.println("Stack Elements after pop operation: "+stack);
    }
}
