package com.delta.smt.ui.buycar.addNewAddress.mvp;

import com.delta.commonlibs.utils.RxsRxSchedulers;
import com.delta.smt.api.ApiService;
import com.delta.smt.base.BaseModel;
import com.delta.smt.entity.cart.AddressAreaResult;
import com.delta.smt.entity.cart.NewAddressResult;

import rx.Observable;


/**
 * Created by wushufeng on 2017/5/7.
 */


public class AddNewAddressModel extends BaseModel<ApiService> implements AddNewAddressContract.Model {

    public AddNewAddressModel(ApiService apiService) {
        super(apiService);
    }


    @Override
    public Observable<NewAddressResult> addUserAddress(String token, String merchant_id, String location_id, String phone, String name, String address, String def) {
        return getService().addUserAddress(token, merchant_id, location_id, phone, name, address, def).compose(RxsRxSchedulers.<NewAddressResult>io_main());
    }

    @Override
    public Observable<AddressAreaResult> getAddressArea(String as_tree) {
        return getService().getAddressArea(as_tree).compose(RxsRxSchedulers.<AddressAreaResult>io_main());
    }
}