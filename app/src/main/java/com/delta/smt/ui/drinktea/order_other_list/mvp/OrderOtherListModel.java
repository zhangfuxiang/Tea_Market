package com.delta.smt.ui.drinktea.order_other_list.mvp;

import com.delta.commonlibs.utils.RxsRxSchedulers;
import com.delta.smt.api.ApiService;
import com.delta.smt.base.BaseModel;
import com.delta.smt.entity.drinktea.ShopList;

import rx.Observable;


/**
 * Created by wushufeng on 2017/4/20.
 */


public class OrderOtherListModel extends BaseModel<ApiService> implements OrderOtherListContract.Model {

    public OrderOtherListModel(ApiService apiService) {
        super(apiService);
    }

    @Override
    public Observable<ShopList> getShopList(String token, String merchant_id, String page, String size, String keyword, String is_current) {
        return getService().getShopList(token, merchant_id, page, size, keyword, is_current).compose(RxsRxSchedulers.<ShopList>io_main());
    }

}