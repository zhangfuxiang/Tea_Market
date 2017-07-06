package com.delta.smt.ui.login.start.mvp;

import com.delta.commonlibs.utils.RxsRxSchedulers;
import com.delta.smt.api.ApiService;
import com.delta.smt.base.BaseModel;
import com.delta.smt.entity.StartResult;

import rx.Observable;


/**
 * Created by wushufeng on 2017/4/4.
 */


public class StartModel extends BaseModel<ApiService> implements StartContract.Model {

    public StartModel(ApiService apiService) {
        super(apiService);
    }


    @Override
    public Observable<StartResult> start(String client, String client_version, String os, String os_token, String api_version) {
        return getService().start(client, client_version, os, os_token, api_version).compose(RxsRxSchedulers.<StartResult>io_main());
    }
}