package com.delta.smt.ui.Personal.store_manager.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.commonlibs.di.scope.FragmentScope;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.ui.Personal.store_manager.StoreManagerActivity;

import dagger.Component;


/**
 * Created by Fuxiang.Zhang on 2017/4/24.
 */

//@FragmentScope
@ActivityScope
@Component(modules = StoreManagerModule.class, dependencies = AppComponent.class)
public interface StoreManagerComponent {
    void inject(StoreManagerActivity activity);
//    void inject(StoreManagerFragment Fragment);
}