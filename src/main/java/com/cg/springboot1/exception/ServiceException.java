package com.cg.springboot1.exception;

import com.cg.springboot1.constants.ResultCode;

public final class ServiceException extends RuntimeException {

    /**
     * 错误码
     */
    private final Integer code;

    public ServiceException(ResultCode resultCode) {
        // 使用父类的 message 字段
        super(resultCode.message());
        // 设置错误码
        this.code = resultCode.code();
    }

    public Integer getCode() {
        return code;
    }

}