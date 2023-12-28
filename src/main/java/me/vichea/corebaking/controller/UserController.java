package me.vichea.corebaking.controller;

import me.vichea.corebaking.dto.BankResponse;
import me.vichea.corebaking.dto.UserRequest;
import me.vichea.corebaking.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;
    @PostMapping
    public BankResponse createAccount(@RequestBody UserRequest userRequest){
        return userService.createAccount(userRequest);
    }
}
