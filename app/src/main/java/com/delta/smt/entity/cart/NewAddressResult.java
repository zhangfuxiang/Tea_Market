package com.delta.smt.entity.cart;

/**
 * Created by wushufeng on 2017/5/7.
 */

public class NewAddressResult {


    /**
     * app_code : 22000
     * app_msg :
     * result : {"name":"wsf","phone":"15210940588","address":"象牙山","location_id":"130104","code":130104,"province":"河北省","city":"石家庄市","area":"桥西区","uid":24,"status":0,"update_time":"2017-05-10 23:13:30","create_time":"2017-05-10 23:13:30","id":"49"}
     */

    private String app_code;
    private String app_msg;
    private Object result;

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

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    /*public static class ResultBean {
        *//**
     * name : wsf
     * phone : 15210940588
     * address : 象牙山
     * location_id : 130104
     * code : 130104
     * province : 河北省
     * city : 石家庄市
     * area : 桥西区
     * uid : 24
     * status : 0
     * update_time : 2017-05-10 23:13:30
     * create_time : 2017-05-10 23:13:30
     * id : 49
     *//*

        private String name;
        private String phone;
        private String address;
        private String location_id;
        private String code;
        private String province;
        private String city;
        private String area;
        private String uid;
        private String status;
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

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
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

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
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
    }*/
}
