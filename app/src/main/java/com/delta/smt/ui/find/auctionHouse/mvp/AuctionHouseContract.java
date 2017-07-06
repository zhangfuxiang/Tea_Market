package com.delta.smt.ui.find.auctionHouse.mvp;

import com.delta.commonlibs.base.mvp.IModel;
import com.delta.commonlibs.base.mvp.IView;
import com.delta.smt.entity.AuctionHouseListItem;

import rx.Observable;


/**
 * Created by wushufeng on 2017/3/18.
 */

public interface AuctionHouseContract {
    //对于经常使用的关于UI的方法可以定义到BaseView中,如显示隐藏进度条,和显示文字消息
    interface View extends IView {

        void onAuctionListSuccess(AuctionHouseListItem item);

        void onAuctionListfailed(AuctionHouseListItem item);

        void onAuctionListfailed(Throwable throwable);
    }

    //Model层定义接口,外部只需关心model返回的数据,无需关心内部细节,及是否使用缓存
    interface Model extends IModel {
        Observable<AuctionHouseListItem> getAuctionList();
    }
}