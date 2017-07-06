package com.delta.smt.ui.login.register.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.ui.login.register.RegisterActivity;

import dagger.Component;

/**
 * Created by wushufeng on 2017/3/16.
 */

@ActivityScope
@Component(modules = RegisterModule.class, dependencies = AppComponent.class)
public interface RegisterComponent {
    void inject(RegisterActivity activity);
}