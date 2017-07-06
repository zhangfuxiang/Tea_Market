package com.delta.smt.entity;

/**
 * Created by wushufeng on 2017/4/5.
 */

public class UserCLoginResult {


    /**
     * app_code : 22000
     * app_msg :
     * result : {"token":{"token":"f8836f071a762f7e2eb6f6cfb903cb0e","expire":1494355791},"user":{"id":48,"name":"u_15210940588","type":0,"sex":1,"phone":"15210940588","image_url":"http://tea.api.test.sygcsoft.com/public/static/images/default_avatar3.png","image_id":null,"merchant_id":1,"balance":"10000.00"}}
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
