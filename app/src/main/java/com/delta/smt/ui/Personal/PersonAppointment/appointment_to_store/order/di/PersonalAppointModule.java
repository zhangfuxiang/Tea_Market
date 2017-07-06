package com.delta.smt.ui.Personal.PersonAppointment.appointment_to_store.order.di;


import com.delta.commonlibs.di.scope.FragmentScope;
import com.delta.smt.api.ApiService;
import com.delta.smt.ui.Personal.PersonAppointment.appointment_to_store.order.mvp.PersonalAppointContract;
import com.delta.smt.ui.Personal.PersonAppointment.appointment_to_store.order.mvp.PersonalAppointModel;

import dagger.Provides;


@dagger.Module
public class PersonalAppointModule {

    PersonalAppointContract.View view;

    public PersonalAppointModule(PersonalAppointContract.View view) {
        this.view = view;
    }
    @FragmentScope
    @Provides
    PersonalAppointContract.View providerView() {
        return view;
    }

    @FragmentScope
    @Provides
    PersonalAppointContract.Model providerModel(ApiService service) {
        return new PersonalAppointModel(service);
    }
}
