package com.delta.smt.ui.buycar.confirmOrder.mvp;

import android.util.Log;

import com.delta.commonlibs.base.mvp.BasePresenter;
import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.entity.cart.ComfirmOrderListItem;
import com.delta.smt.entity.cart.DefaultAddressResult;
import com.delta.smt.entity.cart.PayOrder;
import com.delta.smt.entity.cart.SubmitOrder;

import javax.inject.Inject;

import rx.functions.Action1;

/**
 * Created by wushufeng on 2017/3/29.
 */

//@FragmentScope
@ActivityScope
public class ConfirmOrderPresenter extends BasePresenter<ConfirmOrderContract.Model, ConfirmOrderContract.View> {


    @Inject
    public ConfirmOrderPresenter(ConfirmOrderContract.Model model, ConfirmOrderContract.View mView) {
        super(model, mView);
    }

    public void getComfirmOrderList() {
        getModel().getComfirmOrderList().subscribe(new Action1<ComfirmOrderListItem>() {
            @Override
            public void call(ComfirmOrderListItem comfirmOrderListItem) {
                if (comfirmOrderListItem.getCode().equals("0")) {
                    Log.i(TAG, "call: ");
                    getView().onComfirmOrderListSuccess(comfirmOrderListItem);
                } else {
                    getView().onComfirmOrderListFailed(comfirmOrderListItem);
                }
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                getView().onComfirmOrderListFailed(throwable);
            }
        });
    }

    public void getDefaultAddress(String token, String merchant_id) {
        getModel().getDefaultAddress(token, merchant_id).subscribe(new Action1<DefaultAddressResult>() {
            @Override
            public void call(DefaultAddressResult defaultAddressResult) {
                if (defaultAddressResult.getApp_code().equals("22000")) {
                    Log.i(TAG, "call: ");
                    getView().onGetDefaultAddressSuccess(defaultAddressResult);
                } else {
                    getView().onGetDefaultAddressFailed(defaultAddressResult);
                }
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                getView().onGetDefaultAddressFailed(throwable);
            }
        });
    }

    public void submitOrder(String fullUrl) {
        getModel().submitOrder(fullUrl).subscribe(new Action1<SubmitOrder>() {
            @Override
            public void call(SubmitOrder submitOrder) {
                if (submitOrder.getApp_code() == 22000) {
                    getView().onSubmitOrderSuccess(submitOrder);
                } else {
                    getView().onSubmitOrderFailed(submitOrder);
                }
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                getView().onSubmitOrderFailed(throwable);
            }
        });
    }

    public void payOrder(String token, String merchant_id, String order_ids, String pay_type, String pay_pwd) {
        getModel().payOrder(token, merchant_id, order_ids, pay_type, pay_pwd).subscribe(new Action1<PayOrder>() {
            @Override
            public void call(PayOrder payOrder) {
                if (payOrder.getApp_code() == 22000) {
                    getView().onPayOrderSuccess(payOrder);
                } else {
                    getView().onPayOrderFailed(payOrder);
                }
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                getView().onPayOrderFailed(throwable);
            }
        });
    }

}