package com.delta.smt.ui.drinktea.order_this_list.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.ui.drinktea.order_this_list.OrderThisListActivity;

import dagger.Component;


/**
 * Created by wushufeng on 2017/5/14.
 */

//@FragmentScope
@ActivityScope
@Component(modules = OrderThisListModule.class, dependencies = AppComponent.class)
public interface OrderThisListComponent {
    void inject(OrderThisListActivity activity);
//    void inject(OrderThisListFragment Fragment);
}