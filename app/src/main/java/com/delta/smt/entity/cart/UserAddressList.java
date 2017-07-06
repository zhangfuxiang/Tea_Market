package com.delta.smt.entity.cart;

/**
 * Created by wushufeng on 2017/5/15.
 */

public class UserAddressList {

    /**
     * app_code : 22000
     * app_msg :
     * result : {"list":[{"id":96,"uid":24,"name":"w","phone":"15210940588","province":"北京市","city":"市辖区","area":"石景山区","address":"sdhdhj","status":0,"is_delete":0,"create_time":"2017-05-15 08:01:59","update_time":"2017-05-15 18:58:43","location_id":110107,"code":"110107"}]}
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
