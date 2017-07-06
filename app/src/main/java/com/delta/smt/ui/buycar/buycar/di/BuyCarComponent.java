package com.delta.smt.ui.buycar.buycar.di;

import com.delta.commonlibs.di.scope.FragmentScope;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.ui.buycar.BuyCarFragment;

import dagger.Component;


/**
 * Created by wushufeng on 2017/3/27.
 */

@FragmentScope
//@ActivityScope
@Component(modules = BuyCarModule.class, dependencies = AppComponent.class)
public interface BuyCarComponent {
    //void inject(BuyCarActivity activity);
    void inject(BuyCarFragment Fragment);
}