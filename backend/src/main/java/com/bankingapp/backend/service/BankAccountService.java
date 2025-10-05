package com.bankingapp.backend.service;

import com.bankingapp.backend.model.BankAccount;
import com.bankingapp.backend.repository.BankAccountRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BankAccountService {

    private final BankAccountRepository bankAccountRepository;

    public BankAccountService(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    public List<BankAccount> getAllBankAccounts() {
        return bankAccountRepository.findAll();
    }

    public BankAccount getBankAccountById(Long id) {
        return bankAccountRepository.findById(id).orElse(null);
    }

    public BankAccount createBankAccount(BankAccount bankAccount) {
        if(bankAccount.getBalance() < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative.");
        }
        if(bankAccount.getUser() == null) {
            throw new IllegalArgumentException("Bank user does not exist.");
        }

        // if invalid account type is provided, throw an error
        if(bankAccount.getAccountType() == null) {
            throw new IllegalArgumentException("Invalid account type.");
        }

        bankAccount.setAccountNumber(bankAccount.generateRandomAccountNumber());
        bankAccount.setCreationDate(LocalDateTime.now());
        return bankAccountRepository.save(bankAccount);
    }

    public String deleteBankAccount(Long id) {
        return bankAccountRepository.findById(id).map(account -> {;
            bankAccountRepository.deleteById(id);
            return "Bank account with ID " + id + " deleted successfully.";
        }).orElse("Bank account does not exist.");
    }
}
