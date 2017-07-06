package com.delta.smt.entity;

/**
 * Created by wushufeng on 2017/4/4.
 */

public class SendCodeResult {

    /**
     * app_code : 22000
     * app_msg :
     * result : 发送成功
     */

    private String app_code;
    private String app_msg;
    private String result;

    public String getApp_code() {
        return app_code;
    }

    public void setApp_code(String app_code) {
        this.app_code = app_code;
    }

    public String getApp_msg() {
        return app_msg;
    }

    public void setApp_msg(String app_msg) {
        this.app_msg = app_msg;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
