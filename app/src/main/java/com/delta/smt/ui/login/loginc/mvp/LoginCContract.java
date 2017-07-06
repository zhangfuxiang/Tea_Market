package com.delta.smt.ui.login.loginc.mvp;

import com.delta.commonlibs.base.mvp.IModel;
import com.delta.commonlibs.base.mvp.IView;
import com.delta.smt.entity.SendCodeResult;
import com.delta.smt.entity.UserCLoginResult;

import rx.Observable;


/**
 * Created by wushufeng on 2017/5/3.
 */

public interface LoginCContract {
    //对于经常使用的关于UI的方法可以定义到BaseView中,如显示隐藏进度条,和显示文字消息
    interface View extends IView {
        void onSendCodeCSuccess(SendCodeResult sendCodeResult);

        void onSendCodeCFailed(SendCodeResult sendCodeResult);

        void onSendCodeCFailed(Throwable throwable);

        void onLoginCSuccess(UserCLoginResult userCLoginResult);

        void onLoginCFailed(UserCLoginResult userCLoginResult);

        void onLoginCFailed(Throwable throwable);
    }

    //Model层定义接口,外部只需关心model返回的数据,无需关心内部细节,及是否使用缓存
    interface Model extends IModel {
        Observable<SendCodeResult> sendCodeC(String merchant_id, String phone, String type);

        Observable<UserCLoginResult> loginC(String phone, String code, String merchant_id);
    }
}