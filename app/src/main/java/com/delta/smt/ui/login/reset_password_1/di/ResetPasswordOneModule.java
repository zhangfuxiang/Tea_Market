package com.delta.smt.ui.login.reset_password_1.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.api.ApiService;
import com.delta.smt.ui.login.reset_password_1.mvp.ResetPasswordOneConstract;
import com.delta.smt.ui.login.reset_password_1.mvp.ResetPasswordOneModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by wushufeng on 2017/3/16.
 */

@Module
public class ResetPasswordOneModule {
    ResetPasswordOneConstract.View view;

    public ResetPasswordOneModule(ResetPasswordOneConstract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    ResetPasswordOneConstract.View providerView() {
        return view;
    }

    @ActivityScope
    @Provides
    ResetPasswordOneConstract.Model providerModel(ApiService service) {
        return new ResetPasswordOneModel(service);
    }
}
