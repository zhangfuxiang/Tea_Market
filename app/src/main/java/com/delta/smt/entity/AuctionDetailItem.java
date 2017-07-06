package com.delta.smt.entity;

import java.util.List;

/**
 * Created by wushufeng on 2017/3/18.
 */

public class AuctionDetailItem {

    private String msg;
    private String code;
    private ResultBean result;

    public AuctionDetailItem(String msg, String code, ResultBean result) {
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

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * picture_urls : ["baidu","google","hehe","haha"]
         * tea_name : 222
         * now_price : 222
         * show_price_times : 222
         */

        private String tea_name;
        private String now_price;
        private String show_price_times;
        private List<String> picture_urls;

        public ResultBean(String tea_name, String now_price, String show_price_times, List<String> picture_urls) {
            this.tea_name = tea_name;
            this.now_price = now_price;
            this.show_price_times = show_price_times;
            this.picture_urls = picture_urls;
        }

        public String getTea_name() {
            return tea_name;
        }

        public void setTea_name(String tea_name) {
            this.tea_name = tea_name;
        }

        public String getNow_price() {
            return now_price;
        }

        public void setNow_price(String now_price) {
            this.now_price = now_price;
        }

        public String getShow_price_times() {
            return show_price_times;
        }

        public void setShow_price_times(String show_price_times) {
            this.show_price_times = show_price_times;
        }

        public List<String> getPicture_urls() {
            return picture_urls;
        }

        public void setPicture_urls(List<String> picture_urls) {
            this.picture_urls = picture_urls;
        }
    }

}
