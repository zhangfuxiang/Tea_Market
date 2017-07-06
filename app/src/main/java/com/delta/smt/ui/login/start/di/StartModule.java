package com.delta.smt.ui.login.start.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.api.ApiService;
import com.delta.smt.ui.login.start.mvp.StartContract;
import com.delta.smt.ui.login.start.mvp.StartModel;

import dagger.Module;
import dagger.Provides;


/**
 * Created by wushufeng on 2017/4/4.
 */

@Module
public class StartModule {
    private StartContract.View mView;

    /**
     * 构建StartModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public StartModule(StartContract.View view) {
        this.mView = view;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    StartContract.View provideStartView() {
        return mView;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    StartContract.Model provideStartModel(ApiService apiService) {
        return new StartModel(apiService);
    }
}