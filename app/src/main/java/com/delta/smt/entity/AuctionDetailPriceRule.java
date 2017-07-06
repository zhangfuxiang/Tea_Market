package com.delta.smt.entity;

/**
 * Created by Shufeng.Wu on 2017/3/20.
 */

public class AuctionDetailPriceRule {
    private String msg;
    private String code;
    private Result result;

    public AuctionDetailPriceRule(String msg, String code, Result result) {
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

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public static class Result {
        private String bottom_price;
        private String every_add_price;
        private String after_price_delay;

        public Result(String bottom_price, String every_add_price, String after_price_delay) {
            this.bottom_price = bottom_price;
            this.every_add_price = every_add_price;
            this.after_price_delay = after_price_delay;
        }

        public String getBottom_price() {
            return bottom_price;
        }

        public void setBottom_price(String bottom_price) {
            this.bottom_price = bottom_price;
        }

        public String getEvery_add_price() {
            return every_add_price;
        }

        public void setEvery_add_price(String every_add_price) {
            this.every_add_price = every_add_price;
        }

        public String getAfter_price_delay() {
            return after_price_delay;
        }

        public void setAfter_price_delay(String after_price_delay) {
            this.after_price_delay = after_price_delay;
        }
    }
}
