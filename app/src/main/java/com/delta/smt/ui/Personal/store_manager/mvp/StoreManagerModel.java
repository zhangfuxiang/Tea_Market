package com.delta.smt.ui.Personal.store_manager.mvp;

import com.delta.smt.api.ApiService;
import com.delta.smt.base.BaseModel;


/**
 * Created by Fuxiang.Zhang on 2017/4/24.
 */


public class StoreManagerModel extends BaseModel<ApiService> implements StoreManagerContract.Model {

    public StoreManagerModel(ApiService apiService) {
        super(apiService);
    }


}
