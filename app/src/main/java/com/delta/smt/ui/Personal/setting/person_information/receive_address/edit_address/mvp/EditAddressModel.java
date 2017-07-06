package com.delta.smt.ui.Personal.setting.person_information.receive_address.edit_address.mvp;

import com.delta.commonlibs.utils.RxsRxSchedulers;
import com.delta.smt.api.ApiService;
import com.delta.smt.base.BaseModel;
import com.delta.smt.entity.AddAddress;
import com.delta.smt.entity.ItemAddressDetail;
import com.delta.smt.entity.ItemBean;
import com.delta.smt.entity.ItemLocation;

import okhttp3.ResponseBody;
import rx.Observable;


/**
 * Created by Fuxiang.Zhang on 2017/5/7.
 */


public class EditAddressModel extends BaseModel<ApiService> implements EditAddressContract.Model {

    public EditAddressModel(ApiService apiService) {
        super(apiService);
    }

    @Override
    public Observable<ResponseBody> getLocation() {
        return getService().getLocation().compose(RxsRxSchedulers.<ResponseBody>io_main());
    }

    @Override
    public Observable<ResponseBody> getAddressDetail(String token, int id) {
        return getService().getAddressDetail(token,id).compose(RxsRxSchedulers.<ResponseBody>io_main());
    }

    @Override
    public Observable<ResponseBody> editReceiveAddress(String token, int location_id, String name, String phone, String address, String defaultAddress, int address_id) {
        return getService().editReceiveAddress(token,location_id,name,phone,address,defaultAddress,address_id)
                .compose(RxsRxSchedulers.<ResponseBody>io_main());
    }

    @Override
    public Observable<ResponseBody> deleteAddress(String token, int id) {
        return getService().deleteAddress(token,id).compose(RxsRxSchedulers.<ResponseBody>io_main());
    }


}
