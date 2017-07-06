package com.delta.smt.ui.main.mvp;

import com.delta.commonlibs.utils.RxsRxSchedulers;
import com.delta.smt.api.ApiService;
import com.delta.smt.base.BaseModel;
import com.delta.smt.entity.drinktea.ShopList;

import rx.Observable;

/**
 * @description :
 * @autHor :  V.Wenju.Tian
 * @date : 2016/12/16 12:49
 */


public class MainModel extends BaseModel<ApiService> implements MainContract.Model {

    public MainModel(ApiService apiService) {
        super(apiService);
    }

    @Override
    public Observable<ShopList> getShopList(String token, String merchant_id, String page, String size, String keyword, String is_current) {
        return getService().getShopList(token, merchant_id, page, size, keyword, is_current).compose(RxsRxSchedulers.<ShopList>io_main());
    }
}
