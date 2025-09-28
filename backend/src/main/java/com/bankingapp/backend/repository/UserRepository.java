package com.bankingapp.backend.repository;

import com.bankingapp.backend.model.BankUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<BankUser, Long> {
}
