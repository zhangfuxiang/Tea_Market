package com.delta.smt.entity.drinktea;

/**
 * Created by wushufeng on 2017/5/14.
 */

public class UserAddress {

    /**
     * app_code : 22000
     * app_msg :
     * result : {"list":[{"id":21,"uid":12,"name":"赵剑","phone":"15210954985","province":"北京市","city":"市辖区","area":"朝阳区","address":"兖州哦啊实打实","status":0,"is_delete":0,"create_time":"2017-04-16 12:04:27","update_time":"2017-04-16 12:04:27","location_id":110105,"code":"110105"},{"id":20,"uid":12,"name":"赵剑","phone":"15210954985","province":"北京市","city":"市辖区","area":"朝阳区","address":"回龙观啊啊","status":0,"is_delete":0,"create_time":"2017-04-16 12:03:10","update_time":"2017-04-16 12:03:10","location_id":110105,"code":"110105"}]}
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
