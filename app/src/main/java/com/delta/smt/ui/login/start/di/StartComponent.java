package com.delta.smt.ui.login.start.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.StartActivity;
import com.delta.smt.di.component.AppComponent;

import dagger.Component;


/**
 * Created by wushufeng on 2017/4/4.
 */

//@FragmentScope
@ActivityScope
@Component(modules = StartModule.class, dependencies = AppComponent.class)
public interface StartComponent {
    void inject(StartActivity activity);
//    void inject(StartFragment Fragment);
}