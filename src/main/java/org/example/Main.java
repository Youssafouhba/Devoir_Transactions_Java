package org.example;

import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException {
     Customer customer1 = new Customer("Youssef ouhba");
     Customer customer2 = new Customer("Mouhammed fahlaoui");
     Employee employee1 = new Employee("Employee1");
     Employee employee2 = new Employee("Employee2");
     Bank bank1 = new Bank("bank1");
     Bank bank2 = new Bank("bank2");
     Account account1 = new Account(customer2,7000000,bank1);
     Account account2 = new Account(customer1,1000000,bank2);
     Transaction transaction1 = new Transaction(account1,account2,4400);
     boolean a = transaction1.approveTransaction();
     int b=5;
     b= (b=10)+b;
     System.out.println(b);
     b+=(b=10);
     System.out.println(b);

    }
}