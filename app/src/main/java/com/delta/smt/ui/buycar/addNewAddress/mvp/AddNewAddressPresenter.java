package com.delta.smt.ui.buycar.addNewAddress.mvp;

import com.delta.commonlibs.base.mvp.BasePresenter;
import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.entity.cart.AddressAreaResult;
import com.delta.smt.entity.cart.NewAddressResult;

import javax.inject.Inject;

import rx.functions.Action1;

/**
 * Created by wushufeng on 2017/5/7.
 */

//@FragmentScope
@ActivityScope
public class AddNewAddressPresenter extends BasePresenter<AddNewAddressContract.Model, AddNewAddressContract.View> {


    @Inject
    public AddNewAddressPresenter(AddNewAddressContract.Model model, AddNewAddressContract.View mView) {
        super(model, mView);
    }

    public void addUserAddress(String token, String merchant_id, String location_id, String phone, String name, String address, String def) {
        getModel().addUserAddress(token, merchant_id, location_id, phone, name, address, def).subscribe(new Action1<NewAddressResult>() {
            @Override
            public void call(NewAddressResult newAddressResult) {
                if (newAddressResult.getApp_code().equals("22000")) {
                    getView().onAddUserAddressSuccess(newAddressResult);
                } else {
                    getView().onAddUserAddressFailed(newAddressResult);
                }
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                getView().onAddUserAddressFailed(throwable);
            }
        });
    }

    public void getAddressArea(String as_tree) {
        getModel().getAddressArea(as_tree).subscribe(new Action1<AddressAreaResult>() {
            @Override
            public void call(AddressAreaResult addressAreaResult) {
                if (addressAreaResult.getApp_code().equals("22000")) {
                    getView().onAddressAreaSuccess(addressAreaResult);
                } else {
                    getView().onAddressAreaFailed(addressAreaResult);
                }
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                getView().onAddressAreaFailed(throwable);
            }
        });
    }

}