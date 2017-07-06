package com.delta.smt.ui.Personal.PersonAppointment.AppointmentDetail.mvp;

import com.delta.commonlibs.utils.RxsRxSchedulers;
import com.delta.smt.api.ApiService;
import com.delta.smt.base.BaseModel;

import java.util.Map;

import okhttp3.ResponseBody;
import rx.Observable;


/**
 * Created by Fuxiang.Zhang on 2017/4/27.
 */


public class PersonalAppointmentDetailModel extends BaseModel<ApiService> implements PersonalAppointmentDetailContract.Model {

    public PersonalAppointmentDetailModel(ApiService apiService) {
        super(apiService);
    }


    @Override
    public Observable<ResponseBody> cancelAppointMent(Map<String, String> queryMap) {
        return getService().cancelAppointMent(queryMap).compose(RxsRxSchedulers.<ResponseBody>io_main());
    }

    @Override
    public Observable<ResponseBody> arrive(Map<String, String> queryMap1) {
        return getService().arrive(queryMap1).compose(RxsRxSchedulers.<ResponseBody>io_main());
    }
}
