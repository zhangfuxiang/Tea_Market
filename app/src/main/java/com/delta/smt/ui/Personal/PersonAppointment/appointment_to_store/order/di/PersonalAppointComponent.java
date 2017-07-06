package com.delta.smt.ui.Personal.PersonAppointment.appointment_to_store.order.di;

import com.delta.commonlibs.di.scope.FragmentScope;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.ui.Personal.PersonAppointment.appointment_to_store.order.PersonalAppointFragment;

import dagger.Component;

/**
 * Created by V.Wenju.Tian on 2016/11/29.
 */
@FragmentScope
@Component(modules = PersonalAppointModule.class, dependencies = AppComponent.class)
public interface PersonalAppointComponent {
    void inject(PersonalAppointFragment personalFragment);
}
