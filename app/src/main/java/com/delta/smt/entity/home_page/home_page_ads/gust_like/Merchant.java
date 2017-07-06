
package com.delta.smt.entity.home_page.home_page_ads.gust_like;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Merchant {

    @SerializedName("id")
    private Long mId;
    @SerializedName("shop_address")
    private Object mShopAddress;
    @SerializedName("shop_title")
    private String mShopTitle;

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public Object getShopAddress() {
        return mShopAddress;
    }

    public void setShopAddress(Object shopAddress) {
        mShopAddress = shopAddress;
    }

    public String getShopTitle() {
        return mShopTitle;
    }

    public void setShopTitle(String shopTitle) {
        mShopTitle = shopTitle;
    }

}
