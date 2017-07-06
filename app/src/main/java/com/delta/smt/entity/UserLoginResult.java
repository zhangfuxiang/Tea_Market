package com.delta.smt.entity;

/**
 * Created by wushufeng on 2017/4/5.
 */

public class UserLoginResult {

    /**
     * app_code : 22000
     * app_msg :
     * result : {"token":{"token":"25c72f82a9c2975a085b73ee8196a012","expire":1491118085},"merchant":{"id":1,"uid":12,"shop_title":" Jesse茶商","shop_address":null,"status":1},"user":{"id":12,"name":"Jesse","sex":1,"phone":"15210954985"}}
     */

    private String app_code;
    private String app_msg;
    private ResultBean result;

    public String getApp_code() {
        return app_code;
    }

    public void setApp_code(String app_code) {
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
        /**
         * token : {"token":"25c72f82a9c2975a085b73ee8196a012","expire":1491118085}
         * merchant : {"id":1,"uid":12,"shop_title":" Jesse茶商","shop_address":null,"status":1}
         * user : {"id":12,"name":"Jesse","sex":1,"phone":"15210954985"}
         */

        private TokenBean token;
        private MerchantBean merchant;
        private UserBean user;

        public TokenBean getToken() {
            return token;
        }

        public void setToken(TokenBean token) {
            this.token = token;
        }

        public MerchantBean getMerchant() {
            return merchant;
        }

        public void setMerchant(MerchantBean merchant) {
            this.merchant = merchant;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public static class TokenBean {
            /**
             * token : 25c72f82a9c2975a085b73ee8196a012
             * expire : 1491118085
             */

            private String token;
            private String expire;

            public String getToken() {
                return token;
            }

            public void setToken(String token) {
                this.token = token;
            }

            public String getExpire() {
                return expire;
            }

            public void setExpire(String expire) {
                this.expire = expire;
            }
        }

        public static class MerchantBean {
            /**
             * id : 1
             * uid : 12
             * shop_title :  Jesse茶商
             * shop_address : null
             * status : 1
             */

            private String id;
            private String uid;
            private String shop_title;
            private Object shop_address;
            private String status;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
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

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }
        }

        public static class UserBean {
            /**
             * id : 12
             * name : Jesse
             * sex : 1
             * phone : 15210954985
             */

            private String id;
            private String name;
            private String sex;
            private String phone;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getSex() {
                return sex;
            }

            public void setSex(String sex) {
                this.sex = sex;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }
        }
    }
}
