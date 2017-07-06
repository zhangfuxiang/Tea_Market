package com.delta.smt.ui.Personal.setting.person_information.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.commonlibs.di.scope.FragmentScope;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.ui.Personal.setting.person_information.PersonInformationActivity;

import dagger.Component;


/**
 * Created by Fuxiang.Zhang on 2017/5/7.
 */

//@FragmentScope
@ActivityScope
@Component(modules = PersonInformationModule.class, dependencies = AppComponent.class)
public interface PersonInformationComponent {
    void inject(PersonInformationActivity activity);
//    void inject(PersonInformationFragment Fragment);
}