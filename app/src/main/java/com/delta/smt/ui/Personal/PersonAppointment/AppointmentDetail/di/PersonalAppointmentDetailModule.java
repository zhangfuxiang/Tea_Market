package com.delta.smt.ui.Personal.PersonAppointment.AppointmentDetail.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.api.ApiService;
import com.delta.smt.ui.Personal.PersonAppointment.AppointmentDetail.mvp.PersonalAppointmentDetailContract;
import com.delta.smt.ui.Personal.PersonAppointment.AppointmentDetail.mvp.PersonalAppointmentDetailModel;

import dagger.Module;
import dagger.Provides;


/**
 * Created by Fuxiang.Zhang on 2017/4/27.
 */

@Module
public class PersonalAppointmentDetailModule {
    private PersonalAppointmentDetailContract.View mView;

    /**
     * 构建OrderDetailModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public PersonalAppointmentDetailModule(PersonalAppointmentDetailContract.View view) {
        this.mView = view;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    PersonalAppointmentDetailContract.View provideOrderDetailView() {
        return mView;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    PersonalAppointmentDetailContract.Model provideOrderDetailModel(ApiService apiService) {
        return new PersonalAppointmentDetailModel(apiService);
    }
}