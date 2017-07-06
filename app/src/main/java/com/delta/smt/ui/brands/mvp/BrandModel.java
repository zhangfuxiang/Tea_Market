package com.delta.smt.ui.brands.mvp;

import com.delta.commonlibs.utils.RxsRxSchedulers;
import com.delta.smt.api.ApiService;
import com.delta.smt.base.BaseModel;
import com.delta.smt.entity.Brands;

import java.util.HashMap;
import java.util.Map;

import rx.Observable;


/**
 * @description :
 * @autHor :  V.Wenju.Tian
 * @date : 2016/12/14 10:37
 */


public class BrandModel extends BaseModel<ApiService> implements BrandContract.Model {


    public BrandModel(ApiService apiService) {
        super(apiService);
    }

    @Override
    public Observable<Brands> getBrands(int index) {
        Map<String, String> maps = new HashMap<>();
        maps.put("limit", "20");
        maps.put("offset", index + "");
        maps.put("gender", "1");
        maps.put("generation", "2");
        return getService().getBrands(maps).compose(RxsRxSchedulers.<Brands>io_main());
    }

}
