package com.delta.smt.ui.login.register.mvp;

import com.delta.commonlibs.base.mvp.BasePresenter;
import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.entity.RegisterResult;

import javax.inject.Inject;

import rx.functions.Action1;

/**
 * Created by wushufeng on 2017/3/16.
 */
@ActivityScope
public class RegisterPresenter extends BasePresenter<RegisterContract.Model, RegisterContract.View> {
    @Inject
    public RegisterPresenter(RegisterContract.Model model, RegisterContract.View mView) {
        super(model, mView);
    }

    public void register(String client, String client_version, String os, String os_token, String api_version, String shop_title, String phone, String password, String name) {


        getModel().register(client, client_version, os, os_token, api_version, shop_title, phone, password, name).subscribe(new Action1<RegisterResult>() {
            @Override
            public void call(RegisterResult registerResult) {

                if ("22000".equals(registerResult.getApp_code())) {
                    getView().registerSucess(registerResult);
                } else {
                    getView().registerFailed(registerResult);
                }


            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                getView().registerFailed(throwable);
            }
        });

    }
}
