package com.delta.smt.ui.Personal.PayMerchant.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.api.ApiService;
import com.delta.smt.ui.Personal.PayMerchant.mvp.PayMerchantContract;
import com.delta.smt.ui.Personal.PayMerchant.mvp.PayMerchantModel;

import dagger.Module;
import dagger.Provides;


/**
 * Created by Fuxiang.Zhang on 2017/4/27.
 */

@Module
public class PayMerchantModule {
    private PayMerchantContract.View mView;

    /**
     * 构建OrderDetailModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public PayMerchantModule(PayMerchantContract.View view) {
        this.mView = view;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    PayMerchantContract.View provideOrderDetailView() {
        return mView;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    PayMerchantContract.Model provideOrderDetailModel(ApiService apiService) {
        return new PayMerchantModel(apiService);
    }
}