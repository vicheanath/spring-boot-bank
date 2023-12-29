package me.vichea.corebaking.service;

import lombok.AllArgsConstructor;
import me.vichea.corebaking.entity.Role;
import me.vichea.corebaking.entity.User;
import org.springframework.stereotype.Service;

/**
 * IAMService
 * class IAMService {
 *     <<Service>>
 *     +createUser(userDetails: UserDetails): User
 *     +assignRole(user: User, role: Role): void
 *     +removeRole(user: User, role: Role): void
 *     +assignPermission(role: Role, permission: Permission): void
 *     +removePermission(role: Role, permission: Permission): void
 *     +authenticateUser(username: String, password: String): boolean
 *     +authorize(user: User, permission: String): boolean
 *   }
 */
@Service
@AllArgsConstructor
public class IAMService {



    User createUser(User userDetails) {
        return null;
    }

    void assignRole(User user, Role role) {

    }

    void removeRole(User user, Role role) {

    }

    void assignPermission(Role role, String permission) {

    }

    void removePermission(Role role, String permission) {

    }

    boolean authenticateUser(String username, String password) {
        return false;
    }

    boolean authorize(User user, String permission) {
        return false;
    }





}
