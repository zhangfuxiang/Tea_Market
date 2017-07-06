
package com.delta.smt.entity.home_page.home_page_ads.gust_like;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class GustList {

    @SerializedName("category_id")
    private Long mCategoryId;
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
    private String sales;

    public String getSales() {
        return sales;
    }

    public void setSales(String sales) {
        this.sales = sales;
    }

    public Long getCategoryId() {
        return mCategoryId;
    }

    public void setCategoryId(Long categoryId) {
        mCategoryId = categoryId;
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
