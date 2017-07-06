package com.delta.smt.ui.main.mvp;

import com.delta.commonlibs.base.mvp.BasePresenter;
import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.entity.drinktea.ShopList;

import javax.inject.Inject;

import rx.functions.Action1;

/**
 * @description :
 * @autHor :  V.Wenju.Tian
 * @date : 2016/12/16 9:42
 */

@ActivityScope
public class MainPresenter extends BasePresenter<MainContract.Model, MainContract.View> {

    @Inject
    public MainPresenter(MainContract.Model model, MainContract.View mView) {
        super(model, mView);
    }

    public void getShopList(String token, String merchant_id, String page, String size, String keyword, String is_current) {
        getModel().getShopList(token, merchant_id, page, size, keyword, is_current).subscribe(new Action1<ShopList>() {
            @Override
            public void call(ShopList shopList) {
                if (shopList.getApp_code() == 22000) {
                    getView().onGetShopListSuccess(shopList);
                } else {
                    getView().onGetShopListFailed(shopList);
                }
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                getView().onGetShopListFailed(throwable);
            }
        });
    }
}
