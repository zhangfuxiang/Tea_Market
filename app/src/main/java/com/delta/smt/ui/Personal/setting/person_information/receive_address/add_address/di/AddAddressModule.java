package com.delta.smt.ui.Personal.setting.person_information.receive_address.add_address.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.commonlibs.di.scope.FragmentScope;
import com.delta.smt.api.ApiService;
import com.delta.smt.ui.Personal.setting.person_information.receive_address.add_address.mvp.AddAddressContract;
import com.delta.smt.ui.Personal.setting.person_information.receive_address.add_address.mvp.AddAddressModel;

import dagger.Module;
import dagger.Provides;


/**
 * Created by Fuxiang.Zhang on 2017/5/7.
 */

@Module
public class AddAddressModule {
    private AddAddressContract.View mView;

    /**
     * 构建AddAddressModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public AddAddressModule(AddAddressContract.View view) {
        this.mView = view;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    AddAddressContract.View provideAddAddressView() {
        return mView;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    AddAddressContract.Model provideAddAddressModel(ApiService apiService) {
        return new AddAddressModel(apiService);
    }
}