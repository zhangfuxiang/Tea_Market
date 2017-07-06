package com.delta.smt.ui.find.priceRecord.mvp;

import android.util.Log;

import com.delta.commonlibs.base.mvp.BasePresenter;
import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.entity.AuctionDetailRecordItem;

import javax.inject.Inject;

import rx.functions.Action1;

/**
 * Created by Shufeng.Wu on 2017/3/21.
 */

//@FragmentScope
@ActivityScope
public class PriceRecordPresenter extends BasePresenter<PriceRecordContract.Model, PriceRecordContract.View> {


    @Inject
    public PriceRecordPresenter(PriceRecordContract.Model model, PriceRecordContract.View mView) {
        super(model, mView);
    }

    public void getPriceRecordList() {
        getModel().getPriceRecordList().subscribe(new Action1<AuctionDetailRecordItem>() {
            @Override
            public void call(AuctionDetailRecordItem auctionDetailRecordItem) {
                if (auctionDetailRecordItem.getCode().equals("0")) {
                    Log.i(TAG, "call: ");
                    getView().onPriceRecordSuccess(auctionDetailRecordItem);
                } else {
                    getView().onPriceRecordFailed(auctionDetailRecordItem);
                }
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                getView().onPriceRecordFailed(throwable);
            }
        });
    }

}