package me.vichea.corebaking.service.impl;

import me.vichea.corebaking.dto.BankResponse;
import me.vichea.corebaking.dto.UserRequest;
import me.vichea.corebaking.entity.User;

import java.util.List;

public interface UserService {

    BankResponse createAccount(UserRequest userRequest);

    BankResponse login(UserRequest userRequest);

    List<User> getAllUsers();
}
