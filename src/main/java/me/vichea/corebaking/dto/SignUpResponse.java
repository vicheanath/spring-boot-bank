package me.vichea.corebaking.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignUpResponse {
    private Long userId;
    private String username;
    private String status;
    private String message;
}
