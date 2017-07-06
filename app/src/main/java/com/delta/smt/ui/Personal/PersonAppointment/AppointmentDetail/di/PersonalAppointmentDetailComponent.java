package com.delta.smt.ui.Personal.PersonAppointment.AppointmentDetail.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.ui.Personal.PersonAppointment.AppointmentDetail.PersonAppointmentDetailActivity;

import dagger.Component;


/**
 * Created by Fuxiang.Zhang on 2017/4/27.
 */

//@FragmentScope
@ActivityScope
@Component(modules = PersonalAppointmentDetailModule.class, dependencies = AppComponent.class)
public interface PersonalAppointmentDetailComponent {
    void inject(PersonAppointmentDetailActivity activity);
//    void inject(OrderDetailFragment Fragment);
}