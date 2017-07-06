package com.delta.smt.ui.Personal.setting.person_information.receive_address.mvp;

import com.delta.commonlibs.utils.RxsRxSchedulers;
import com.delta.smt.api.ApiService;
import com.delta.smt.base.BaseModel;
import com.delta.smt.entity.AddAddress;
import com.delta.smt.entity.ItemBean;
import com.delta.smt.entity.ItemReceiveAddress;

import okhttp3.ResponseBody;
import rx.Observable;


/**
 * Created by Fuxiang.Zhang on 2017/5/7.
 */


public class ReceiveAddressModel extends BaseModel<ApiService> implements ReceiveAddressContract.Model {

    public ReceiveAddressModel(ApiService apiService) {
        super(apiService);
    }


    @Override
    public Observable<ResponseBody> getReceiveAddress(String token) {
        return getService().getReceiveAddress(token).compose(RxsRxSchedulers.<ResponseBody>io_main());
    }

    @Override
    public Observable<ResponseBody> editDefaultAddress(String token, String defaultAddress,int id) {
        return getService().editDefaultAddress(token,defaultAddress,id).compose(RxsRxSchedulers.<ResponseBody>io_main());
    }

    @Override
    public Observable<ResponseBody> deleteAddress(String token, int id) {
        return getService().deleteAddress(token,id).compose(RxsRxSchedulers.<ResponseBody>io_main());
    }
}
