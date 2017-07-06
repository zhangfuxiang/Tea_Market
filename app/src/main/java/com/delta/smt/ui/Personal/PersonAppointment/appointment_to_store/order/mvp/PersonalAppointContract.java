package com.delta.smt.ui.Personal.PersonAppointment.appointment_to_store.order.mvp;

import com.delta.commonlibs.base.mvp.IModel;
import com.delta.commonlibs.base.mvp.IView;
import com.delta.smt.entity.MyAppointResult;
import com.delta.smt.entity.UserInfo;

import rx.Observable;


public class PersonalAppointContract {

    public interface View extends IView {
        void ShowUserInfoSuccess(UserInfo userInfo);

        void showUserInfoError();

        void getBlanceDetailSuccess(MyAppointResult.ResultEntity result);

        void getBlanceDetailFaild(String app_msg);

        void RefershSucess(MyAppointResult.ResultEntity result);

        void loadSucess(MyAppointResult.ResultEntity result);
    }

    public interface Model extends IModel {
        Observable<UserInfo> getUseInfo(String token, String merchant_id);

        Observable<MyAppointResult> getPersonalAppoint(String token, String merchanId, int type, int page, int size);
    }
}
