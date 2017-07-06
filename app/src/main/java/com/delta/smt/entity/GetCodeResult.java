package com.delta.smt.entity;

/**
 * Created by wushufeng on 2017/3/16.
 */

public class GetCodeResult {

    private boolean status;

    private String message;

    public GetCodeResult(boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
