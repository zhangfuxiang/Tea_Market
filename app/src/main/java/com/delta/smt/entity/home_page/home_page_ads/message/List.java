
package com.delta.smt.entity.home_page.home_page_ads.message;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class List {

    @SerializedName("create_time")
    private String mCreateTime;
    @SerializedName("link")
    private Object mLink;
    @SerializedName("message")
    private String mMessage;
    @SerializedName("type")
    private Long mType;

    public String getCreateTime() {
        return mCreateTime;
    }

    public void setCreateTime(String createTime) {
        mCreateTime = createTime;
    }

    public Object getLink() {
        return mLink;
    }

    public void setLink(Object link) {
        mLink = link;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

    public Long getType() {
        return mType;
    }

    public void setType(Long type) {
        mType = type;
    }

}
