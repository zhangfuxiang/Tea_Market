package com.delta.smt.ui.drinktea.order_this.mvp;

import com.delta.commonlibs.base.mvp.BasePresenter;
import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.entity.drinktea.OrderThis;

import javax.inject.Inject;

import rx.functions.Action1;

/**
 * Created by wushufeng on 2017/5/14.
 */

//@FragmentScope
@ActivityScope
public class OrderThisPresenter extends BasePresenter<OrderThisContract.Model, OrderThisContract.View> {


    @Inject
    public OrderThisPresenter(OrderThisContract.Model model, OrderThisContract.View mView) {
        super(model, mView);
    }

    public void bespeakShop(String token, String merchant_id, String room_num, String shop_id, String start_time, String end_time, String comment) {
        getModel().bespeakShop(token, merchant_id, room_num, shop_id, start_time, end_time, comment).subscribe(new Action1<OrderThis>() {
            @Override
            public void call(OrderThis orderThis) {
                if (orderThis.getApp_code() == 22000) {
                    getView().onBespeakShopSuccess(orderThis);
                } else {
                    getView().onBespeakShopFailed(orderThis);
                }
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                getView().onBespeakShopFailed(throwable);
            }
        });
    }

}