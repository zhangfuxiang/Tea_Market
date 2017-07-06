package com.delta.smt.ui.Personal.my_order.no_payment.mvp;

import com.delta.commonlibs.utils.RxsRxSchedulers;
import com.delta.smt.api.ApiService;
import com.delta.smt.base.BaseModel;
import com.delta.smt.entity.ItemBean;
import com.delta.smt.entity.ItemBean1;
import com.delta.smt.entity.ItemNOPayment;
import com.delta.smt.entity.ItemPaySuccess;

import java.util.Map;

import okhttp3.ResponseBody;
import rx.Observable;


/**
 * Created by Fuxiang.Zhang on 2017/4/25.
 */


public class NoPaymentModel extends BaseModel<ApiService> implements NoPaymentContract.Model {

    public NoPaymentModel(ApiService apiService) {
        super(apiService);
    }


    @Override
    public Observable<ResponseBody> getUnpaymentList(String token, String pay_status,String page,String size) {
        return getService().getUnpaymentList(token,pay_status,"0",page,size).compose(RxsRxSchedulers.<ResponseBody>io_main());
    }

    @Override
    public Observable<ResponseBody> cancelOrder(String token, String id) {
        return getService().cancelOrder(token,id).compose(RxsRxSchedulers.<ResponseBody>io_main());
    }

    @Override
    public Observable<ResponseBody> payOrder(Map<String, String> queryMap) {
        return getService().payOrder(queryMap).compose(RxsRxSchedulers.<ResponseBody>io_main());
    }
}
