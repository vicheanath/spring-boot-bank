package me.vichea.corebaking.service;


import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UserService extends UserDetailsService {

    Optional<User> findById(long id);

    User findByEmail(String email);

    User save(User user);

}
