package com.delta.smt.ui.Personal.my_order.no_payment.order_detail.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.commonlibs.di.scope.FragmentScope;
import com.delta.smt.api.ApiService;
import com.delta.smt.ui.Personal.my_order.no_payment.order_detail.mvp.OrderDetailContract;
import com.delta.smt.ui.Personal.my_order.no_payment.order_detail.mvp.OrderDetailModel;

import dagger.Module;
import dagger.Provides;


/**
 * Created by Fuxiang.Zhang on 2017/4/27.
 */

@Module
public class OrderDetailModule {
    private OrderDetailContract.View mView;

    /**
     * 构建OrderDetailModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public OrderDetailModule(OrderDetailContract.View view) {
        this.mView = view;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    OrderDetailContract.View provideOrderDetailView() {
        return mView;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    OrderDetailContract.Model provideOrderDetailModel(ApiService apiService) {
        return new OrderDetailModel(apiService);
    }
}