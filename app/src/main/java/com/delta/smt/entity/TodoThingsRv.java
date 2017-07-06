package com.delta.smt.entity;

/**
 * Created by Shaoqiang.Zhang on 2017/3/16.
 */

public class TodoThingsRv {

    String title;
    int imageUrl;

    public TodoThingsRv(String title, int imageUrl) {
        this.title = title;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }
}
