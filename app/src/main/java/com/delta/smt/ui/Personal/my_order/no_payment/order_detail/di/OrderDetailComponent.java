package com.delta.smt.ui.Personal.my_order.no_payment.order_detail.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.commonlibs.di.scope.FragmentScope;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.ui.Personal.my_order.no_payment.order_detail.OrderDetailActivity;

import dagger.Component;


/**
 * Created by Fuxiang.Zhang on 2017/4/27.
 */

//@FragmentScope
@ActivityScope
@Component(modules = OrderDetailModule.class, dependencies = AppComponent.class)
public interface OrderDetailComponent {
    void inject(OrderDetailActivity activity);
//    void inject(OrderDetailFragment Fragment);
}