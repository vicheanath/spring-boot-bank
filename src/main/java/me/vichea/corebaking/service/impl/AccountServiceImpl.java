package me.vichea.corebaking.service.impl;

import lombok.AllArgsConstructor;
import me.vichea.corebaking.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
@AllArgsConstructor
public class AccountServiceImpl {

    @Autowired
    private final AccountRepository accountRepository;



}
