package com.delta.smt.entity.cart;

import java.util.List;

/**
 * Created by wushufeng on 2017/5/15.
 */

public class MyCartList {

    private List<ListBean> list;

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * merchant_id : 8
         * merchant_title : demo
         * cart : [{"product_id":32,"num":"2","merchant_id":8,"merchant_title":"demo","product":{"id":32,"category_id":8,"merchant_id":8,"title":"demo_商品_5","price":"61.50","suggest_price":"73.80","system_price":"61.50","sales":53,"status":1,"is_delete":1,"is_system":1,"is_sale":1,"is_edit":0,"allow_other_sale":1,"create_time":"2017-04-10 12:22:42","update_time":"2017-04-10 12:22:42","parent_id":0,"submit_status":1,"submit_time":0,"supply_merchant_id":8,"num":-53,"type":1,"merchant":{"id":8,"shop_title":"demo","shop_address":null},"supply_merchant":{"id":8,"shop_title":"demo","shop_address":null},"images":[{"id":66,"product_id":32,"image_id":3,"status":1,"order_no":1,"type":1,"is_main":1,"url":"http://opbeh9tlb.bkt.clouddn.com/2017/05/13/3a4a80da426ace5abb852bcdecad2389.jpg"},{"id":67,"product_id":32,"image_id":4,"status":1,"order_no":2,"type":1,"is_main":0,"url":"http://opbeh9tlb.bkt.clouddn.com/2017/05/13/3a4a80da426ace5abb852bcdecad2389.jpg"}],"param":[{"id":126,"product_id":32,"name":"单位","value":"袋","order_no":1,"status":1},{"id":127,"product_id":32,"name":"重量","value":"5g","order_no":1,"status":1},{"id":128,"product_id":32,"name":"评级","value":"2级","order_no":1,"status":1},{"id":129,"product_id":32,"name":"颜色","value":"褐色","order_no":1,"status":1}]}}]
         */

        private int merchant_id;
        private String merchant_title;
        private List<CartResult.CartBean> cart;

        public int getMerchant_id() {
            return merchant_id;
        }

        public void setMerchant_id(int merchant_id) {
            this.merchant_id = merchant_id;
        }

        public String getMerchant_title() {
            return merchant_title;
        }

        public void setMerchant_title(String merchant_title) {
            this.merchant_title = merchant_title;
        }

        public List<CartResult.CartBean> getCart() {
            return cart;
        }

        public void setCart(List<CartResult.CartBean> cart) {
            this.cart = cart;
        }
    }
}
