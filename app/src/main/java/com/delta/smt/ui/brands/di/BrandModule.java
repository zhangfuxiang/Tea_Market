package com.delta.smt.ui.brands.di;


import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.api.ApiService;
import com.delta.smt.ui.brands.mvp.BrandContract;
import com.delta.smt.ui.brands.mvp.BrandModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by V.Wenju.Tian on 2016/11/29.
 */

@Module
public class BrandModule {
    BrandContract.View view;
    public BrandModule(BrandContract.View view) {
        this.view = view;
    }
    @ActivityScope
    @Provides
    public BrandContract.View providerView() {
        return view;
    }
    @ActivityScope
    @Provides
    public BrandContract.Model providerModel(ApiService service) {
        return new BrandModel(service);
    }
}
