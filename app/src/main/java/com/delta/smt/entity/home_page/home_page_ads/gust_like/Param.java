
package com.delta.smt.entity.home_page.home_page_ads.gust_like;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Param {

    @SerializedName("id")
    private Long mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("order_no")
    private Long mOrderNo;
    @SerializedName("product_id")
    private Long mProductId;
    @SerializedName("status")
    private Long mStatus;
    @SerializedName("value")
    private String mValue;

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
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

    public String getValue() {
        return mValue;
    }

    public void setValue(String value) {
        mValue = value;
    }

}
