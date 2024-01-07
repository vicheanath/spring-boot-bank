package me.vichea.corebaking.common;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ResultCode implements IErrorCode{
    SUCCESS(200, "Operation is successful."),
    FAILED(500, "Operation is failed."),
    VALIDATE_FAILED(404, "Validation is failed."),
    UNAUTHORIZED(401, "Unauthorized."),
    FORBIDDEN(403, "Forbidden.");

    private final Integer code;
    private final String message;

    @Override
    public Integer getCode(){
        return code;
    }

    @Override
    public String getMessage(){
        return message;
    }
}
