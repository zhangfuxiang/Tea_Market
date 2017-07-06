package com.delta.smt.ui.Personal.PayMerchant.mvp;

import com.delta.commonlibs.utils.RxsRxSchedulers;
import com.delta.smt.api.ApiService;
import com.delta.smt.base.BaseModel;
import com.delta.smt.entity.MerchantInfo;

import java.util.Map;

import okhttp3.ResponseBody;
import rx.Observable;


/**
 * Created by Fuxiang.Zhang on 2017/4/27.
 */


public class PayMerchantModel extends BaseModel<ApiService> implements PayMerchantContract.Model {

    public PayMerchantModel(ApiService apiService) {
        super(apiService);
    }


    @Override
    public Observable<MerchantInfo> getMerchantInfo(Map<String, String> stringStringMap) {
        return getService().getMerchantInfo(stringStringMap).compose(RxsRxSchedulers.<MerchantInfo>io_main());
    }

    @Override
    public Observable<ResponseBody> pay(Map<String, String> stringStringMap) {
        return getService().pay(stringStringMap).compose(RxsRxSchedulers.<ResponseBody>io_main());
    }
}
