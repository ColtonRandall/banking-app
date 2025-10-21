package com.bankingapp.backend.controller;

import com.bankingapp.backend.model.AccountType;
import com.bankingapp.backend.model.BankAccount;
import com.bankingapp.backend.model.User;
import com.bankingapp.backend.service.BankAccountService;
import com.bankingapp.backend.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class BankAccountController {

    private final BankAccountService bankAccountService;
    private final UserService bankUserService;

    public BankAccountController(BankAccountService bankAccountService, UserService bankUserService) {
        this.bankUserService = bankUserService;
        this.bankAccountService = bankAccountService;
    }

    @GetMapping
    public List<BankAccount> getAllAccounts() {
        return bankAccountService.getAllBankAccounts();
    }

    @GetMapping("/{id}")
    public BankAccount getAccountById(@PathVariable Long id) {
        return bankAccountService.getBankAccountById(id);
    }

    @PostMapping
    public BankAccount createAccount(@Valid @RequestBody BankAccount bankAccount) {

        // Validate user existence
        User user = bankUserService.getUserById(bankAccount.getUser().getId());
        if (user == null) {
            throw new IllegalArgumentException("Bank user does not exist.");
        }
        bankAccount.setUser(user);

        // Set default account type if not provided
        if (bankAccount.getAccountType() == null) {
            bankAccount.setAccountType(AccountType.SAVINGS);
        }

        // Log the received bank account details
        System.out.println("Received account: " + bankAccount.getAccountNumber() + ", Balance: " + bankAccount.getBalance());
        return bankAccountService.createBankAccount(bankAccount);
    }

    @DeleteMapping("/{id}")
    public String deleteAccount(@PathVariable Long id) {
        return bankAccountService.deleteBankAccount(id);
    }
}
