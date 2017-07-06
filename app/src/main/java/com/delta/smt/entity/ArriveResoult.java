package com.delta.smt.entity;

/**
 * Created by shaoqiang.zhang on 2017/4/11.
 */

public class ArriveResoult {
    private int app_code;

    private String app_msg;

    private boolean result;

    public int getApp_code(){
        return this.app_code;
    }

    public void setApp_code(int app_code) {
        this.app_code = app_code;
    }

    public String getApp_msg(){
        return this.app_msg;
    }

    public void setApp_msg(String app_msg) {
        this.app_msg = app_msg;
    }

    public boolean getResult(){
        return this.result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
