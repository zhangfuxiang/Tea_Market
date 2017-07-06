package com.delta.smt.ui.Personal.AccountBinding.mvp;

import com.delta.smt.api.ApiService;
import com.delta.smt.base.BaseModel;


/**
 * Created by Fuxiang.Zhang on 2017/4/27.
 */


public class AccountBindingModel extends BaseModel<ApiService> implements AccountBindingContract.Model {

    public AccountBindingModel(ApiService apiService) {
        super(apiService);
    }


}
