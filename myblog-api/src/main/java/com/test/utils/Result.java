package com.test.utils;

import lombok.Data;

/**
 * @author numsi
 * @date 2020/4/27 19:38
 */
@Data
public class Result {
    private int code;
    private String message;
    private Object result;

    Result(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.result = data;
    }
}
