package com.delta.smt.entity;

/**
 * Created by wushufeng on 2017/4/25.
 */

public class AddMyShopResult {

    /**
     * app_code : 24002
     * app_msg : 您已经添加过此产品,请不要重复添加
     * result : false
     */

    private String app_code;
    private String app_msg;
    private Object result;

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

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
