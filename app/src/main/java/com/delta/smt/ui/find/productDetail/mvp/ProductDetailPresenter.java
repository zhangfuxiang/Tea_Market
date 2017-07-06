package com.delta.smt.ui.find.productDetail.mvp;

import android.util.Log;

import com.delta.commonlibs.base.mvp.BasePresenter;
import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.entity.AddMyShopResult;
import com.delta.smt.entity.AddToCartResult;
import com.delta.smt.entity.ProductDetail;

import javax.inject.Inject;

import rx.functions.Action1;

/**
 * Created by wushufeng on 2017/3/25.
 */

//@FragmentScope
@ActivityScope
public class ProductDetailPresenter extends BasePresenter<ProductDetailContract.Model, ProductDetailContract.View> {


    @Inject
    public ProductDetailPresenter(ProductDetailContract.Model model, ProductDetailContract.View mView) {
        super(model, mView);
    }

    public void getProductDetail(String token, String product_id, String stringSF) {
        getModel().getProductDetail(token, product_id, stringSF).subscribe(new Action1<ProductDetail>() {
            @Override
            public void call(ProductDetail productDetailItem) {
                if (productDetailItem.getApp_code()==22000) {
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


    public void getAddMyShopResult(String token, String product_id/*, String price*/) {
        getModel().getAddMyShopResult(token, product_id/*, price*/).subscribe(new Action1<AddMyShopResult>() {
            @Override
            public void call(AddMyShopResult addMyShopResult) {
                if (addMyShopResult.getApp_code().equals("22000")) {
                    Log.i(TAG, "call: ");
                    getView().onAddMyShopSuccess(addMyShopResult);
                } else {
                    getView().onAddMyShopFailed(addMyShopResult);
                }
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                getView().onAddMyShopFailed(throwable);
            }
        });
    }

    public void addToCart(String token, String product_id, String num) {
        getModel().addToCart(token, product_id, num).subscribe(new Action1<AddToCartResult>() {
            @Override
            public void call(AddToCartResult addToCartResult) {
                if (addToCartResult.getApp_code().equals("22000")) {
                    Log.i(TAG, "call: ");
                    getView().onAddToCartSuccess(addToCartResult);
                } else {
                    getView().onAddToCartFailed(addToCartResult);
                }
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                getView().onAddToCartFailed(throwable);
            }
        });
    }

}