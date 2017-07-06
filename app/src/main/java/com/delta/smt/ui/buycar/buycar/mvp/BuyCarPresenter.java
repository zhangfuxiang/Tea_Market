package com.delta.smt.ui.buycar.buycar.mvp;

import android.util.Log;

import com.delta.commonlibs.base.mvp.BasePresenter;
import com.delta.commonlibs.di.scope.FragmentScope;
import com.delta.smt.entity.cart.Cart;
import com.delta.smt.entity.cart.CartRemoveResult;
import com.delta.smt.entity.cart.SetCartAmountResult;

import javax.inject.Inject;

import rx.functions.Action1;

/**
 * Created by wushufeng on 2017/3/27.
 */

@FragmentScope
//@ActivityScope
public class BuyCarPresenter extends BasePresenter<BuyCarContract.Model, BuyCarContract.View> {


    @Inject
    public BuyCarPresenter(BuyCarContract.Model model, BuyCarContract.View mView) {
        super(model, mView);
    }

    public void getBuyCarList(String token, String merchant_id) {
        getModel().getBuyCarList(token, merchant_id).subscribe(new Action1<Cart>() {
            @Override
            public void call(Cart cart) {
                if (cart.getApp_code() == 22000) {
                    Log.i(TAG, "call: ");
                    getView().onBuyCarListSuccess(cart);
                } else {
                    getView().onBuyCarListFailed(cart);
                }
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                getView().onBuyCarListFailed(throwable);
            }
        });
    }

    public void setCartAmount(String token, String merchant_id, String product_id, String num) {
        getModel().setCartAmount(token, merchant_id, product_id, num).subscribe(new Action1<SetCartAmountResult>() {
            @Override
            public void call(SetCartAmountResult setCartAmountResult) {
                if (setCartAmountResult.getApp_code().equals("22000")) {
                    Log.i(TAG, "call: ");
                    getView().onSetCartAmountSuccess(setCartAmountResult);
                } else {
                    getView().onSetCartAmountFailed(setCartAmountResult);
                }
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                getView().onSetCartAmountFailed(throwable);
            }
        });
    }

    public void removeCart(String token, String product_ids,String merchant_id) {
        getModel().removeCart(token, product_ids,merchant_id).subscribe(new Action1<CartRemoveResult>() {
            @Override
            public void call(CartRemoveResult cartRemoveResult) {
                if (cartRemoveResult.getApp_code() == 22000) {
                    getView().onRemoveCartSuccess(cartRemoveResult);
                } else {
                    getView().onRemoveCartFailed(cartRemoveResult);
                }
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                getView().onRemoveCartFailed(throwable);
            }
        });
    }


}