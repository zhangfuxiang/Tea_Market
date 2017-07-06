package com.delta.smt.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/5/16.
 */

public class BlanceDetailResult {

    /**
     * app_code : 22000
     * app_msg :
     * result : {"total":2,"size":10,"page":1,"list":[{"id":5,"uid":46,"comment":"购买商品","type":1,"total":"8799.40","change_money":"-400.20","create_time":"2017-04-30 15:57:14","update_time":"2017-04-30 15:57:14"},{"id":3,"uid":46,"comment":"购买商品","type":1,"total":"9199.60","change_money":"-800.40","create_time":"2017-04-30 15:53:35","update_time":"2017-04-30 15:53:35"}]}
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
         * total : 2
         * size : 10
         * page : 1
         * list : [{"id":5,"uid":46,"comment":"购买商品","type":1,"total":"8799.40","change_money":"-400.20","create_time":"2017-04-30 15:57:14","update_time":"2017-04-30 15:57:14"},{"id":3,"uid":46,"comment":"购买商品","type":1,"total":"9199.60","change_money":"-800.40","create_time":"2017-04-30 15:53:35","update_time":"2017-04-30 15:53:35"}]
         */

        private int total;
        private int size;
        private int page;
        private List<ListEntity> list;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public List<ListEntity> getList() {
            return list;
        }

        public void setList(List<ListEntity> list) {
            this.list = list;
        }

        public static class ListEntity {
            /**
             * id : 5
             * uid : 46
             * comment : 购买商品
             * type : 1
             * total : 8799.40
             * change_money : -400.20
             * create_time : 2017-04-30 15:57:14
             * update_time : 2017-04-30 15:57:14
             */

            private int id;
            private int uid;
            private String comment;
            private int type;
            private String total;
            private String change_money;
            private String create_time;
            private String update_time;

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

            public String getComment() {
                return comment;
            }

            public void setComment(String comment) {
                this.comment = comment;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getTotal() {
                return total;
            }

            public void setTotal(String total) {
                this.total = total;
            }

            public String getChange_money() {
                return change_money;
            }

            public void setChange_money(String change_money) {
                this.change_money = change_money;
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
        }
    }
}
