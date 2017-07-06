package com.delta.smt.ui.find.systemShop.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.ui.find.systemShop.SystemShopActivity;

import dagger.Component;


/**
 * Created by Shufeng.Wu on 2017/3/23.
 */

//@FragmentScope
@ActivityScope
@Component(modules = SystemShopModule.class, dependencies = AppComponent.class)
public interface SystemShopComponent {
    void inject(SystemShopActivity activity);
//    void inject(SystemShopFragment Fragment);
}