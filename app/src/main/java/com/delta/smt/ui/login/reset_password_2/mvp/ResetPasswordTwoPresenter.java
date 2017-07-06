package com.delta.smt.ui.login.reset_password_2.mvp;

import android.util.Log;

import com.delta.commonlibs.base.mvp.BasePresenter;
import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.Constant;
import com.delta.smt.entity.ResetPwdResult;

import javax.inject.Inject;

import rx.functions.Action1;

/**
 * Created by wushufeng on 2017/4/5.
 */

//@FragmentScope
@ActivityScope
public class ResetPasswordTwoPresenter extends BasePresenter<ResetPasswordTwoContract.Model, ResetPasswordTwoContract.View> {


    @Inject
    public ResetPasswordTwoPresenter(ResetPasswordTwoContract.Model model, ResetPasswordTwoContract.View mView) {
        super(model, mView);
    }

    public void resetPwd(String phone, String password, String code) {
        getModel().resetPwd(Constant.CLIENT,
                Constant.CLIENT_VERSION,
                Constant.OS,
                Constant.OS_TOKEN,
                Constant.API_VERSION, phone, password, code).subscribe(new Action1<ResetPwdResult>() {
            @Override
            public void call(ResetPwdResult resetPwdResult) {

                Log.i(TAG, "call: " + resetPwdResult.getApp_code());
                if ("22000".equals(resetPwdResult.getApp_code())) {
                    getView().onResetPwdSuccess(resetPwdResult);
                } else {
                    getView().onResetPwdFailed(resetPwdResult);
                }


            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                getView().onResetPwdFailed(throwable);
            }
        });
    }


}