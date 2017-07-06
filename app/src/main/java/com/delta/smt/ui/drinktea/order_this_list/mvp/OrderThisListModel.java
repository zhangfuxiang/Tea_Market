package com.delta.smt.ui.drinktea.order_this_list.mvp;

import com.delta.commonlibs.utils.RxsRxSchedulers;
import com.delta.smt.api.ApiService;
import com.delta.smt.base.BaseModel;
import com.delta.smt.entity.drinktea.ShopList;

import rx.Observable;


/**
 * Created by wushufeng on 2017/5/14.
 */


public class OrderThisListModel extends BaseModel<ApiService> implements OrderThisListContract.Model {

    public OrderThisListModel(ApiService apiService) {
        super(apiService);
    }


    @Override
    public Observable<ShopList> getShopList(String token, String merchant_id, String page, String size, String keyword, String is_current) {
        return getService().getShopList(token, merchant_id, page, size, keyword, is_current).compose(RxsRxSchedulers.<ShopList>io_main());
    }
}