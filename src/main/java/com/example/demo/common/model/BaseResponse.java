package com.example.demo.common.model;

import lombok.Getter;
import lombok.Setter;

import static com.example.demo.common.model.BaseResponseStatus.SUCCESS;

@Getter
@Setter
public class BaseResponse<T> {
    private Boolean success;
    private Integer code;
    private String message;
    private T result;

    public BaseResponse(Boolean success, Integer code, String message, T result) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.result = result;
    }

    public static <T> BaseResponse success(T result) {
        return new BaseResponse(SUCCESS.isSuccess(),
                SUCCESS.getCode(),
                SUCCESS.getMessage(),
                result
        );
    }

    public static <T> BaseResponse fail(BaseResponseStatus status) {
        return new BaseResponse(
                status.isSuccess(),
                status.getCode(),
                status.getMessage(),
                null
        );
    }

    public static <T> BaseResponse fail(BaseResponseStatus status, T result) {
        return new BaseResponse(
                status.isSuccess(),
                status.getCode(),
                status.getMessage(),
                result
        );
    }



}
