package me.vichea.corebaking.repository;

import me.vichea.corebaking.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
}
