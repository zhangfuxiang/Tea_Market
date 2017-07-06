package com.delta.smt.entity;

import java.util.List;

/**
 * Created by wushufeng on 2017/3/18.
 */

public class AuctionHouseListItem {


    /**
     * msg : success
     * result : [{"airCondition":"良","city":"北京","coldIndex":"低发期","updateTime":"20150908153820","date":"2015-09-08","distrct":"门头沟","dressingIndex":"短袖类","exerciseIndex":"适宜","future":[{"date":"2015-09-09","dayTime":"阵雨","night":"阴","temperature":"24°C/18°C","week":"星期三","wind":"无持续风向小于3级"},{"date":"2015-09-10","dayTime":"阵雨","night":"阵雨","temperature":"22°C/15°C","week":"星期四","wind":"无持续风向小于3级"},{"date":"2015-09-11","dayTime":"阴","night":"晴","temperature":"23°C/15°C","week":"星期五","wind":"北风3～4级无持续风向小于3级"},{"date":"2015-09-12","dayTime":"晴","night":"晴","temperature":"26°C/13°C","week":"星期六","wind":"北风3～4级无持续风向小于3级"},{"date":"2015-09-13","dayTime":"晴","night":"晴","temperature":"27°C/16°C","week":"星期日","wind":"无持续风向小于3级"},{"date":"2015-09-14","dayTime":"晴","night":"多云","temperature":"27°C/16°C","week":"星期一","wind":"无持续风向小于3级"},{"date":"2015-09-15","dayTime":"少云","night":"晴","temperature":"26°C/14°C","week":"星期二","wind":"南风3级南风2级"},{"date":"2015-09-16","dayTime":"局部多云","night":"少云","temperature":"26°C/15°C","week":"星期三","wind":"南风3级南风2级"},{"date":"2015-09-17","dayTime":"阴天","night":"局部多云","temperature":"26°C/15°C","week":"星期四","wind":"东南风2级"}],"humidity":"湿度：46%","province":"北京","sunset":"18:37","sunrise":"05:49","temperature":"25℃","time":"14:35","washIndex":"不适宜","weather":"多云","week":"周二","wind":"南风2级"}]
     * retCode : 200
     */

    private String msg;
    private String code;
    private List<ResultBean> result;

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

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        private String picture_url;
        private String tea_name;
        private String now_price;
        private String show_price_times;
        private String end_time;

        public ResultBean(String picture_url, String tea_name, String now_price, String show_price_times, String end_time) {
            this.picture_url = picture_url;
            this.tea_name = tea_name;
            this.now_price = now_price;
            this.show_price_times = show_price_times;
            this.end_time = end_time;
        }

        public String getShow_price_times() {
            return show_price_times;
        }

        public void setShow_price_times(String show_price_times) {
            this.show_price_times = show_price_times;
        }

        public String getPicture_url() {
            return picture_url;
        }

        public void setPicture_url(String picture_url) {
            this.picture_url = picture_url;
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

        public String getEnd_time() {
            return end_time;
        }

        public void setEnd_time(String end_time) {
            this.end_time = end_time;
        }
    }
}
