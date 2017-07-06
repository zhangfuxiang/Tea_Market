package com.delta.smt.ui.drinktea.order_this.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.api.ApiService;
import com.delta.smt.ui.drinktea.order_this.mvp.OrderThisContract;
import com.delta.smt.ui.drinktea.order_this.mvp.OrderThisModel;

import dagger.Module;
import dagger.Provides;


/**
 * Created by wushufeng on 2017/5/14.
 */

@Module
public class OrderThisModule {
    private OrderThisContract.View mView;

    /**
     * 构建OrderThisModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public OrderThisModule(OrderThisContract.View view) {
        this.mView = view;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    OrderThisContract.View provideOrderThisView() {
        return mView;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    OrderThisContract.Model provideOrderThisModel(ApiService apiService) {
        return new OrderThisModel(apiService);
    }
}