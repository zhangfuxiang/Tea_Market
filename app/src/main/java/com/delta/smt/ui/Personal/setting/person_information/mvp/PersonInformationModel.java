package com.delta.smt.ui.Personal.setting.person_information.mvp;

import com.delta.commonlibs.utils.RxsRxSchedulers;
import com.delta.smt.api.ApiService;
import com.delta.smt.base.BaseModel;
import com.delta.smt.entity.ImageHeaderBean;
import com.delta.smt.entity.ItemUserInformation;

import java.io.File;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import rx.Observable;


/**
 * Created by Fuxiang.Zhang on 2017/5/7.
 */


public class PersonInformationModel extends BaseModel<ApiService> implements PersonInformationContract.Model {

    public PersonInformationModel(ApiService apiService) {
        super(apiService);
    }


    @Override
    public Observable<ResponseBody> getPersonInformation(String token) {
        return getService().getPersonInformation(token).compose(RxsRxSchedulers.<ResponseBody>io_main());
    }

    @Override
    public Observable<ResponseBody> updatePersonInformation(Map<String,String> querymap) {
        return getService().updatePersonInformation(querymap).compose(RxsRxSchedulers.<ResponseBody>io_main());
    }

    @Override
    public Observable<ResponseBody> submitImage(String token, MultipartBody.Part params) {
        return getService().submitImage(token,params).compose(RxsRxSchedulers.<ResponseBody>io_main());
    }
}
