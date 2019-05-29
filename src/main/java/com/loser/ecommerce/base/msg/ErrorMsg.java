package com.loser.ecommerce.base.msg;

import java.util.Map;

public class ErrorMsg extends Message {

    public ErrorMsg(int code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public ErrorMsg(int code, String message, Map<String, Object> data) {
        super();
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * Response error message
     *
     * @return
     */
    public static ResponseMsg error() {
        return new ResponseMsg(500, "error");
    }

    /**
     * 自定义错误信息
     *
     * @param message
     * @return
     */
    public static ResponseMsg error(String message) {
        return new ResponseMsg(500, message);
    }
}
