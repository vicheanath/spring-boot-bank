package me.vichea.corebaking.service.impl;

import me.vichea.corebaking.dto.BankResponse;
import me.vichea.corebaking.dto.UserRequest;

public interface UserService {

    BankResponse createAccount(UserRequest userRequest);

    BankResponse login(UserRequest userRequest);
}
