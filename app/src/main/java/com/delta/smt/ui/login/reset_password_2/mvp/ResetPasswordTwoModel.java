package com.delta.smt.ui.login.reset_password_2.mvp;

import com.delta.commonlibs.utils.RxsRxSchedulers;
import com.delta.smt.api.ApiService;
import com.delta.smt.base.BaseModel;
import com.delta.smt.entity.ResetPwdResult;

import rx.Observable;


/**
 * Created by wushufeng on 2017/4/5.
 */


public class ResetPasswordTwoModel extends BaseModel<ApiService> implements ResetPasswordTwoContract.Model {

    public ResetPasswordTwoModel(ApiService apiService) {
        super(apiService);
    }


    @Override
    public Observable<ResetPwdResult> resetPwd(String client, String client_version, String os, String os_token, String api_version, String phone, String password, String code) {
        return getService().resetPwd(client, client_version, os, os_token, api_version, phone, password, code).compose(RxsRxSchedulers.<ResetPwdResult>io_main());
    }
}