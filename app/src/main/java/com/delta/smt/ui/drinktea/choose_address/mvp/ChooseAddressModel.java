package com.delta.smt.ui.drinktea.choose_address.mvp;

import com.delta.commonlibs.utils.RxsRxSchedulers;
import com.delta.smt.api.ApiService;
import com.delta.smt.base.BaseModel;
import com.delta.smt.entity.drinktea.UserAddress;

import rx.Observable;


/**
 * Created by wushufeng on 2017/4/22.
 */


public class ChooseAddressModel extends BaseModel<ApiService> implements ChooseAddressContract.Model {

    public ChooseAddressModel(ApiService apiService) {
        super(apiService);
    }

    @Override
    public Observable<UserAddress> getUserAddressList(String token, String merchant_id) {
        return getService().getUserAddressList(token, merchant_id).compose(RxsRxSchedulers.<UserAddress>io_main());
    }


    /*@Override
    public Observable<List<String>> getReceivingAddress() {
        List<String> list = new ArrayList<>();
        list.add("北京市朝阳区望京街道广顺南大街16号嘉美中心写字楼1221室");
        list.add("北京市朝阳区望京街道广顺南大街16号嘉美中心写字楼1221室");
        list.add("北京市朝阳区望京街道广顺南大街16号嘉美中心写字楼1221室");
        list.add("北京市朝阳区望京街道广顺南大街16号嘉美中心写字楼1221室");
        list.add("北京市朝阳区望京街道广顺南大街16号嘉美中心写字楼1221室");
        list.add("北京市朝阳区望京街道广顺南大街16号嘉美中心写字楼1221室");
        list.add("北京市朝阳区望京街道广顺南大街16号嘉美中心写字楼1221室");
        list.add("北京市朝阳区望京街道广顺南大街16号嘉美中心写字楼1221室");
        list.add("北京市朝阳区望京街道广顺南大街16号嘉美中心写字楼1221室");
        return Observable.just(list);
    }*/
}