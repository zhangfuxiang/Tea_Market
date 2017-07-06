package com.delta.smt.ui.main.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.ui.login.login.LoginActivity;
import com.delta.smt.ui.login.login.di.LoginModule;

import dagger.Component;

/**
 * Created by V.Wenju.Tian on 2016/11/29.
 */
@ActivityScope
@Component(modules = LoginModule.class, dependencies = AppComponent.class)
public interface LoginComponent {
    void inject(LoginActivity activity);
}
