package org.example;

public enum TransactionStatus {
    PENDING,
    VALIDATION_PENDING,
    APPROVED,
    REJECTED
}
//PENDING : la transaction est en attente de validation.
//VALIDATION_PENDING : la transaction est en attente de la validation d'un ou plusieurs validateurs.
//APPROVED : la transaction a été approuvée.
//REJECTED : la transaction a été rejetée.