package me.vichea.corebaking.repository;

import me.vichea.corebaking.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Boolean existsByRoleName(String roleName);
    Role findByRoleName(String roleName);
}
