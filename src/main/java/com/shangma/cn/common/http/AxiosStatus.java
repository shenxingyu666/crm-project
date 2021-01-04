package com.shangma.cn.common.http;

/**
 * 开发者：辉哥
 * 特点： 辉哥很帅
 * 开发时间：2021/1/1 12:18
 * 文件说明：
 */

public enum AxiosStatus {

    OK(20000,"操作成功"),
    ERROE(50000,"操作失败")
    ;

    AxiosStatus(int status, String message) {
        this.status = status;
        this.message = message;
    }

    private  int status;

    private String message;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
