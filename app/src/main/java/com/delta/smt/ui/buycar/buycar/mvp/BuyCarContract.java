package com.delta.smt.ui.buycar.buycar.mvp;

import com.delta.commonlibs.base.mvp.IModel;
import com.delta.commonlibs.base.mvp.IView;
import com.delta.smt.entity.cart.Cart;
import com.delta.smt.entity.cart.CartRemoveResult;
import com.delta.smt.entity.cart.SetCartAmountResult;

import rx.Observable;


/**
 * Created by wushufeng on 2017/3/27.
 */

public interface BuyCarContract {
    //对于经常使用的关于UI的方法可以定义到BaseView中,如显示隐藏进度条,和显示文字消息
    interface View extends IView {
        void onBuyCarListSuccess(Cart cartListResult);

        void onBuyCarListFailed(Cart cartListResult);

        void onBuyCarListFailed(Throwable throwable);

        void onSetCartAmountSuccess(SetCartAmountResult setCartAmountResult);

        void onSetCartAmountFailed(SetCartAmountResult setCartAmountResult);

        void onSetCartAmountFailed(Throwable throwable);

        void onRemoveCartSuccess(CartRemoveResult cartRemoveResult);

        void onRemoveCartFailed(CartRemoveResult cartRemoveResult);

        void onRemoveCartFailed(Throwable throwable);
    }

    //Model层定义接口,外部只需关心model返回的数据,无需关心内部细节,及是否使用缓存
    interface Model extends IModel {
        Observable<Cart> getBuyCarList(String token, String merchant_id);

        Observable<SetCartAmountResult> setCartAmount(String token, String merchant_id, String product_id, String num);

        Observable<CartRemoveResult> removeCart(String token, String product_ids,String merchant_id);

    }
}