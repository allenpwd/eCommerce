package com.loser.ecommerce.base.msg;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public abstract class Message {
    protected int code;
    protected String message;
    protected Map<String, Object> data = new HashMap<String, Object>();

    /**
     * put message into Response
     *
     * @param key   message key
     * @param value message
     * @return
     */
    public Message push(String key, Object value) {
        this.getData().put(key, value);
        return this;
    }

    /**
     * 默认返回data
     *
     * @param value
     * @return
     */
    public Message push(Object value) {
        this.getData().put("data", value);
        return this;
    }

    /**
     * push into data
     * @param map
     * @return
     */
    public Message push(Map<String, Object> map) {
        this.getData().putAll(map);
        return this;
    }
}
