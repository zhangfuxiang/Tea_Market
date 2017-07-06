package com.delta.smt.ui.Personal.AccountBinding.mvp;

import com.delta.commonlibs.base.mvp.BasePresenter;
import com.delta.commonlibs.di.scope.ActivityScope;

import javax.inject.Inject;

/**
 * Created by Fuxiang.Zhang on 2017/4/27.
 */

//@FragmentScope
@ActivityScope
public class AccountBindingPresenter extends BasePresenter<AccountBindingContract.Model, AccountBindingContract.View> {


    @Inject
    public AccountBindingPresenter(AccountBindingContract.Model model, AccountBindingContract.View mView) {
        super(model, mView);
    }


}