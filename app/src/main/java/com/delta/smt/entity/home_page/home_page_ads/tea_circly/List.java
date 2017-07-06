
package com.delta.smt.entity.home_page.home_page_ads.tea_circly;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class List {

    @SerializedName("appid")
    private Long mAppid;
    @SerializedName("comment_num")
    private Long mCommentNum;
    @SerializedName("content")
    private String mContent;
    @SerializedName("create_time")
    private String mCreateTime;
    @SerializedName("from_merchant_id")
    private Long mFromMerchantId;
    @SerializedName("id")
    private Long mId;
    @SerializedName("is_delete")
    private Long mIsDelete;
    @SerializedName("isc")
    private Long mIsc;
    @SerializedName("scheme")
    private String mScheme;
    @SerializedName("status")
    private Long mStatus;
    @SerializedName("summary")
    private String mSummary;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("uid")
    private Long mUid;
    @SerializedName("update_time")
    private String mUpdateTime;
    @SerializedName("user")
    private User mUser;

    public Long getAppid() {
        return mAppid;
    }

    public void setAppid(Long appid) {
        mAppid = appid;
    }

    public Long getCommentNum() {
        return mCommentNum;
    }

    public void setCommentNum(Long commentNum) {
        mCommentNum = commentNum;
    }

    public String getContent() {
        return mContent;
    }

    public void setContent(String content) {
        mContent = content;
    }

    public String getCreateTime() {
        return mCreateTime;
    }

    public void setCreateTime(String createTime) {
        mCreateTime = createTime;
    }

    public Long getFromMerchantId() {
        return mFromMerchantId;
    }

    public void setFromMerchantId(Long fromMerchantId) {
        mFromMerchantId = fromMerchantId;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public Long getIsDelete() {
        return mIsDelete;
    }

    public void setIsDelete(Long isDelete) {
        mIsDelete = isDelete;
    }

    public Long getIsc() {
        return mIsc;
    }

    public void setIsc(Long isc) {
        mIsc = isc;
    }

    public String getScheme() {
        return mScheme;
    }

    public void setScheme(String scheme) {
        mScheme = scheme;
    }

    public Long getStatus() {
        return mStatus;
    }

    public void setStatus(Long status) {
        mStatus = status;
    }

    public String getSummary() {
        return mSummary;
    }

    public void setSummary(String summary) {
        mSummary = summary;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Long getUid() {
        return mUid;
    }

    public void setUid(Long uid) {
        mUid = uid;
    }

    public String getUpdateTime() {
        return mUpdateTime;
    }

    public void setUpdateTime(String updateTime) {
        mUpdateTime = updateTime;
    }

    public User getUser() {
        return mUser;
    }

    public void setUser(User user) {
        mUser = user;
    }

}
