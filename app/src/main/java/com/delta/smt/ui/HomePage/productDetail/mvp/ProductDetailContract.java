package com.delta.smt.ui.HomePage.productDetail.mvp;

import com.delta.commonlibs.base.mvp.IModel;
import com.delta.commonlibs.base.mvp.IView;
import com.delta.smt.entity.ProductDetailItem;

import rx.Observable;


/**
 * Created by wushufeng on 2017/3/25.
 */

public interface ProductDetailContract {
    //对于经常使用的关于UI的方法可以定义到BaseView中,如显示隐藏进度条,和显示文字消息
    interface View extends IView {
        void onProductDetailSuccess(ProductDetailItem productDetailItem);

        void onProductDetailFailed(ProductDetailItem productDetailItem);

        void onProductDetailFailed(Throwable throwable);
    }

    //Model层定义接口,外部只需关心model返回的数据,无需关心内部细节,及是否使用缓存
    interface Model extends IModel {
        Observable<ProductDetailItem> getProductDetail();
    }
}