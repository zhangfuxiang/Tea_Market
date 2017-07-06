package com.delta.smt.entity;

import java.util.List;

/**
 * Created by wushufeng on 2017/3/18.
 */

public class SubjectActivityListItem {
    /**
     * app_code : 22000
     * app_msg :
     * result : {"total":11,"page":1,"size":20,"list":[{"id":12,"title":"创建测试活动","number":100,"uid":0,"merchant_id":1,"price":"0.00","start_time":1493604000,"end_time":1496365200,"image_id":"9","address":"紫禁城内","images":null,"content":"一起来那","status":0,"is_delete":0,"create_time":1491315333,"update_time":1491315333,"category_id":10},{"id":11,"title":"茶旅主体活动 4","number":80,"uid":13,"merchant_id":2,"price":"49.20","start_time":1495173600,"end_time":1495188000,"image_id":"4","address":"北京某地","images":null,"content":"<h3>茶旅 活动<\/h3> <p>有惊喜<\/p>","status":0,"is_delete":0,"create_time":1491203850,"update_time":1491203850,"category_id":9},{"id":10,"title":"雅集主体活动 3","number":60,"uid":13,"merchant_id":2,"price":"36.90","start_time":1495087200,"end_time":1495101600,"image_id":"4","address":"北京某地","images":null,"content":"<h3>雅集 活动<\/h3> <p>有惊喜<\/p>","status":0,"is_delete":0,"create_time":1491203850,"update_time":1491203850,"category_id":12},{"id":9,"title":"品茶主体活动 2","number":40,"uid":13,"merchant_id":2,"price":"24.60","start_time":1495000800,"end_time":1495015200,"image_id":"4","address":"北京某地","images":null,"content":"<h3>品茶 活动<\/h3> <p>有惊喜<\/p>","status":0,"is_delete":0,"create_time":1491203850,"update_time":1491203850,"category_id":11},{"id":8,"title":"茶旅主体活动 4","number":80,"uid":12,"merchant_id":1,"price":"49.20","start_time":1495173600,"end_time":1495188000,"image_id":"4","address":"北京某地","images":null,"content":"<h3>茶旅 活动<\/h3> <p>有惊喜<\/p>","status":0,"is_delete":0,"create_time":1491203847,"update_time":1491203847,"category_id":9},{"id":7,"title":"雅集主体活动 3","number":60,"uid":12,"merchant_id":1,"price":"36.90","start_time":1495087200,"end_time":1495101600,"image_id":"4","address":"北京某地","images":null,"content":"<h3>雅集 活动<\/h3> <p>有惊喜<\/p>","status":0,"is_delete":0,"create_time":1491203847,"update_time":1491203847,"category_id":12},{"id":6,"title":"品茶主体活动 2","number":40,"uid":12,"merchant_id":1,"price":"24.60","start_time":1495000800,"end_time":1495015200,"image_id":"4","address":"北京某地","images":null,"content":"<h3>品茶 活动<\/h3> <p>有惊喜<\/p>","status":0,"is_delete":0,"create_time":1491203847,"update_time":1491203847,"category_id":11},{"id":4,"title":"培训主体活动 1","number":20,"uid":12,"merchant_id":1,"price":"12.30","start_time":1494828000,"end_time":1494842400,"image_id":"4","address":"北京某地","images":null,"content":"<h3>培训 活动<\/h3> <p>有惊喜<\/p>","status":0,"is_delete":0,"create_time":1491203792,"update_time":1491203792,"category_id":10},{"id":5,"title":"茶旅主体活动 2","number":40,"uid":12,"merchant_id":1,"price":"24.60","start_time":1494828000,"end_time":1494842400,"image_id":"4","address":"北京某地","images":null,"content":"<h3>茶旅 活动<\/h3> <p>有惊喜<\/p>","status":0,"is_delete":0,"create_time":1491203792,"update_time":1491203792,"category_id":9},{"id":2,"title":"培训主体活动 1","number":20,"uid":13,"merchant_id":2,"price":"12.30","start_time":1494828000,"end_time":1494842400,"image_id":"4","address":"北京某地","images":null,"content":"<h3>培训 活动<\/h3> <p>有惊喜<\/p>","status":0,"is_delete":0,"create_time":1491203783,"update_time":1491203783,"category_id":10},{"id":3,"title":"茶旅主体活动 2","number":40,"uid":13,"merchant_id":2,"price":"24.60","start_time":1494828000,"end_time":1494842400,"image_id":"4","address":"北京某地","images":null,"content":"<h3>茶旅 活动<\/h3> <p>有惊喜<\/p>","status":0,"is_delete":0,"create_time":1491203783,"update_time":1491203783,"category_id":9}]}
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
         * total : 11
         * page : 1
         * size : 20
         * list : [{"id":12,"title":"创建测试活动","number":100,"uid":0,"merchant_id":1,"price":"0.00","start_time":1493604000,"end_time":1496365200,"image_id":"9","address":"紫禁城内","images":null,"content":"一起来那","status":0,"is_delete":0,"create_time":1491315333,"update_time":1491315333,"category_id":10},{"id":11,"title":"茶旅主体活动 4","number":80,"uid":13,"merchant_id":2,"price":"49.20","start_time":1495173600,"end_time":1495188000,"image_id":"4","address":"北京某地","images":null,"content":"<h3>茶旅 活动<\/h3> <p>有惊喜<\/p>","status":0,"is_delete":0,"create_time":1491203850,"update_time":1491203850,"category_id":9},{"id":10,"title":"雅集主体活动 3","number":60,"uid":13,"merchant_id":2,"price":"36.90","start_time":1495087200,"end_time":1495101600,"image_id":"4","address":"北京某地","images":null,"content":"<h3>雅集 活动<\/h3> <p>有惊喜<\/p>","status":0,"is_delete":0,"create_time":1491203850,"update_time":1491203850,"category_id":12},{"id":9,"title":"品茶主体活动 2","number":40,"uid":13,"merchant_id":2,"price":"24.60","start_time":1495000800,"end_time":1495015200,"image_id":"4","address":"北京某地","images":null,"content":"<h3>品茶 活动<\/h3> <p>有惊喜<\/p>","status":0,"is_delete":0,"create_time":1491203850,"update_time":1491203850,"category_id":11},{"id":8,"title":"茶旅主体活动 4","number":80,"uid":12,"merchant_id":1,"price":"49.20","start_time":1495173600,"end_time":1495188000,"image_id":"4","address":"北京某地","images":null,"content":"<h3>茶旅 活动<\/h3> <p>有惊喜<\/p>","status":0,"is_delete":0,"create_time":1491203847,"update_time":1491203847,"category_id":9},{"id":7,"title":"雅集主体活动 3","number":60,"uid":12,"merchant_id":1,"price":"36.90","start_time":1495087200,"end_time":1495101600,"image_id":"4","address":"北京某地","images":null,"content":"<h3>雅集 活动<\/h3> <p>有惊喜<\/p>","status":0,"is_delete":0,"create_time":1491203847,"update_time":1491203847,"category_id":12},{"id":6,"title":"品茶主体活动 2","number":40,"uid":12,"merchant_id":1,"price":"24.60","start_time":1495000800,"end_time":1495015200,"image_id":"4","address":"北京某地","images":null,"content":"<h3>品茶 活动<\/h3> <p>有惊喜<\/p>","status":0,"is_delete":0,"create_time":1491203847,"update_time":1491203847,"category_id":11},{"id":4,"title":"培训主体活动 1","number":20,"uid":12,"merchant_id":1,"price":"12.30","start_time":1494828000,"end_time":1494842400,"image_id":"4","address":"北京某地","images":null,"content":"<h3>培训 活动<\/h3> <p>有惊喜<\/p>","status":0,"is_delete":0,"create_time":1491203792,"update_time":1491203792,"category_id":10},{"id":5,"title":"茶旅主体活动 2","number":40,"uid":12,"merchant_id":1,"price":"24.60","start_time":1494828000,"end_time":1494842400,"image_id":"4","address":"北京某地","images":null,"content":"<h3>茶旅 活动<\/h3> <p>有惊喜<\/p>","status":0,"is_delete":0,"create_time":1491203792,"update_time":1491203792,"category_id":9},{"id":2,"title":"培训主体活动 1","number":20,"uid":13,"merchant_id":2,"price":"12.30","start_time":1494828000,"end_time":1494842400,"image_id":"4","address":"北京某地","images":null,"content":"<h3>培训 活动<\/h3> <p>有惊喜<\/p>","status":0,"is_delete":0,"create_time":1491203783,"update_time":1491203783,"category_id":10},{"id":3,"title":"茶旅主体活动 2","number":40,"uid":13,"merchant_id":2,"price":"24.60","start_time":1494828000,"end_time":1494842400,"image_id":"4","address":"北京某地","images":null,"content":"<h3>茶旅 活动<\/h3> <p>有惊喜<\/p>","status":0,"is_delete":0,"create_time":1491203783,"update_time":1491203783,"category_id":9}]
         */

        private String total;
        private String page;
        private String size;
        private List<ListBean> list;

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public String getPage() {
            return page;
        }

        public void setPage(String page) {
            this.page = page;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * id : 12
             * title : 创建测试活动
             * number : 100
             * uid : 0
             * merchant_id : 1
             * price : 0.00
             * start_time : 1493604000
             * end_time : 1496365200
             * image_id : 9
             * address : 紫禁城内
             * images : null
             * content : 一起来那
             * status : 0
             * is_delete : 0
             * create_time : 1491315333
             * update_time : 1491315333
             * category_id : 10
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
    private PushableActivityList<ResultBean> result;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public PushableActivityList<ResultBean> getResult() {
        return result;
    }

    public void setResult(PushableActivityList<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        private String picture_url;
        private String activity_name;
        private String enroll_amount;
        private String state;

        public ResultBean(String picture_url, String activity_name, String enroll_amount, String state) {
            this.picture_url = picture_url;
            this.activity_name = activity_name;
            this.enroll_amount = enroll_amount;
            this.state = state;
        }

        public String getPicture_url() {
            return picture_url;
        }

        public void setPicture_url(String picture_url) {
            this.picture_url = picture_url;
        }

        public String getActivity_name() {
            return activity_name;
        }

        public void setActivity_name(String activity_name) {
            this.activity_name = activity_name;
        }

        public String getEnroll_amount() {
            return enroll_amount;
        }

        public void setEnroll_amount(String enroll_amount) {
            this.enroll_amount = enroll_amount;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }
    }*/
}
