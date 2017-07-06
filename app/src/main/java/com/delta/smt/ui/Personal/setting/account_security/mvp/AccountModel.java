package com.delta.smt.ui.Personal.setting.account_security.mvp;

import com.delta.commonlibs.utils.RxsRxSchedulers;
import com.delta.smt.api.ApiService;
import com.delta.smt.base.BaseModel;

import java.util.Map;

import okhttp3.ResponseBody;
import rx.Observable;


/**
 * Created by Fuxiang.Zhang on 2017/5/17.
 */


public class AccountModel extends BaseModel<ApiService> implements AccountContract.Model {

    public AccountModel(ApiService apiService) {
        super(apiService);
    }


    @Override
    public Observable<ResponseBody> changePhone(Map<String, String> stringStringMap) {
        return getService().changePhone(stringStringMap).compose(RxsRxSchedulers.<ResponseBody>io_main());
    }

    @Override
    public Observable<ResponseBody> confimCode(Map<String, String> stringStringMap) {
        return getService().checkCode(stringStringMap).compose(RxsRxSchedulers.<ResponseBody>io_main());
    }


}
