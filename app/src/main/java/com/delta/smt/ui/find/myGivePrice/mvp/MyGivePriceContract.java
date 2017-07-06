package com.delta.smt.ui.find.myGivePrice.mvp;

import com.delta.commonlibs.base.mvp.IModel;
import com.delta.commonlibs.base.mvp.IView;
import com.delta.smt.entity.MyGivePriceResult;

import rx.Observable;


/**
 * Created by wushufeng on 2017/3/21.
 */

public interface MyGivePriceContract {
    //对于经常使用的关于UI的方法可以定义到BaseView中,如显示隐藏进度条,和显示文字消息
    interface View extends IView {
        void onGivePriceSuccess(MyGivePriceResult myGivePriceResult);

        void onGivePriceFailed(MyGivePriceResult myGivePriceResult);

        void onGivePriceFailed(Throwable throwable);
    }

    //Model层定义接口,外部只需关心model返回的数据,无需关心内部细节,及是否使用缓存
    interface Model extends IModel {
        Observable<MyGivePriceResult> getGivePriceResult(String price);
    }
}