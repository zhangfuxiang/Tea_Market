package com.delta.smt.ui.brands.di;


import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.ui.brands.BrandListActivity;

import dagger.Component;

/**
 * Created by V.Wenju.Tian on 2016/11/29.
 */
@ActivityScope
@Component(modules = BrandModule.class, dependencies = AppComponent.class)
public interface BrandComponent {
    void inject(BrandListActivity activity);
}
