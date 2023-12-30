package me.vichea.corebaking.service.impl;

import lombok.AllArgsConstructor;
import me.vichea.corebaking.entity.Permission;
import me.vichea.corebaking.entity.Role;
import me.vichea.corebaking.entity.User;
import me.vichea.corebaking.repository.PermissionRepository;
import me.vichea.corebaking.repository.RoleRepository;
import me.vichea.corebaking.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@AllArgsConstructor
public class IAMServiceImpl implements IAMService{

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;

    @Override
    public User createUser(User userDetails) {
        return userRepository.save(userDetails);
    }

    @Override
    public void assignRole(User user, String roleCode) {
        Role role = roleRepository.findByCode(roleCode);
        Optional.ofNullable(role)
                .ifPresentOrElse(
                        r -> {
                            user.getRoles().add(r);
                            userRepository.save(user);
                        },
                        () -> {
                            throw new RuntimeException("Role not found");
                        }
                );
    }

    @Override
    public void removeRole(User user, String roleCode) {
        Role role = roleRepository.findByCode(roleCode);
        Optional.ofNullable(role)
                .ifPresentOrElse(
                        r -> {
                            user.getRoles().remove(r);
                            userRepository.save(user);
                        },
                        () -> {
                            throw new RuntimeException("Role not found");
                        }
                );
    }

    @Override
    public void assignPermission(String roleCode, String permissionCode) {
        Role role = roleRepository.findByCode(roleCode);
        Permission permission = permissionRepository.findByCode(permissionCode);
        Optional.ofNullable(role)
                .ifPresentOrElse(
                        r -> {
                            r.getPermissions().add(permission);
                            roleRepository.save(r);
                        },
                        () -> {
                            throw new RuntimeException("Role not found");
                        }
                );

    }

    @Override
    public void removePermission(String roleCode, String permissionCode) {
        Role role = roleRepository.findByCode(roleCode);
        Permission permission = permissionRepository.findByCode(permissionCode);
        Optional.ofNullable(role)
                .ifPresentOrElse(
                        r -> {
                            r.getPermissions().remove(permission);
                            roleRepository.save(r);
                        },
                        () -> {
                            throw new RuntimeException("Role not found");
                        }
                );
    }

    @Override
    public boolean authenticateUser(String username, String password) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        return authentication.isAuthenticated();
    }

    @Override
    public boolean authorize(User user, String permissionCode) {
        return user.getRoles().stream().anyMatch(role -> role.getPermissions().stream().anyMatch(permission -> permission.getCode().equals(permissionCode)));
    }
}
