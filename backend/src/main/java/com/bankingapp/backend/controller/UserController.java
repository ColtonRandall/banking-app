package com.bankingapp.backend.controller;

import com.bankingapp.backend.model.BankUser;
import com.bankingapp.backend.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public BankUser createUser(@RequestBody BankUser bankUser) {
        return userService.createUser(bankUser);
    }

    @GetMapping
    public List<BankUser> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public BankUser getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }
}
