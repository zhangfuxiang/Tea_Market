package com.delta.smt.entity;

import java.util.List;

/**
 * Created by Fuxiang.Zhang on 2017/5/20.
 */

public class ItemPaySuccess {


    /**
     * app_code : 22000
     * app_msg :
     * result : [{"order_id":198,"result":true}]
     */

    private int app_code;
    private String app_msg;
    private List<ResultBean> result;

    public int getApp_code() {
        return app_code;
    }

    public void setApp_code(int app_code) {
        this.app_code = app_code;
    }

    public String getApp_msg() {
        return app_msg;
    }

    public void setApp_msg(String app_msg) {
        this.app_msg = app_msg;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * order_id : 198
         * result : true
         */

        private int order_id;
        private boolean result;

        public int getOrder_id() {
            return order_id;
        }

        public void setOrder_id(int order_id) {
            this.order_id = order_id;
        }

        public boolean isResult() {
            return result;
        }

        public void setResult(boolean result) {
            this.result = result;
        }
    }
}
