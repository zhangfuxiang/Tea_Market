package com.delta.smt.entity;

/**
 * Created by shaoqiang.zhang on 2017/4/11.
 */

public class TodoThings {

    private int app_code;

    private String app_msg;

    private Result result;

    public int getApp_code() {
        return this.app_code;
    }

    public void setApp_code(int app_code) {
        this.app_code = app_code;
    }

    public String getApp_msg() {
        return this.app_msg;
    }

    public void setApp_msg(String app_msg) {
        this.app_msg = app_msg;
    }

    public Result getResult() {
        return this.result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public class Result {
        private int order_num;

        private int bespeak_num;

        private int buy_ask_num;

        private int purchase_num;

        private int new_product_num;

        private int activity_num;

        private int message_num;

        private int ad_num;

        private int circle_num;

        private int auction_num;

        private int stock_num;

        public int getOrder_num() {
            return this.order_num;
        }

        public void setOrder_num(int order_num) {
            this.order_num = order_num;
        }

        public int getBespeak_num() {
            return this.bespeak_num;
        }

        public void setBespeak_num(int bespeak_num) {
            this.bespeak_num = bespeak_num;
        }

        public int getBuy_ask_num() {
            return this.buy_ask_num;
        }

        public void setBuy_ask_num(int buy_ask_num) {
            this.buy_ask_num = buy_ask_num;
        }

        public int getPurchase_num() {
            return this.purchase_num;
        }

        public void setPurchase_num(int purchase_num) {
            this.purchase_num = purchase_num;
        }

        public int getNew_product_num() {
            return this.new_product_num;
        }

        public void setNew_product_num(int new_product_num) {
            this.new_product_num = new_product_num;
        }

        public int getActivity_num() {
            return this.activity_num;
        }

        public void setActivity_num(int activity_num) {
            this.activity_num = activity_num;
        }

        public int getMessage_num() {
            return this.message_num;
        }

        public void setMessage_num(int message_num) {
            this.message_num = message_num;
        }

        public int getAd_num() {
            return this.ad_num;
        }

        public void setAd_num(int ad_num) {
            this.ad_num = ad_num;
        }

        public int getCircle_num() {
            return this.circle_num;
        }

        public void setCircle_num(int circle_num) {
            this.circle_num = circle_num;
        }

        public int getAuction_num() {
            return this.auction_num;
        }

        public void setAuction_num(int auction_num) {
            this.auction_num = auction_num;
        }

        public int getStock_num() {
            return this.stock_num;
        }

        public void setStock_num(int stock_num) {
            this.stock_num = stock_num;
        }

    }
}
