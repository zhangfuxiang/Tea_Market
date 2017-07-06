
package com.delta.smt.entity.home_page.home_page_ads.systemgoods;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Image {

    @SerializedName("id")
    private Long mId;
    @SerializedName("image_id")
    private Long mImageId;
    @SerializedName("is_main")
    private Long mIsMain;
    @SerializedName("order_no")
    private Long mOrderNo;
    @SerializedName("product_id")
    private Long mProductId;
    @SerializedName("status")
    private Long mStatus;
    @SerializedName("type")
    private Long mType;
    @SerializedName("url")
    private String mUrl;

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public Long getImageId() {
        return mImageId;
    }

    public void setImageId(Long imageId) {
        mImageId = imageId;
    }

    public Long getIsMain() {
        return mIsMain;
    }

    public void setIsMain(Long isMain) {
        mIsMain = isMain;
    }

    public Long getOrderNo() {
        return mOrderNo;
    }

    public void setOrderNo(Long orderNo) {
        mOrderNo = orderNo;
    }

    public Long getProductId() {
        return mProductId;
    }

    public void setProductId(Long productId) {
        mProductId = productId;
    }

    public Long getStatus() {
        return mStatus;
    }

    public void setStatus(Long status) {
        mStatus = status;
    }

    public Long getType() {
        return mType;
    }

    public void setType(Long type) {
        mType = type;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

}
