package com.delta.smt.entity.cart;

import java.util.List;

/**
 * Created by wushufeng on 2017/3/27.
 */

public class ComfirmOrderListItem {
    private String msg;
    private String code;
    private List<Result> result;

    public ComfirmOrderListItem(String msg, String code, List<Result> result) {
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

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }

    public static class Result {
        private String name;
        private String price;
        private String amount;
        private String url;

        public Result(String name, String price, String amount, String url) {
            this.name = name;
            this.price = price;
            this.amount = amount;
            this.url = url;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

}
