package com.delta.smt.entity;

/**
 * Created by Shaoqiang.Zhang on 2017/3/17.
 */

public class NearActivity {

    String imagrUrl;
    String title;
    String count;
    String status;

    public NearActivity(String imagrUrl, String title, String count, String status) {
        this.imagrUrl = imagrUrl;
        this.title = title;
        this.count = count;
        this.status = status;
    }

    public String getImagrUrl() {
        return imagrUrl;
    }

    public void setImagrUrl(String imagrUrl) {
        this.imagrUrl = imagrUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
