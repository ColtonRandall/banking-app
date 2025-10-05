package com.bankingapp.backend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime creationDate;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    private String accountNumber;
    private Double balance;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private BankUser user;

    // Constructors
    public BankAccount() {
    }

    public BankAccount(String accountNumber, Double balance, AccountType accountType, LocalDateTime creationDate, BankUser user) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountType = accountType;
        this.creationDate = creationDate;
        this.user = user;
    }

    public String generateRandomAccountNumber() {
        int number = (int) (Math.random() * 1_000_000_000);
        return String.format("%09d", number);
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public BankUser getUser() {
        return user;
    }

    public void setUser(BankUser user) {
        this.user = user;
    }
}
