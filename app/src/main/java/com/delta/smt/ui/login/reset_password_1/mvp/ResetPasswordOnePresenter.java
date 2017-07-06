package com.delta.smt.ui.login.reset_password_1.mvp;

import android.util.Log;

import com.delta.commonlibs.base.mvp.BasePresenter;
import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.Constant;
import com.delta.smt.entity.SendCodeResult;

import javax.inject.Inject;

import rx.functions.Action1;

/**
 * Created by wushufeng on 2017/3/16.
 */
@ActivityScope
public class ResetPasswordOnePresenter extends BasePresenter<ResetPasswordOneConstract.Model, ResetPasswordOneConstract.View> {
    @Inject
    public ResetPasswordOnePresenter(ResetPasswordOneConstract.Model model, ResetPasswordOneConstract.View mView) {
        super(model, mView);
    }

    public void sendCode(String phone, String type) {
        getModel().sendCode(Constant.CLIENT,
                Constant.CLIENT_VERSION,
                Constant.OS,
                Constant.OS_TOKEN,
                Constant.API_VERSION, phone, type).subscribe(new Action1<SendCodeResult>() {
            @Override
            public void call(SendCodeResult sendCodeResult) {

                Log.i(TAG, "call: " + sendCodeResult.getApp_code());
                if ("22000".equals(sendCodeResult.getApp_code())) {
                    getView().sendCodeSuccess(sendCodeResult);
                } else {
                    getView().sendCodeFailed(sendCodeResult);
                }


            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                getView().sendCodeFailed(throwable);
            }
        });
    }
}
