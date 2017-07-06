package com.delta.smt.ui.buycar.updateUserAddress.mvp;

import android.util.Log;

import com.delta.commonlibs.base.mvp.BasePresenter;
import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.entity.cart.DeleteUserAddress;
import com.delta.smt.entity.cart.UpdateUserAddress;

import javax.inject.Inject;

import rx.functions.Action1;

/**
 * Created by wushufeng on 2017/5/11.
 */

//@FragmentScope
@ActivityScope
public class UpdateUserAddressPresenter extends BasePresenter<UpdateUserAddressContract.Model, UpdateUserAddressContract.View> {


    @Inject
    public UpdateUserAddressPresenter(UpdateUserAddressContract.Model model, UpdateUserAddressContract.View mView) {
        super(model, mView);
    }

    public void updateUserAddress(String token, String merchant_id, String location_id, String name, String phone, String address, String def, String address_id) {
        getModel().updateUserAddress(token, merchant_id, location_id, name, phone, address, def, address_id).subscribe(new Action1<UpdateUserAddress>() {
            @Override
            public void call(UpdateUserAddress updateUserAddress) {
                if (updateUserAddress.getApp_code().equals("22000")) {
                    getView().onUpdateUserAddressSuccess(updateUserAddress);
                } else {
                    getView().onUpdateUserAddressFailed(updateUserAddress);
                }
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                getView().onUpdateUserAddressFailed(throwable);
            }
        });
    }

    public void deleteUserAddress(String token, String merchant_id, String address_id) {
        getModel().deleteUserAddress(token, merchant_id, address_id).subscribe(new Action1<DeleteUserAddress>() {
            @Override
            public void call(DeleteUserAddress deleteUserAddress) {
                if (deleteUserAddress.getApp_code().equals("22000")) {
                    Log.i(TAG, "call: ");
                    getView().onDeleteUserAddressSuccess(deleteUserAddress);
                } else {
                    getView().onDeleteUserAddressFailed(deleteUserAddress);
                }
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                getView().onDeleteUserAddressFailed(throwable);
            }
        });
    }


}