
package com.delta.smt.entity;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class PushableActivityResult {

    @SerializedName("list")
    private java.util.List<PushableActivityList> mList;
    @SerializedName("page")
    private Long mPage;
    @SerializedName("size")
    private Long mSize;
    @SerializedName("total")
    private Long mTotal;

    public java.util.List<PushableActivityList> getList() {
        return mList;
    }

    public void setList(java.util.List<PushableActivityList> list) {
        mList = list;
    }

    public Long getPage() {
        return mPage;
    }

    public void setPage(Long page) {
        mPage = page;
    }

    public Long getSize() {
        return mSize;
    }

    public void setSize(Long size) {
        mSize = size;
    }

    public Long getTotal() {
        return mTotal;
    }

    public void setTotal(Long total) {
        mTotal = total;
    }

}
