package com.cgutech.roadcloud.common;

/**
 * Created by Becan on 2017/6/6.
 */
public class Result {
    private String message="success"; //default success
    private int code = 300;  //success code=300

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
