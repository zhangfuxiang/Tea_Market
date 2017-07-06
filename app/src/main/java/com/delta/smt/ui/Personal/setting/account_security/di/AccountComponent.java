package com.delta.smt.ui.Personal.setting.account_security.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.ui.Personal.setting.account_security.ChangeNewPhoneActivity;
import com.delta.smt.ui.login.reset_password_1.di.ResetPasswordOneModule;

import dagger.Component;


/**
 * Created by Fuxiang.Zhang on 2017/5/17.
 */

//@FragmentScope
@ActivityScope
@Component(modules = {AccountModule.class, ResetPasswordOneModule.class},dependencies = AppComponent.class)
public interface AccountComponent {
    void inject(ChangeNewPhoneActivity changeNewPhoneActivity);
    //void inject(AccountActivity activity);
//    void inject(AccountFragment Fragment);
}