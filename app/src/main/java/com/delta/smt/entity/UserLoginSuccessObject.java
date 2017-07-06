package com.delta.smt.entity;

/**
 * Created by wushufeng on 2017/4/22.
 */

public class UserLoginSuccessObject {


    /**
     * token : {"token":"f8836f071a762f7e2eb6f6cfb903cb0e","expire":1494355791}
     * user : {"id":48,"name":"u_15210940588","type":0,"sex":1,"phone":"15210940588","image_url":"http://tea.api.test.sygcsoft.com/public/static/images/default_avatar3.png","image_id":null,"merchant_id":1,"balance":"10000.00"}
     */

    private TokenBean token;
    private UserBean user;

    public TokenBean getToken() {
        return token;
    }

    public void setToken(TokenBean token) {
        this.token = token;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public static class TokenBean {
        /**
         * token : f8836f071a762f7e2eb6f6cfb903cb0e
         * expire : 1494355791
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

    public static class UserBean {
        /**
         * id : 48
         * name : u_15210940588
         * type : 0
         * sex : 1
         * phone : 15210940588
         * image_url : http://tea.api.test.sygcsoft.com/public/static/images/default_avatar3.png
         * image_id : null
         * merchant_id : 1
         * balance : 10000.00
         */

        private String id;
        private String name;
        private String type;
        private String sex;
        private String phone;
        //private String image_url;
        //private Object image_id;
        private String merchant_id;
        private String balance;

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

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
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

        /*public String getImage_url() {
            return image_url;
        }

        public void setImage_url(String image_url) {
            this.image_url = image_url;
        }*/

        /*public Object getImage_id() {
            return image_id;
        }

        public void setImage_id(Object image_id) {
            this.image_id = image_id;
        }*/

        public String getMerchant_id() {
            return merchant_id;
        }

        public void setMerchant_id(String merchant_id) {
            this.merchant_id = merchant_id;
        }

        public String getBalance() {
            return balance;
        }

        public void setBalance(String balance) {
            this.balance = balance;
        }
    }
}
