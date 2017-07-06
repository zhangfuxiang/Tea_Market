package com.delta.smt.entity;

import java.util.List;

/**
 * Created by Shufeng.Wu on 2017/3/20.
 */

public class AuctionDetailRecordItem {

    private String msg;
    private String code;

    private List<AuctionDetailRecordItem.ResultBean> result;

    public AuctionDetailRecordItem(String msg, String code, List<AuctionDetailRecordItem.ResultBean> result) {
        this.msg = msg;
        this.code = code;
        this.result = result;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<AuctionDetailRecordItem.ResultBean> getResult() {
        return result;
    }

    public void setResult(List<AuctionDetailRecordItem.ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        private String head_image;
        private String person_name;
        private String price;
        private String price_time;

        public ResultBean(String head_image, String person_name, String price, String price_time) {
            this.head_image = head_image;
            this.person_name = person_name;
            this.price = price;
            this.price_time = price_time;
        }

        public String getHead_image() {
            return head_image;
        }

        public void setHead_image(String head_image) {
            this.head_image = head_image;
        }

        public String getPerson_name() {
            return person_name;
        }

        public void setPerson_name(String person_name) {
            this.person_name = person_name;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getPrice_time() {
            return price_time;
        }

        public void setPrice_time(String price_time) {
            this.price_time = price_time;
        }
    }

}
