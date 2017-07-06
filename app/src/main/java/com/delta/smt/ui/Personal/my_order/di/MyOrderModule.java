package com.delta.smt.ui.Personal.my_order.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.commonlibs.di.scope.FragmentScope;
import com.delta.smt.api.ApiService;
import com.delta.smt.ui.Personal.my_order.mvp.MyOrderContract;
import com.delta.smt.ui.Personal.my_order.mvp.MyOrderModel;

import dagger.Module;
import dagger.Provides;


/**
 * Created by Fuxiang.Zhang on 2017/4/25.
 */

@Module
public class MyOrderModule {
    private MyOrderContract.View mView;

    /**
     * 构建MyOrderModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public MyOrderModule(MyOrderContract.View view) {
        this.mView = view;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    MyOrderContract.View provideMyOrderView() {
        return mView;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    MyOrderContract.Model provideMyOrderModel(ApiService apiService) {
        return new MyOrderModel(apiService);
    }
}