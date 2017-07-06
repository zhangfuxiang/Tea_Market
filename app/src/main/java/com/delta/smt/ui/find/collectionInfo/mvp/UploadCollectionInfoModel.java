package com.delta.smt.ui.find.collectionInfo.mvp;

import com.delta.smt.api.ApiService;
import com.delta.smt.base.BaseModel;
import com.delta.smt.entity.UploadCollectionInfoResult;

import rx.Observable;


/**
 * Created by Shufeng.Wu on 2017/3/22.
 */


public class UploadCollectionInfoModel extends BaseModel<ApiService> implements UploadCollectionInfoContract.Model {

    public UploadCollectionInfoModel(ApiService apiService) {
        super(apiService);
    }


    @Override
    public Observable<UploadCollectionInfoResult> sendCollectionInfo(String str) {
        return null;
    }
}