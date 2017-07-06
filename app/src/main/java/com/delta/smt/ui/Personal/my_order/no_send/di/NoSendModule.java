package com.delta.smt.ui.Personal.my_order.no_send.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.commonlibs.di.scope.FragmentScope;
import com.delta.smt.api.ApiService;
import com.delta.smt.ui.Personal.my_order.no_send.mvp.NoSendContract;
import com.delta.smt.ui.Personal.my_order.no_send.mvp.NoSendModel;

import dagger.Module;
import dagger.Provides;


/**
 * Created by Fuxiang.Zhang on 2017/4/25.
 */

@Module
public class NoSendModule {
    private NoSendContract.View mView;

    /**
     * 构建NoSendModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public NoSendModule(NoSendContract.View view) {
        this.mView = view;
    }

      @FragmentScope
//    @ActivityScope
    @Provides
    NoSendContract.View provideNoSendView() {
        return mView;
    }

      @FragmentScope
//    @ActivityScope
    @Provides
    NoSendContract.Model provideNoSendModel(ApiService apiService) {
        return new NoSendModel(apiService);
    }
}