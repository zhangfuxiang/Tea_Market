package com.delta.smt.ui.buycar.buycar.di;

import com.delta.commonlibs.di.scope.FragmentScope;
import com.delta.smt.api.ApiService;
import com.delta.smt.ui.buycar.buycar.mvp.BuyCarContract;
import com.delta.smt.ui.buycar.buycar.mvp.BuyCarModel;

import dagger.Module;
import dagger.Provides;


/**
 * Created by wushufeng on 2017/3/27.
 */

@Module
public class BuyCarModule {
    private BuyCarContract.View mView;

    /**
     * 构建BuyCarModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public BuyCarModule(BuyCarContract.View view) {
        this.mView = view;
    }

    @FragmentScope
    //@ActivityScope
    @Provides
    BuyCarContract.View provideBuyCarView() {
        return mView;
    }

    @FragmentScope
    //@ActivityScope
    @Provides
    BuyCarContract.Model provideBuyCarModel(ApiService apiService) {
        return new BuyCarModel(apiService);
    }
}