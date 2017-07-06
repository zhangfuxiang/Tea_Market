package com.delta.smt.ui.Personal.my_order.mvp;

import android.util.Log;

import com.delta.commonlibs.base.mvp.BasePresenter;
import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.commonlibs.di.scope.FragmentScope;


import javax.inject.Inject;

/**
 * Created by Fuxiang.Zhang on 2017/4/25.
 */

//@FragmentScope
@ActivityScope
public class MyOrderPresenter extends BasePresenter<MyOrderContract.Model, MyOrderContract.View> {


    @Inject
    public MyOrderPresenter(MyOrderContract.Model model, MyOrderContract.View mView) {
        super(model, mView);
    }


}