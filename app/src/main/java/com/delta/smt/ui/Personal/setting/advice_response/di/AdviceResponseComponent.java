package com.delta.smt.ui.Personal.setting.advice_response.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.commonlibs.di.scope.FragmentScope;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.ui.Personal.setting.advice_response.AdviceResponseActivity;

import dagger.Component;


/**
 * Created by Fuxiang.Zhang on 2017/5/20.
 */

//@FragmentScope
@ActivityScope
@Component(modules = AdviceResponseModule.class, dependencies = AppComponent.class)
public interface AdviceResponseComponent {
    void inject(AdviceResponseActivity activity);
//    void inject(AdviceResponseFragment Fragment);
}