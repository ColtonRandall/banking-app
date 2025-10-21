package com.bankingapp.backend;

import com.bankingapp.backend.model.BankAccount;
import com.bankingapp.backend.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.bankingapp.backend.model.AccountType.BUSINESS;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BankingAppApplicationTests {

    @Test
    void shouldStoreAndReturnBalance() {
        // Arrange
        BankAccount account = new BankAccount();
        account.setBalance(1000.0);

        // Act
        double result = account.getBalance();

        // Assert
        assertEquals(1000.0, result);
    }

    @Test
    void shouldStoreAndReturnAccountTypeAndUser() {
        User user = new User();
        user.setName("Colton");

        BankAccount account = new BankAccount();
        account.setAccountType(BUSINESS);
        account.setUser(user);

        assertEquals(BUSINESS, account.getAccountType());
        assertEquals("Colton", account.getUser().getName());
    }

    @Test
    void shouldStoreAndReturnUserFields() {
        User user = new User();
        user.setId(1L);
        user.setName("Colton Randall");
        user.setEmail("colton@email.com");

        assertEquals(1L, user.getId());
        assertEquals("Colton Randall", user.getName());
        assertEquals("colton@email.com", user.getEmail());
    }


}
