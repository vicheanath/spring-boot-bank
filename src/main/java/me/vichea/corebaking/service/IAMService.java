package me.vichea.corebaking.service;

import me.vichea.corebaking.entity.User;

public interface IAMService {
    User createUser(User userDetails);
    void assignRole(User user, String role);
    void removeRole(User user, String role);
    void assignPermission(String role, String permission);
    void removePermission(String role, String permission);
    boolean authenticateUser(String username, String password);
    boolean authorize(User user, String permission);

}
