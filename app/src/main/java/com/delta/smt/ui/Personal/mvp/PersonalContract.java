package com.delta.smt.ui.Personal.mvp;

import com.delta.commonlibs.base.mvp.IModel;
import com.delta.commonlibs.base.mvp.IView;
import com.delta.smt.entity.UserInfo;

import java.util.Map;

import okhttp3.ResponseBody;
import rx.Observable;


public class PersonalContract{

    public interface View extends IView {
        void ShowUserInfoSuccess(UserInfo userInfo);

        void showUserInfoError();

        void resetPasswordSuccess();

        void resetPasswordFailed(String app_msg);

        void checkPasswordSuccess();

        void checkPasswordFailed(String app_msg);
    }

    public interface Model extends IModel {
        Observable<UserInfo> getUseInfo(String token, String merchant_id);

        Observable<ResponseBody> modifyChargePassword(Map<String, String> stringStringMap);

        Observable<ResponseBody> checkPayPwd(Map<String, String> stringStringMap);
    }
}
