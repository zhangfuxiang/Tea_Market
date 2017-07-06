package com.delta.smt.ui.main.mvp;

import com.delta.commonlibs.base.mvp.IModel;
import com.delta.commonlibs.base.mvp.IView;
import com.delta.smt.entity.drinktea.ShopList;

import rx.Observable;

/**
 * @description :
 * @autHor :  V.Wenju.Tian
 * @date : 2016/12/16 9:41
 */


public interface MainContract {
    interface View extends IView {
        void onGetShopListSuccess(ShopList shopList);

        void onGetShopListFailed(ShopList shopList);

        void onGetShopListFailed(Throwable throwable);
    }

    interface Model extends IModel {
        Observable<ShopList> getShopList(String token,
                                         String merchant_id,
                                         String page,
                                         String size,
                                         String keyword,
                                         String is_current);
    }

}
