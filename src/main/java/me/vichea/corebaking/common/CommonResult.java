package me.vichea.corebaking.common;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;

    /**
     * Success return result
     * @param data data to return
     * @param <T> data type
     * @return CommonResult
     */
    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    /**
     * Success return result
     * @param data data to return
     * @param message message to return
     * @param <T> data type
     * @return CommonResult
     */
    public static <T> CommonResult<T> success(T data, String message) {
        return new CommonResult<>(ResultCode.SUCCESS.getCode(), message, data);
    }

    /**
     * Failed return result
     * @param errorCode error code
     * @param <T> data type
     * @return  CommonResult
     */
    public static <T> CommonResult<T> failed(IErrorCode errorCode) {
        return new CommonResult<>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    /**
     * Failed return result
     * @param errorCode error code
     * @param message    message to return
     * @param <T> data type
     * @return CommonResult
     */
    public static <T> CommonResult<T> failed(IErrorCode errorCode, String message) {
        return new CommonResult<>(errorCode.getCode(), message, null);
    }

    /**
     * Failed return result
     * @param message message to return
     * @param <T> data type
     * @return CommonResult
     */
    public static <T> CommonResult<T> failed(String message) {
        return new CommonResult<>(ResultCode.FAILED.getCode(), message, null);
    }

    /**
     * Failed return result
     * @param <T> data type
     * @return CommonResult
     */
    public static <T> CommonResult<T> failed() {
        return failed(ResultCode.FAILED);
    }

    /**
     * Validate failed return result
     * @param <T> data type
     * @return CommonResult
     */
    public static <T> CommonResult<T> validateFailed() {
        return failed(ResultCode.VALIDATE_FAILED);
    }

    /**
     * Validate failed return result
     * @param message message to return
     * @param <T> data type
     * @return CommonResult
     */
    public static <T> CommonResult<T> validateFailed(String message) {
        return new CommonResult<>(ResultCode.VALIDATE_FAILED.getCode(), message, null);
    }

    /**
     * Unauthorized return result
     * @param data data to return
     * @param <T> data type
     * @return CommonResult
     */
    public static <T> CommonResult<T> unauthorized(T data) {
        return new CommonResult<>(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMessage(), data);
    }

    /**
     * Forbidden return result
     * @param data data to return
     * @param <T> data type
     * @return CommonResult
     */
    public static <T> CommonResult<T> forbidden(T data) {
        return new CommonResult<>(ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getMessage(), data);
    }
}
