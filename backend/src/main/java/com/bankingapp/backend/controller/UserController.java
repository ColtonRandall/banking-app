package com.bankingapp.backend.controller;

import com.bankingapp.backend.model.BankUser;
import com.bankingapp.backend.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public BankUser createUser(@RequestBody BankUser bankUser) {
        return userRepository.save(bankUser);
    }

    @GetMapping
    public List<BankUser> getAllUsers() {
        return userRepository.findAll();
    }
}
