package com.delta.smt.entity;

/**
 * Created by wushufeng on 2017/3/21.
 */

public class UploadCollectionInfoResult {
    private String msg;
    private String code;
    private String result;


    public UploadCollectionInfoResult(String msg, String code, String result) {
        this.msg = msg;
        this.code = code;
        this.result = result;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
