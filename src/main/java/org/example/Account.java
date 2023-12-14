package org.example;

import java.util.Random;

public class Account {
    private final int accountNumber;
    private Customer customer;
    private double balance;
    private Bank bank;

    public Account(Customer customer, double balance, Bank bank) {
        this.accountNumber=new Random().nextInt(11);
        this.customer = customer;
        this.balance = balance;
        this.bank = bank;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
}
