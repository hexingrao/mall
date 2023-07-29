package com.example.result;

import lombok.Data;

/**
 * @auther 何兴绕
 * @Date 2023年07月29日 14:25
 */
@Data
public class Result {

    private static final int SUCCESS_CODE = 200;

    private static final int ERROR_CODE = -1;

    private int code;

    private Object data;

    private String msg;

    public static Result success() {
        Result result = new Result();
        result.setCode(SUCCESS_CODE);
        return result;
    }

    public static Result success(Object data) {
        Result result = new Result();
        result.setCode(SUCCESS_CODE);
        result.setData(data);
        return result;
    }

    public static Result error(String msg) {
        Result result = new Result();
        result.setCode(ERROR_CODE);
        result.setMsg(msg);
        return result;
    }
}
