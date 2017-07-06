package com.delta.smt.entity;

import java.util.List;

/**
 * Created by wushufeng on 2017/3/18.
 */

public class ProductDetailItem {

    private String msg;
    private String code;
    private ResultBean result;

    public ProductDetailItem(String msg, String code, ResultBean result) {
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

        private String product_name;
        private String system_price;
        private String source;
        private String sale_amount;
        private List<String> picture_urls;


        public ResultBean(String product_name, String system_price, String source, String sale_amount, List<String> picture_urls) {
            this.product_name = product_name;
            this.system_price = system_price;
            this.source = source;
            this.sale_amount = sale_amount;
            this.picture_urls = picture_urls;
        }

        public String getProduct_name() {
            return product_name;
        }

        public void setProduct_name(String product_name) {
            this.product_name = product_name;
        }

        public String getSystem_price() {
            return system_price;
        }

        public void setSystem_price(String system_price) {
            this.system_price = system_price;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getSale_amount() {
            return sale_amount;
        }

        public void setSale_amount(String sale_amount) {
            this.sale_amount = sale_amount;
        }

        public List<String> getPicture_urls() {
            return picture_urls;
        }

        public void setPicture_urls(List<String> picture_urls) {
            this.picture_urls = picture_urls;
        }
    }

}
