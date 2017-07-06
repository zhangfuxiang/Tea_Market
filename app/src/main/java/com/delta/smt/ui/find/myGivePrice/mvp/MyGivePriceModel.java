package com.delta.smt.ui.find.myGivePrice.mvp;

import com.delta.smt.api.ApiService;
import com.delta.smt.base.BaseModel;
import com.delta.smt.entity.MyGivePriceResult;

import rx.Observable;


/**
 * Created by wushufeng on 2017/3/21.
 */


public class MyGivePriceModel extends BaseModel<ApiService> implements MyGivePriceContract.Model {

    public MyGivePriceModel(ApiService apiService) {
        super(apiService);
    }


    @Override
    public Observable<MyGivePriceResult> getGivePriceResult(String price) {
        String result = "";
        MyGivePriceResult myGivePriceResult = new MyGivePriceResult("success", "0", result);
        return Observable.just(myGivePriceResult);
    }
}