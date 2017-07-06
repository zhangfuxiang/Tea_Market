package com.delta.smt.entity;

import java.util.List;

/**
 * Created by Shufeng.Wu on 2017/3/22.
 */

public class SubjectActivityDetailResult {
    /**
     * app_code : 22000
     * app_msg :
     * result : {"activity":{"id":11,"title":"茶旅主体活动 4","number":80,"uid":13,"merchant_id":2,"price":"49.20","start_time":1495173600,"end_time":1495188000,"image_id":"4","address":"北京某地","images":null,"content":"<h3>茶旅 活动<\/h3> <p>有惊喜<\/p>","status":0,"is_delete":0,"create_time":1491203850,"update_time":1491203850,"category_id":9}}
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
        /**
         * activity : {"id":11,"title":"茶旅主体活动 4","number":80,"uid":13,"merchant_id":2,"price":"49.20","start_time":1495173600,"end_time":1495188000,"image_id":"4","address":"北京某地","images":null,"content":"<h3>茶旅 活动<\/h3> <p>有惊喜<\/p>","status":0,"is_delete":0,"create_time":1491203850,"update_time":1491203850,"category_id":9}
         */

        private ActivityBean activity;

        public ActivityBean getActivity() {
            return activity;
        }

        public void setActivity(ActivityBean activity) {
            this.activity = activity;
        }

        public static class ActivityBean {
            /**
             * id : 11
             * title : 茶旅主体活动 4
             * number : 80
             * uid : 13
             * merchant_id : 2
             * price : 49.20
             * start_time : 1495173600
             * end_time : 1495188000
             * image_id : 4
             * address : 北京某地
             * images : null
             * content : <h3>茶旅 活动</h3> <p>有惊喜</p>
             * status : 0
             * is_delete : 0
             * create_time : 1491203850
             * update_time : 1491203850
             * category_id : 9
             */

            private String id;
            private String title;
            private String number;
            private String sign_num;
            private String uid;
            private String merchant_id;
            private String price;
            private String start_time;
            private String end_time;
            private String image_id;
            private String address;
            private List<String> images;
            private String content;
            private String status;
            private String is_delete;
            private String create_time;
            private String update_time;
            private String category_id;
            private String image_url;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getNumber() {
                return number;
            }

            public void setNumber(String number) {
                this.number = number;
            }

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public String getMerchant_id() {
                return merchant_id;
            }

            public void setMerchant_id(String merchant_id) {
                this.merchant_id = merchant_id;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getStart_time() {
                return start_time;
            }

            public void setStart_time(String start_time) {
                this.start_time = start_time;
            }

            public String getEnd_time() {
                return end_time;
            }

            public void setEnd_time(String end_time) {
                this.end_time = end_time;
            }

            public String getImage_id() {
                return image_id;
            }

            public void setImage_id(String image_id) {
                this.image_id = image_id;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
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

            public String getCategory_id() {
                return category_id;
            }

            public void setCategory_id(String category_id) {
                this.category_id = category_id;
            }

            public String getSign_num() {
                return sign_num;
            }

            public void setSign_num(String sign_num) {
                this.sign_num = sign_num;
            }

            public List<String> getImages() {
                return images;
            }

            public void setImages(List<String> images) {
                this.images = images;
            }

            public String getImage_url() {
                return image_url;
            }

            public void setImage_url(String image_url) {
                this.image_url = image_url;
            }
        }
    }

    /*private String msg;
    private String code;
    private PushableActivityResult result;

    public SubjectActivityDetailResult(String msg, String code, PushableActivityResult result) {
        this.msg = msg;
        this.code = code;
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public PushableActivityResult getResult() {
        return result;
    }

    public void setResult(PushableActivityResult result) {
        this.result = result;
    }

    public static class PushableActivityResult {
        private PushableActivityList<String> picture_urls;
        private String activity_name;
        private String activity_status;
        private String sign_up_price;
        private String person_amount;
        private String person_amount_limit;
        private String activity_start_time;
        private String activity_end_time;
        private String activity_place;
        private String activity_content;


        public PushableActivityResult(PushableActivityList<String> picture_urls, String activity_name, String activity_status, String sign_up_price, String person_amount, String person_amount_limit, String activity_start_time, String activity_end_time, String activity_place, String activity_content) {
            this.picture_urls = picture_urls;
            this.activity_name = activity_name;
            this.activity_status = activity_status;
            this.sign_up_price = sign_up_price;
            this.person_amount = person_amount;
            this.person_amount_limit = person_amount_limit;
            this.activity_start_time = activity_start_time;
            this.activity_end_time = activity_end_time;
            this.activity_place = activity_place;
            this.activity_content = activity_content;
        }

        public PushableActivityList<String> getPicture_urls() {
            return picture_urls;
        }

        public void setPicture_urls(PushableActivityList<String> picture_urls) {
            this.picture_urls = picture_urls;
        }

        public String getActivity_name() {
            return activity_name;
        }

        public void setActivity_name(String activity_name) {
            this.activity_name = activity_name;
        }

        public String getActivity_status() {
            return activity_status;
        }

        public void setActivity_status(String activity_status) {
            this.activity_status = activity_status;
        }

        public String getSign_up_price() {
            return sign_up_price;
        }

        public void setSign_up_price(String sign_up_price) {
            this.sign_up_price = sign_up_price;
        }

        public String getPerson_amount() {
            return person_amount;
        }

        public void setPerson_amount(String person_amount) {
            this.person_amount = person_amount;
        }

        public String getPerson_amount_limit() {
            return person_amount_limit;
        }

        public void setPerson_amount_limit(String person_amount_limit) {
            this.person_amount_limit = person_amount_limit;
        }

        public String getActivity_start_time() {
            return activity_start_time;
        }

        public void setActivity_start_time(String activity_start_time) {
            this.activity_start_time = activity_start_time;
        }

        public String getActivity_end_time() {
            return activity_end_time;
        }

        public void setActivity_end_time(String activity_end_time) {
            this.activity_end_time = activity_end_time;
        }

        public String getActivity_place() {
            return activity_place;
        }

        public void setActivity_place(String activity_place) {
            this.activity_place = activity_place;
        }

        public String getActivity_content() {
            return activity_content;
        }

        public void setActivity_content(String activity_content) {
            this.activity_content = activity_content;
        }
    }*/
}
