package com.delta.smt.ui.Personal.PersonalActivities.order.mvp;

import com.delta.commonlibs.utils.RxsRxSchedulers;
import com.delta.smt.api.ApiService;
import com.delta.smt.base.BaseModel;
import com.delta.smt.entity.MyActivity;
import com.delta.smt.entity.UserInfo;

import rx.Observable;

/**
 * Created by xy on 2017/3/18.
 */

public class PersonalActivityModel extends BaseModel<ApiService> implements PersonalActivityContract.Model {
    public PersonalActivityModel(ApiService apiService) {
        super(apiService);
    }

    @Override
    public Observable<UserInfo> getUseInfo(String token, String merchant_id) {
        return getService().getUserInfo(token, merchant_id).compose(RxsRxSchedulers.<UserInfo>io_main());
    }

    @Override
    public Observable<MyActivity> getPersonalActivity(String token, String merchanId, int type, int page, int size) {
        return getService().getPersonalActivity(token,merchanId,type,page,size).compose(RxsRxSchedulers.<MyActivity>io_main());
    }
}
