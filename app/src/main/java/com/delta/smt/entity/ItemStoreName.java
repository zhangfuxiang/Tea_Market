package com.delta.smt.entity;

/**
 * Created by Fuxiang.Zhang on 2017/4/25.
 */

public class ItemStoreName {
    private String store_name;
    private String address;


    public ItemStoreName() {
    }

    public ItemStoreName(String store_name, String address) {
        this.store_name = store_name;
        this.address = address;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
