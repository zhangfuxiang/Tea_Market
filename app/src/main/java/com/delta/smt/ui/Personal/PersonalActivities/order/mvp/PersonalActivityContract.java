package com.delta.smt.ui.Personal.PersonalActivities.order.mvp;

import com.delta.commonlibs.base.mvp.IModel;
import com.delta.commonlibs.base.mvp.IView;
import com.delta.smt.entity.MyActivity;
import com.delta.smt.entity.UserInfo;

import rx.Observable;


public class PersonalActivityContract {

    public interface View extends IView {
        void ShowUserInfoSuccess(UserInfo userInfo);

        void showUserInfoError();

        void getBlanceDetailSuccess(MyActivity.ResultEntity result);

        void getBlanceDetailFaild(String app_msg);

        void RefershSucess(MyActivity.ResultEntity result);

        void loadSucess(MyActivity.ResultEntity result);
    }

    public interface Model extends IModel {
        Observable<UserInfo> getUseInfo(String token, String merchant_id);

        Observable<MyActivity> getPersonalActivity(String token, String merchanId, int type, int page, int size);
    }
}
