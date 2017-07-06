package com.delta.smt.ui.Personal.my_order.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.commonlibs.di.scope.FragmentScope;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.ui.Personal.my_order.MyOrderActivity;

import dagger.Component;


/**
 * Created by Fuxiang.Zhang on 2017/4/25.
 */

//@FragmentScope
@ActivityScope
@Component(modules = MyOrderModule.class, dependencies = AppComponent.class)
public interface MyOrderComponent {
    void inject(MyOrderActivity activity);
//    void inject(MyOrderFragment Fragment);
}