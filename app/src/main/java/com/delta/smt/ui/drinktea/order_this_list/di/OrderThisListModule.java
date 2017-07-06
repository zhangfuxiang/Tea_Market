package com.delta.smt.ui.drinktea.order_this_list.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.api.ApiService;
import com.delta.smt.ui.drinktea.order_this_list.mvp.OrderThisListContract;
import com.delta.smt.ui.drinktea.order_this_list.mvp.OrderThisListModel;

import dagger.Module;
import dagger.Provides;


/**
 * Created by wushufeng on 2017/5/14.
 */

@Module
public class OrderThisListModule {
    private OrderThisListContract.View mView;

    /**
     * 构建OrderThisListModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public OrderThisListModule(OrderThisListContract.View view) {
        this.mView = view;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    OrderThisListContract.View provideOrderThisListView() {
        return mView;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    OrderThisListContract.Model provideOrderThisListModel(ApiService apiService) {
        return new OrderThisListModel(apiService);
    }
}