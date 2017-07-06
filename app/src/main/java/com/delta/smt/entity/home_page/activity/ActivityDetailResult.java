package com.delta.smt.entity.home_page.activity;

import java.util.List;

/**
 * Created by wushufeng on 2017/6/3.
 */

public class ActivityDetailResult {
    /**
     * act : {"id":38,"title":"品茶主体活动 2","number":40,"sign_num":12,"uid":12,"merchant_id":1,"price":"24.60","start_time":1495000800,"end_time":1495015200,"image_id":"4","address":"北京某地","images":["http://on1z8q8is.bkt.clouddn.com//2017/04/03/3a4a80da426ace5abb852bcdecad2389.jpg","http://on1z8q8is.bkt.clouddn.com//2017/04/03/8619cb55f870b73b812a8ef50cb7aa4e.jpg","http://on1z8q8is.bkt.clouddn.com//2017/04/03/beea251915534d935f13897df7723565.jpg"],"content":"品茶 活动 有惊喜","status":0,"is_delete":0,"create_time":1492258919,"update_time":1492258919,"category_id":11,"image_url":"http://on1z8q8is.bkt.clouddn.com/j0hjuquo_49m6w34h3u2o58cf4be6891ee.jpg","is_signed":1,"sign_id":123}
     */

    private ActBean act;

    public ActBean getAct() {
        return act;
    }

    public void setAct(ActBean act) {
        this.act = act;
    }

    public static class ActBean {
        /**
         * id : 38
         * title : 品茶主体活动 2
         * number : 40
         * sign_num : 12
         * uid : 12
         * merchant_id : 1
         * price : 24.60
         * start_time : 1495000800
         * end_time : 1495015200
         * image_id : 4
         * address : 北京某地
         * images : ["http://on1z8q8is.bkt.clouddn.com//2017/04/03/3a4a80da426ace5abb852bcdecad2389.jpg","http://on1z8q8is.bkt.clouddn.com//2017/04/03/8619cb55f870b73b812a8ef50cb7aa4e.jpg","http://on1z8q8is.bkt.clouddn.com//2017/04/03/beea251915534d935f13897df7723565.jpg"]
         * content : 品茶 活动 有惊喜
         * status : 0
         * is_delete : 0
         * create_time : 1492258919
         * update_time : 1492258919
         * category_id : 11
         * image_url : http://on1z8q8is.bkt.clouddn.com/j0hjuquo_49m6w34h3u2o58cf4be6891ee.jpg
         * is_signed : 1
         * sign_id : 123
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
        private String content;
        private String status;
        private String is_delete;
        private String create_time;
        private String update_time;
        private String category_id;
        private String image_url;
        private String is_signed;
        private String sign_id;
        private List<String> images;

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

        public String getSign_num() {
            return sign_num;
        }

        public void setSign_num(String sign_num) {
            this.sign_num = sign_num;
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

        public String getImage_url() {
            return image_url;
        }

        public void setImage_url(String image_url) {
            this.image_url = image_url;
        }

        public String getIs_signed() {
            return is_signed;
        }

        public void setIs_signed(String is_signed) {
            this.is_signed = is_signed;
        }

        public String getSign_id() {
            return sign_id;
        }

        public void setSign_id(String sign_id) {
            this.sign_id = sign_id;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }
}
