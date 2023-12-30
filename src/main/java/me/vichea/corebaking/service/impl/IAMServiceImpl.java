package me.vichea.corebaking.service.impl;

import lombok.AllArgsConstructor;
import me.vichea.corebaking.entity.Permission;
import me.vichea.corebaking.entity.Role;
import me.vichea.corebaking.entity.User;
import me.vichea.corebaking.repository.RoleRepository;
import me.vichea.corebaking.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class IAMServiceImpl implements IAMService{

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final RoleRepository roleRepository;

    @Override
    public User createUser(User userDetails) {
        return userRepository.save(userDetails);
    }

    @Override
    public void assignRole(User user, String roleCode) {
        Role role = roleRepository.findByCode(roleCode);
        if (role != null) {
            user.getRoles().add(role);
            userRepository.save(user);
        } else {
            throw new RuntimeException("Role not found");
        }
    }

    @Override
    public void removeRole(User user, String roleCode) {
        Role role = roleRepository.findByCode(roleCode);
        if (role != null) {
            user.getRoles().remove(role);
            userRepository.save(user);
        } else {
            throw new RuntimeException("Role not found");
        }
    }

    @Override
    public void assignPermission(String roleCode, String permissionCode) {
        Role role = roleRepository.findByCode(roleCode);
        Permission permission = role.getPermissions().stream().filter(p -> p.getCode().equals(permissionCode)).findFirst().orElse(null);
        if (role != null) {
            role.getPermissions().add(permission);
            roleRepository.save(role);
        } else {
            throw new RuntimeException("Role not found");
        }
    }

    @Override
    public void removePermission(String role, String permission) {

    }

    @Override
    public boolean authenticateUser(String username, String password) {
       return false;
    }

    @Override
    public boolean authorize(User user, String permission) {
        return false;
    }
}
