package com.delta.smt.entity;

import java.util.List;

/**
 * Created by shaoqiang.zhang on 2017/4/11.
 */

public class AppointmentStoreDetail {

    private int app_code;

    private String app_msg;

    private Result result;

    public int getApp_code(){
        return this.app_code;
    }

    public void setApp_code(int app_code) {
        this.app_code = app_code;
    }

    public String getApp_msg(){
        return this.app_msg;
    }

    public void setApp_msg(String app_msg) {
        this.app_msg = app_msg;
    }

    public Result getResult(){
        return this.result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public class Result {
        private int total;

        private int page;

        private int size;

        private List<MList> list ;

        public int getTotal(){
            return this.total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getPage(){
            return this.page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getSize(){
            return this.size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public List<MList> getList(){
            return this.list;
        }

        public void setList(List<MList> list) {
            this.list = list;
        }

        public class MList {
            private int id;

            private int merchant_id;

            private String phone;

            private int shop_id;

            private int uid;

            private int room_num;

            private int start_time;

            private int end_time;

            private int bespeak_time;

            private int to_time;

            private String remarks;

            private int number;

            private int status;

            private int is_delete;

            private int create_time;

            private int update_time;

            private String name;

            private User user;

            public int getId(){
                return this.id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getMerchant_id(){
                return this.merchant_id;
            }

            public void setMerchant_id(int merchant_id) {
                this.merchant_id = merchant_id;
            }

            public String getPhone(){
                return this.phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public int getShop_id(){
                return this.shop_id;
            }

            public void setShop_id(int shop_id) {
                this.shop_id = shop_id;
            }

            public int getUid(){
                return this.uid;
            }

            public void setUid(int uid) {
                this.uid = uid;
            }

            public int getRoom_num(){
                return this.room_num;
            }

            public void setRoom_num(int room_num) {
                this.room_num = room_num;
            }

            public int getStart_time(){
                return this.start_time;
            }

            public void setStart_time(int start_time) {
                this.start_time = start_time;
            }

            public int getEnd_time(){
                return this.end_time;
            }

            public void setEnd_time(int end_time) {
                this.end_time = end_time;
            }

            public int getBespeak_time(){
                return this.bespeak_time;
            }

            public void setBespeak_time(int bespeak_time) {
                this.bespeak_time = bespeak_time;
            }

            public int getTo_time(){
                return this.to_time;
            }

            public void setTo_time(int to_time) {
                this.to_time = to_time;
            }

            public String getRemarks(){
                return this.remarks;
            }

            public void setRemarks(String remarks) {
                this.remarks = remarks;
            }

            public int getNumber(){
                return this.number;
            }

            public void setNumber(int number) {
                this.number = number;
            }

            public int getStatus(){
                return this.status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getIs_delete(){
                return this.is_delete;
            }

            public void setIs_delete(int is_delete) {
                this.is_delete = is_delete;
            }

            public int getCreate_time(){
                return this.create_time;
            }

            public void setCreate_time(int create_time) {
                this.create_time = create_time;
            }

            public int getUpdate_time(){
                return this.update_time;
            }

            public void setUpdate_time(int update_time) {
                this.update_time = update_time;
            }

            public String getName(){
                return this.name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public User getUser() {
                return user;
            }

            public void setUser(User user) {
                this.user = user;
            }

            public class User {
                private int id;

                private String name;

                private String phone;

                private int sex;

                private int create_time;

                private String banlance;

                public int getId(){
                    return this.id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getName(){
                    return this.name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getPhone(){
                    return this.phone;
                }

                public void setPhone(String phone) {
                    this.phone = phone;
                }

                public int getSex(){
                    return this.sex;
                }

                public void setSex(int sex) {
                    this.sex = sex;
                }

                public int getCreate_time(){
                    return this.create_time;
                }

                public void setCreate_time(int create_time) {
                    this.create_time = create_time;
                }

                public String getBanlance(){
                    return this.banlance;
                }

                public void setBanlance(String banlance) {
                    this.banlance = banlance;
                }

            }

        }
    }


}
