package com.delta.smt.ui.Personal.di;

import com.delta.commonlibs.di.scope.FragmentScope;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.ui.Personal.Balance.BalanceActivity;
import com.delta.smt.ui.Personal.PersonalFragment;
import com.delta.smt.ui.Personal.setting.account_security.AccountActivity;
import com.delta.smt.ui.Personal.setting.account_security.resetChargePassword.ChangePasswordActivity;
import com.delta.smt.ui.Personal.setting.account_security.ChangePhoneActivity;
import com.delta.smt.ui.Personal.setting.account_security.resetChargePassword.ResetChargePasswordActivity;

import dagger.Component;

/**
 * Created by V.Wenju.Tian on 2016/11/29.
 */
@FragmentScope
@Component(modules = PresonalModule.class, dependencies = AppComponent.class)
public interface PresonalComponent {
    void inject(PersonalFragment personalFragment);

    void inject(AccountActivity accountActivity);

    void inject(ChangePhoneActivity changePhoneActivity);

    void inject(ChangePasswordActivity changePassword);

    void inject(ResetChargePasswordActivity resetChargePasswordActivity);

    void inject(BalanceActivity balanceActivity);
}
