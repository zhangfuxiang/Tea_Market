package com.delta.smt.ui.login.register.mvp;

import com.delta.commonlibs.base.mvp.IModel;
import com.delta.commonlibs.base.mvp.IView;
import com.delta.smt.entity.RegisterResult;

import rx.Observable;

/**
 * Created by wushufeng on 2017/3/16.
 */

public interface RegisterContract {
    interface Model extends IModel {

        Observable<RegisterResult> register(String client, String client_version, String os, String os_token, String api_version, String shop_title, String phone, String password, String name);



    }

    interface View extends IView {

        void registerSucess(RegisterResult registerResult);

        void registerFailed(RegisterResult registerResult);

        void registerFailed(Throwable throwable);

    }
}
