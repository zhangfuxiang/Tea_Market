package com.delta.smt.ui.login.register.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.api.ApiService;
import com.delta.smt.ui.login.register.mvp.RegisterContract;
import com.delta.smt.ui.login.register.mvp.RegisterModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by wushufeng on 2017/3/16.
 */

@Module
public class RegisterModule {
    RegisterContract.View view;

    public RegisterModule(RegisterContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    RegisterContract.View providerView() {
        return view;
    }

    @ActivityScope
    @Provides
    RegisterContract.Model providerModel(ApiService service) {
        return new RegisterModel(service);
    }
}
