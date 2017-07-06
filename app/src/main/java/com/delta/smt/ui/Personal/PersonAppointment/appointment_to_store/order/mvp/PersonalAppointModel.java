package com.delta.smt.ui.Personal.PersonAppointment.appointment_to_store.order.mvp;

import com.delta.commonlibs.utils.RxsRxSchedulers;
import com.delta.smt.api.ApiService;
import com.delta.smt.base.BaseModel;
import com.delta.smt.entity.MyAppointResult;
import com.delta.smt.entity.UserInfo;

import rx.Observable;

/**
 * Created by xy on 2017/3/18.
 */

public class PersonalAppointModel extends BaseModel<ApiService> implements PersonalAppointContract.Model {
    public PersonalAppointModel(ApiService apiService) {
        super(apiService);
    }

    @Override
    public Observable<UserInfo> getUseInfo(String token, String merchant_id) {
        return getService().getUserInfo(token, merchant_id).compose(RxsRxSchedulers.<UserInfo>io_main());
    }

    @Override
    public Observable<MyAppointResult> getPersonalAppoint(String token, String merchanId, int type, int page, int size) {
        return getService().getPersonalAppoint(token,merchanId,type,page,size).compose(RxsRxSchedulers.<MyAppointResult>io_main());
    }
}
