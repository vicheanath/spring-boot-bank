package me.vichea.corebaking.service;

import lombok.AllArgsConstructor;
import me.vichea.corebaking.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
@AllArgsConstructor
public class AccountService {

    @Autowired
    private final AccountRepository accountRepository;

    boolean deposit(String accountNumber, double amount) {

    }

    boolean withdraw(String accountNumber, double amount) {
        return false;
    }

    boolean transfer(String fromAccountNumber, String toAccountNumber, double amount) {
        return false;
    }

    double getBalance(String accountNumber) {
        return 0;
    }

}
