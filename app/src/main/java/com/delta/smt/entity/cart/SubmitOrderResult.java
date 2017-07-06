package com.delta.smt.entity.cart;

import java.util.List;

/**
 * Created by Shufeng.Wu on 2017/5/16.
 */

public class SubmitOrderResult {

    /**
     * order_num : 3
     * order_ids : ["51","52","53"]
     * order_list : [{"uid":18,"address_id":10,"merchant_id":1,"supply_merchant_id":1,"order_no":"34512017042123144911","order_name":"","order_money":12.3,"order_remarks":"","user_ip":"180.88.191.195","istype":0,"deliver_fee":0,"delivery_name":"小明","delivery_location_id":110105,"delivery_phone":"15212341235","delivery_address":"某地某村","delivery_code":"110105","update_time":"2017-04-21 23:14:48","create_time":"2017-04-21 23:14:48","id":"48","order_product":[{"order_id":"48","uid":18,"product_id":8,"status":0,"num":1,"price":"12.30","amount":12.3,"id":"50"}]},{"uid":18,"address_id":10,"merchant_id":1,"supply_merchant_id":3,"order_no":"33422017042123144912","order_name":"","order_money":59.04,"order_remarks":"","user_ip":"180.88.191.195","istype":0,"deliver_fee":0,"delivery_name":"小明","delivery_location_id":110105,"delivery_phone":"15212341235","delivery_address":"某地某村","delivery_code":"110105","update_time":"2017-04-21 23:14:48","create_time":"2017-04-21 23:14:48","id":"49","order_product":[{"order_id":"49","uid":18,"product_id":40,"status":0,"num":2,"price":"29.52","amount":59.04,"id":"51"}]},{"uid":18,"address_id":10,"merchant_id":1,"supply_merchant_id":2,"order_no":"31672017042123144913","order_name":"","order_money":118.08,"order_remarks":"","user_ip":"180.88.191.195","istype":0,"deliver_fee":0,"delivery_name":"小明","delivery_location_id":110105,"delivery_phone":"15212341235","delivery_address":"某地某村","delivery_code":"110105","update_time":"2017-04-21 23:14:48","create_time":"2017-04-21 23:14:48","id":"50","order_product":[{"order_id":"50","uid":18,"product_id":42,"status":0,"num":4,"price":"29.52","amount":118.08,"id":"52"}]}]
     */

    private int order_num;
    private List<String> order_ids;
    private List<OrderListBean> order_list;

    public int getOrder_num() {
        return order_num;
    }

    public void setOrder_num(int order_num) {
        this.order_num = order_num;
    }

    public List<String> getOrder_ids() {
        return order_ids;
    }

    public void setOrder_ids(List<String> order_ids) {
        this.order_ids = order_ids;
    }

    public List<OrderListBean> getOrder_list() {
        return order_list;
    }

    public void setOrder_list(List<OrderListBean> order_list) {
        this.order_list = order_list;
    }

    public static class OrderListBean {
        /**
         * uid : 18
         * address_id : 10
         * merchant_id : 1
         * supply_merchant_id : 1
         * order_no : 34512017042123144911
         * order_name :
         * order_money : 12.3
         * order_remarks :
         * user_ip : 180.88.191.195
         * istype : 0
         * deliver_fee : 0
         * delivery_name : 小明
         * delivery_location_id : 110105
         * delivery_phone : 15212341235
         * delivery_address : 某地某村
         * delivery_code : 110105
         * update_time : 2017-04-21 23:14:48
         * create_time : 2017-04-21 23:14:48
         * id : 48
         * order_product : [{"order_id":"48","uid":18,"product_id":8,"status":0,"num":1,"price":"12.30","amount":12.3,"id":"50"}]
         */

        private int uid;
        private int address_id;
        private int merchant_id;
        private int supply_merchant_id;
        private String order_no;
        private String order_name;
        private double order_money;
        private String order_remarks;
        private String user_ip;
        private int istype;
        private int deliver_fee;
        private String delivery_name;
        private int delivery_location_id;
        private String delivery_phone;
        private String delivery_address;
        private String delivery_code;
        private String update_time;
        private String create_time;
        private String id;
        private List<OrderProductBean> order_product;

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public int getAddress_id() {
            return address_id;
        }

        public void setAddress_id(int address_id) {
            this.address_id = address_id;
        }

        public int getMerchant_id() {
            return merchant_id;
        }

        public void setMerchant_id(int merchant_id) {
            this.merchant_id = merchant_id;
        }

        public int getSupply_merchant_id() {
            return supply_merchant_id;
        }

        public void setSupply_merchant_id(int supply_merchant_id) {
            this.supply_merchant_id = supply_merchant_id;
        }

        public String getOrder_no() {
            return order_no;
        }

        public void setOrder_no(String order_no) {
            this.order_no = order_no;
        }

        public String getOrder_name() {
            return order_name;
        }

        public void setOrder_name(String order_name) {
            this.order_name = order_name;
        }

        public double getOrder_money() {
            return order_money;
        }

        public void setOrder_money(double order_money) {
            this.order_money = order_money;
        }

        public String getOrder_remarks() {
            return order_remarks;
        }

        public void setOrder_remarks(String order_remarks) {
            this.order_remarks = order_remarks;
        }

        public String getUser_ip() {
            return user_ip;
        }

        public void setUser_ip(String user_ip) {
            this.user_ip = user_ip;
        }

        public int getIstype() {
            return istype;
        }

        public void setIstype(int istype) {
            this.istype = istype;
        }

        public int getDeliver_fee() {
            return deliver_fee;
        }

        public void setDeliver_fee(int deliver_fee) {
            this.deliver_fee = deliver_fee;
        }

        public String getDelivery_name() {
            return delivery_name;
        }

        public void setDelivery_name(String delivery_name) {
            this.delivery_name = delivery_name;
        }

        public int getDelivery_location_id() {
            return delivery_location_id;
        }

        public void setDelivery_location_id(int delivery_location_id) {
            this.delivery_location_id = delivery_location_id;
        }

        public String getDelivery_phone() {
            return delivery_phone;
        }

        public void setDelivery_phone(String delivery_phone) {
            this.delivery_phone = delivery_phone;
        }

        public String getDelivery_address() {
            return delivery_address;
        }

        public void setDelivery_address(String delivery_address) {
            this.delivery_address = delivery_address;
        }

        public String getDelivery_code() {
            return delivery_code;
        }

        public void setDelivery_code(String delivery_code) {
            this.delivery_code = delivery_code;
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

        public List<OrderProductBean> getOrder_product() {
            return order_product;
        }

        public void setOrder_product(List<OrderProductBean> order_product) {
            this.order_product = order_product;
        }

        public static class OrderProductBean {
            /**
             * order_id : 48
             * uid : 18
             * product_id : 8
             * status : 0
             * num : 1
             * price : 12.30
             * amount : 12.3
             * id : 50
             */

            private String order_id;
            private int uid;
            private int product_id;
            private int status;
            private int num;
            private String price;
            private double amount;
            private String id;

            public String getOrder_id() {
                return order_id;
            }

            public void setOrder_id(String order_id) {
                this.order_id = order_id;
            }

            public int getUid() {
                return uid;
            }

            public void setUid(int uid) {
                this.uid = uid;
            }

            public int getProduct_id() {
                return product_id;
            }

            public void setProduct_id(int product_id) {
                this.product_id = product_id;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getNum() {
                return num;
            }

            public void setNum(int num) {
                this.num = num;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public double getAmount() {
                return amount;
            }

            public void setAmount(double amount) {
                this.amount = amount;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }
        }
    }
}
