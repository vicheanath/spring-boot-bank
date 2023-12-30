package me.vichea.corebaking.service;

import me.vichea.corebaking.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("user")


public interface UserService extends UserDetailsService {

    Optional<User> findById(Long id);

    User findByEmail(String email);

    User save(User user);

}

/*
ERROR
{
    "message": "Validation failed for object='user'. Error count: 1",
    "status": 400,
    "error": "Bad Request",
}

Success
{
    "responseMessage": "User created successfully",
    "data": {
        "id": 1,
        "username": "vichea",
        "email": "",
     },
    "status": 201,
    "page": 1,
    "size": 1,
    "totalPages": 1,
 */

