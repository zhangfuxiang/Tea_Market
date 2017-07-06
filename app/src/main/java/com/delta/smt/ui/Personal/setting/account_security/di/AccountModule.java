package com.delta.smt.ui.Personal.setting.account_security.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.commonlibs.di.scope.FragmentScope;
import com.delta.smt.api.ApiService;
import com.delta.smt.ui.Personal.setting.account_security.mvp.AccountContract;
import com.delta.smt.ui.Personal.setting.account_security.mvp.AccountModel;

import dagger.Module;
import dagger.Provides;


/**
 * Created by Fuxiang.Zhang on 2017/5/17.
 */

@Module
public class AccountModule {
    private AccountContract.View mView;

    /**
     * 构建AccountModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public AccountModule(AccountContract.View view) {
        this.mView = view;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    AccountContract.View provideAccountView() {
        return mView;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    AccountContract.Model provideAccountModel(ApiService apiService) {
        return new AccountModel(apiService);
    }
}