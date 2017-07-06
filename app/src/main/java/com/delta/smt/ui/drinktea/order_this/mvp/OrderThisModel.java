package com.delta.smt.ui.drinktea.order_this.mvp;

import com.delta.commonlibs.utils.RxsRxSchedulers;
import com.delta.smt.api.ApiService;
import com.delta.smt.base.BaseModel;
import com.delta.smt.entity.drinktea.OrderThis;

import rx.Observable;


/**
 * Created by wushufeng on 2017/5/14.
 */


public class OrderThisModel extends BaseModel<ApiService> implements OrderThisContract.Model {

    public OrderThisModel(ApiService apiService) {
        super(apiService);
    }


    @Override
    public Observable<OrderThis> bespeakShop(String token, String merchant_id, String room_num, String shop_id, String start_time, String end_time, String comment) {
        return getService().bespeakShop(token, merchant_id, room_num, shop_id, start_time, end_time, comment).compose(RxsRxSchedulers.<OrderThis>io_main());
    }
}