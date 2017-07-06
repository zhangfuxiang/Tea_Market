package com.delta.smt.ui.drinktea.order_other_list.mvp;

import com.delta.commonlibs.base.mvp.BasePresenter;
import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.Constant;
import com.delta.smt.entity.drinktea.ShopList;

import javax.inject.Inject;

import rx.functions.Action1;

/**
 * Created by wushufeng on 2017/4/20.
 */

//@FragmentScope
@ActivityScope
public class OrderOtherListPresenter extends BasePresenter<OrderOtherListContract.Model, OrderOtherListContract.View> {


    @Inject
    public OrderOtherListPresenter(OrderOtherListContract.Model model, OrderOtherListContract.View mView) {
        super(model, mView);
    }

    public void getShopList(String token, String merchant_id, String page, String size, String keyword, String is_current, final int type) {
        getModel().getShopList(token, merchant_id, page, size, keyword, is_current).subscribe(new Action1<ShopList>() {
            @Override
            public void call(ShopList shopList) {
                if (shopList.getApp_code() == 22000) {
                    if (type == Constant.NOMAL) {
                        getView().onGetShopListSuccess(shopList);
                    } else if (type == Constant.PUllTOREFRESH) {
                        getView().onGetShopListRefreshSuccess(shopList);
                    } else if (type == Constant.UPLOADMORE) {
                        getView().onGetShopListLoadMoreSuccess(shopList);
                    }
                } else {

                    if (type == Constant.NOMAL) {
                        getView().onGetShopListFailed(shopList);
                    } else if (type == Constant.PUllTOREFRESH) {
                        getView().onGetShopListRefreshfailed(shopList);
                    } else if (type == Constant.UPLOADMORE) {
                        getView().onGetShopListLoadMorefailed(shopList);
                    }
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