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

    @GetMapping("/{id}")
    public BankUser getUserById(@PathVariable Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return "User with ID " + id + " deleted successfully.";
        }
        else {
            return "User does not exist.";
        }
    }
}
