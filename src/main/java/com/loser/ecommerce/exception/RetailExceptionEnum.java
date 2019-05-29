package com.loser.ecommerce.exception;

/**
 * 异常枚举
 */
public enum RetailExceptionEnum implements ServiceExceptionEnum {

    /**
     * 90XX
     * Token
     */
    TOKEN_EXPIRED(400, "9001:许可文件过期"),
    TOKEN_ERROR(400, "9002:许可文件错误"),
    TOKEN_MISSING(400, "9003:未提供许可文件"),

    /**
     * 10XX
     * 用户
     */
    USER_EXISTED(400, "1001:用户已存在"),
    USER_NOT_EXIST(400, "1002:用户不存在"),
    USER_PASSWORD_ERROR(400, "1003:用户名或密码错误"),
    USER_NOT_FOUND(400, "1004:用户不存在或已被删除"),
    USER_EXPIRED(400, "1005:用户已被停用"),
    USER_DELETEED(400, "1006:用户已被删除"),
    USER_FORBIDDEN(400, "1007:用户已被删除"),
    USER_IMFORMATION_NOT_MATCH(400, "1008:用户信息不匹配"),
    USER_ROLE_PERMISSION_NOT_ALLOW(400, "1009:用户角色权限不足"),


    /**
     * 00XX
     * 其他
     */
    INVLIDE_DATE_STRING(400, "0001:输入日期格式不对"),

    /**
     * 80XX
     * 文件上传
     */
    FILE_READING_ERROR(400, "8001:FILE_READING_ERROR!"),
    FILE_NOT_FOUND(400, "8002:FILE_NOT_FOUND!"),

    /**
     * 错误的请求
     */
    REQUEST_NULL(500, "请求有错误"),
    SERVER_ERROR(500, "服务器异常");

    RetailExceptionEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private Integer code;

    private String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
