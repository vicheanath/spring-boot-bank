package me.vichea.corebaking.service;

import me.vichea.corebaking.entity.Permission;
import org.springframework.stereotype.Service;

public interface PermissionService {
    Permission save(Permission permission);
}
