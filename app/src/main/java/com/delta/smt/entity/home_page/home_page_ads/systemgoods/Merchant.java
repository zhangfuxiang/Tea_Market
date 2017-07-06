
package com.delta.smt.entity.home_page.home_page_ads.systemgoods;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Merchant {

    @SerializedName("id")
    private Long mId;
    @SerializedName("shop_address")
    private String mShopAddress;
    @SerializedName("shop_title")
    private String mShopTitle;

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public String getShopAddress() {
        return mShopAddress;
    }

    public void setShopAddress(String shopAddress) {
        mShopAddress = shopAddress;
    }

    public String getShopTitle() {
        return mShopTitle;
    }

    public void setShopTitle(String shopTitle) {
        mShopTitle = shopTitle;
    }

}
