package com.delta.smt.entity.cart;

/**
 * Created by wushufeng on 2017/5/4.
 */

public class DefaultAddressResult {


    /**
     * app_code : 22000
     * app_msg :
     * result : {"id":37,"uid":24,"name":"哦哦哦","phone":"13666666666","province":"北京市","city":"市辖区","area":"西城区","address":"噢噢噢哦哦","status":0,"is_delete":0,"create_time":"2017-05-03 11:03:51","update_time":"2017-05-03 11:03:51","location_id":110102,"code":"110102"}
     */

    private String app_code;
    private String app_msg;
    private Object result;

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

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    /*public static class ResultBean {
        *//**
     * id : 37
     * uid : 24
     * name : 哦哦哦
     * phone : 13666666666
     * province : 北京市
     * city : 市辖区
     * area : 西城区
     * address : 噢噢噢哦哦
     * status : 0
     * is_delete : 0
     * create_time : 2017-05-03 11:03:51
     * update_time : 2017-05-03 11:03:51
     * location_id : 110102
     * code : 110102
     *//*


    }*/
}
