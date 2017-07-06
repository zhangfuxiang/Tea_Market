package com.delta.smt.ui.login.login.mvp;

import com.delta.commonlibs.base.mvp.BasePresenter;
import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.Constant;
import com.delta.smt.entity.UserLoginResult;

import javax.inject.Inject;

import rx.functions.Action1;

/**
 * Created by V.Wenju.Tian on 2016/9/2.
 */

@ActivityScope
public class LoginPresenter extends BasePresenter<LoginContract.Model, LoginContract.View> {

    @Inject
    public LoginPresenter(LoginContract.Model model, LoginContract.View mView) {
        super(model, mView);
    }

    public void login(String phone, String password) {


        getModel().login(Constant.CLIENT, Constant.CLIENT_VERSION,
                Constant.OS,
                Constant.OS_TOKEN,
                Constant.API_VERSION, phone, password).subscribe(new Action1<UserLoginResult>() {
            @Override
            public void call(UserLoginResult userLoginResult) {

                if ("22000".equals(userLoginResult.getApp_code())) {
                    getView().loginSucess(userLoginResult);
                } else {
                    getView().loginFailed(userLoginResult);
                }

            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                getView().loginFailed(throwable);
            }
        });

    }
}
