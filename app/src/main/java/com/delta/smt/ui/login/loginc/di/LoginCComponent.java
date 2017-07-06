package com.delta.smt.ui.login.loginc.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.ui.login.loginc.LoginCActivity;

import dagger.Component;


/**
 * Created by wushufeng on 2017/5/3.
 */

//@FragmentScope
@ActivityScope
@Component(modules = LoginCModule.class, dependencies = AppComponent.class)
public interface LoginCComponent {
    void inject(LoginCActivity activity);
//    void inject(LoginCFragment Fragment);
}