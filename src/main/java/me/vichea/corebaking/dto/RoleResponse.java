package me.vichea.corebaking.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoleResponse {
    private Long roleId;
    private String roleName;
    private String code;
    private String description;
}
