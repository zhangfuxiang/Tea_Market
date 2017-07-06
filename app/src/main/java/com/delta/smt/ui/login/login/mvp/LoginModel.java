package com.delta.smt.ui.login.login.mvp;


import com.delta.commonlibs.utils.RxsRxSchedulers;
import com.delta.smt.api.ApiService;
import com.delta.smt.base.BaseModel;
import com.delta.smt.entity.UserLoginResult;

import rx.Observable;


/**
 * Created by V.Wenju.Tian on 2016/9/2.
 */
public class LoginModel extends BaseModel<ApiService> implements LoginContract.Model {


    public LoginModel(ApiService apiService) {
        super(apiService);
    }

    @Override
    public Observable<UserLoginResult> login(String client, String client_version, String os, String os_token, String api_version, String phone, String password) {
        return getService().login(client, client_version, os, os_token, api_version, phone, password).compose(RxsRxSchedulers.<UserLoginResult>io_main());
    }
}


