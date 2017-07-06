package com.delta.smt.ui.Personal.my_order.no_receive.mvp;

import com.delta.commonlibs.utils.RxsRxSchedulers;
import com.delta.smt.api.ApiService;
import com.delta.smt.base.BaseModel;
import com.delta.smt.entity.ItemBean1;
import com.delta.smt.entity.ItemNOReceive;

import java.util.Map;

import okhttp3.ResponseBody;
import rx.Observable;


/**
 * Created by Fuxiang.Zhang on 2017/4/25.
 */


public class NoReceiveModel extends BaseModel<ApiService> implements NoReceiveContract.Model {

    public NoReceiveModel(ApiService apiService) {
        super(apiService);
    }


    @Override
    public Observable<ResponseBody> getNoReceiveList(String token, String pay_status) {
        return getService().getNOReceiveList(token,pay_status,"2","50").compose(RxsRxSchedulers.<ResponseBody>io_main());
    }

    @Override
    public Observable<ResponseBody> confirmReceive(Map<String, String> queryMap) {
        return getService().confirmReceive(queryMap).compose(RxsRxSchedulers.<ResponseBody>io_main());
    }
}
