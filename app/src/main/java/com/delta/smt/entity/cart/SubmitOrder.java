package com.delta.smt.entity.cart;

/**
 * Created by Shufeng.Wu on 2017/5/16.
 */

public class SubmitOrder {

    /**
     * app_code : 22000
     * app_msg :
     * result : {"order_num":3,"order_ids":["51","52","53"],"order_list":[{"uid":18,"address_id":10,"merchant_id":1,"supply_merchant_id":1,"order_no":"34512017042123144911","order_name":"","order_money":12.3,"order_remarks":"","user_ip":"180.88.191.195","istype":0,"deliver_fee":0,"delivery_name":"小明","delivery_location_id":110105,"delivery_phone":"15212341235","delivery_address":"某地某村","delivery_code":"110105","update_time":"2017-04-21 23:14:48","create_time":"2017-04-21 23:14:48","id":"48","order_product":[{"order_id":"48","uid":18,"product_id":8,"status":0,"num":1,"price":"12.30","amount":12.3,"id":"50"}]},{"uid":18,"address_id":10,"merchant_id":1,"supply_merchant_id":3,"order_no":"33422017042123144912","order_name":"","order_money":59.04,"order_remarks":"","user_ip":"180.88.191.195","istype":0,"deliver_fee":0,"delivery_name":"小明","delivery_location_id":110105,"delivery_phone":"15212341235","delivery_address":"某地某村","delivery_code":"110105","update_time":"2017-04-21 23:14:48","create_time":"2017-04-21 23:14:48","id":"49","order_product":[{"order_id":"49","uid":18,"product_id":40,"status":0,"num":2,"price":"29.52","amount":59.04,"id":"51"}]},{"uid":18,"address_id":10,"merchant_id":1,"supply_merchant_id":2,"order_no":"31672017042123144913","order_name":"","order_money":118.08,"order_remarks":"","user_ip":"180.88.191.195","istype":0,"deliver_fee":0,"delivery_name":"小明","delivery_location_id":110105,"delivery_phone":"15212341235","delivery_address":"某地某村","delivery_code":"110105","update_time":"2017-04-21 23:14:48","create_time":"2017-04-21 23:14:48","id":"50","order_product":[{"order_id":"50","uid":18,"product_id":42,"status":0,"num":4,"price":"29.52","amount":118.08,"id":"52"}]}]}
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
