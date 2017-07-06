package com.delta.smt.ui.find.priceRecord.mvp;

import com.delta.commonlibs.base.mvp.IModel;
import com.delta.commonlibs.base.mvp.IView;
import com.delta.smt.entity.AuctionDetailRecordItem;

import rx.Observable;


/**
 * Created by Shufeng.Wu on 2017/3/21.
 */

public interface PriceRecordContract {
    //对于经常使用的关于UI的方法可以定义到BaseView中,如显示隐藏进度条,和显示文字消息
    interface View extends IView {
        void onPriceRecordSuccess(AuctionDetailRecordItem item);

        void onPriceRecordFailed(AuctionDetailRecordItem item);

        void onPriceRecordFailed(Throwable throwable);
    }

    //Model层定义接口,外部只需关心model返回的数据,无需关心内部细节,及是否使用缓存
    interface Model extends IModel {
        Observable<AuctionDetailRecordItem> getPriceRecordList();
    }
}