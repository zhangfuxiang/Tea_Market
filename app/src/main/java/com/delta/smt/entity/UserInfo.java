package com.delta.smt.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/5/16.
 */

public class UserInfo implements Serializable{


    /**
     * app_code : 22000
     * app_msg :
     * result : {"user":{"id":22,"name":"u_15210940588","type":0,"sex":2,"phone":"15210940588","image_url":"http://tea.api.test.sygcsoft.com/public/static/images/default_avatar3.png","image_id":null,"merchant_id":1,"balance":"10000.00","score":"0.00","create_time":"2017-05-20 16:16:22","auth":null,"set_pay_pwd":1,"frozen_balance":0}}
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
         * user : {"id":22,"name":"u_15210940588","type":0,"sex":2,"phone":"15210940588","image_url":"http://tea.api.test.sygcsoft.com/public/static/images/default_avatar3.png","image_id":null,"merchant_id":1,"balance":"10000.00","score":"0.00","create_time":"2017-05-20 16:16:22","auth":null,"set_pay_pwd":1,"frozen_balance":0}
         */

        private UserEntity user;

        public UserEntity getUser() {
            return user;
        }

        public void setUser(UserEntity user) {
            this.user = user;
        }

        public static class UserEntity {
            /**
             * id : 22
             * name : u_15210940588
             * type : 0
             * sex : 2
             * phone : 15210940588
             * image_url : http://tea.api.test.sygcsoft.com/public/static/images/default_avatar3.png
             * image_id : null
             * merchant_id : 1
             * balance : 10000.00
             * score : 0.00
             * create_time : 2017-05-20 16:16:22
             * auth : null
             * set_pay_pwd : 1
             * frozen_balance : 0
             */

            private int id;
            private String name;
            private int type;
            private int sex;
            private String phone;
            private String image_url;
            private Object image_id;
            private int merchant_id;
            private String balance;
            private String score;
            private String create_time;
            private Object auth;
            private int set_pay_pwd;
            private int frozen_balance;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getSex() {
                return sex;
            }

            public void setSex(int sex) {
                this.sex = sex;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getImage_url() {
                return image_url;
            }

            public void setImage_url(String image_url) {
                this.image_url = image_url;
            }

            public Object getImage_id() {
                return image_id;
            }

            public void setImage_id(Object image_id) {
                this.image_id = image_id;
            }

            public int getMerchant_id() {
                return merchant_id;
            }

            public void setMerchant_id(int merchant_id) {
                this.merchant_id = merchant_id;
            }

            public String getBalance() {
                return balance;
            }

            public void setBalance(String balance) {
                this.balance = balance;
            }

            public String getScore() {
                return score;
            }

            public void setScore(String score) {
                this.score = score;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public Object getAuth() {
                return auth;
            }

            public void setAuth(Object auth) {
                this.auth = auth;
            }

            public int getSet_pay_pwd() {
                return set_pay_pwd;
            }

            public void setSet_pay_pwd(int set_pay_pwd) {
                this.set_pay_pwd = set_pay_pwd;
            }

            public int getFrozen_balance() {
                return frozen_balance;
            }

            public void setFrozen_balance(int frozen_balance) {
                this.frozen_balance = frozen_balance;
            }
        }
    }
}
