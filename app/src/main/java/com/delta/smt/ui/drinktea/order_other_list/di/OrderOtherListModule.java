package com.delta.smt.ui.drinktea.order_other_list.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.api.ApiService;
import com.delta.smt.ui.drinktea.order_other_list.mvp.OrderOtherListContract;
import com.delta.smt.ui.drinktea.order_other_list.mvp.OrderOtherListModel;

import dagger.Module;
import dagger.Provides;


/**
 * Created by wushufeng on 2017/4/20.
 */

@Module
public class OrderOtherListModule {
    private OrderOtherListContract.View mView;

    /**
     * 构建OrderOtherListModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public OrderOtherListModule(OrderOtherListContract.View view) {
        this.mView = view;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    OrderOtherListContract.View provideOrderOtherListView() {
        return mView;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    OrderOtherListContract.Model provideOrderOtherListModel(ApiService apiService) {
        return new OrderOtherListModel(apiService);
    }
}