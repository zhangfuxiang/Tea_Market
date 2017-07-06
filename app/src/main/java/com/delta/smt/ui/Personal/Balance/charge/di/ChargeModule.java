package com.delta.smt.ui.Personal.Balance.charge.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.api.ApiService;
import com.delta.smt.ui.Personal.Balance.charge.mvp.ChargeContract;
import com.delta.smt.ui.Personal.Balance.charge.mvp.ChargeModel;

import dagger.Module;
import dagger.Provides;


/**
 * Created by Fuxiang.Zhang on 2017/4/27.
 */

@Module
public class ChargeModule {
    private ChargeContract.View mView;

    /**
     * 构建OrderDetailModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public ChargeModule(ChargeContract.View view) {
        this.mView = view;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    ChargeContract.View provideOrderDetailView() {
        return mView;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    ChargeContract.Model provideOrderDetailModel(ApiService apiService) {
        return new ChargeModel(apiService);
    }
}