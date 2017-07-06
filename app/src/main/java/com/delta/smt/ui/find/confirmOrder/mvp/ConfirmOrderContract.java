package com.delta.smt.ui.find.confirmOrder.mvp;

import com.delta.commonlibs.base.mvp.IModel;
import com.delta.commonlibs.base.mvp.IView;
import com.delta.smt.entity.ComfirmOrderListItem;

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
    }

    //Model层定义接口,外部只需关心model返回的数据,无需关心内部细节,及是否使用缓存
    interface Model extends IModel {
        Observable<ComfirmOrderListItem> getComfirmOrderList();
    }
}