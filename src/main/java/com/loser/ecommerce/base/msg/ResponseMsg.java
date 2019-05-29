package com.loser.ecommerce.base.msg;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class ResponseMsg {
    /**
     * 状态码 成功:200 内部错误:500
     * 失败：401 没找到资源：404
     */
    @ApiModelProperty("状态码 成功:200，内部错误:500，失败：401")
    private int code;
    /**
     * 返回信息
     */
    @ApiModelProperty("返回信息")
    private String message;
    /**
     * 返回数据
     */
    @ApiModelProperty("返回数据")
    private Map<String, Object> data = new HashMap<String, Object>();

    public ResponseMsg() {
        super();
    }

    public ResponseMsg(int code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public ResponseMsg(int code, String message, Map<String, Object> data) {
        super();
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * Response sunccess message
     *
     * @return
     */
    public static ResponseMsg success() {
        return new ResponseMsg(200, "success");
    }

    /**
     * 自定义成功信息
     *
     * @param message
     * @return
     */
    public static ResponseMsg success(String message) {
        return new ResponseMsg(200, message);
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

    /**
     * Response failed message
     *
     * @return
     */
    public static ResponseMsg failed() {
        return new ResponseMsg(401, "failed");
    }

    /**
     * 自定义错误信息
     *
     * @param message
     * @return
     */
    public static ResponseMsg failed(String message) {
        return new ResponseMsg(401, message);
    }

    /**
     * put message into Response
     *
     * @param key   message key
     * @param value message
     * @return
     */
    public ResponseMsg push(String key, Object value) {
        this.getData().put(key, value);
        return this;
    }

    /**
     * 默认返回data
     *
     * @param value
     * @return
     */
    public ResponseMsg push(Object value) {
        this.getData().put("data", value);
        return this;
    }

    /**
     * push into data
     * @param map
     * @return
     */
    public ResponseMsg push(Map<String, Object> map) {
        this.getData().putAll(map);
        return this;
    }
}
