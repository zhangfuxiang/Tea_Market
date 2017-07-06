package com.delta.smt.ui.Personal.PersonalActivities.order.di;


import com.delta.commonlibs.di.scope.FragmentScope;
import com.delta.smt.api.ApiService;
import com.delta.smt.ui.Personal.PersonalActivities.order.mvp.PersonalActivityContract;
import com.delta.smt.ui.Personal.PersonalActivities.order.mvp.PersonalActivityModel;

import dagger.Provides;


@dagger.Module
public class PersonalActivityModule {

    PersonalActivityContract.View view;

    public PersonalActivityModule(PersonalActivityContract.View view) {
        this.view = view;
    }
    @FragmentScope
    @Provides
    PersonalActivityContract.View providerView() {
        return view;
    }

    @FragmentScope
    @Provides
    PersonalActivityContract.Model providerModel(ApiService service) {
        return new PersonalActivityModel(service);
    }
}
