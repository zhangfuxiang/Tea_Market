package com.delta.smt.ui.login.loginc.mvp;

import com.delta.commonlibs.base.mvp.BasePresenter;
import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.entity.SendCodeResult;
import com.delta.smt.entity.UserCLoginResult;

import javax.inject.Inject;

import rx.functions.Action1;

/**
 * Created by wushufeng on 2017/5/3.
 */

//@FragmentScope
@ActivityScope
public class LoginCPresenter extends BasePresenter<LoginCContract.Model, LoginCContract.View> {


    @Inject
    public LoginCPresenter(LoginCContract.Model model, LoginCContract.View mView) {
        super(model, mView);
    }

    public void sendCodeC(String merchant_id, String phone, String type) {
        getModel().sendCodeC(merchant_id, phone, type).subscribe(new Action1<SendCodeResult>() {
            @Override
            public void call(SendCodeResult sendCodeResult) {
                if (sendCodeResult.getApp_code().equals("22000")) {
                    getView().onSendCodeCSuccess(sendCodeResult);
                } else {
                    getView().onSendCodeCFailed(sendCodeResult);
                }
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                getView().onSendCodeCFailed(throwable);
            }
        });
    }

    public void loginC(String phone, String code, String merchant_id) {
        getModel().loginC(phone, code, merchant_id).subscribe(new Action1<UserCLoginResult>() {
            @Override
            public void call(UserCLoginResult userCLoginResult) {
                if (userCLoginResult.getApp_code().equals("22000")) {
                    getView().onLoginCSuccess(userCLoginResult);
                } else {
                    getView().onLoginCFailed(userCLoginResult);
                }
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                getView().onLoginCFailed(throwable);
            }
        });
    }

}