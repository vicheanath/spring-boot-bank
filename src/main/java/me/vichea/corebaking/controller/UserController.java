package me.vichea.corebaking.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import me.vichea.corebaking.common.CommonResult;
import me.vichea.corebaking.dto.SignUpRequest;
import me.vichea.corebaking.dto.SignUpResponse;
import me.vichea.corebaking.entity.User;
import me.vichea.corebaking.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
@SecurityRequirement(name = "Bearer Authentication")
public class UserController {

        private final UserService userService;

        @GetMapping
        public List<User> list() {
            return userService.findAll();
        }
        @PostMapping("/signup")
        public CommonResult<SignUpResponse> create(@RequestBody SignUpRequest userSignUpRequest) {
            ModelMapper modelMapper = new ModelMapper();
            User user = modelMapper.map(userSignUpRequest, User.class);
            SignUpResponse signUpResponse = modelMapper.map(userService.signUp(user), SignUpResponse.class);
            return new CommonResult<>(HttpStatus.OK.value(), "User created successfully", signUpResponse);

        }

        @GetMapping("/{id}")
        public User get(@PathVariable("id") long id) {
            return userService.findById(id).get();
        }



}
