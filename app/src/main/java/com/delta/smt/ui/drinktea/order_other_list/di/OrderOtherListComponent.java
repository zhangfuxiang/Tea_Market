package com.delta.smt.ui.drinktea.order_other_list.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.ui.drinktea.order_other_list.OrderOtherListActivity;

import dagger.Component;


/**
 * Created by wushufeng on 2017/4/20.
 */

//@FragmentScope
@ActivityScope
@Component(modules = OrderOtherListModule.class, dependencies = AppComponent.class)
public interface OrderOtherListComponent {
    void inject(OrderOtherListActivity activity);
//    void inject(OrderOtherListFragment Fragment);
}