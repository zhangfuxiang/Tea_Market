package com.delta.smt.ui.Personal.my_order.no_payment.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.commonlibs.di.scope.FragmentScope;
import com.delta.smt.api.ApiService;
import com.delta.smt.ui.Personal.my_order.no_payment.mvp.NoPaymentContract;
import com.delta.smt.ui.Personal.my_order.no_payment.mvp.NoPaymentModel;

import dagger.Module;
import dagger.Provides;


/**
 * Created by Fuxiang.Zhang on 2017/4/25.
 */

@Module
public class NoPaymentModule {
    private NoPaymentContract.View mView;

    /**
     * 构建NoPaymentModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public NoPaymentModule(NoPaymentContract.View view) {
        this.mView = view;
    }

      @FragmentScope
//    @ActivityScope
    @Provides
    NoPaymentContract.View provideNoPaymentView() {
        return mView;
    }

      @FragmentScope
//    @ActivityScope
    @Provides
    NoPaymentContract.Model provideNoPaymentModel(ApiService apiService) {
        return new NoPaymentModel(apiService);
    }
}