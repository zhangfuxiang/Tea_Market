package com.delta.smt.entity.cart;

/**
 * Created by wushufeng on 2017/5/11.
 */

public class UpdateUserAddress {

    /**
     * app_code : 22000
     * app_msg :
     * result : {"id":65,"uid":24,"name":"hehehehe","phone":"15210940588","province":"北京市","city":"市辖区","area":"朝阳区","address":"万庄","status":1,"is_delete":0,"create_time":"2017-05-11 19:52:38","update_time":"2017-05-11 23:09:48","location_id":"110105","code":"131003"}
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
}
