package com.ajp.labs.Lab1;

import java.util.Scanner;

public class Bank {
    double amount;
    Bank(double amount){
        this.amount = amount;
    }
    void withdraw(double withdrawalAmount){
        if(withdrawalAmount<=amount){
            amount -= withdrawalAmount;
            System.out.println("Withdraw Successful");
        }
        else System.out.println("Insufficient Balance");
    }
    void deposit(double depositAmount){
        amount += depositAmount;
        System.out.println(depositAmount+" deposited successfully");
    }
    void show(){
        System.out.println("Total Account Balance: "+amount);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank user = new Bank(10000);
        System.out.println("Enter amount to withdraw: ");
        double amt = sc.nextInt();
        user.withdraw(amt);
        user.deposit(5000);
        user.show();
    }
}
