package com.delta.smt.entity;

import java.util.List;

/**
 * Created by wushufeng on 2017/4/20.
 */

public class OrderOtherListItem {
    private String msg;
    private String code;
    private List<ResultBean> result;

    public OrderOtherListItem(String msg, String code, List<ResultBean> result) {
        this.msg = msg;
        this.code = code;
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        private String image_url;
        private String tea_shop_name;
        private boolean this_shop;
        private String address;
        private String distance;
        private String price;

        public ResultBean(String image_url, String tea_shop_name, boolean this_shop, String address, String distance, String price) {
            this.image_url = image_url;
            this.tea_shop_name = tea_shop_name;
            this.this_shop = this_shop;
            this.address = address;
            this.distance = distance;
            this.price = price;
        }

        public String getImage_url() {
            return image_url;
        }

        public void setImage_url(String image_url) {
            this.image_url = image_url;
        }

        public String getTea_shop_name() {
            return tea_shop_name;
        }

        public void setTea_shop_name(String tea_shop_name) {
            this.tea_shop_name = tea_shop_name;
        }

        public boolean isThis_shop() {
            return this_shop;
        }

        public void setThis_shop(boolean this_shop) {
            this.this_shop = this_shop;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }
    }
}
