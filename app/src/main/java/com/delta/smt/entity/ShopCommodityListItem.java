package com.delta.smt.entity;

import java.util.List;

/**
 * Created by wushufeng on 2017/3/18.
 */

public class ShopCommodityListItem {
    /**
     * app_code : 22000
     * app_msg :
     * result : {"total":4,"page":"1","size":20,"list":[{"id":1,"category_id":1,"merchant_id":1,"title":"茶2","price":"33.00","suggest_price":"0.00","system_price":"22.00","allow_other_sale":1,"parent_id":0,"supply_merchant_id":1,"merchant":{"id":1,"shop_title":" Jesse茶商","shop_address":null},"supply_merchant":{"id":1,"shop_title":" Jesse茶商","shop_address":null},"images":[{"id":3,"product_id":1,"image_id":3,"status":1,"order_no":1,"type":1,"is_main":1,"url":"http://on1z8q8is.bkt.clouddn.com/j0hjtkew_1lkgxltijfms58cf4baf33630.jpg"},{"id":4,"product_id":1,"image_id":4,"status":1,"order_no":2,"type":1,"is_main":0,"url":"http://on1z8q8is.bkt.clouddn.com/j0hjuquo_49m6w34h3u2o58cf4be6891ee.jpg"},{"id":5,"product_id":1,"image_id":5,"status":1,"order_no":3,"type":1,"is_main":0,"url":"http://on1z8q8is.bkt.clouddn.com/j0hqfaa8_6y8dfsg7b5cs58cf7702df5ca.gif"}],"param":[{"id":8,"product_id":1,"name":"产地","value":"北京","order_no":1,"status":1},{"id":9,"product_id":1,"name":"大小","value":"100kg","order_no":1,"status":1}]},{"id":35,"category_id":2,"merchant_id":3,"title":"wsf_商品_2","price":"24.60","suggest_price":"29.52","system_price":"24.60","allow_other_sale":1,"parent_id":0,"supply_merchant_id":3,"merchant":{"id":3,"shop_title":"wsf","shop_address":null},"supply_merchant":{"id":3,"shop_title":"wsf","shop_address":null},"images":[{"id":72,"product_id":35,"image_id":3,"status":1,"order_no":1,"type":1,"is_main":1,"url":"http://on1z8q8is.bkt.clouddn.com/j0hjtkew_1lkgxltijfms58cf4baf33630.jpg"},{"id":73,"product_id":35,"image_id":4,"status":1,"order_no":2,"type":1,"is_main":0,"url":"http://on1z8q8is.bkt.clouddn.com/j0hjuquo_49m6w34h3u2o58cf4be6891ee.jpg"}],"param":[{"id":138,"product_id":35,"name":"单位","value":"袋","order_no":1,"status":1},{"id":139,"product_id":35,"name":"重量","value":"2g","order_no":1,"status":1},{"id":140,"product_id":35,"name":"评级","value":"2级","order_no":1,"status":1},{"id":141,"product_id":35,"name":"颜色","value":"褐色","order_no":1,"status":1}]},{"id":12,"category_id":1,"merchant_id":1,"title":" Jesse茶商_商品_5","price":"61.50","suggest_price":"73.80","system_price":"61.50","allow_other_sale":1,"parent_id":0,"supply_merchant_id":1,"merchant":{"id":1,"shop_title":" Jesse茶商","shop_address":null},"supply_merchant":{"id":1,"shop_title":" Jesse茶商","shop_address":null},"images":[{"id":26,"product_id":12,"image_id":3,"status":1,"order_no":1,"type":1,"is_main":1,"url":"http://on1z8q8is.bkt.clouddn.com/j0hjtkew_1lkgxltijfms58cf4baf33630.jpg"},{"id":27,"product_id":12,"image_id":4,"status":1,"order_no":2,"type":1,"is_main":0,"url":"http://on1z8q8is.bkt.clouddn.com/j0hjuquo_49m6w34h3u2o58cf4be6891ee.jpg"}],"param":[{"id":50,"product_id":12,"name":"单位","value":"袋","order_no":1,"status":1},{"id":51,"product_id":12,"name":"重量","value":"5g","order_no":1,"status":1},{"id":52,"product_id":12,"name":"评级","value":"2级","order_no":1,"status":1},{"id":53,"product_id":12,"name":"颜色","value":"褐色","order_no":1,"status":1}]},{"id":38,"category_id":5,"merchant_id":3,"title":"wsf_商品_5","price":"61.50","suggest_price":"73.80","system_price":"61.50","allow_other_sale":1,"parent_id":0,"supply_merchant_id":3,"merchant":{"id":3,"shop_title":"wsf","shop_address":null},"supply_merchant":{"id":3,"shop_title":"wsf","shop_address":null},"images":[{"id":78,"product_id":38,"image_id":3,"status":1,"order_no":1,"type":1,"is_main":1,"url":"http://on1z8q8is.bkt.clouddn.com/j0hjtkew_1lkgxltijfms58cf4baf33630.jpg"},{"id":79,"product_id":38,"image_id":4,"status":1,"order_no":2,"type":1,"is_main":0,"url":"http://on1z8q8is.bkt.clouddn.com/j0hjuquo_49m6w34h3u2o58cf4be6891ee.jpg"}],"param":[{"id":150,"product_id":38,"name":"单位","value":"袋","order_no":1,"status":1},{"id":151,"product_id":38,"name":"重量","value":"5g","order_no":1,"status":1},{"id":152,"product_id":38,"name":"评级","value":"2级","order_no":1,"status":1},{"id":153,"product_id":38,"name":"颜色","value":"褐色","order_no":1,"status":1}]}]}
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
         * total : 4
         * page : 1
         * size : 20
         * list : [{"id":1,"category_id":1,"merchant_id":1,"title":"茶2","price":"33.00","suggest_price":"0.00","system_price":"22.00","allow_other_sale":1,"parent_id":0,"supply_merchant_id":1,"merchant":{"id":1,"shop_title":" Jesse茶商","shop_address":null},"supply_merchant":{"id":1,"shop_title":" Jesse茶商","shop_address":null},"images":[{"id":3,"product_id":1,"image_id":3,"status":1,"order_no":1,"type":1,"is_main":1,"url":"http://on1z8q8is.bkt.clouddn.com/j0hjtkew_1lkgxltijfms58cf4baf33630.jpg"},{"id":4,"product_id":1,"image_id":4,"status":1,"order_no":2,"type":1,"is_main":0,"url":"http://on1z8q8is.bkt.clouddn.com/j0hjuquo_49m6w34h3u2o58cf4be6891ee.jpg"},{"id":5,"product_id":1,"image_id":5,"status":1,"order_no":3,"type":1,"is_main":0,"url":"http://on1z8q8is.bkt.clouddn.com/j0hqfaa8_6y8dfsg7b5cs58cf7702df5ca.gif"}],"param":[{"id":8,"product_id":1,"name":"产地","value":"北京","order_no":1,"status":1},{"id":9,"product_id":1,"name":"大小","value":"100kg","order_no":1,"status":1}]},{"id":35,"category_id":2,"merchant_id":3,"title":"wsf_商品_2","price":"24.60","suggest_price":"29.52","system_price":"24.60","allow_other_sale":1,"parent_id":0,"supply_merchant_id":3,"merchant":{"id":3,"shop_title":"wsf","shop_address":null},"supply_merchant":{"id":3,"shop_title":"wsf","shop_address":null},"images":[{"id":72,"product_id":35,"image_id":3,"status":1,"order_no":1,"type":1,"is_main":1,"url":"http://on1z8q8is.bkt.clouddn.com/j0hjtkew_1lkgxltijfms58cf4baf33630.jpg"},{"id":73,"product_id":35,"image_id":4,"status":1,"order_no":2,"type":1,"is_main":0,"url":"http://on1z8q8is.bkt.clouddn.com/j0hjuquo_49m6w34h3u2o58cf4be6891ee.jpg"}],"param":[{"id":138,"product_id":35,"name":"单位","value":"袋","order_no":1,"status":1},{"id":139,"product_id":35,"name":"重量","value":"2g","order_no":1,"status":1},{"id":140,"product_id":35,"name":"评级","value":"2级","order_no":1,"status":1},{"id":141,"product_id":35,"name":"颜色","value":"褐色","order_no":1,"status":1}]},{"id":12,"category_id":1,"merchant_id":1,"title":" Jesse茶商_商品_5","price":"61.50","suggest_price":"73.80","system_price":"61.50","allow_other_sale":1,"parent_id":0,"supply_merchant_id":1,"merchant":{"id":1,"shop_title":" Jesse茶商","shop_address":null},"supply_merchant":{"id":1,"shop_title":" Jesse茶商","shop_address":null},"images":[{"id":26,"product_id":12,"image_id":3,"status":1,"order_no":1,"type":1,"is_main":1,"url":"http://on1z8q8is.bkt.clouddn.com/j0hjtkew_1lkgxltijfms58cf4baf33630.jpg"},{"id":27,"product_id":12,"image_id":4,"status":1,"order_no":2,"type":1,"is_main":0,"url":"http://on1z8q8is.bkt.clouddn.com/j0hjuquo_49m6w34h3u2o58cf4be6891ee.jpg"}],"param":[{"id":50,"product_id":12,"name":"单位","value":"袋","order_no":1,"status":1},{"id":51,"product_id":12,"name":"重量","value":"5g","order_no":1,"status":1},{"id":52,"product_id":12,"name":"评级","value":"2级","order_no":1,"status":1},{"id":53,"product_id":12,"name":"颜色","value":"褐色","order_no":1,"status":1}]},{"id":38,"category_id":5,"merchant_id":3,"title":"wsf_商品_5","price":"61.50","suggest_price":"73.80","system_price":"61.50","allow_other_sale":1,"parent_id":0,"supply_merchant_id":3,"merchant":{"id":3,"shop_title":"wsf","shop_address":null},"supply_merchant":{"id":3,"shop_title":"wsf","shop_address":null},"images":[{"id":78,"product_id":38,"image_id":3,"status":1,"order_no":1,"type":1,"is_main":1,"url":"http://on1z8q8is.bkt.clouddn.com/j0hjtkew_1lkgxltijfms58cf4baf33630.jpg"},{"id":79,"product_id":38,"image_id":4,"status":1,"order_no":2,"type":1,"is_main":0,"url":"http://on1z8q8is.bkt.clouddn.com/j0hjuquo_49m6w34h3u2o58cf4be6891ee.jpg"}],"param":[{"id":150,"product_id":38,"name":"单位","value":"袋","order_no":1,"status":1},{"id":151,"product_id":38,"name":"重量","value":"5g","order_no":1,"status":1},{"id":152,"product_id":38,"name":"评级","value":"2级","order_no":1,"status":1},{"id":153,"product_id":38,"name":"颜色","value":"褐色","order_no":1,"status":1}]}]
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
             * id : 1
             * category_id : 1
             * merchant_id : 1
             * title : 茶2
             * price : 33.00
             * suggest_price : 0.00
             * system_price : 22.00
             * allow_other_sale : 1
             * parent_id : 0
             * supply_merchant_id : 1
             * merchant : {"id":1,"shop_title":" Jesse茶商","shop_address":null}
             * supply_merchant : {"id":1,"shop_title":" Jesse茶商","shop_address":null}
             * images : [{"id":3,"product_id":1,"image_id":3,"status":1,"order_no":1,"type":1,"is_main":1,"url":"http://on1z8q8is.bkt.clouddn.com/j0hjtkew_1lkgxltijfms58cf4baf33630.jpg"},{"id":4,"product_id":1,"image_id":4,"status":1,"order_no":2,"type":1,"is_main":0,"url":"http://on1z8q8is.bkt.clouddn.com/j0hjuquo_49m6w34h3u2o58cf4be6891ee.jpg"},{"id":5,"product_id":1,"image_id":5,"status":1,"order_no":3,"type":1,"is_main":0,"url":"http://on1z8q8is.bkt.clouddn.com/j0hqfaa8_6y8dfsg7b5cs58cf7702df5ca.gif"}]
             * param : [{"id":8,"product_id":1,"name":"产地","value":"北京","order_no":1,"status":1},{"id":9,"product_id":1,"name":"大小","value":"100kg","order_no":1,"status":1}]
             */

            private String id;
            private String category_id;
            private String merchant_id;
            private String title;
            private String price;
            private String suggest_price;
            private String system_price;
            private String allow_other_sale;
            private String parent_id;
            private String supply_merchant_id;
            private MerchantBean merchant;
            private SupplyMerchantBean supply_merchant;
            private List<ImagesBean> images;
            private List<ParamBean> param;
            private String sales;

            public String getSales() {
                return sales;
            }

            public void setSales(String sales) {
                this.sales = sales;
            }

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

            public String getAllow_other_sale() {
                return allow_other_sale;
            }

            public void setAllow_other_sale(String allow_other_sale) {
                this.allow_other_sale = allow_other_sale;
            }

            public String getParent_id() {
                return parent_id;
            }

            public void setParent_id(String parent_id) {
                this.parent_id = parent_id;
            }

            public String getSupply_merchant_id() {
                return supply_merchant_id;
            }

            public void setSupply_merchant_id(String supply_merchant_id) {
                this.supply_merchant_id = supply_merchant_id;
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

            public static class MerchantBean {
                /**
                 * id : 1
                 * shop_title :  Jesse茶商
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

            public static class SupplyMerchantBean {
                /**
                 * id : 1
                 * shop_title :  Jesse茶商
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

            public static class ImagesBean {
                /**
                 * id : 3
                 * product_id : 1
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

            public static class ParamBean {
                /**
                 * id : 8
                 * product_id : 1
                 * name : 产地
                 * value : 北京
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


    /*private String msg;
    private String code;
    private UserAddressItem<ResultBean> result;

    public ShopCommodityListItem(String msg, String code, UserAddressItem<ResultBean> result) {
        this.msg = msg;
        this.code = code;
        this.result = result;
    }

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

    public UserAddressItem<ResultBean> getResult() {
        return result;
    }

    public void setResult(UserAddressItem<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        private String picture_url;
        private String commodity_name;
        private String now_price;
        private String sale_amout;

        public ResultBean(String picture_url, String commodity_name, String now_price, String sale_amout) {
            this.picture_url = picture_url;
            this.commodity_name = commodity_name;
            this.now_price = now_price;
            this.sale_amout = sale_amout;
        }

        public String getPicture_url() {
            return picture_url;
        }

        public void setPicture_url(String picture_url) {
            this.picture_url = picture_url;
        }

        public String getCommodity_name() {
            return commodity_name;
        }

        public void setCommodity_name(String commodity_name) {
            this.commodity_name = commodity_name;
        }

        public String getNow_price() {
            return now_price;
        }

        public void setNow_price(String now_price) {
            this.now_price = now_price;
        }

        public String getSale_amout() {
            return sale_amout;
        }

        public void setSale_amout(String sale_amout) {
            this.sale_amout = sale_amout;
        }
    }*/
}
