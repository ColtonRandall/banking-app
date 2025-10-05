package com.bankingapp.backend.service;

import com.bankingapp.backend.model.User;
import com.bankingapp.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User createUser(User bankUser) {
        return userRepository.save(bankUser);
    }

    public String deleteUser(Long id) {
        try {
            if (!userRepository.existsById(id)) {
                return "User with ID " + id + " does not exist.";
            }
            userRepository.deleteById(id);
            return "User with ID " + id + " deleted successfully.";
        } catch (Exception e) {
            throw new RuntimeException("Could not delete user with ID " + id + ". " + e.getMessage());
        }
    }
}