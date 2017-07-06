package com.delta.smt.entity.home_page.activity;

/**
 * Created by wushufeng on 2017/6/4.
 */

public class ActivitySignUpResult {

    /**
     * app_code : 22000
     * app_msg :
     * result : 操作成功
     */

    private int app_code;
    private String app_msg;
    private Object result;

    public int getApp_code() {
        return app_code;
    }

    public void setApp_code(int app_code) {
        this.app_code = app_code;
    }

    public String getApp_msg() {
        return app_msg;
    }

    public void setApp_msg(String app_msg) {
        this.app_msg = app_msg;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
