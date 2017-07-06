package com.delta.smt.entity;

/**
 * Created by Fuxiang.Zhang on 2017/5/8.
 */

public class AddAddress {
    /**
     * app_code : 22000
     * app_msg :
     * result : {"name":"张先森","phone":"15210075202","address":"回龙观啊啊","location_id":"110105","code":110105,"province":"北京市","city":"市辖区","area":"朝阳区","uid":51,"status":0,"update_time":"2017-05-08 22:11:33","create_time":"2017-05-08 22:11:33","id":"43"}
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
        /**
         * name : 张先森
         * phone : 15210075202
         * address : 回龙观啊啊
         * location_id : 110105
         * code : 110105
         * province : 北京市
         * city : 市辖区
         * area : 朝阳区
         * uid : 51
         * status : 0
         * update_time : 2017-05-08 22:11:33
         * create_time : 2017-05-08 22:11:33
         * id : 43
         */

        private String name;
        private String phone;
        private String address;
        private String location_id;
        private int code;
        private String province;
        private String city;
        private String area;
        private int uid;
        private int status;
        private String update_time;
        private String create_time;
        private String id;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getLocation_id() {
            return location_id;
        }

        public void setLocation_id(String location_id) {
            this.location_id = location_id;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getUpdate_time() {
            return update_time;
        }

        public void setUpdate_time(String update_time) {
            this.update_time = update_time;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}
