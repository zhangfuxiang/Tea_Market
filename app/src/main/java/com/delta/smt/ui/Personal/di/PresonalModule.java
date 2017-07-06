package com.delta.smt.ui.Personal.di;


import com.delta.commonlibs.di.scope.FragmentScope;
import com.delta.smt.api.ApiService;
import com.delta.smt.ui.Personal.mvp.PersonalContract;
import com.delta.smt.ui.Personal.mvp.PresonalModel;

import dagger.Module;
import dagger.Provides;


@Module
public class PresonalModule {

    PersonalContract.View view;

    public PresonalModule(PersonalContract.View view) {
        this.view = view;
    }
    @FragmentScope
    @Provides
    PersonalContract.View providerView() {
        return view;
    }

    @FragmentScope
    @Provides
    PersonalContract.Model providerModel(ApiService service) {
        return new PresonalModel(service);
    }
}
