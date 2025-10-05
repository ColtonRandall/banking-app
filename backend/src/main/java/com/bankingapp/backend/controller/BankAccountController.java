package com.bankingapp.backend.controller;

import com.bankingapp.backend.model.BankAccount;
import com.bankingapp.backend.service.BankAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class BankAccountController {

    private final BankAccountService bankAccountService;

    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @GetMapping
    public List<BankAccount> getAllAccounts() {
        return bankAccountService.getAllBankAccounts();
    }

    @GetMapping("/{id}")
    public BankAccount getAccountById(@PathVariable Long id) {;
        return bankAccountService.getBankAccountById(id);
    }

    @PostMapping
    public BankAccount createAccount(@RequestBody BankAccount bankAccount) {
        System.out.println("Received account: " + bankAccount.getAccountNumber() + ", Balance: " + bankAccount.getBalance());
        return bankAccountService.createBankAccount(bankAccount);
    }

    @DeleteMapping("/{id}")
    public String deleteAccount(@PathVariable Long id) {
        return bankAccountService.deleteBankAccount(id);
    }
}
