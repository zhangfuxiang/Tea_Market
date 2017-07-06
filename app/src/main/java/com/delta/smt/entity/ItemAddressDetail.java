package com.delta.smt.entity;

/**
 * Created by Fuxiang.Zhang on 2017/5/11.
 */

public class ItemAddressDetail {

    /**
     * app_code : 22000
     * app_msg :
     * result : {"address":{"id":21,"uid":12,"name":"赵剑","phone":"15210954985","province":"北京市","city":"市辖区","area":"朝阳区","address":"兖州哦啊实打实","status":0,"is_delete":0,"create_time":"2017-04-16 12:04:27","update_time":"2017-04-16 12:04:27","location_id":110105,"code":"110105"}}
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
         * address : {"id":21,"uid":12,"name":"赵剑","phone":"15210954985","province":"北京市","city":"市辖区","area":"朝阳区","address":"兖州哦啊实打实","status":0,"is_delete":0,"create_time":"2017-04-16 12:04:27","update_time":"2017-04-16 12:04:27","location_id":110105,"code":"110105"}
         */

        private AddressBean address;

        public AddressBean getAddress() {
            return address;
        }

        public void setAddress(AddressBean address) {
            this.address = address;
        }

        public static class AddressBean {
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

            private int id;
            private int uid;
            private String name;
            private String phone;
            private String province;
            private String city;
            private String area;
            private String address;
            private int status;
            private int is_delete;
            private String create_time;
            private String update_time;
            private int location_id;
            private String code;

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

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getIs_delete() {
                return is_delete;
            }

            public void setIs_delete(int is_delete) {
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

            public int getLocation_id() {
                return location_id;
            }

            public void setLocation_id(int location_id) {
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
