
package com.delta.smt.entity.home_page.home_page_ads.systemgoods;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class List {

    @SerializedName("allow_other_sale")
    private Long mAllowOtherSale;
    @SerializedName("category_id")
    private Long mCategoryId;
    @SerializedName("create_time")
    private String mCreateTime;
    @SerializedName("id")
    private Long mId;
    @SerializedName("images")
    private java.util.List<Image> mImages;
    @SerializedName("merchant")
    private Merchant mMerchant;
    @SerializedName("merchant_id")
    private Long mMerchantId;
    @SerializedName("param")
    private java.util.List<Param> mParam;
    @SerializedName("parent_id")
    private Long mParentId;
    @SerializedName("price")
    private String mPrice;
    @SerializedName("suggest_price")
    private String mSuggestPrice;
    @SerializedName("supply_merchant")
    private SupplyMerchant mSupplyMerchant;
    @SerializedName("supply_merchant_id")
    private Long mSupplyMerchantId;
    @SerializedName("system_price")
    private String mSystemPrice;
    @SerializedName("title")
    private String mTitle;

    public Long getAllowOtherSale() {
        return mAllowOtherSale;
    }

    public void setAllowOtherSale(Long allowOtherSale) {
        mAllowOtherSale = allowOtherSale;
    }

    public Long getCategoryId() {
        return mCategoryId;
    }

    public void setCategoryId(Long categoryId) {
        mCategoryId = categoryId;
    }

    public String getCreateTime() {
        return mCreateTime;
    }

    public void setCreateTime(String createTime) {
        mCreateTime = createTime;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public java.util.List<Image> getImages() {
        return mImages;
    }

    public void setImages(java.util.List<Image> images) {
        mImages = images;
    }

    public Merchant getMerchant() {
        return mMerchant;
    }

    public void setMerchant(Merchant merchant) {
        mMerchant = merchant;
    }

    public Long getMerchantId() {
        return mMerchantId;
    }

    public void setMerchantId(Long merchantId) {
        mMerchantId = merchantId;
    }

    public java.util.List<Param> getParam() {
        return mParam;
    }

    public void setParam(java.util.List<Param> param) {
        mParam = param;
    }

    public Long getParentId() {
        return mParentId;
    }

    public void setParentId(Long parentId) {
        mParentId = parentId;
    }

    public String getPrice() {
        return mPrice;
    }

    public void setPrice(String price) {
        mPrice = price;
    }

    public String getSuggestPrice() {
        return mSuggestPrice;
    }

    public void setSuggestPrice(String suggestPrice) {
        mSuggestPrice = suggestPrice;
    }

    public SupplyMerchant getSupplyMerchant() {
        return mSupplyMerchant;
    }

    public void setSupplyMerchant(SupplyMerchant supplyMerchant) {
        mSupplyMerchant = supplyMerchant;
    }

    public Long getSupplyMerchantId() {
        return mSupplyMerchantId;
    }

    public void setSupplyMerchantId(Long supplyMerchantId) {
        mSupplyMerchantId = supplyMerchantId;
    }

    public String getSystemPrice() {
        return mSystemPrice;
    }

    public void setSystemPrice(String systemPrice) {
        mSystemPrice = systemPrice;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

}
