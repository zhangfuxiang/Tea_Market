package com.delta.smt.ui.find.auctionHouseDetail.mvp;

import com.delta.commonlibs.base.mvp.IModel;
import com.delta.commonlibs.base.mvp.IView;
import com.delta.smt.entity.AuctionDetailItem;
import com.delta.smt.entity.AuctionDetailPriceRule;
import com.delta.smt.entity.AuctionDetailRecordItem;

import rx.Observable;


/**
 * Created by wushufeng on 2017/3/19.
 */

public interface AuctionHouseDetailContract {
    //对于经常使用的关于UI的方法可以定义到BaseView中,如显示隐藏进度条,和显示文字消息
    interface View extends IView {
        void onAuctionDetailSuccess(AuctionDetailItem item);

        void onAuctionDetailfailed(AuctionDetailItem item);

        void onAuctionDetailfailed(Throwable throwable);

        void onAuctionRecordSuccess(AuctionDetailRecordItem item);

        void onAuctionRecordfailed(AuctionDetailRecordItem item);

        void onAuctionRecordfailed(Throwable throwable);

        void onPriceRuleSuccess(AuctionDetailPriceRule item);

        void onPriceRulefailed(AuctionDetailPriceRule item);

        void onPriceRulefailed(Throwable throwable);
    }

    //Model层定义接口,外部只需关心model返回的数据,无需关心内部细节,及是否使用缓存
    interface Model extends IModel {
        Observable<AuctionDetailItem> getAuctionDetail();

        Observable<AuctionDetailRecordItem> getAuctionRecordList();

        Observable<AuctionDetailPriceRule> getPriceRule();

    }
}