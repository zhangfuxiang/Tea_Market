package com.delta.smt.ui.Personal.Balance.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.ui.Personal.Balance.withDraw.WithdrawActivity;

import dagger.Component;


/**
 * Created by Fuxiang.Zhang on 2017/4/27.
 */

//@FragmentScope
@ActivityScope
@Component(modules = BalanceModule.class, dependencies = AppComponent.class)
public interface BalanceComponent {
    void inject(WithdrawActivity activity);
//    void inject(OrderDetailFragment Fragment);
}