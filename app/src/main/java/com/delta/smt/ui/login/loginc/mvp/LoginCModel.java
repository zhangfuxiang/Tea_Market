package com.delta.smt.ui.login.loginc.mvp;

import com.delta.commonlibs.utils.RxsRxSchedulers;
import com.delta.smt.api.ApiService;
import com.delta.smt.base.BaseModel;
import com.delta.smt.entity.SendCodeResult;
import com.delta.smt.entity.UserCLoginResult;

import rx.Observable;


/**
 * Created by wushufeng on 2017/5/3.
 */


public class LoginCModel extends BaseModel<ApiService> implements LoginCContract.Model {

    public LoginCModel(ApiService apiService) {
        super(apiService);
    }


    @Override
    public Observable<SendCodeResult> sendCodeC(String merchant_id, String phone, String type) {
        return getService().sendCodeC(merchant_id, phone, type).compose(RxsRxSchedulers.<SendCodeResult>io_main());
    }

    @Override
    public Observable<UserCLoginResult> loginC(String phone, String code, String merchant_id) {
        return getService().loginC(phone, code, merchant_id).compose(RxsRxSchedulers.<UserCLoginResult>io_main());
    }
}