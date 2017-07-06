
package com.delta.smt.entity;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class PushableActivity {

    @SerializedName("app_code")
    private Long mAppCode;
    @SerializedName("app_msg")
    private String mAppMsg;
    @SerializedName("result")
    private PushableActivityResult mResult;

    public Long getAppCode() {
        return mAppCode;
    }

    public void setAppCode(Long appCode) {
        mAppCode = appCode;
    }

    public String getAppMsg() {
        return mAppMsg;
    }

    public void setAppMsg(String appMsg) {
        mAppMsg = appMsg;
    }

    public PushableActivityResult getResult() {
        return mResult;
    }

    public void setResult(PushableActivityResult result) {
        mResult = result;
    }

}
