package com.delta.smt.ui.login.reset_password_1.mvp;

import com.delta.commonlibs.utils.RxsRxSchedulers;
import com.delta.smt.api.ApiService;
import com.delta.smt.base.BaseModel;
import com.delta.smt.entity.SendCodeResult;

import rx.Observable;

/**
 * Created by wushufeng on 2017/3/16.
 */

public class ResetPasswordOneModel extends BaseModel<ApiService> implements ResetPasswordOneConstract.Model {
    public ResetPasswordOneModel(ApiService apiService) {
        super(apiService);
    }


    @Override
    public Observable<SendCodeResult> sendCode(String client, String client_version, String os, String os_token, String api_version, String phone, String type) {
        return getService().sendCode(client, client_version, os, os_token, api_version, phone, type).compose(RxsRxSchedulers.<SendCodeResult>io_main());
    }
}
