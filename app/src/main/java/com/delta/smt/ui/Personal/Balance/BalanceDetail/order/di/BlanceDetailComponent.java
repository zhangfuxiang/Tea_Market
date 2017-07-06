package com.delta.smt.ui.Personal.Balance.BalanceDetail.order.di;

import com.delta.commonlibs.di.scope.FragmentScope;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.ui.Personal.Balance.BalanceDetail.order.BalanceDetailFragment;

import dagger.Component;

/**
 * Created by V.Wenju.Tian on 2016/11/29.
 */
@FragmentScope
@Component(modules = BlanceDetailModule.class, dependencies = AppComponent.class)
public interface BlanceDetailComponent {
    void inject(BalanceDetailFragment personalFragment);
}
