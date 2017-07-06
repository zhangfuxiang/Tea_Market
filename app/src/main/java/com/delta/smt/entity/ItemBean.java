package com.delta.smt.entity;

import java.util.Objects;

/**
 * Created by Fuxiang.Zhang on 2017/5/11.
 */

public class ItemBean {

    /**
     * app_code : 22000
     * app_msg :
     * result : true
     */

    private int app_code;
    private String app_msg;
    private boolean result;

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

    public boolean getResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
