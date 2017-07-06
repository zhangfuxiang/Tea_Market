package com.delta.smt.ui.buycar.confirmOrder.mvp;

import com.delta.commonlibs.base.mvp.IModel;
import com.delta.commonlibs.base.mvp.IView;
import com.delta.smt.entity.cart.ComfirmOrderListItem;
import com.delta.smt.entity.cart.DefaultAddressResult;
import com.delta.smt.entity.cart.PayOrder;
import com.delta.smt.entity.cart.SubmitOrder;

import rx.Observable;


/**
 * Created by wushufeng on 2017/3/28.
 */

public interface ConfirmOrderContract {
    //对于经常使用的关于UI的方法可以定义到BaseView中,如显示隐藏进度条,和显示文字消息
    interface View extends IView {
        void onComfirmOrderListSuccess(ComfirmOrderListItem comfirmOrderListItem);

        void onComfirmOrderListFailed(ComfirmOrderListItem comfirmOrderListItem);

        void onComfirmOrderListFailed(Throwable throwable);

        void onGetDefaultAddressSuccess(DefaultAddressResult defaultAddressResult);

        void onGetDefaultAddressFailed(DefaultAddressResult defaultAddressResult);

        void onGetDefaultAddressFailed(Throwable throwable);

        void onSubmitOrderSuccess(SubmitOrder submitOrder);

        void onSubmitOrderFailed(SubmitOrder submitOrder);

        void onSubmitOrderFailed(Throwable throwable);

        void onPayOrderSuccess(PayOrder payOrder);

        void onPayOrderFailed(PayOrder payOrder);

        void onPayOrderFailed(Throwable throwable);

    }

    //Model层定义接口,外部只需关心model返回的数据,无需关心内部细节,及是否使用缓存
    interface Model extends IModel {
        Observable<ComfirmOrderListItem> getComfirmOrderList();

        Observable<DefaultAddressResult> getDefaultAddress(String token, String merchant_id);

        Observable<SubmitOrder> submitOrder(String fullUrl);
        //Observable<SubmitOrder> submitOrder(String token, String address_id, Map<String, String> options);

        Observable<PayOrder> payOrder(String token, String merchant_id, String order_ids, String pay_type, String pay_pwd);
    }
}