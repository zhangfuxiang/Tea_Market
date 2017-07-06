package com.delta.smt.entity.drinktea;

import java.util.List;

/**
 * Created by wushufeng on 2017/5/14.
 */

public class ShopListResult {

    /**
     * page : 1
     * size : 10
     * total : 2
     * list : [{"id":18,"merchant_id":1,"uid":12,"username":"赵老板","phone":null,"shopname":"瑾煊听雨轩2","image_id":7,"location_id":110105,"shopaddress":"央视大楼111层","license_image_id":"0","certificate_image_id":"0","price":"291.00","status":1,"create_time":"2017-04-26 23:06:41","update_time":"2017-04-26 23:06:41","province":"北京市","city":"市辖区","area":"朝阳区","image_url":"http://on1z8q8is.bkt.clouddn.com//2017/04/03/4174d6fc0021b18f4e0069a049a1ec0b.jpg","license_image_url":"","certificate_image_url":"","merchant":{"id":1,"uid":12,"shop_title":" Jesse茶商","shop_address":null,"status":1}},{"id":17,"merchant_id":1,"uid":12,"username":"赵老板","phone":"15210954985","shopname":"瑾煊听雨轩","image_id":8,"location_id":110105,"shopaddress":"央视大楼111层","license_image_id":"0","certificate_image_id":"0","price":"291.00","status":1,"create_time":"2017-04-26 23:01:25","update_time":"2017-04-26 23:01:25","province":"北京市","city":"市辖区","area":"朝阳区","image_url":"http://on1z8q8is.bkt.clouddn.com//2017/04/03/27fe5b13f0171ce2757d0f5efc2f1a51.jpg","license_image_url":"","certificate_image_url":""}]
     */

    private int page;
    private String size;
    private int total;
    private List<ListBean> list;

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
         * id : 18
         * merchant_id : 1
         * uid : 12
         * username : 赵老板
         * phone : null
         * shopname : 瑾煊听雨轩2
         * image_id : 7
         * location_id : 110105
         * shopaddress : 央视大楼111层
         * license_image_id : 0
         * certificate_image_id : 0
         * price : 291.00
         * status : 1
         * create_time : 2017-04-26 23:06:41
         * update_time : 2017-04-26 23:06:41
         * province : 北京市
         * city : 市辖区
         * area : 朝阳区
         * image_url : http://on1z8q8is.bkt.clouddn.com//2017/04/03/4174d6fc0021b18f4e0069a049a1ec0b.jpg
         * license_image_url :
         * certificate_image_url :
         * merchant : {"id":1,"uid":12,"shop_title":" Jesse茶商","shop_address":null,"status":1}
         */

        private int id;
        private int merchant_id;
        private int uid;
        private String username;
        private String phone;
        private String shopname;
        private int image_id;
        private int location_id;
        private String shopaddress;
        private String license_image_id;
        private String certificate_image_id;
        private String price;
        private int status;
        private String create_time;
        private String update_time;
        private String province;
        private String city;
        private String area;
        private String image_url;
        private String license_image_url;
        private String certificate_image_url;
        private MerchantBean merchant;

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

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getShopname() {
            return shopname;
        }

        public void setShopname(String shopname) {
            this.shopname = shopname;
        }

        public int getImage_id() {
            return image_id;
        }

        public void setImage_id(int image_id) {
            this.image_id = image_id;
        }

        public int getLocation_id() {
            return location_id;
        }

        public void setLocation_id(int location_id) {
            this.location_id = location_id;
        }

        public String getShopaddress() {
            return shopaddress;
        }

        public void setShopaddress(String shopaddress) {
            this.shopaddress = shopaddress;
        }

        public String getLicense_image_id() {
            return license_image_id;
        }

        public void setLicense_image_id(String license_image_id) {
            this.license_image_id = license_image_id;
        }

        public String getCertificate_image_id() {
            return certificate_image_id;
        }

        public void setCertificate_image_id(String certificate_image_id) {
            this.certificate_image_id = certificate_image_id;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
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

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getImage_url() {
            return image_url;
        }

        public void setImage_url(String image_url) {
            this.image_url = image_url;
        }

        public String getLicense_image_url() {
            return license_image_url;
        }

        public void setLicense_image_url(String license_image_url) {
            this.license_image_url = license_image_url;
        }

        public String getCertificate_image_url() {
            return certificate_image_url;
        }

        public void setCertificate_image_url(String certificate_image_url) {
            this.certificate_image_url = certificate_image_url;
        }

        public MerchantBean getMerchant() {
            return merchant;
        }

        public void setMerchant(MerchantBean merchant) {
            this.merchant = merchant;
        }

        public static class MerchantBean {
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
            private String shop_address;
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
        }
    }
}
