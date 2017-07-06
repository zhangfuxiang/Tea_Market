package com.delta.smt.ui.main.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.MainActivity;
import com.delta.smt.di.component.AppComponent;

import dagger.Component;


/**
 * Created by wushufeng on 2017/5/14.
 */

//@FragmentScope
@ActivityScope
@Component(modules = MainModule.class, dependencies = AppComponent.class)
public interface MainComponent {
    void inject(MainActivity activity);
//    void inject(MainFragment Fragment);
}