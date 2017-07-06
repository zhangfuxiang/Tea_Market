package com.delta.smt.ui.Personal.my_order.mvp;

import com.delta.smt.api.ApiService;
import com.delta.smt.base.BaseModel;


/**
 * Created by Fuxiang.Zhang on 2017/4/25.
 */


public class MyOrderModel extends BaseModel<ApiService> implements MyOrderContract.Model {

    public MyOrderModel(ApiService apiService) {
        super(apiService);
    }


}
