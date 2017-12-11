package com.gimefive.user.web.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 *
 * @author yingjun
 *
 * ajax 请求的返回类型封装JSON结果
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResult<T> implements Serializable {


    private static final long serialVersionUID = -4185151304730685014L;

    private boolean success;

    private T data;

    private String msg;

    public BaseResult(boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    public BaseResult(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "BaseResult [success=" + success + ", data=" + data + ", msg=" + msg + "]";
    }

}
