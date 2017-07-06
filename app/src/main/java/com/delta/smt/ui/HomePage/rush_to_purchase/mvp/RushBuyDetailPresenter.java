package com.delta.smt.ui.HomePage.rush_to_purchase.mvp;

import android.util.Log;

import com.delta.commonlibs.base.mvp.BasePresenter;
import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.entity.ProductDetailItem;

import javax.inject.Inject;

import rx.functions.Action1;

/**
 * Created by wushufeng on 2017/3/25.
 */

//@FragmentScope
@ActivityScope
public class RushBuyDetailPresenter extends BasePresenter<RushBuyDetailContract.Model, RushBuyDetailContract.View> {


    @Inject
    public RushBuyDetailPresenter(RushBuyDetailContract.Model model, RushBuyDetailContract.View mView) {
        super(model, mView);
    }

    public void getProductDetail() {
        getModel().getProductDetail().subscribe(new Action1<ProductDetailItem>() {
            @Override
            public void call(ProductDetailItem productDetailItem) {
                if (productDetailItem.getCode().equals("0")) {
                    Log.i(TAG, "call: ");
                    getView().onProductDetailSuccess(productDetailItem);
                } else {
                    getView().onProductDetailFailed(productDetailItem);
                }
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                getView().onProductDetailFailed(throwable);
            }
        });
    }


}