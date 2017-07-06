package com.delta.smt.entity.home_page.activity;

/**
 * Created by Shufeng.Wu on 2017/6/2.
 */

public class ActivityCategory {

    /**
     * app_code : 22000
     * app_msg :
     * result : {"list":[{"id":9,"parent_id":0,"name":"茶旅","type":"act","sort":0},{"id":10,"parent_id":0,"name":"培训","type":"act","sort":0},{"id":11,"parent_id":0,"name":"品茶","type":"act","sort":0},{"id":12,"parent_id":0,"name":"雅集","type":"act","sort":0}]}
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
