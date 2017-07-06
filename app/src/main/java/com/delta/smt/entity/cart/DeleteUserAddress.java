package com.delta.smt.entity.cart;

/**
 * Created by Shufeng.Wu on 2017/5/11.
 */

public class DeleteUserAddress {

    /**
     * app_code : 22000
     * app_msg :
     * result : true
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
