package com.delta.smt.ui.Personal.setting.person_information.receive_address.add_address.mvp;

import com.delta.commonlibs.utils.RxsRxSchedulers;
import com.delta.smt.api.ApiService;
import com.delta.smt.base.BaseModel;
import com.delta.smt.entity.AddAddress;
import com.delta.smt.entity.ItemLocation;

import okhttp3.ResponseBody;
import rx.Observable;


/**
 * Created by Fuxiang.Zhang on 2017/5/7.
 */


public class AddAddressModel extends BaseModel<ApiService> implements AddAddressContract.Model {

    public AddAddressModel(ApiService apiService) {
        super(apiService);
    }


    @Override
    public Observable<ResponseBody> addReceiveAddress(String token, String location_id, String phone, String name, String address, String defaultAddress) {
        return getService()
                .addReceiveAddress(token,location_id,phone,name,address,defaultAddress)
                .compose(RxsRxSchedulers.<ResponseBody>io_main());
    }

    @Override
    public Observable<ResponseBody> getLocation() {
        return getService().getLocation().compose(RxsRxSchedulers.<ResponseBody>io_main());
    }
}
