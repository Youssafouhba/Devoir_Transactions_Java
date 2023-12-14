package org.example;

import org.json.JSONObject;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Transaction {
    private Account sourceAccount;
    private final int idTransaction;

    String date;
    private Account targetAccount;
    private double amount;
    private List<Employee> validators;

    private TransactionStatus status;

    public Transaction(Account sourceAccount, Account targetAccount, double amount) {

        this.idTransaction=new Random().nextInt(30);
        this.sourceAccount = sourceAccount;
        this.targetAccount = targetAccount;
        this.validators = new ArrayList<>();

        this.status = TransactionStatus.PENDING;
        this.amount = amount;
    }
    public void getValidators() {
       int i = 1;
        // Parcourir la liste des validateurs
        for (Employee validator : this.validators) {
            System.out.println("Validator " + i +" : name is " + validator.getName() + " ValidatorID is " + validator.getId());
            i++;
        }


    }
    public void addValidator(Employee e) {
            validators.add(e);

    }

    public String getType() {
        if (sourceAccount.getBank() == targetAccount.getBank()) {
            return "virRest"; // Virement entre comptes de la même banque
        } else if (sourceAccount.getCustomer() == targetAccount.getCustomer()) {
            return "virInt"; // Virement interne (même client, différentes banques)
        } else {
            return "virCha"; // Virement vers une autre banque (différents clients, différentes banques)
        }
    }
    public TransactionStatus TransactionDecision() {
        if (amount >= 0 && amount <= 100000) {
            Decision decision = new Decision("No validition need");
            System.out.println(decision);
            status = TransactionStatus.APPROVED;
        } else if (amount <= 1000000 && amount > 100000) {
            Decision decision = new Decision("This transaction needs 1 validator");
            System.out.println(decision);
            status = TransactionStatus.VALIDATION_PENDING;
        } else if (amount > 1000000) {
            Decision decision = new Decision("This transaction needs 2 validators");
            System.out.println(decision);
            status = TransactionStatus.VALIDATION_PENDING;
        }
        return status;
    }
    public boolean isFullyApproved() {
        int approvedCount = validators.size();
        if (amount >= 0 && amount <= 100000) {
            status = TransactionStatus.APPROVED;
            return true;
        } else if (amount <= 1000000 && amount > 100000 && approvedCount == 1) {
            status = TransactionStatus.APPROVED;
            return true;
        } else if (amount > 1000000 && approvedCount == 2) {
            return true;
        }else {
            status = TransactionStatus.VALIDATION_PENDING;
            return false;
        }
    }
    public double getAmount(){
        double s = this.amount;
        return s;
    }
    public TransactionStatus getStatus(){
        return status;
    }
    public void setStatus(TransactionStatus s){
        this.status=s;
    }
    private void updateAccounts() {
        // Check if the source account has sufficient balance
        if (sourceAccount.getBalance() >= amount) {
            sourceAccount.setBalance(sourceAccount.getBalance() - amount); // Update the source account balance
            targetAccount.setBalance(targetAccount.getBalance() + amount); // Update the target account balance
        } else {
            // Handle insufficient balance error
            status = TransactionStatus.REJECTED;
            System.out.println("Insufficient balance in the source account.");
        }
    }
    public boolean approveTransaction() {

            if (isFullyApproved()) {
                LocalDateTime now=LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                date = now.format(formatter);
                updateAccounts(); // Update both source and target accounts
                System.out.println("The transaction passed successfully");
                return true;
            }else {
                System.out.println("The transaction needs to be validate");
                return false;
            }
    }
    public static void serializeTransaction(Transaction transaction, File file) throws IOException {
        // Create an ObjectOutputStream to write the transaction object to the file
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));

        // Serialize the transaction object
        out.writeObject(transaction);

        // Close the ObjectOutputStream
        out.close();
    }
    public void serializeToFile(String filePath) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Transaction id", idTransaction);
        jsonObject.put("source Account id", sourceAccount.getAccountNumber());
        jsonObject.put("target Account id", targetAccount.getAccountNumber());
        jsonObject.put("Amount", this.getAmount());
        jsonObject.put("Date", date);
        jsonObject.put("Transaction status", this.getStatus());

        try (FileWriter fileWriter = new FileWriter(filePath, true)) {
            fileWriter.write(jsonObject.toString() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
