package com.delta.smt.ui.Personal.AccountBinding.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.api.ApiService;
import com.delta.smt.ui.Personal.AccountBinding.mvp.AccountBindingContract;
import com.delta.smt.ui.Personal.AccountBinding.mvp.AccountBindingModel;

import dagger.Module;
import dagger.Provides;


/**
 * Created by Fuxiang.Zhang on 2017/4/27.
 */

@Module
public class AccountBindingModule {
    private AccountBindingContract.View mView;

    /**
     * 构建OrderDetailModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public AccountBindingModule(AccountBindingContract.View view) {
        this.mView = view;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    AccountBindingContract.View provideOrderDetailView() {
        return mView;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    AccountBindingContract.Model provideOrderDetailModel(ApiService apiService) {
        return new AccountBindingModel(apiService);
    }
}