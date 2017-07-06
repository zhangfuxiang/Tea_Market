package com.delta.smt.ui.drinktea.choose_address.mvp;

import com.delta.commonlibs.base.mvp.BasePresenter;
import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.entity.drinktea.UserAddress;

import javax.inject.Inject;

import rx.functions.Action1;

/**
 * Created by wushufeng on 2017/4/22.
 */

//@FragmentScope
@ActivityScope
public class ChooseAddressPresenter extends BasePresenter<ChooseAddressContract.Model, ChooseAddressContract.View> {


    @Inject
    public ChooseAddressPresenter(ChooseAddressContract.Model model, ChooseAddressContract.View mView) {
        super(model, mView);
    }

/*    public void getReceivingAddress() {
        getModel().getReceivingAddress().subscribe(new Action1<List<String>>() {
            @Override
            public void call(List<String> strings) {
                getView().onReceivingAddressSuccess(strings);
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                getView().onReceivingAddressFailed(throwable);
            }
        });
    }*/

    public void getUserAddressList(String token, String merchant_id) {
        getModel().getUserAddressList(token, merchant_id).subscribe(new Action1<UserAddress>() {
            @Override
            public void call(UserAddress userAddress) {
                if (userAddress.getApp_code() == 22000) {
                    getView().onGetUserAddressListSuccess(userAddress);
                } else {
                    getView().onGetUserAddressListFailed(userAddress);
                }
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                getView().onGetUserAddressListFailed(throwable);
            }
        });
    }

}