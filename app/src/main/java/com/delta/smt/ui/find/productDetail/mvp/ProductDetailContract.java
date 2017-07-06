package com.delta.smt.ui.find.productDetail.mvp;

import com.delta.commonlibs.base.mvp.IModel;
import com.delta.commonlibs.base.mvp.IView;
import com.delta.smt.entity.AddMyShopResult;
import com.delta.smt.entity.AddToCartResult;
import com.delta.smt.entity.ProductDetail;

import rx.Observable;


/**
 * Created by wushufeng on 2017/3/25.
 */

public interface ProductDetailContract {
    //对于经常使用的关于UI的方法可以定义到BaseView中,如显示隐藏进度条,和显示文字消息
    interface View extends IView {
        void onProductDetailSuccess(ProductDetail ProductDetail);

        void onProductDetailFailed(ProductDetail ProductDetail);

        void onProductDetailFailed(Throwable throwable);

        void onAddMyShopSuccess(AddMyShopResult addMyShopResult);

        void onAddMyShopFailed(AddMyShopResult addMyShopResult);

        void onAddMyShopFailed(Throwable throwable);

        void onAddToCartSuccess(AddToCartResult addToCartResult);

        void onAddToCartFailed(AddToCartResult addToCartResult);

        void onAddToCartFailed(Throwable throwable);
    }

    //Model层定义接口,外部只需关心model返回的数据,无需关心内部细节,及是否使用缓存
    interface Model extends IModel {
        Observable<ProductDetail> getProductDetail(String token, String product_id, String stringSF);

        Observable<AddMyShopResult> getAddMyShopResult(String token, String product_id/*,String price*/);

        Observable<AddToCartResult> addToCart(String token, String product_id, String num);
    }
}