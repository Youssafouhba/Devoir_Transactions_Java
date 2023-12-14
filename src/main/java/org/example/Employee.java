package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Employee {

    private String name;
    private int id;
    private List<Transaction> transactions;
    public Employee(String name) {
        this.name = name;
        this.id = new Random().nextInt(11);;
        this.transactions = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public void validate(Transaction transaction) {
        if (!transaction.isFullyApproved()) {
            transaction.addValidator(this);
            if(transaction.isFullyApproved()){
                TransactionStatus s=TransactionStatus.APPROVED;
                transaction.setStatus(s);
            }
        }else {
            System.out.println("The transaction has already the needed number of validations");
        }
    }
    public List<Transaction> getValidatedTransactions() {
        // Créer une liste vide de transactions validées
        List<Transaction> validatedTransactions = new ArrayList<>();

        // Parcourir la liste des transactions
        for (Transaction transaction : this.transactions) {
            validatedTransactions.add(transaction);
        }
        // Retourner la liste
        return validatedTransactions;
    }

    public int getId() {
        return id;
    }
}
