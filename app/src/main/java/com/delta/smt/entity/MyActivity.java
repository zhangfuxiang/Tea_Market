package com.delta.smt.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/5/17.
 */

public class MyActivity {


    /**
     * app_code : 22000
     * app_msg :
     * result : {"total":1,"page":1,"size":"1","list":[{"id":5,"uid":39,"activity_id":60,"from_merchant_id":2,"pay_status":2,"status":1,"create_time":1495439330,"update_time":1495439330,"pay_type":3,"pay_no":null,"balance":"999.00","total":"999.00","activity":{"id":60,"title":"国际茶贸易20国集团峰会","number":999,"sign_num":6,"uid":0,"merchant_id":2,"price":"999.00","start_time":1495606367,"end_time":1496124772,"image_id":"","address":"鸟巢","images":["http://opbeh9tlb.bkt.clouddn.com/j2pjd95s_2z6e2gq08in8591918645fafc.jpg"],"content":"<img src=\"http://opbeh9tlb.bkt.clouddn.com/j2ju90lk_7fe0ayfqtxul5913d69deeb1a.jpg\" alt=\"\" />","status":0,"is_delete":0,"create_time":1495433438,"update_time":1495438119,"category_id":9,"image_url":"http://opbeh9tlb.bkt.clouddn.com/j2pjd95s_2z6e2gq08in8591918645fafc.jpg","is_signed":1,"sign_id":5,"merchant":{"id":2,"uid":2,"shop_title":"康龄轩","shop_address":"马连道","status":1,"logo_image_id":null,"app_name":"康龄轩"},"category_name":"茶旅","summary":""}}]}
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
         * total : 1
         * page : 1
         * size : 1
         * list : [{"id":5,"uid":39,"activity_id":60,"from_merchant_id":2,"pay_status":2,"status":1,"create_time":1495439330,"update_time":1495439330,"pay_type":3,"pay_no":null,"balance":"999.00","total":"999.00","activity":{"id":60,"title":"国际茶贸易20国集团峰会","number":999,"sign_num":6,"uid":0,"merchant_id":2,"price":"999.00","start_time":1495606367,"end_time":1496124772,"image_id":"","address":"鸟巢","images":["http://opbeh9tlb.bkt.clouddn.com/j2pjd95s_2z6e2gq08in8591918645fafc.jpg"],"content":"<img src=\"http://opbeh9tlb.bkt.clouddn.com/j2ju90lk_7fe0ayfqtxul5913d69deeb1a.jpg\" alt=\"\" />","status":0,"is_delete":0,"create_time":1495433438,"update_time":1495438119,"category_id":9,"image_url":"http://opbeh9tlb.bkt.clouddn.com/j2pjd95s_2z6e2gq08in8591918645fafc.jpg","is_signed":1,"sign_id":5,"merchant":{"id":2,"uid":2,"shop_title":"康龄轩","shop_address":"马连道","status":1,"logo_image_id":null,"app_name":"康龄轩"},"category_name":"茶旅","summary":""}}]
         */

        private int total;
        private int page;
        private String size;
        private List<ListEntity> list;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
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
             * uid : 39
             * activity_id : 60
             * from_merchant_id : 2
             * pay_status : 2
             * status : 1
             * create_time : 1495439330
             * update_time : 1495439330
             * pay_type : 3
             * pay_no : null
             * balance : 999.00
             * total : 999.00
             * activity : {"id":60,"title":"国际茶贸易20国集团峰会","number":999,"sign_num":6,"uid":0,"merchant_id":2,"price":"999.00","start_time":1495606367,"end_time":1496124772,"image_id":"","address":"鸟巢","images":["http://opbeh9tlb.bkt.clouddn.com/j2pjd95s_2z6e2gq08in8591918645fafc.jpg"],"content":"<img src=\"http://opbeh9tlb.bkt.clouddn.com/j2ju90lk_7fe0ayfqtxul5913d69deeb1a.jpg\" alt=\"\" />","status":0,"is_delete":0,"create_time":1495433438,"update_time":1495438119,"category_id":9,"image_url":"http://opbeh9tlb.bkt.clouddn.com/j2pjd95s_2z6e2gq08in8591918645fafc.jpg","is_signed":1,"sign_id":5,"merchant":{"id":2,"uid":2,"shop_title":"康龄轩","shop_address":"马连道","status":1,"logo_image_id":null,"app_name":"康龄轩"},"category_name":"茶旅","summary":""}
             */

            private int id;
            private int uid;
            private int activity_id;
            private int from_merchant_id;
            private int pay_status;
            private int status;
            private int create_time;
            private int update_time;
            private int pay_type;
            private Object pay_no;
            private String balance;
            private String total;
            private ActivityEntity activity;

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

            public int getActivity_id() {
                return activity_id;
            }

            public void setActivity_id(int activity_id) {
                this.activity_id = activity_id;
            }

            public int getFrom_merchant_id() {
                return from_merchant_id;
            }

            public void setFrom_merchant_id(int from_merchant_id) {
                this.from_merchant_id = from_merchant_id;
            }

            public int getPay_status() {
                return pay_status;
            }

            public void setPay_status(int pay_status) {
                this.pay_status = pay_status;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getCreate_time() {
                return create_time;
            }

            public void setCreate_time(int create_time) {
                this.create_time = create_time;
            }

            public int getUpdate_time() {
                return update_time;
            }

            public void setUpdate_time(int update_time) {
                this.update_time = update_time;
            }

            public int getPay_type() {
                return pay_type;
            }

            public void setPay_type(int pay_type) {
                this.pay_type = pay_type;
            }

            public Object getPay_no() {
                return pay_no;
            }

            public void setPay_no(Object pay_no) {
                this.pay_no = pay_no;
            }

            public String getBalance() {
                return balance;
            }

            public void setBalance(String balance) {
                this.balance = balance;
            }

            public String getTotal() {
                return total;
            }

            public void setTotal(String total) {
                this.total = total;
            }

            public ActivityEntity getActivity() {
                return activity;
            }

            public void setActivity(ActivityEntity activity) {
                this.activity = activity;
            }

            public static class ActivityEntity {
                /**
                 * id : 60
                 * title : 国际茶贸易20国集团峰会
                 * number : 999
                 * sign_num : 6
                 * uid : 0
                 * merchant_id : 2
                 * price : 999.00
                 * start_time : 1495606367
                 * end_time : 1496124772
                 * image_id :
                 * address : 鸟巢
                 * images : ["http://opbeh9tlb.bkt.clouddn.com/j2pjd95s_2z6e2gq08in8591918645fafc.jpg"]
                 * content : <img src="http://opbeh9tlb.bkt.clouddn.com/j2ju90lk_7fe0ayfqtxul5913d69deeb1a.jpg" alt="" />
                 * status : 0
                 * is_delete : 0
                 * create_time : 1495433438
                 * update_time : 1495438119
                 * category_id : 9
                 * image_url : http://opbeh9tlb.bkt.clouddn.com/j2pjd95s_2z6e2gq08in8591918645fafc.jpg
                 * is_signed : 1
                 * sign_id : 5
                 * merchant : {"id":2,"uid":2,"shop_title":"康龄轩","shop_address":"马连道","status":1,"logo_image_id":null,"app_name":"康龄轩"}
                 * category_name : 茶旅
                 * summary :
                 */

                private int id;
                private String title;
                private int number;
                private int sign_num;
                private int uid;
                private int merchant_id;
                private String price;
                private String start_time;
                private String end_time;
                private String image_id;
                private String address;
                private String content;
                private int status;
                private int is_delete;
                private int create_time;
                private int update_time;
                private int category_id;
                private String image_url;
                private int is_signed;
                private int sign_id;
                private MerchantEntity merchant;
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

                public int getNumber() {
                    return number;
                }

                public void setNumber(int number) {
                    this.number = number;
                }

                public int getSign_num() {
                    return sign_num;
                }

                public void setSign_num(int sign_num) {
                    this.sign_num = sign_num;
                }

                public int getUid() {
                    return uid;
                }

                public void setUid(int uid) {
                    this.uid = uid;
                }

                public int getMerchant_id() {
                    return merchant_id;
                }

                public void setMerchant_id(int merchant_id) {
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

                public int getCreate_time() {
                    return create_time;
                }

                public void setCreate_time(int create_time) {
                    this.create_time = create_time;
                }

                public int getUpdate_time() {
                    return update_time;
                }

                public void setUpdate_time(int update_time) {
                    this.update_time = update_time;
                }

                public int getCategory_id() {
                    return category_id;
                }

                public void setCategory_id(int category_id) {
                    this.category_id = category_id;
                }

                public String getImage_url() {
                    return image_url;
                }

                public void setImage_url(String image_url) {
                    this.image_url = image_url;
                }

                public int getIs_signed() {
                    return is_signed;
                }

                public void setIs_signed(int is_signed) {
                    this.is_signed = is_signed;
                }

                public int getSign_id() {
                    return sign_id;
                }

                public void setSign_id(int sign_id) {
                    this.sign_id = sign_id;
                }

                public MerchantEntity getMerchant() {
                    return merchant;
                }

                public void setMerchant(MerchantEntity merchant) {
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

                public static class MerchantEntity {
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
    }
}
