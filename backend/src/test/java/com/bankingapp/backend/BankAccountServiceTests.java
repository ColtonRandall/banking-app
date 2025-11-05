package com.bankingapp.backend;

import com.bankingapp.backend.model.BankAccount;;
import com.bankingapp.backend.repository.BankAccountRepository;
import com.bankingapp.backend.service.BankAccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BankAccountServiceTests {

    @Mock
    private BankAccountRepository bankAccountRepository;

    @InjectMocks
    private BankAccountService bankAccountService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getBankAccountById_shouldReturnBankAccount_whenExists() {
        // Arrange
        Long id = 1L;
        BankAccount account = new BankAccount();
        account.setId(id);
        account.setAccountNumber("123456789");

        when(bankAccountRepository.findById(id)).thenReturn(Optional.of(account));

        // Act
        BankAccount result = bankAccountService.getBankAccountById(id);

        // Assert
        assertNotNull(result);
        assertEquals(id, result.getId());
        assertEquals("123456789", result.getAccountNumber());
        verify(bankAccountRepository, times(1)).findById(id);
    }

    @Test
    void getBankAccountById_shouldReturnNull_whenNotExists() {
        // Arrange
        Long id = 99L;
        when(bankAccountRepository.findById(id)).thenReturn(Optional.empty());

        // Act
        BankAccount result = bankAccountService.getBankAccountById(id);

        // Assert
        assertNull(result);
        verify(bankAccountRepository, times(1)).findById(id);
    }
}