package com.delta.smt.entity;

/**
 * Created by Administrator on 2017/5/21.
 */

public class MerchantInfo {

    /**
     * app_code : 22000
     * app_msg :
     * result : {"merchant":{"id":1,"uid":12,"shop_title":" Jesse茶商","shop_address":null,"status":1}}
     */

    private int app_code;
    private String app_msg;
    private ResultEntity result;

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

    public ResultEntity getResult() {
        return result;
    }

    public void setResult(ResultEntity result) {
        this.result = result;
    }

    public static class ResultEntity {
        /**
         * merchant : {"id":1,"uid":12,"shop_title":" Jesse茶商","shop_address":null,"status":1}
         */

        private MerchantEntity merchant;

        public MerchantEntity getMerchant() {
            return merchant;
        }

        public void setMerchant(MerchantEntity merchant) {
            this.merchant = merchant;
        }

        public static class MerchantEntity {
            /**
             * id : 1
             * uid : 12
             * shop_title :  Jesse茶商
             * shop_address : null
             * status : 1
             */

            private int id;
            private int uid;
            private String shop_title;
            private Object shop_address;
            private int status;
            private String image_url;

            public String getImage_url() {
                return image_url;
            }

            public void setImage_url(String image_url) {
                this.image_url = image_url;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getUid() {
                return uid;
            }

            public void setUid(int uid) {
                this.uid = uid;
            }

            public String getShop_title() {
                return shop_title;
            }

            public void setShop_title(String shop_title) {
                this.shop_title = shop_title;
            }

            public Object getShop_address() {
                return shop_address;
            }

            public void setShop_address(Object shop_address) {
                this.shop_address = shop_address;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }
        }
    }
}
