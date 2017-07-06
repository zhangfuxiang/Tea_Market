package com.delta.smt.ui.Personal.my_order.no_receive.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.commonlibs.di.scope.FragmentScope;
import com.delta.smt.api.ApiService;
import com.delta.smt.ui.Personal.my_order.no_receive.mvp.NoReceiveContract;
import com.delta.smt.ui.Personal.my_order.no_receive.mvp.NoReceiveModel;

import dagger.Module;
import dagger.Provides;


/**
 * Created by Fuxiang.Zhang on 2017/4/25.
 */

@Module
public class NoReceiveModule {
    private NoReceiveContract.View mView;

    /**
     * 构建NoReceiveModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public NoReceiveModule(NoReceiveContract.View view) {
        this.mView = view;
    }

      @FragmentScope
//    @ActivityScope
    @Provides
    NoReceiveContract.View provideNoReceiveView() {
        return mView;
    }

      @FragmentScope
//    @ActivityScope
    @Provides
    NoReceiveContract.Model provideNoReceiveModel(ApiService apiService) {
        return new NoReceiveModel(apiService);
    }
}