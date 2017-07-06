package com.delta.smt.ui.Personal.Balance.BalanceDetail.order.di;


import com.delta.commonlibs.di.scope.FragmentScope;
import com.delta.smt.api.ApiService;
import com.delta.smt.ui.Personal.Balance.BalanceDetail.order.mvp.BlanceDetailContract;
import com.delta.smt.ui.Personal.Balance.BalanceDetail.order.mvp.BlanceDetailModel;

import dagger.Provides;


@dagger.Module
public class BlanceDetailModule {

    BlanceDetailContract.View view;

    public BlanceDetailModule(BlanceDetailContract.View view) {
        this.view = view;
    }
    @FragmentScope
    @Provides
    BlanceDetailContract.View providerView() {
        return view;
    }

    @FragmentScope
    @Provides
    BlanceDetailContract.Model providerModel(ApiService service) {
        return new BlanceDetailModel(service);
    }
}
