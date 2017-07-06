package com.delta.smt.ui.find.auctionHouseDetail.mvp;

import android.util.Log;

import com.delta.commonlibs.base.mvp.BasePresenter;
import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.entity.AuctionDetailItem;
import com.delta.smt.entity.AuctionDetailPriceRule;
import com.delta.smt.entity.AuctionDetailRecordItem;

import javax.inject.Inject;

import rx.functions.Action1;

/**
 * Created by wushufeng on 2017/3/20.
 */

//@FragmentScope
@ActivityScope
public class AuctionHouseDetailPresenter extends BasePresenter<AuctionHouseDetailContract.Model, AuctionHouseDetailContract.View> {


    @Inject
    public AuctionHouseDetailPresenter(AuctionHouseDetailContract.Model model, AuctionHouseDetailContract.View mView) {
        super(model, mView);
    }

    public void getAuctionDetialList() {
        getModel().getAuctionDetail().subscribe(new Action1<AuctionDetailItem>() {
            @Override
            public void call(AuctionDetailItem auctionDetailItem) {
                if (auctionDetailItem.getCode().equals("0")) {
                    Log.i(TAG, "call: ");
                    getView().onAuctionDetailSuccess(auctionDetailItem);
                } else {
                    getView().onAuctionDetailfailed(auctionDetailItem);
                }

            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                getView().onAuctionDetailfailed(throwable);
            }
        });
    }

    public void getAuctionRecordList() {
        getModel().getAuctionRecordList().subscribe(new Action1<AuctionDetailRecordItem>() {
            @Override
            public void call(AuctionDetailRecordItem auctionDetailRecordItem) {
                if (auctionDetailRecordItem.getCode().equals("0")) {
                    Log.i(TAG, "call: ");
                    getView().onAuctionRecordSuccess(auctionDetailRecordItem);
                } else {
                    getView().onAuctionRecordfailed(auctionDetailRecordItem);
                }
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                getView().onAuctionRecordfailed(throwable);
            }
        });
    }

    public void getPriceRule() {
        getModel().getPriceRule().subscribe(new Action1<AuctionDetailPriceRule>() {
            @Override
            public void call(AuctionDetailPriceRule auctionDetailPriceRule) {
                if (auctionDetailPriceRule.getCode().equals("0")) {
                    Log.i(TAG, "call: ");
                    getView().onPriceRuleSuccess(auctionDetailPriceRule);
                } else {
                    getView().onPriceRulefailed(auctionDetailPriceRule);
                }
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                getView().onPriceRulefailed(throwable);
            }
        });
    }

}