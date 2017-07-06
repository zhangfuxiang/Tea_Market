package com.delta.smt.entity;

import java.util.List;

/**
 * Created by shaoqiang.zhang on 2017/4/11.
 */

public class ReferBuy {
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

            private int product_id;

            private int merchant_id;

            private int uid;

            private String questions;

            private String answer;

            private int is_delete;

            private int status;

            private int create_time;

            private int update_time;

            public int getId(){
                return this.id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getProduct_id(){
                return this.product_id;
            }

            public void setProduct_id(int product_id) {
                this.product_id = product_id;
            }

            public int getMerchant_id(){
                return this.merchant_id;
            }

            public void setMerchant_id(int merchant_id) {
                this.merchant_id = merchant_id;
            }

            public int getUid(){
                return this.uid;
            }

            public void setUid(int uid) {
                this.uid = uid;
            }

            public String getQuestions(){
                return this.questions;
            }

            public void setQuestions(String questions) {
                this.questions = questions;
            }

            public String getAnswer(){
                return this.answer;
            }

            public void setAnswer(String answer) {
                this.answer = answer;
            }

            public int getIs_delete(){
                return this.is_delete;
            }

            public void setIs_delete(int is_delete) {
                this.is_delete = is_delete;
            }

            public int getStatus(){
                return this.status;
            }

            public void setStatus(int status) {
                this.status = status;
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

        }
    }
}
