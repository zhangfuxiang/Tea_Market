package com.delta.smt.entity.cart;

/**
 * Created by wushufeng on 2017/5/13.
 */

public class Cart {

    /**
     * app_code : 22000
     * app_msg :
     * result : {"cart":[{"product_id":32,"num":30,"product":{"id":32,"category_id":8,"merchant_id":8,"title":"demo_商品_5","price":"61.50","suggest_price":"73.80","system_price":"61.50","sales":0,"status":1,"is_delete":0,"is_system":1,"is_sale":1,"is_edit":0,"allow_other_sale":1,"create_time":"2017-04-10 12:22:42","update_time":"2017-04-10 12:22:42","parent_id":0,"submit_status":1,"submit_time":0,"supply_merchant_id":8,"num":0,"type":1,"merchant":{"id":8,"shop_title":"demo","shop_address":null},"supply_merchant":{"id":8,"shop_title":"demo","shop_address":null},"images":[{"id":66,"product_id":32,"image_id":3,"status":1,"order_no":1,"type":1,"is_main":1,"url":"http://on1z8q8is.bkt.clouddn.com/j0hjtkew_1lkgxltijfms58cf4baf33630.jpg"},{"id":67,"product_id":32,"image_id":4,"status":1,"order_no":2,"type":1,"is_main":0,"url":"http://on1z8q8is.bkt.clouddn.com/j0hjuquo_49m6w34h3u2o58cf4be6891ee.jpg"}],"param":[{"id":126,"product_id":32,"name":"单位","value":"袋","order_no":1,"status":1},{"id":127,"product_id":32,"name":"重量","value":"5g","order_no":1,"status":1},{"id":128,"product_id":32,"name":"评级","value":"2级","order_no":1,"status":1},{"id":129,"product_id":32,"name":"颜色","value":"褐色","order_no":1,"status":1}]}}]}
     */

    private int app_code;
    private String app_msg;
    private Object result;

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

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
