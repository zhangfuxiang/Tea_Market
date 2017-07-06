package com.delta.smt.entity.drinktea;

/**
 * Created by wushufeng on 2017/5/14.
 */

public class OrderThis {

    /**
     * app_code : 22000
     * app_msg :
     * result : {"shop_id":"2","merchant_id":1,"phone":"15210954985","room_num":"1","uid":46,"start_time":1495123200,"end_time":1495209600,"bespeak_time":1493570924,"to_time":1495123200,"remarks":"","number":"2709245481","status":1,"name":"赵剑","update_time":"2017-05-01 00:48:44","create_time":"2017-05-01 00:48:44","id":"33"}
     */

    private int app_code;
    private String app_msg;
    private Object result;

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

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * shop_id : 2
         * merchant_id : 1
         * phone : 15210954985
         * room_num : 1
         * uid : 46
         * start_time : 1495123200
         * end_time : 1495209600
         * bespeak_time : 1493570924
         * to_time : 1495123200
         * remarks :
         * number : 2709245481
         * status : 1
         * name : 赵剑
         * update_time : 2017-05-01 00:48:44
         * create_time : 2017-05-01 00:48:44
         * id : 33
         */

        private String shop_id;
        private int merchant_id;
        private String phone;
        private String room_num;
        private int uid;
        private int start_time;
        private int end_time;
        private int bespeak_time;
        private int to_time;
        private String remarks;
        private String number;
        private int status;
        private String name;
        private String update_time;
        private String create_time;
        private String id;

        public String getShop_id() {
            return shop_id;
        }

        public void setShop_id(String shop_id) {
            this.shop_id = shop_id;
        }

        public int getMerchant_id() {
            return merchant_id;
        }

        public void setMerchant_id(int merchant_id) {
            this.merchant_id = merchant_id;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getRoom_num() {
            return room_num;
        }

        public void setRoom_num(String room_num) {
            this.room_num = room_num;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public int getStart_time() {
            return start_time;
        }

        public void setStart_time(int start_time) {
            this.start_time = start_time;
        }

        public int getEnd_time() {
            return end_time;
        }

        public void setEnd_time(int end_time) {
            this.end_time = end_time;
        }

        public int getBespeak_time() {
            return bespeak_time;
        }

        public void setBespeak_time(int bespeak_time) {
            this.bespeak_time = bespeak_time;
        }

        public int getTo_time() {
            return to_time;
        }

        public void setTo_time(int to_time) {
            this.to_time = to_time;
        }

        public String getRemarks() {
            return remarks;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
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
