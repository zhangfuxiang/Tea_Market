package com.delta.smt.ui.login.reset_password_2.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.api.ApiService;
import com.delta.smt.ui.login.reset_password_2.mvp.ResetPasswordTwoContract;
import com.delta.smt.ui.login.reset_password_2.mvp.ResetPasswordTwoModel;

import dagger.Module;
import dagger.Provides;


/**
 * Created by wushufeng on 2017/4/5.
 */

@Module
public class ResetPasswordTwoModule {
    private ResetPasswordTwoContract.View mView;

    /**
     * 构建ResetPasswordTwoModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public ResetPasswordTwoModule(ResetPasswordTwoContract.View view) {
        this.mView = view;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    ResetPasswordTwoContract.View provideResetPasswordTwoView() {
        return mView;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    ResetPasswordTwoContract.Model provideResetPasswordTwoModel(ApiService apiService) {
        return new ResetPasswordTwoModel(apiService);
    }
}