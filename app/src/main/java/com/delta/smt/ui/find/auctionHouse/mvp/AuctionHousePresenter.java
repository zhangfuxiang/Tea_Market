package com.delta.smt.ui.find.auctionHouse.mvp;

import android.util.Log;

import com.delta.commonlibs.base.mvp.BasePresenter;
import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.entity.AuctionHouseListItem;

import javax.inject.Inject;

import rx.functions.Action1;

/**
 * Created by wushufeng on 2017/3/18.
 */

//@FragmentScope
@ActivityScope
public class AuctionHousePresenter extends BasePresenter<AuctionHouseContract.Model, AuctionHouseContract.View> {


    @Inject
    public AuctionHousePresenter(AuctionHouseContract.Model model, AuctionHouseContract.View mView) {
        super(model, mView);
    }

    public void getAuctionList() {
        getModel().getAuctionList().subscribe(new Action1<AuctionHouseListItem>() {
            @Override
            public void call(AuctionHouseListItem auctionHouseListItem) {
                if (auctionHouseListItem.getCode().equals("0")) {
                    Log.i(TAG, "call: ");
                    getView().onAuctionListSuccess(auctionHouseListItem);
                } else {
                    getView().onAuctionListfailed(auctionHouseListItem);
                }

            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                getView().onAuctionListfailed(throwable);
            }
        });
    }


}