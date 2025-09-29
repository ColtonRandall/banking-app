package com.bankingapp.backend.service;

import com.bankingapp.backend.model.BankUser;
import com.bankingapp.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<BankUser> getAllUsers() {
        return userRepository.findAll();
    }

    public BankUser getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public BankUser createUser(BankUser bankUser) {
        return userRepository.save(bankUser);
    }

    public String deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return "User with ID " + id + " deleted successfully.";
        } else {
            return "User does not exist.";
        }
    }
}
