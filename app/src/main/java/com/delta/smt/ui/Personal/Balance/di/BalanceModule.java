package com.delta.smt.ui.Personal.Balance.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.api.ApiService;
import com.delta.smt.ui.Personal.Balance.mvp.BalanceContract;
import com.delta.smt.ui.Personal.Balance.mvp.BalanceModel;

import dagger.Module;
import dagger.Provides;


/**
 * Created by Fuxiang.Zhang on 2017/4/27.
 */

@Module
public class BalanceModule {
    private BalanceContract.View mView;

    /**
     * 构建OrderDetailModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public BalanceModule(BalanceContract.View view) {
        this.mView = view;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    BalanceContract.View provideOrderDetailView() {
        return mView;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    BalanceContract.Model provideOrderDetailModel(ApiService apiService) {
        return new BalanceModel(apiService);
    }
}