package com.delta.smt.ui.login.reset_password_1.mvp;

import com.delta.commonlibs.base.mvp.IModel;
import com.delta.commonlibs.base.mvp.IView;
import com.delta.smt.entity.SendCodeResult;

import rx.Observable;

/**
 * Created by wushufeng on 2017/3/16.
 */

public interface ResetPasswordOneConstract {
    interface Model extends IModel {

        Observable<SendCodeResult> sendCode(String client, String client_version, String os, String os_token, String api_version, String phone, String type);

    }

    interface View extends IView {

        void sendCodeSuccess(SendCodeResult sendCodeResult);

        void sendCodeFailed(SendCodeResult sendCodeResult);

        void sendCodeFailed(Throwable throwable);


    }
}
