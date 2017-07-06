
package com.delta.smt.entity.home_page.home_page_ads.gust_like;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Result {

    @SerializedName("list")
    private java.util.List<GustList> mList;

    public java.util.List<GustList> getList() {
        return mList;
    }

    public void setList(java.util.List<GustList> list) {
        mList = list;
    }

}
