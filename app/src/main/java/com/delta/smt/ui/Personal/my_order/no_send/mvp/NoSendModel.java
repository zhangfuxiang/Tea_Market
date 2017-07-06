package com.delta.smt.ui.Personal.my_order.no_send.mvp;

import com.delta.commonlibs.utils.RxsRxSchedulers;
import com.delta.smt.api.ApiService;
import com.delta.smt.base.BaseModel;
import com.delta.smt.entity.ItemNOSend;

import okhttp3.ResponseBody;
import rx.Observable;


/**
 * Created by Fuxiang.Zhang on 2017/4/25.
 */


public class NoSendModel extends BaseModel<ApiService> implements NoSendContract.Model {

    public NoSendModel(ApiService apiService) {
        super(apiService);
    }


    @Override
    public Observable<ResponseBody> getNoSendList(String token, String pay_status,String page,String size) {
        return getService().getNoSendList(token,pay_status,"1",page,size).compose(RxsRxSchedulers.<ResponseBody>io_main());
    }
}
