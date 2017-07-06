package com.delta.smt.entity.home_page.activity;

/**
 * Created by Shufeng.Wu on 2017/6/2.
 */

public class ActivityList {

    /**
     * app_code : 22000
     * app_msg :
     * result : {"page":1,"size":"1","total":25,"list":[{"id":38,"title":"品茶主体活动 2","number":40,"sign_num":11,"uid":12,"merchant_id":1,"price":"24.60","start_time":1495000800,"end_time":1495015200,"image_id":"4","address":"北京某地","images":["http://on1z8q8is.bkt.clouddn.com//2017/04/03/3a4a80da426ace5abb852bcdecad2389.jpg","http://on1z8q8is.bkt.clouddn.com//2017/04/03/8619cb55f870b73b812a8ef50cb7aa4e.jpg","http://on1z8q8is.bkt.clouddn.com//2017/04/03/beea251915534d935f13897df7723565.jpg"],"content":"品茶 活动 有惊喜","status":0,"is_delete":0,"create_time":1492258919,"update_time":1492258919,"category_id":11,"image_url":"http://on1z8q8is.bkt.clouddn.com/j0hjuquo_49m6w34h3u2o58cf4be6891ee.jpg","summary":"品茶 活动 有惊喜"}]}
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
