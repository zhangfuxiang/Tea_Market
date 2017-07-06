package com.delta.smt.ui.Personal.Balance.charge.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.ui.Personal.Balance.charge.ChargeActivity;

import dagger.Component;


/**
 * Created by Fuxiang.Zhang on 2017/4/27.
 */

//@FragmentScope
@ActivityScope
@Component(modules = ChargeModule.class, dependencies = AppComponent.class)
public interface ChargeComponent {
    void inject(ChargeActivity activity);
//    void inject(OrderDetailFragment Fragment);
}