package com.delta.smt.ui.login.loginc.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.api.ApiService;
import com.delta.smt.ui.login.loginc.mvp.LoginCContract;
import com.delta.smt.ui.login.loginc.mvp.LoginCModel;

import dagger.Module;
import dagger.Provides;


/**
 * Created by wushufeng on 2017/5/3.
 */

@Module
public class LoginCModule {
    private LoginCContract.View mView;

    /**
     * 构建LoginCModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public LoginCModule(LoginCContract.View view) {
        this.mView = view;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    LoginCContract.View provideLoginCView() {
        return mView;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    LoginCContract.Model provideLoginCModel(ApiService apiService) {
        return new LoginCModel(apiService);
    }
}