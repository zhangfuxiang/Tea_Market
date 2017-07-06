package com.delta.smt.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/5/25.
 */

public class ProductDetails {

    /**
     * app_code : 22000
     * app_msg :
     * result : {"product":{"id":26,"category_id":0,"merchant_id":1,"title":"少平的店铺_商品_5","price":"73.80","suggest_price":"73.80","system_price":"61.50","sales":0,"details":"<h1>少平的店铺_商品_5<h1> 测试用商品描述","status":1,"is_delete":0,"is_system":0,"is_sale":1,"is_edit":0,"allow_other_sale":0,"create_time":1491191205,"update_time":1491191205,"parent_id":24,"submit_status":3,"submit_time":0,"merchant":{"id":1,"shop_title":" Jesse茶商","shop_address":null},"supply_merchant":{"id":2,"uid":13,"shop_title":"少平的店铺","shop_address":null,"status":1},"images":[{"id":54,"product_id":26,"image_id":3,"status":1,"order_no":1,"type":1,"is_main":1,"url":"http://on1z8q8is.bkt.clouddn.com/j0hjtkew_1lkgxltijfms58cf4baf33630.jpg"},{"id":55,"product_id":26,"image_id":4,"status":1,"order_no":2,"type":1,"is_main":0,"url":"http://on1z8q8is.bkt.clouddn.com/j0hjuquo_49m6w34h3u2o58cf4be6891ee.jpg"}],"param":[{"id":106,"product_id":26,"name":"单位","value":"袋","order_no":1,"status":1},{"id":107,"product_id":26,"name":"重量","value":"5g","order_no":1,"status":1},{"id":108,"product_id":26,"name":"评级","value":"2级","order_no":1,"status":1},{"id":109,"product_id":26,"name":"颜色","value":"褐色","order_no":1,"status":1}]}}
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
         * product : {"id":26,"category_id":0,"merchant_id":1,"title":"少平的店铺_商品_5","price":"73.80","suggest_price":"73.80","system_price":"61.50","sales":0,"details":"<h1>少平的店铺_商品_5<h1> 测试用商品描述","status":1,"is_delete":0,"is_system":0,"is_sale":1,"is_edit":0,"allow_other_sale":0,"create_time":1491191205,"update_time":1491191205,"parent_id":24,"submit_status":3,"submit_time":0,"merchant":{"id":1,"shop_title":" Jesse茶商","shop_address":null},"supply_merchant":{"id":2,"uid":13,"shop_title":"少平的店铺","shop_address":null,"status":1},"images":[{"id":54,"product_id":26,"image_id":3,"status":1,"order_no":1,"type":1,"is_main":1,"url":"http://on1z8q8is.bkt.clouddn.com/j0hjtkew_1lkgxltijfms58cf4baf33630.jpg"},{"id":55,"product_id":26,"image_id":4,"status":1,"order_no":2,"type":1,"is_main":0,"url":"http://on1z8q8is.bkt.clouddn.com/j0hjuquo_49m6w34h3u2o58cf4be6891ee.jpg"}],"param":[{"id":106,"product_id":26,"name":"单位","value":"袋","order_no":1,"status":1},{"id":107,"product_id":26,"name":"重量","value":"5g","order_no":1,"status":1},{"id":108,"product_id":26,"name":"评级","value":"2级","order_no":1,"status":1},{"id":109,"product_id":26,"name":"颜色","value":"褐色","order_no":1,"status":1}]}
         */

        private ProductEntity product;

        public ProductEntity getProduct() {
            return product;
        }

        public void setProduct(ProductEntity product) {
            this.product = product;
        }

        public static class ProductEntity {
            /**
             * id : 26
             * category_id : 0
             * merchant_id : 1
             * title : 少平的店铺_商品_5
             * price : 73.80
             * suggest_price : 73.80
             * system_price : 61.50
             * sales : 0
             * details : <h1>少平的店铺_商品_5<h1> 测试用商品描述
             * status : 1
             * is_delete : 0
             * is_system : 0
             * is_sale : 1
             * is_edit : 0
             * allow_other_sale : 0
             * create_time : 1491191205
             * update_time : 1491191205
             * parent_id : 24
             * submit_status : 3
             * submit_time : 0
             * merchant : {"id":1,"shop_title":" Jesse茶商","shop_address":null}
             * supply_merchant : {"id":2,"uid":13,"shop_title":"少平的店铺","shop_address":null,"status":1}
             * images : [{"id":54,"product_id":26,"image_id":3,"status":1,"order_no":1,"type":1,"is_main":1,"url":"http://on1z8q8is.bkt.clouddn.com/j0hjtkew_1lkgxltijfms58cf4baf33630.jpg"},{"id":55,"product_id":26,"image_id":4,"status":1,"order_no":2,"type":1,"is_main":0,"url":"http://on1z8q8is.bkt.clouddn.com/j0hjuquo_49m6w34h3u2o58cf4be6891ee.jpg"}]
             * param : [{"id":106,"product_id":26,"name":"单位","value":"袋","order_no":1,"status":1},{"id":107,"product_id":26,"name":"重量","value":"5g","order_no":1,"status":1},{"id":108,"product_id":26,"name":"评级","value":"2级","order_no":1,"status":1},{"id":109,"product_id":26,"name":"颜色","value":"褐色","order_no":1,"status":1}]
             */

            private int id;
            private int category_id;
            private int merchant_id;
            private String title;
            private String price;
            private String suggest_price;
            private String system_price;
            private int sales;
            private String details;
            private int status;
            private int is_delete;
            private int is_system;
            private int is_sale;
            private int is_edit;
            private int allow_other_sale;
            private int create_time;
            private int update_time;
            private int parent_id;
            private int submit_status;
            private int submit_time;
            private MerchantEntity merchant;
            private SupplyMerchantEntity supply_merchant;
            private List<ImagesEntity> images;
            private List<ParamEntity> param;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getCategory_id() {
                return category_id;
            }

            public void setCategory_id(int category_id) {
                this.category_id = category_id;
            }

            public int getMerchant_id() {
                return merchant_id;
            }

            public void setMerchant_id(int merchant_id) {
                this.merchant_id = merchant_id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getSuggest_price() {
                return suggest_price;
            }

            public void setSuggest_price(String suggest_price) {
                this.suggest_price = suggest_price;
            }

            public String getSystem_price() {
                return system_price;
            }

            public void setSystem_price(String system_price) {
                this.system_price = system_price;
            }

            public int getSales() {
                return sales;
            }

            public void setSales(int sales) {
                this.sales = sales;
            }

            public String getDetails() {
                return details;
            }

            public void setDetails(String details) {
                this.details = details;
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

            public int getIs_system() {
                return is_system;
            }

            public void setIs_system(int is_system) {
                this.is_system = is_system;
            }

            public int getIs_sale() {
                return is_sale;
            }

            public void setIs_sale(int is_sale) {
                this.is_sale = is_sale;
            }

            public int getIs_edit() {
                return is_edit;
            }

            public void setIs_edit(int is_edit) {
                this.is_edit = is_edit;
            }

            public int getAllow_other_sale() {
                return allow_other_sale;
            }

            public void setAllow_other_sale(int allow_other_sale) {
                this.allow_other_sale = allow_other_sale;
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

            public int getParent_id() {
                return parent_id;
            }

            public void setParent_id(int parent_id) {
                this.parent_id = parent_id;
            }

            public int getSubmit_status() {
                return submit_status;
            }

            public void setSubmit_status(int submit_status) {
                this.submit_status = submit_status;
            }

            public int getSubmit_time() {
                return submit_time;
            }

            public void setSubmit_time(int submit_time) {
                this.submit_time = submit_time;
            }

            public MerchantEntity getMerchant() {
                return merchant;
            }

            public void setMerchant(MerchantEntity merchant) {
                this.merchant = merchant;
            }

            public SupplyMerchantEntity getSupply_merchant() {
                return supply_merchant;
            }

            public void setSupply_merchant(SupplyMerchantEntity supply_merchant) {
                this.supply_merchant = supply_merchant;
            }

            public List<ImagesEntity> getImages() {
                return images;
            }

            public void setImages(List<ImagesEntity> images) {
                this.images = images;
            }

            public List<ParamEntity> getParam() {
                return param;
            }

            public void setParam(List<ParamEntity> param) {
                this.param = param;
            }

            public static class MerchantEntity {
                /**
                 * id : 1
                 * shop_title :  Jesse茶商
                 * shop_address : null
                 */

                private int id;
                private String shop_title;
                private Object shop_address;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
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
            }

            public static class SupplyMerchantEntity {
                /**
                 * id : 2
                 * uid : 13
                 * shop_title : 少平的店铺
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

            public static class ImagesEntity {
                /**
                 * id : 54
                 * product_id : 26
                 * image_id : 3
                 * status : 1
                 * order_no : 1
                 * type : 1
                 * is_main : 1
                 * url : http://on1z8q8is.bkt.clouddn.com/j0hjtkew_1lkgxltijfms58cf4baf33630.jpg
                 */

                private int id;
                private int product_id;
                private int image_id;
                private int status;
                private int order_no;
                private int type;
                private int is_main;
                private String url;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getProduct_id() {
                    return product_id;
                }

                public void setProduct_id(int product_id) {
                    this.product_id = product_id;
                }

                public int getImage_id() {
                    return image_id;
                }

                public void setImage_id(int image_id) {
                    this.image_id = image_id;
                }

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
                }

                public int getOrder_no() {
                    return order_no;
                }

                public void setOrder_no(int order_no) {
                    this.order_no = order_no;
                }

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }

                public int getIs_main() {
                    return is_main;
                }

                public void setIs_main(int is_main) {
                    this.is_main = is_main;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }

            public static class ParamEntity {
                /**
                 * id : 106
                 * product_id : 26
                 * name : 单位
                 * value : 袋
                 * order_no : 1
                 * status : 1
                 */

                private int id;
                private int product_id;
                private String name;
                private String value;
                private int order_no;
                private int status;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getProduct_id() {
                    return product_id;
                }

                public void setProduct_id(int product_id) {
                    this.product_id = product_id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }

                public int getOrder_no() {
                    return order_no;
                }

                public void setOrder_no(int order_no) {
                    this.order_no = order_no;
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
}
