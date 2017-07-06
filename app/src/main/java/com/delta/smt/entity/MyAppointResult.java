package com.delta.smt.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/5/17.
 */

public class MyAppointResult {

    /**
     * app_code : 22000
     * app_msg :
     * result : {"total":6,"size":"1","page":1,"list":[{"id":38,"merchant_id":1,"phone":"15210954985","shop_id":2,"uid":46,"room_num":1,"start_time":1495123200,"end_time":1495209600,"bespeak_time":1493571620,"to_time":1495123200,"remarks":"喝茶","number":2716208954,"status":0,"is_delete":0,"create_time":1493571620,"update_time":1493571714,"name":"赵剑","is_self_member":0,"user":{"id":46,"name":"赵剑","phone":"15210954985","sex":1,"create_time":1493435120,"balance":"9074.80","image_url":"http://tea.api.test.sygcsoft.com/public/static/images/default_avatar3.png","merchant_id":1},"user_merchant":{"id":1,"uid":12,"shop_title":" Jesse茶商","shop_address":null,"status":1},"shop":{"id":null,"merchant_id":null,"username":null,"shopname":null,"phone":null,"shopaddress":null,"price":null,"image_id":null,"image_url":null}}]}
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
         * total : 6
         * size : 1
         * page : 1
         * list : [{"id":38,"merchant_id":1,"phone":"15210954985","shop_id":2,"uid":46,"room_num":1,"start_time":1495123200,"end_time":1495209600,"bespeak_time":1493571620,"to_time":1495123200,"remarks":"喝茶","number":2716208954,"status":0,"is_delete":0,"create_time":1493571620,"update_time":1493571714,"name":"赵剑","is_self_member":0,"user":{"id":46,"name":"赵剑","phone":"15210954985","sex":1,"create_time":1493435120,"balance":"9074.80","image_url":"http://tea.api.test.sygcsoft.com/public/static/images/default_avatar3.png","merchant_id":1},"user_merchant":{"id":1,"uid":12,"shop_title":" Jesse茶商","shop_address":null,"status":1},"shop":{"id":null,"merchant_id":null,"username":null,"shopname":null,"phone":null,"shopaddress":null,"price":null,"image_id":null,"image_url":null}}]
         */

        private int total;
        private String size;
        private int page;
        private List<ListEntity> list;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
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

        public static class ListEntity implements Serializable {
            /**
             * id : 38
             * merchant_id : 1
             * phone : 15210954985
             * shop_id : 2
             * uid : 46
             * room_num : 1
             * start_time : 1495123200
             * end_time : 1495209600
             * bespeak_time : 1493571620
             * to_time : 1495123200
             * remarks : 喝茶
             * number : 2716208954
             * status : 0
             * is_delete : 0
             * create_time : 1493571620
             * update_time : 1493571714
             * name : 赵剑
             * is_self_member : 0
             * user : {"id":46,"name":"赵剑","phone":"15210954985","sex":1,"create_time":1493435120,"balance":"9074.80","image_url":"http://tea.api.test.sygcsoft.com/public/static/images/default_avatar3.png","merchant_id":1}
             * user_merchant : {"id":1,"uid":12,"shop_title":" Jesse茶商","shop_address":null,"status":1}
             * shop : {"id":null,"merchant_id":null,"username":null,"shopname":null,"phone":null,"shopaddress":null,"price":null,"image_id":null,"image_url":null}
             */

            private int id;
            private int merchant_id;
            private String phone;
            private int shop_id;
            private int uid;
            private int room_num;
            private String start_time;
            private String end_time;
            private String bespeak_time;
            private String to_time;
            private String remarks;
            private long number;
            private int status;
            private int is_delete;
            private String create_time;
            private String update_time;
            private String name;

            public void setStart_time(String start_time) {
                this.start_time = start_time;
            }

            public void setEnd_time(String end_time) {
                this.end_time = end_time;
            }

            public void setBespeak_time(String bespeak_time) {
                this.bespeak_time = bespeak_time;
            }

            public String getTo_time() {
                return to_time;
            }

            public void setTo_time(String to_time) {
                this.to_time = to_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public void setUpdate_time(String update_time) {
                this.update_time = update_time;
            }

            private int is_self_member;
            private UserEntity user;
            private UserMerchantEntity user_merchant;
            private ShopEntity shop;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
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

            public int getShop_id() {
                return shop_id;
            }

            public void setShop_id(int shop_id) {
                this.shop_id = shop_id;
            }

            public int getUid() {
                return uid;
            }

            public void setUid(int uid) {
                this.uid = uid;
            }

            public int getRoom_num() {
                return room_num;
            }

            public void setRoom_num(int room_num) {
                this.room_num = room_num;
            }



            public String getBespeak_time() {
                return bespeak_time;
            }


            public String getRemarks() {
                return remarks;
            }

            public void setRemarks(String remarks) {
                this.remarks = remarks;
            }

            public long getNumber() {
                return number;
            }

            public void setNumber(long number) {
                this.number = number;
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

            public String getStart_time() {
                return start_time;
            }

            public String getEnd_time() {
                return end_time;
            }

            public String getCreate_time() {
                return create_time;
            }

            public String getUpdate_time() {
                return update_time;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getIs_self_member() {
                return is_self_member;
            }

            public void setIs_self_member(int is_self_member) {
                this.is_self_member = is_self_member;
            }

            public UserEntity getUser() {
                return user;
            }

            public void setUser(UserEntity user) {
                this.user = user;
            }

            public UserMerchantEntity getUser_merchant() {
                return user_merchant;
            }

            public void setUser_merchant(UserMerchantEntity user_merchant) {
                this.user_merchant = user_merchant;
            }

            public ShopEntity getShop() {
                return shop;
            }

            public void setShop(ShopEntity shop) {
                this.shop = shop;
            }

            public static class UserEntity {
                /**
                 * id : 46
                 * name : 赵剑
                 * phone : 15210954985
                 * sex : 1
                 * create_time : 1493435120
                 * balance : 9074.80
                 * image_url : http://tea.api.test.sygcsoft.com/public/static/images/default_avatar3.png
                 * merchant_id : 1
                 */

                private int id;
                private String name;
                private String phone;
                private int sex;
                private int create_time;
                private String balance;
                private String image_url;
                private int merchant_id;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getPhone() {
                    return phone;
                }

                public void setPhone(String phone) {
                    this.phone = phone;
                }

                public int getSex() {
                    return sex;
                }

                public void setSex(int sex) {
                    this.sex = sex;
                }

                public int getCreate_time() {
                    return create_time;
                }

                public void setCreate_time(int create_time) {
                    this.create_time = create_time;
                }

                public String getBalance() {
                    return balance;
                }

                public void setBalance(String balance) {
                    this.balance = balance;
                }

                public String getImage_url() {
                    return image_url;
                }

                public void setImage_url(String image_url) {
                    this.image_url = image_url;
                }

                public int getMerchant_id() {
                    return merchant_id;
                }

                public void setMerchant_id(int merchant_id) {
                    this.merchant_id = merchant_id;
                }
            }

            public static class UserMerchantEntity {
                /**
                 * id : 1
                 * uid : 12
                 * shop_title :  Jesse茶商
                 * shop_address : null
                 * status : 1
                 */

                private int id;
                private int uid;
                private String shop_title;
                private Object shop_address;
                private int status;

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

                public Object getShop_address() {
                    return shop_address;
                }

                public void setShop_address(Object shop_address) {
                    this.shop_address = shop_address;
                }

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
                }
            }

            public static class ShopEntity {
                /**
                 * id : null
                 * merchant_id : null
                 * username : null
                 * shopname : null
                 * phone : null
                 * shopaddress : null
                 * price : null
                 * image_id : null
                 * image_url : null
                 */

                private Object id;
                private Object merchant_id;
                private Object username;
                private Object shopname;
                private Object phone;
                private Object shopaddress;
                private Object price;
                private Object image_id;
                private Object image_url;

                public Object getId() {
                    return id;
                }

                public void setId(Object id) {
                    this.id = id;
                }

                public Object getMerchant_id() {
                    return merchant_id;
                }

                public void setMerchant_id(Object merchant_id) {
                    this.merchant_id = merchant_id;
                }

                public Object getUsername() {
                    return username;
                }

                public void setUsername(Object username) {
                    this.username = username;
                }

                public Object getShopname() {
                    return shopname;
                }

                public void setShopname(Object shopname) {
                    this.shopname = shopname;
                }

                public Object getPhone() {
                    return phone;
                }

                public void setPhone(Object phone) {
                    this.phone = phone;
                }

                public Object getShopaddress() {
                    return shopaddress;
                }

                public void setShopaddress(Object shopaddress) {
                    this.shopaddress = shopaddress;
                }

                public Object getPrice() {
                    return price;
                }

                public void setPrice(Object price) {
                    this.price = price;
                }

                public Object getImage_id() {
                    return image_id;
                }

                public void setImage_id(Object image_id) {
                    this.image_id = image_id;
                }

                public Object getImage_url() {
                    return image_url;
                }

                public void setImage_url(Object image_url) {
                    this.image_url = image_url;
                }
            }
        }
    }
}
