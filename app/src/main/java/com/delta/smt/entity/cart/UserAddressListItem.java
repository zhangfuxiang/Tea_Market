package com.delta.smt.entity.cart;

import java.util.List;

/**
 * Created by wushufeng on 2017/5/5.
 */

public class UserAddressListItem {

    /**
     * app_code : 22000
     * app_msg :
     * result : {"list":[{"id":21,"uid":12,"name":"赵剑","phone":"15210954985","province":"北京市","city":"市辖区","area":"朝阳区","address":"兖州哦啊实打实","status":0,"is_delete":0,"create_time":"2017-04-16 12:04:27","update_time":"2017-04-16 12:04:27","location_id":110105,"code":"110105"},{"id":20,"uid":12,"name":"赵剑","phone":"15210954985","province":"北京市","city":"市辖区","area":"朝阳区","address":"回龙观啊啊","status":0,"is_delete":0,"create_time":"2017-04-16 12:03:10","update_time":"2017-04-16 12:03:10","location_id":110105,"code":"110105"}]}
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
        private List<ListBean> list;

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * id : 21
             * uid : 12
             * name : 赵剑
             * phone : 15210954985
             * province : 北京市
             * city : 市辖区
             * area : 朝阳区
             * address : 兖州哦啊实打实
             * status : 0
             * is_delete : 0
             * create_time : 2017-04-16 12:04:27
             * update_time : 2017-04-16 12:04:27
             * location_id : 110105
             * code : 110105
             */

            private String id;
            private String uid;
            private String name;
            private String phone;
            private String province;
            private String city;
            private String area;
            private String address;
            private String status;
            private String is_delete;
            private String create_time;
            private String update_time;
            private String location_id;
            private String code;

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

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getIs_delete() {
                return is_delete;
            }

            public void setIs_delete(String is_delete) {
                this.is_delete = is_delete;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public String getUpdate_time() {
                return update_time;
            }

            public void setUpdate_time(String update_time) {
                this.update_time = update_time;
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
        }
    }
}
