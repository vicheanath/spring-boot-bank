package me.vichea.corebaking.service;

import me.vichea.corebaking.model.reponse.JwtAuthenticationResponse;
import me.vichea.corebaking.model.request.SignUpRequests;
import me.vichea.corebaking.model.request.SigninRequest;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequests request);

    JwtAuthenticationResponse signin(SigninRequest request);
}
