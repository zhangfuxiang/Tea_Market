package com.delta.smt.ui.login.reset_password_2.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.ui.login.reset_password_2.ResetPasswordTwoActivity;

import dagger.Component;


/**
 * Created by wushufeng on 2017/4/5.
 */

//@FragmentScope
@ActivityScope
@Component(modules = ResetPasswordTwoModule.class, dependencies = AppComponent.class)
public interface ResetPasswordTwoComponent {
    void inject(ResetPasswordTwoActivity activity);
//    void inject(ResetPasswordTwoFragment Fragment);
}