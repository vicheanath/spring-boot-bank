package me.vichea.corebaking.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.vichea.corebaking.common.IErrorCode;

@Getter
public class ApiException extends RuntimeException{
    private IErrorCode errorCode;

    public ApiException(IErrorCode errorCode){
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ApiException(String message){
        super(message);
    }

    public ApiException(Throwable cause){
        super(cause);
    }

    public ApiException(String message, Throwable cause){
        super(message, cause);
    }
}
