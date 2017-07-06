package com.delta.smt.entity.cart;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wushufeng on 2017/4/29.
 */

public class CartListResult implements Serializable {

    /**
     * app_code : 22000
     * app_msg :
     * result : {"cart":[{"product_id":32,"num":30,"product":{"id":32,"category_id":8,"merchant_id":8,"title":"demo_商品_5","price":"61.50","suggest_price":"73.80","system_price":"61.50","sales":0,"status":1,"is_delete":0,"is_system":1,"is_sale":1,"is_edit":0,"allow_other_sale":1,"create_time":"2017-04-10 12:22:42","update_time":"2017-04-10 12:22:42","parent_id":0,"submit_status":1,"submit_time":0,"supply_merchant_id":8,"num":0,"type":1,"merchant":{"id":8,"shop_title":"demo","shop_address":null},"supply_merchant":{"id":8,"shop_title":"demo","shop_address":null},"images":[{"id":66,"product_id":32,"image_id":3,"status":1,"order_no":1,"type":1,"is_main":1,"url":"http://on1z8q8is.bkt.clouddn.com/j0hjtkew_1lkgxltijfms58cf4baf33630.jpg"},{"id":67,"product_id":32,"image_id":4,"status":1,"order_no":2,"type":1,"is_main":0,"url":"http://on1z8q8is.bkt.clouddn.com/j0hjuquo_49m6w34h3u2o58cf4be6891ee.jpg"}],"param":[{"id":126,"product_id":32,"name":"单位","value":"袋","order_no":1,"status":1},{"id":127,"product_id":32,"name":"重量","value":"5g","order_no":1,"status":1},{"id":128,"product_id":32,"name":"评级","value":"2级","order_no":1,"status":1},{"id":129,"product_id":32,"name":"颜色","value":"褐色","order_no":1,"status":1}]}}]}
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

    public static class ResultBean implements Serializable {
        private List<CartBean> cart;

        public List<CartBean> getCart() {
            return cart;
        }

        public void setCart(List<CartBean> cart) {
            this.cart = cart;
        }

        public static class CartBean implements Serializable {
            /**
             * product_id : 32
             * num : 30
             * product : {"id":32,"category_id":8,"merchant_id":8,"title":"demo_商品_5","price":"61.50","suggest_price":"73.80","system_price":"61.50","sales":0,"status":1,"is_delete":0,"is_system":1,"is_sale":1,"is_edit":0,"allow_other_sale":1,"create_time":"2017-04-10 12:22:42","update_time":"2017-04-10 12:22:42","parent_id":0,"submit_status":1,"submit_time":0,"supply_merchant_id":8,"num":0,"type":1,"merchant":{"id":8,"shop_title":"demo","shop_address":null},"supply_merchant":{"id":8,"shop_title":"demo","shop_address":null},"images":[{"id":66,"product_id":32,"image_id":3,"status":1,"order_no":1,"type":1,"is_main":1,"url":"http://on1z8q8is.bkt.clouddn.com/j0hjtkew_1lkgxltijfms58cf4baf33630.jpg"},{"id":67,"product_id":32,"image_id":4,"status":1,"order_no":2,"type":1,"is_main":0,"url":"http://on1z8q8is.bkt.clouddn.com/j0hjuquo_49m6w34h3u2o58cf4be6891ee.jpg"}],"param":[{"id":126,"product_id":32,"name":"单位","value":"袋","order_no":1,"status":1},{"id":127,"product_id":32,"name":"重量","value":"5g","order_no":1,"status":1},{"id":128,"product_id":32,"name":"评级","value":"2级","order_no":1,"status":1},{"id":129,"product_id":32,"name":"颜色","value":"褐色","order_no":1,"status":1}]}
             */

            private String product_id;
            private String num;
            //是否被勾选
            private boolean checked;
            private ProductBean product;

            public boolean isChecked() {
                return checked;
            }

            public void setChecked(boolean checked) {
                this.checked = checked;
            }

            public String getProduct_id() {
                return product_id;
            }

            public void setProduct_id(String product_id) {
                this.product_id = product_id;
            }

            public String getNum() {
                return num;
            }

            public void setNum(String num) {
                this.num = num;
            }

            public ProductBean getProduct() {
                return product;
            }

            public void setProduct(ProductBean product) {
                this.product = product;
            }

            public static class ProductBean implements Serializable {
                /**
                 * id : 32
                 * category_id : 8
                 * merchant_id : 8
                 * title : demo_商品_5
                 * price : 61.50
                 * suggest_price : 73.80
                 * system_price : 61.50
                 * sales : 0
                 * status : 1
                 * is_delete : 0
                 * is_system : 1
                 * is_sale : 1
                 * is_edit : 0
                 * allow_other_sale : 1
                 * create_time : 2017-04-10 12:22:42
                 * update_time : 2017-04-10 12:22:42
                 * parent_id : 0
                 * submit_status : 1
                 * submit_time : 0
                 * supply_merchant_id : 8
                 * num : 0
                 * type : 1
                 * merchant : {"id":8,"shop_title":"demo","shop_address":null}
                 * supply_merchant : {"id":8,"shop_title":"demo","shop_address":null}
                 * images : [{"id":66,"product_id":32,"image_id":3,"status":1,"order_no":1,"type":1,"is_main":1,"url":"http://on1z8q8is.bkt.clouddn.com/j0hjtkew_1lkgxltijfms58cf4baf33630.jpg"},{"id":67,"product_id":32,"image_id":4,"status":1,"order_no":2,"type":1,"is_main":0,"url":"http://on1z8q8is.bkt.clouddn.com/j0hjuquo_49m6w34h3u2o58cf4be6891ee.jpg"}]
                 * param : [{"id":126,"product_id":32,"name":"单位","value":"袋","order_no":1,"status":1},{"id":127,"product_id":32,"name":"重量","value":"5g","order_no":1,"status":1},{"id":128,"product_id":32,"name":"评级","value":"2级","order_no":1,"status":1},{"id":129,"product_id":32,"name":"颜色","value":"褐色","order_no":1,"status":1}]
                 */

                private String id;
                private String category_id;
                private String merchant_id;
                private String title;
                private String price;
                private String suggest_price;
                private String system_price;
                private String sales;
                private String status;
                private String is_delete;
                private String is_system;
                private String is_sale;
                private String is_edit;
                private String allow_other_sale;
                private String create_time;
                private String update_time;
                private String parent_id;
                private String submit_status;
                private String submit_time;
                private String supply_merchant_id;
                private String num;
                private String type;
                private MerchantBean merchant;
                private SupplyMerchantBean supply_merchant;
                private List<ImagesBean> images;
                private List<ParamBean> param;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getCategory_id() {
                    return category_id;
                }

                public void setCategory_id(String category_id) {
                    this.category_id = category_id;
                }

                public String getMerchant_id() {
                    return merchant_id;
                }

                public void setMerchant_id(String merchant_id) {
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

                public String getSales() {
                    return sales;
                }

                public void setSales(String sales) {
                    this.sales = sales;
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

                public String getIs_system() {
                    return is_system;
                }

                public void setIs_system(String is_system) {
                    this.is_system = is_system;
                }

                public String getIs_sale() {
                    return is_sale;
                }

                public void setIs_sale(String is_sale) {
                    this.is_sale = is_sale;
                }

                public String getIs_edit() {
                    return is_edit;
                }

                public void setIs_edit(String is_edit) {
                    this.is_edit = is_edit;
                }

                public String getAllow_other_sale() {
                    return allow_other_sale;
                }

                public void setAllow_other_sale(String allow_other_sale) {
                    this.allow_other_sale = allow_other_sale;
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

                public String getParent_id() {
                    return parent_id;
                }

                public void setParent_id(String parent_id) {
                    this.parent_id = parent_id;
                }

                public String getSubmit_status() {
                    return submit_status;
                }

                public void setSubmit_status(String submit_status) {
                    this.submit_status = submit_status;
                }

                public String getSubmit_time() {
                    return submit_time;
                }

                public void setSubmit_time(String submit_time) {
                    this.submit_time = submit_time;
                }

                public String getSupply_merchant_id() {
                    return supply_merchant_id;
                }

                public void setSupply_merchant_id(String supply_merchant_id) {
                    this.supply_merchant_id = supply_merchant_id;
                }

                public String getNum() {
                    return num;
                }

                public void setNum(String num) {
                    this.num = num;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public MerchantBean getMerchant() {
                    return merchant;
                }

                public void setMerchant(MerchantBean merchant) {
                    this.merchant = merchant;
                }

                public SupplyMerchantBean getSupply_merchant() {
                    return supply_merchant;
                }

                public void setSupply_merchant(SupplyMerchantBean supply_merchant) {
                    this.supply_merchant = supply_merchant;
                }

                public List<ImagesBean> getImages() {
                    return images;
                }

                public void setImages(List<ImagesBean> images) {
                    this.images = images;
                }

                public List<ParamBean> getParam() {
                    return param;
                }

                public void setParam(List<ParamBean> param) {
                    this.param = param;
                }

                public static class MerchantBean implements Serializable {
                    /**
                     * id : 8
                     * shop_title : demo
                     * shop_address : null
                     */

                    private String id;
                    private String shop_title;
                    private Object shop_address;

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
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

                public static class SupplyMerchantBean implements Serializable {
                    /**
                     * id : 8
                     * shop_title : demo
                     * shop_address : null
                     */

                    private String id;
                    private String shop_title;
                    private Object shop_address;

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
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

                public static class ImagesBean implements Serializable {
                    /**
                     * id : 66
                     * product_id : 32
                     * image_id : 3
                     * status : 1
                     * order_no : 1
                     * type : 1
                     * is_main : 1
                     * url : http://on1z8q8is.bkt.clouddn.com/j0hjtkew_1lkgxltijfms58cf4baf33630.jpg
                     */

                    private String id;
                    private String product_id;
                    private String image_id;
                    private String status;
                    private String order_no;
                    private String type;
                    private String is_main;
                    private String url;

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }

                    public String getProduct_id() {
                        return product_id;
                    }

                    public void setProduct_id(String product_id) {
                        this.product_id = product_id;
                    }

                    public String getImage_id() {
                        return image_id;
                    }

                    public void setImage_id(String image_id) {
                        this.image_id = image_id;
                    }

                    public String getStatus() {
                        return status;
                    }

                    public void setStatus(String status) {
                        this.status = status;
                    }

                    public String getOrder_no() {
                        return order_no;
                    }

                    public void setOrder_no(String order_no) {
                        this.order_no = order_no;
                    }

                    public String getType() {
                        return type;
                    }

                    public void setType(String type) {
                        this.type = type;
                    }

                    public String getIs_main() {
                        return is_main;
                    }

                    public void setIs_main(String is_main) {
                        this.is_main = is_main;
                    }

                    public String getUrl() {
                        return url;
                    }

                    public void setUrl(String url) {
                        this.url = url;
                    }
                }

                public static class ParamBean implements Serializable {
                    /**
                     * id : 126
                     * product_id : 32
                     * name : 单位
                     * value : 袋
                     * order_no : 1
                     * status : 1
                     */

                    private String id;
                    private String product_id;
                    private String name;
                    private String value;
                    private String order_no;
                    private String status;

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }

                    public String getProduct_id() {
                        return product_id;
                    }

                    public void setProduct_id(String product_id) {
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

                    public String getOrder_no() {
                        return order_no;
                    }

                    public void setOrder_no(String order_no) {
                        this.order_no = order_no;
                    }

                    public String getStatus() {
                        return status;
                    }

                    public void setStatus(String status) {
                        this.status = status;
                    }
                }
            }
        }
    }
}
