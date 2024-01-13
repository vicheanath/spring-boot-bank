package me.vichea.corebaking.controller;

import lombok.RequiredArgsConstructor;

import me.vichea.corebaking.model.reponse.JwtAuthenticationResponse;

import me.vichea.corebaking.model.request.SignUpRequests;
import me.vichea.corebaking.model.request.SigninRequest;
import me.vichea.corebaking.service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    @PostMapping("/signup")
    public ResponseEntity<JwtAuthenticationResponse> signup(@RequestBody SignUpRequests request) {
        System.out.println("password in rwquest:"+request.getPassword());
        return ResponseEntity.ok(authenticationService.signup(request));
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SigninRequest request) {
        return ResponseEntity.ok(authenticationService.signin(request));
    }
}
