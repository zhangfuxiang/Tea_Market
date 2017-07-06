
package com.delta.smt.entity.home_page.home_page_ads.tea_circly;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class TeaCircly {

    @SerializedName("app_code")
    private Long mAppCode;
    @SerializedName("app_msg")
    private String mAppMsg;
    @SerializedName("result")
    private Result mResult;

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

    public Result getResult() {
        return mResult;
    }

    public void setResult(Result result) {
        mResult = result;
    }

}
