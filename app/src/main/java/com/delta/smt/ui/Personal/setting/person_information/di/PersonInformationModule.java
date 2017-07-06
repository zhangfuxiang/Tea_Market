package com.delta.smt.ui.Personal.setting.person_information.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.commonlibs.di.scope.FragmentScope;
import com.delta.smt.api.ApiService;
import com.delta.smt.ui.Personal.setting.person_information.mvp.PersonInformationContract;
import com.delta.smt.ui.Personal.setting.person_information.mvp.PersonInformationModel;

import dagger.Module;
import dagger.Provides;


/**
 * Created by Fuxiang.Zhang on 2017/5/7.
 */

@Module
public class PersonInformationModule {
    private PersonInformationContract.View mView;

    /**
     * 构建PersonInformationModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public PersonInformationModule(PersonInformationContract.View view) {
        this.mView = view;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    PersonInformationContract.View providePersonInformationView() {
        return mView;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    PersonInformationContract.Model providePersonInformationModel(ApiService apiService) {
        return new PersonInformationModel(apiService);
    }
}