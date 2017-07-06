package com.delta.smt.ui.Personal.my_order.all_content.mvp;

import com.delta.commonlibs.utils.RxsRxSchedulers;
import com.delta.smt.api.ApiService;
import com.delta.smt.base.BaseModel;
import com.delta.smt.entity.ItemMyOrder;

import okhttp3.ResponseBody;
import rx.Observable;


/**
 * Created by Fuxiang.Zhang on 2017/4/25.
 */


public class AllContentModel extends BaseModel<ApiService> implements AllContentContract.Model {

    public AllContentModel(ApiService apiService) {
        super(apiService);
    }


    @Override
    public Observable<ResponseBody> getMyOrderList(String token, String pay_status,String page,String size) {
        return getService().getMyOrderList(token,pay_status,"0",page,size).compose(RxsRxSchedulers.<ResponseBody>io_main());
    }

    @Override
    public Observable<ResponseBody> cancelOrder(String token, String id) {
        return getService().cancelOrder(token,id).compose(RxsRxSchedulers.<ResponseBody>io_main());
    }
}
