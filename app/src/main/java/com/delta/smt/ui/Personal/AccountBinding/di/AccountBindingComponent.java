package com.delta.smt.ui.Personal.AccountBinding.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.ui.Personal.AccountBinding.AccountBindingActivity;

import dagger.Component;


/**
 * Created by Fuxiang.Zhang on 2017/4/27.
 */

//@FragmentScope
@ActivityScope
@Component(modules = AccountBindingModule.class, dependencies = AppComponent.class)
public interface AccountBindingComponent {
    void inject(AccountBindingActivity activity);
//    void inject(OrderDetailFragment Fragment);
}