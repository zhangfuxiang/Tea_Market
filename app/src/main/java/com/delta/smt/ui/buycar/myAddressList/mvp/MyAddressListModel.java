package com.delta.smt.ui.buycar.myAddressList.mvp;

import com.delta.commonlibs.utils.RxsRxSchedulers;
import com.delta.smt.api.ApiService;
import com.delta.smt.base.BaseModel;
import com.delta.smt.entity.cart.DeleteUserAddress;
import com.delta.smt.entity.cart.UpdateUserAddress;
import com.delta.smt.entity.cart.UserAddressList;

import rx.Observable;


/**
 * Created by wushufeng on 2017/5/5.
 */


public class MyAddressListModel extends BaseModel<ApiService> implements MyAddressListContract.Model {

    public MyAddressListModel(ApiService apiService) {
        super(apiService);
    }


    @Override
    public Observable<UserAddressList> getMyAddressList(String token, String merchant_id) {
        return getService().getMyAddressList(token, merchant_id).compose(RxsRxSchedulers.<UserAddressList>io_main());
    }

    @Override
    public Observable<DeleteUserAddress> deleteUserAddress(String token, String merchant_id, String address_id) {
        return getService().deleteUserAddress(token, merchant_id, address_id).compose(RxsRxSchedulers.<DeleteUserAddress>io_main());
    }

    @Override
    public Observable<UpdateUserAddress> updateUserAddress(String token, String merchant_id, String location_id, String name, String phone, String address, String def, String address_id) {
        return getService().updateUserAddress(token, merchant_id, location_id, name, phone, address, def, address_id).compose(RxsRxSchedulers.<UpdateUserAddress>io_main());
    }
}