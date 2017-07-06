package com.delta.smt.ui.drinktea.order_this.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.ui.drinktea.order_this.OrderThisActivity;

import dagger.Component;


/**
 * Created by wushufeng on 2017/5/14.
 */

//@FragmentScope
@ActivityScope
@Component(modules = OrderThisModule.class, dependencies = AppComponent.class)
public interface OrderThisComponent {
    void inject(OrderThisActivity activity);
//    void inject(OrderThisFragment Fragment);
}