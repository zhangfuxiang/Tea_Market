package com.delta.smt.ui.Personal.my_order.no_payment.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.commonlibs.di.scope.FragmentScope;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.ui.Personal.my_order.no_payment.NoPaymentFragment;

import dagger.Component;


/**
 * Created by Fuxiang.Zhang on 2017/4/25.
 */

@FragmentScope
//@ActivityScope
@Component(modules = NoPaymentModule.class, dependencies = AppComponent.class)
public interface NoPaymentComponent {
//    void inject(NoPaymentActivity activity);
    void inject(NoPaymentFragment Fragment);
}