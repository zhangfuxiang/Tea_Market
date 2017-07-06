package com.delta.smt.ui.Personal.setting.advice_response.mvp;

import com.delta.commonlibs.utils.RxsRxSchedulers;
import com.delta.smt.api.ApiService;
import com.delta.smt.base.BaseModel;
import com.delta.smt.entity.ItemBean1;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import rx.Observable;


/**
 * Created by Fuxiang.Zhang on 2017/5/20.
 */


public class AdviceResponseModel extends BaseModel<ApiService> implements AdviceResponseContract.Model {

    public AdviceResponseModel(ApiService apiService) {
        super(apiService);
    }


    @Override
    public Observable<ItemBean1> submitAdvice(Map<String, String> queryMap) {
        return getService().submitAdvice(queryMap).compose(RxsRxSchedulers.<ItemBean1>io_main());
    }

    @Override
    public Observable<ResponseBody> submitImage(String token, MultipartBody.Part params) {
        return getService().submitImage(token,params).compose(RxsRxSchedulers.<ResponseBody>io_main());
    }
}
