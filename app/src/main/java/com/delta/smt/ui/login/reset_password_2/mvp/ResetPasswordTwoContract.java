package com.delta.smt.ui.login.reset_password_2.mvp;

import com.delta.commonlibs.base.mvp.IModel;
import com.delta.commonlibs.base.mvp.IView;
import com.delta.smt.entity.ResetPwdResult;

import rx.Observable;


/**
 * Created by wushufeng on 2017/4/2.
 */

public interface ResetPasswordTwoContract {
    //对于经常使用的关于UI的方法可以定义到BaseView中,如显示隐藏进度条,和显示文字消息
    interface View extends IView {
        void onResetPwdSuccess(ResetPwdResult resetPwdResult);

        void onResetPwdFailed(ResetPwdResult resetPwdResult);

        void onResetPwdFailed(Throwable throwable);
    }

    //Model层定义接口,外部只需关心model返回的数据,无需关心内部细节,及是否使用缓存
    interface Model extends IModel {
        Observable<ResetPwdResult> resetPwd(String client, String client_version, String os, String os_token, String api_version, String phone, String password, String code);
    }
}