package com.delta.smt.ui.Personal.mvp;

import com.delta.commonlibs.utils.RxsRxSchedulers;
import com.delta.smt.api.ApiService;
import com.delta.smt.base.BaseModel;
import com.delta.smt.entity.UserInfo;

import java.util.Map;

import okhttp3.ResponseBody;
import rx.Observable;

/**
 * Created by xy on 2017/3/18.
 */

public class PresonalModel extends BaseModel<ApiService> implements PersonalContract.Model {
    public PresonalModel(ApiService apiService) {
        super(apiService);
    }

    @Override
    public Observable<UserInfo> getUseInfo(String token, String merchant_id) {
        return getService().getUserInfo(token, merchant_id).compose(RxsRxSchedulers.<UserInfo>io_main());
    }

    @Override
    public Observable<ResponseBody> modifyChargePassword(Map<String, String> stringStringMap) {
        return getService().modifyChargePassword(stringStringMap).compose(RxsRxSchedulers.<ResponseBody>io_main());
    }

    @Override
    public Observable<ResponseBody> checkPayPwd(Map<String, String> stringStringMap) {
        return getService().checkPayPwd(stringStringMap).compose(RxsRxSchedulers.<ResponseBody>io_main());
    }
}
