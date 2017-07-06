package com.delta.smt.ui.Personal.store_manager.mvp;

import android.util.Log;

import com.delta.commonlibs.base.mvp.BasePresenter;
import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.commonlibs.di.scope.FragmentScope;


import javax.inject.Inject;

/**
 * Created by Fuxiang.Zhang on 2017/4/24.
 */

//@FragmentScope
@ActivityScope
public class StoreManagerPresenter extends BasePresenter<StoreManagerContract.Model, StoreManagerContract.View> {


    @Inject
    public StoreManagerPresenter(StoreManagerContract.Model model, StoreManagerContract.View mView) {
        super(model, mView);
    }


}