package com.delta.smt.ui.Personal.my_order.no_payment.order_detail.mvp;

import com.delta.commonlibs.base.mvp.IModel;
import com.delta.commonlibs.base.mvp.IView;
import com.delta.commonlibs.rx.rxbus.Message;
import com.delta.smt.entity.ItemBean1;
import com.delta.smt.entity.ItemOrderDetail;
import com.delta.smt.entity.ItemPaySuccess;

import java.util.Map;

import okhttp3.ResponseBody;
import rx.Observable;


/**
 * Created by Fuxiang.Zhang on 2017/4/27.
 */

public interface OrderDetailContract {
    //对于经常使用的关于UI的方法可以定义到BaseView中,如显示隐藏进度条,和显示文字消息
    interface View extends IView {
        void showMessage(String message);
        void getOrderDetail(ItemOrderDetail.ResultBean mItemOrderDetail);
        void cancelOrder(String message);
        void payOrder(String message);
    }

    //Model层定义接口,外部只需关心model返回的数据,无需关心内部细节,及是否使用缓存
    interface Model extends IModel {
        Observable<ResponseBody> getOrderDetail(String token, String id);
        Observable<ResponseBody> cancelOrder(String token, String id);
        Observable<ResponseBody> payOrder(Map<String,String> queryMap);
    }
}