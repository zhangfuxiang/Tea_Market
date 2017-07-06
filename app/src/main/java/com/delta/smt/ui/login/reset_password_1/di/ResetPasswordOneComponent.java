package com.delta.smt.ui.login.reset_password_1.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.ui.login.reset_password_1.ResetPasswordOneActivity;

import dagger.Component;

/**
 * Created by wushufeng on 2017/3/16.
 */

@ActivityScope
@Component(modules = ResetPasswordOneModule.class, dependencies = AppComponent.class)
public interface ResetPasswordOneComponent {
    void inject(ResetPasswordOneActivity activity);

    //void inject(ChangeNewPhoneActivity changeNewPhoneActivity);

    //void inject(ChangeNewPhoneActivity changeNewPhoneActivity);
}