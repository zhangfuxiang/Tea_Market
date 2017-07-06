package com.delta.smt.entity;

/**
 * Created by wushufeng on 2017/3/16.
 */

public class RegisterResult {


    /**
     * app_code : 22001
     * app_msg : 店铺名不得为空
     * result : false
     */

    private String app_code;
    private String app_msg;
    private boolean result;

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

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
