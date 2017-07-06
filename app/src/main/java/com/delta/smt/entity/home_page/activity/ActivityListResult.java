package com.delta.smt.entity.home_page.activity;

import java.util.List;

/**
 * Created by Shufeng.Wu on 2017/6/2.
 */

public class ActivityListResult {


    /**
     * page : 1
     * size : 10
     * total : 2
     * list : [{"id":69,"title":"云南茶之旅","number":99,"sign_num":0,"uid":0,"merchant_id":2,"price":"1.00","start_time":1496826558,"end_time":1498813803,"image_id":"","address":"云南","images":["http://opbeh9tlb.bkt.clouddn.com/j3crrgr4_466yc83qd6gq592e87fa86153.jpg","http://opbeh9tlb.bkt.clouddn.com/j3crrq0g_4b5u04osbqpy592e88068a84c.jpg"],"content":"<p>\n\t6月7日早8点集合\n<\/p>\n<p>\n\t<img src=\"http://opbeh9tlb.bkt.clouddn.com/j2ibxomg_12pl9fa7y2wx5912724122925.jpg\" alt=\"\" /><img src=\"http://opbeh9tlb.bkt.clouddn.com/j3crrgr4_466yc83qd6gq592e87fa86153.jpg\" alt=\"\" /><img src=\"http://opbeh9tlb.bkt.clouddn.com/j3crrq0g_4b5u04osbqpy592e88068a84c.jpg\" alt=\"\" />\n<\/p>","status":1,"is_delete":0,"create_time":1496221771,"update_time":1496221771,"category_id":9,"image_url":"http://opbeh9tlb.bkt.clouddn.com/j3crrgr4_466yc83qd6gq592e87fa86153.jpg","is_signed":0,"sign_id":0,"merchant":{"id":2,"uid":2,"shop_title":"康龄轩","shop_address":"马连道","status":1,"logo_image_id":null,"app_name":"康龄轩"},"category_name":"茶旅","summary":"6月7日早8点集合"},{"id":65,"title":"r\u2006y\u2006g","number":466,"sign_num":15,"uid":0,"merchant_id":1,"price":"0.01","start_time":1537681920,"end_time":1590213120,"image_id":"98","address":"i 糊涂","images":["http://opbeh9tlb.bkt.clouddn.com/2017/05/17/c3450a2bda97046cdfec7139f13451e1.JPG"],"content":"伴奏都督？","status":0,"is_delete":0,"create_time":1495518773,"update_time":1495714936,"category_id":9,"image_url":"http://opbeh9tlb.bkt.clouddn.com/2017/05/17/c3450a2bda97046cdfec7139f13451e1.JPG","is_signed":0,"sign_id":0,"merchant":{"id":1,"uid":1,"shop_title":"伴夏商城","shop_address":"马连道","status":1,"logo_image_id":null,"app_name":"伴夏商城"},"category_name":"茶旅","summary":"伴奏都督？"}]
     */

    private String page;
    private String size;
    private int total;
    private List<ListBean> list;

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

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * id : 69
         * title : 云南茶之旅
         * number : 99
         * sign_num : 0
         * uid : 0
         * merchant_id : 2
         * price : 1.00
         * start_time : 1496826558
         * end_time : 1498813803
         * image_id :
         * address : 云南
         * images : ["http://opbeh9tlb.bkt.clouddn.com/j3crrgr4_466yc83qd6gq592e87fa86153.jpg","http://opbeh9tlb.bkt.clouddn.com/j3crrq0g_4b5u04osbqpy592e88068a84c.jpg"]
         * content : <p>
         6月7日早8点集合
         </p>
         <p>
         <img src="http://opbeh9tlb.bkt.clouddn.com/j2ibxomg_12pl9fa7y2wx5912724122925.jpg" alt="" /><img src="http://opbeh9tlb.bkt.clouddn.com/j3crrgr4_466yc83qd6gq592e87fa86153.jpg" alt="" /><img src="http://opbeh9tlb.bkt.clouddn.com/j3crrq0g_4b5u04osbqpy592e88068a84c.jpg" alt="" />
         </p>
         * status : 1
         * is_delete : 0
         * create_time : 1496221771
         * update_time : 1496221771
         * category_id : 9
         * image_url : http://opbeh9tlb.bkt.clouddn.com/j3crrgr4_466yc83qd6gq592e87fa86153.jpg
         * is_signed : 0
         * sign_id : 0
         * merchant : {"id":2,"uid":2,"shop_title":"康龄轩","shop_address":"马连道","status":1,"logo_image_id":null,"app_name":"康龄轩"}
         * category_name : 茶旅
         * summary : 6月7日早8点集合
         */

        private int id;
        private String title;
        private String number;
        private String sign_num;
        private String uid;
        private String merchant_id;
        private String price;
        private long start_time;
        private long end_time;
        private String image_id;
        private String address;
        private String content;
        private String status;
        private String is_delete;
        private long create_time;
        private long update_time;
        private String category_id;
        private String image_url;
        private String is_signed;
        private String sign_id;
        private MerchantBean merchant;
        private String category_name;
        private String summary;
        private List<String> images;

        public int getId() {
            return id;
        }

        public void setId(int id) {
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

        public long getStart_time() {
            return start_time;
        }

        public void setStart_time(long start_time) {
            this.start_time = start_time;
        }

        public long getEnd_time() {
            return end_time;
        }

        public void setEnd_time(long end_time) {
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

        public long getCreate_time() {
            return create_time;
        }

        public void setCreate_time(long create_time) {
            this.create_time = create_time;
        }

        public long getUpdate_time() {
            return update_time;
        }

        public void setUpdate_time(long update_time) {
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

        public MerchantBean getMerchant() {
            return merchant;
        }

        public void setMerchant(MerchantBean merchant) {
            this.merchant = merchant;
        }

        public String getCategory_name() {
            return category_name;
        }

        public void setCategory_name(String category_name) {
            this.category_name = category_name;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }

        public static class MerchantBean {
            /**
             * id : 2
             * uid : 2
             * shop_title : 康龄轩
             * shop_address : 马连道
             * status : 1
             * logo_image_id : null
             * app_name : 康龄轩
             */

            private int id;
            private int uid;
            private String shop_title;
            private String shop_address;
            private int status;
            private Object logo_image_id;
            private String app_name;

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

            public String getShop_title() {
                return shop_title;
            }

            public void setShop_title(String shop_title) {
                this.shop_title = shop_title;
            }

            public String getShop_address() {
                return shop_address;
            }

            public void setShop_address(String shop_address) {
                this.shop_address = shop_address;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public Object getLogo_image_id() {
                return logo_image_id;
            }

            public void setLogo_image_id(Object logo_image_id) {
                this.logo_image_id = logo_image_id;
            }

            public String getApp_name() {
                return app_name;
            }

            public void setApp_name(String app_name) {
                this.app_name = app_name;
            }
        }
    }
}
