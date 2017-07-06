package com.delta.smt.ui.find.auctionHouseDetail.ProductPicTxtDetail.mvp;

import com.delta.commonlibs.utils.RxsRxSchedulers;
import com.delta.smt.api.ApiService;
import com.delta.smt.base.BaseModel;

import java.util.Map;

import okhttp3.ResponseBody;
import rx.Observable;


/**
 * Created by Fuxiang.Zhang on 2017/4/27.
 */


public class ProductPicTxtDetailComponentModel extends BaseModel<ApiService> implements ProductPicTxtDetailComponentContract.Model {

    public ProductPicTxtDetailComponentModel(ApiService apiService) {
        super(apiService);
    }


    @Override
    public Observable<ResponseBody> withdraw(Map<String, String> stringObjectMap) {
        return getService().withdraw(stringObjectMap).compose(RxsRxSchedulers.<ResponseBody>io_main());
    }
}
