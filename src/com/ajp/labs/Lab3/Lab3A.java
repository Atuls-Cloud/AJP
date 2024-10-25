package com.ajp.labs.Lab3;
class Animal{
    public void makeSound(){
        System.out.println("The animal makes a sound");
    }
}
class Cat extends Animal{
    @Override
    public void makeSound() {
        System.out.println("The Cat meows");
    }
}
class Dog extends Animal{
    @Override
    public void makeSound() {
        System.out.println("The dog barks");
    }
}
public class Lab3A {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Cat cat = new Cat();
        Dog dog = new Dog();
        animal.makeSound();
        cat.makeSound();
        dog.makeSound();
    }
}
