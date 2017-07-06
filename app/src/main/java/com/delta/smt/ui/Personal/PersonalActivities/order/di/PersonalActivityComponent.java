package com.delta.smt.ui.Personal.PersonalActivities.order.di;

import com.delta.commonlibs.di.scope.FragmentScope;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.ui.Personal.PersonalActivities.order.PersonalActivityFragment;

import dagger.Component;

/**
 * Created by V.Wenju.Tian on 2016/11/29.
 */
@FragmentScope
@Component(modules = PersonalActivityModule.class, dependencies = AppComponent.class)
public interface PersonalActivityComponent {
    void inject(PersonalActivityFragment personalFragment);
}
