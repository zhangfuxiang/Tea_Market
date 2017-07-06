package com.delta.smt.ui.login.register.mvp;

import com.delta.commonlibs.utils.RxsRxSchedulers;
import com.delta.smt.api.ApiService;
import com.delta.smt.base.BaseModel;
import com.delta.smt.entity.RegisterResult;

import rx.Observable;

/**
 * Created by wushufeng on 2017/3/16.
 */

public class RegisterModel extends BaseModel<ApiService> implements RegisterContract.Model {


    public RegisterModel(ApiService apiService) {
        super(apiService);
    }

    @Override
    public Observable<RegisterResult> register(String client, String client_version, String os, String os_token, String api_version, String shop_title, String phone, String password, String name) {
        return getService().register(client, client_version, os, os_token, api_version, shop_title, phone, password, name).compose(RxsRxSchedulers.<RegisterResult>io_main());
    }
}
