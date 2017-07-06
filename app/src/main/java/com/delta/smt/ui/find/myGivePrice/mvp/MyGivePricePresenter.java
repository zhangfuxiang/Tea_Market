package com.delta.smt.ui.find.myGivePrice.mvp;

import android.util.Log;

import com.delta.commonlibs.base.mvp.BasePresenter;
import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.entity.MyGivePriceResult;

import javax.inject.Inject;

import rx.functions.Action1;

/**
 * Created by wushufeng on 2017/3/21.
 */

//@FragmentScope
@ActivityScope
public class MyGivePricePresenter extends BasePresenter<MyGivePriceContract.Model, MyGivePriceContract.View> {


    @Inject
    public MyGivePricePresenter(MyGivePriceContract.Model model, MyGivePriceContract.View mView) {
        super(model, mView);
    }

    public void getGivePriceResult(String price) {
        getModel().getGivePriceResult(price).subscribe(new Action1<MyGivePriceResult>() {
            @Override
            public void call(MyGivePriceResult myGivePriceResult) {
                if (myGivePriceResult.getCode().equals("0")) {
                    Log.i(TAG, "call: ");
                    getView().onGivePriceSuccess(myGivePriceResult);
                } else {
                    getView().onGivePriceFailed(myGivePriceResult);
                }
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                getView().onGivePriceFailed(throwable);
            }
        });
    }


}