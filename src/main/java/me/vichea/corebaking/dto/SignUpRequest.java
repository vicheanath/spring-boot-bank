package me.vichea.corebaking.dto;

import lombok.Builder;
import lombok.Data;
import me.vichea.corebaking.entity.UserStatus;

import java.util.List;

@Data
@Builder
public class SignUpRequest {
    private String username;
    private String password;
    private UserStatus status;
    private List<String> roles;  // { "ADMIN", "USER" }
}
