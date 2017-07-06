package com.delta.smt.ui.login.login.mvp;


import com.delta.commonlibs.base.mvp.IModel;
import com.delta.commonlibs.base.mvp.IView;
import com.delta.smt.entity.UserLoginResult;

import rx.Observable;

/**
 * Created by V.Wenju.Tian on 2016/9/2.
 */
public interface LoginContract {

    interface Model extends IModel {

        Observable<UserLoginResult> login(String client, String client_version, String os, String os_token, String api_version, String phone, String password);

    }

    interface View extends IView {

        void loginSucess(UserLoginResult userLoginResult);

        void loginFailed(UserLoginResult userLoginResult);

        void loginFailed(Throwable throwable);

    }

}
