package com.delta.smt.ui.find.confirmOrder.mvp;

import android.util.Log;

import com.delta.commonlibs.base.mvp.BasePresenter;
import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.entity.ComfirmOrderListItem;

import javax.inject.Inject;

import rx.functions.Action1;

/**
 * Created by wushufeng on 2017/3/29.
 */

//@FragmentScope
@ActivityScope
public class ConfirmOrderPresenter extends BasePresenter<ConfirmOrderContract.Model, ConfirmOrderContract.View> {


    @Inject
    public ConfirmOrderPresenter(ConfirmOrderContract.Model model, ConfirmOrderContract.View mView) {
        super(model, mView);
    }

    public void getComfirmOrderList(){
        getModel().getComfirmOrderList().subscribe(new Action1<ComfirmOrderListItem>() {
            @Override
            public void call(ComfirmOrderListItem comfirmOrderListItem) {
                if (comfirmOrderListItem.getCode().equals("0")) {
                    Log.i(TAG, "call: ");
                    getView().onComfirmOrderListSuccess(comfirmOrderListItem);
                } else {
                    getView().onComfirmOrderListFailed(comfirmOrderListItem);
                }
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                getView().onComfirmOrderListFailed(throwable);
            }
        });
    }

}