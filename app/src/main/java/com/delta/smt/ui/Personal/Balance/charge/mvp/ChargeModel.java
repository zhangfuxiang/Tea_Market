package com.delta.smt.ui.Personal.Balance.charge.mvp;

import com.delta.commonlibs.utils.RxsRxSchedulers;
import com.delta.smt.api.ApiService;
import com.delta.smt.base.BaseModel;
import com.delta.smt.entity.ChargeResult;

import java.util.Map;

import okhttp3.ResponseBody;
import rx.Observable;


/**
 * Created by Fuxiang.Zhang on 2017/4/27.
 */


public class ChargeModel extends BaseModel<ApiService> implements ChargeContract.Model {

    public ChargeModel(ApiService apiService) {
        super(apiService);
    }


    @Override
    public Observable<ChargeResult> getChargeList(Map<String, String> queryMap) {
        return getService().getChargeList(queryMap).compose(RxsRxSchedulers.<ChargeResult>io_main());
    }

    @Override
    public Observable<ResponseBody> chargePay(Map<String, String> queryMap) {
        return getService().chargePay(queryMap).compose(RxsRxSchedulers.<ResponseBody>io_main());
    }
}
