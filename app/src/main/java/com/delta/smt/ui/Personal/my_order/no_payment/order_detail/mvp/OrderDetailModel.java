package com.delta.smt.ui.Personal.my_order.no_payment.order_detail.mvp;

import com.delta.commonlibs.utils.RxsRxSchedulers;
import com.delta.smt.api.ApiService;
import com.delta.smt.base.BaseModel;
import com.delta.smt.entity.ItemBean1;
import com.delta.smt.entity.ItemOrderDetail;
import com.delta.smt.entity.ItemPaySuccess;

import java.util.Map;

import okhttp3.ResponseBody;
import rx.Observable;


/**
 * Created by Fuxiang.Zhang on 2017/4/27.
 */


public class OrderDetailModel extends BaseModel<ApiService> implements OrderDetailContract.Model {

    public OrderDetailModel(ApiService apiService) {
        super(apiService);
    }


    @Override
    public Observable<ResponseBody> getOrderDetail(String token, String id) {
        return getService().getOrderDetail(token,id).compose(RxsRxSchedulers.<ResponseBody>io_main());
    }

    @Override
    public Observable<ResponseBody> cancelOrder(String token, String id) {
        return getService().cancelOrder(token,id).compose(RxsRxSchedulers. <ResponseBody>io_main());
    }

    @Override
    public Observable<ResponseBody> payOrder(Map<String, String> queryMap) {
        return getService().payOrder(queryMap).compose(RxsRxSchedulers.<ResponseBody>io_main());
    }
}
