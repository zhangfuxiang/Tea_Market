package com.delta.smt.ui.main.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.api.ApiService;
import com.delta.smt.ui.main.mvp.MainContract;
import com.delta.smt.ui.main.mvp.MainModel;

import dagger.Module;
import dagger.Provides;


/**
 * Created by V.Wenju.Tian on 2016/11/29.
 */

@Module
public class MainModule {

    MainContract.View view;
    public MainModule(MainContract.View view) {
        this.view = view;
    }
    @ActivityScope
    @Provides
    MainContract.View providerView() {
        return view;
    }

    @ActivityScope
    @Provides
    MainContract.Model providerModel(ApiService service) {
        return new MainModel(service);
    }
}
