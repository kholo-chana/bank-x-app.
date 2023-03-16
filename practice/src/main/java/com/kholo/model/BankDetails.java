package com.kholo.model;

import java.util.Scanner;

public class BankDetails {

    private String accountNumber;
    private String name;
    private String accountType;
    private long balance = 500;

    Scanner sc = new Scanner(System.in);
    //method to open new account
    public void openAccount() {
        System.out.print("Enter Account No: ");
        accountNumber = sc.next();

        System.out.print("Enter Account type: ");
        accountType = sc.next();

        System.out.print("Enter Name: ");
        name = sc.next();

        System.out.print("Enter Balance: ");
        balance = sc.nextLong();
    }
    //method to display account details
    public void showAccount() {
        System.out.println("Name of account holder: " + name);
        System.out.println("Account no.: " + accountNumber);
        System.out.println("Account type: " + accountType);
        System.out.println("Balance: " + balance);
    }
    //method to deposit money
    public void deposit() {

        System.out.println("Enter the amount you want to deposit: ");
        long amt = sc.nextLong();
        double interestRate = 0.005;

        if (accountType == "Savings"){
            balance = balance + amt;
            balance += balance * interestRate;
        }else

            balance = balance + amt;

    }

    //method to withdraw money
    public void withdrawal() {
        long amt;
        System.out.println("Enter the amount you want to withdraw : ");
        amt = sc.nextLong();
        if (balance >= amt) {
            balance = balance - amt;
            System.out.println("Balance after withdrawal: R" + balance);
        } else {
            System.out.println("Your balance is less than " + amt + "\tTransaction failed...!!" );
        }
    }
    //method to search an account number
    public boolean search(String accNo) {
        if (accNo.equals(accNo)) {
            showAccount();
            return (true);
        }
        return (false);
    }
}
