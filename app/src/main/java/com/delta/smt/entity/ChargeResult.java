package com.delta.smt.entity;

import java.util.List;

/**
 * @description :
 * @autHor :  V.Wenju.Tian
 * @date : 2017/5/18 16:13
 */


public class ChargeResult {

    /**
     * app_code : 22000
     * app_msg :
     * result : {"map":[{"total":"50","money":"50","recommand":1},{"total":"100","money":"100"},{"total":"200","money":"200"},{"total":"300","money":"300"},{"total":"500","money":"500"},{"total":"1000","money":"1000"},{"total":"2000","money":"2000"},{"total":"3000","money":"3000"},{"total":"5000","money":"5000","recommand":1}]}
     */

    private int app_code;
    private String app_msg;
    private ResultBean result;

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

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        private List<MapBean> map;

        public List<MapBean> getMap() {
            return map;
        }

        public void setMap(List<MapBean> map) {
            this.map = map;
        }

        public static class MapBean {
            /**
             * total : 50
             * money : 50
             * recommand : 1
             */

            private String total;
            private String money;
            private int recommand;

            public String getTotal() {
                return total;
            }

            public void setTotal(String total) {
                this.total = total;
            }

            public String getMoney() {
                return money;
            }

            public void setMoney(String money) {
                this.money = money;
            }

            public int getRecommand() {
                return recommand;
            }

            public void setRecommand(int recommand) {
                this.recommand = recommand;
            }
        }
    }
}
