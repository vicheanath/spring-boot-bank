package me.vichea.corebaking.bin;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import me.vichea.corebaking.entity.Permission;
import me.vichea.corebaking.entity.Role;
import me.vichea.corebaking.service.PermissionService;
import me.vichea.corebaking.service.RoleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {
    private final PermissionService permissionService;
    private final RoleService roleService;
    static final String[] ROLES = {"USER", "ADMIN", "SUPER_ADMIN", "MANAGER", "STAFF", "CUSTOMER", "GUEST", "ANONYMOUS","SYSTEM","BOT","API"};
    static final String[] PERMISSIONS = {"READ", "WRITE", "UPDATE", "DELETE"};
    static final String[] MODULES = {"ACCOUNT", "CARD", "CARD_PROVIDER", "CUSTOMER", "LOAN", "LOAN_TYPE", "PAYMENT", "PAYMENT_TYPE", "PRODUCT", "PRODUCT_TYPE", "ROLE", "USER"};
    @Override
    public void run(String... args) throws Exception {
        System.out.println("DataSeeder.run - START");
        System.out.println("Creating permissions...");
        List<String> permissions = new ArrayList<>();
        for (String module : MODULES) {
            for (String permission : PERMISSIONS) {
                permissions.add(module + ":" + permission);
                Permission p = Permission.builder()
                        .name(module.toLowerCase() + " - " + permission.toLowerCase())
                        .code(module.toUpperCase() + ":" + permission.toUpperCase())
                        .description( "This permission is for " + module.toLowerCase() + " module and " + permission.toLowerCase() + " operation.")
                        .build();
                System.out.println("p = " + p.getDescription());
                permissionService.save(p);
            }
        }
        System.out.println("permissions = " + permissions);

        System.out.println("Creating roles...");
        List<String> roles = new ArrayList<>();
        for (String role : ROLES) {
            roles.add(role);
            Role r = Role.builder()
                    .name(role.toLowerCase())
                    .code(role.toUpperCase())
                    .description("This role is for " + role.toLowerCase() + " user.")
                    .build();
            roleService.save(r);
        }
        System.out.println("roles = " + roles);

        //TODO: Assign permissions to roles abc

        System.out.println("DataSeeder.run - END");

    }

}
