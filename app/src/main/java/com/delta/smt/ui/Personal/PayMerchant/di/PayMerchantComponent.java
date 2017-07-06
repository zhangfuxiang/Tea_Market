package com.delta.smt.ui.Personal.PayMerchant.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.ui.Personal.PayMerchant.PayMerchantActivity;

import dagger.Component;


/**
 * Created by Fuxiang.Zhang on 2017/4/27.
 */

//@FragmentScope
@ActivityScope
@Component(modules = PayMerchantModule.class, dependencies = AppComponent.class)
public interface PayMerchantComponent {
    void inject(PayMerchantActivity activity);
//    void inject(OrderDetailFragment Fragment);
}