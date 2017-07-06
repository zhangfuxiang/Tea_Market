package com.delta.smt.ui.Personal.setting.person_information.receive_address.edit_address.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.commonlibs.di.scope.FragmentScope;
import com.delta.smt.api.ApiService;
import com.delta.smt.ui.Personal.setting.person_information.receive_address.edit_address.mvp.EditAddressContract;
import com.delta.smt.ui.Personal.setting.person_information.receive_address.edit_address.mvp.EditAddressModel;

import dagger.Module;
import dagger.Provides;


/**
 * Created by Fuxiang.Zhang on 2017/5/7.
 */

@Module
public class EditAddressModule {
    private EditAddressContract.View mView;

    /**
     * 构建EditAddressModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public EditAddressModule(EditAddressContract.View view) {
        this.mView = view;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    EditAddressContract.View provideEditAddressView() {
        return mView;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    EditAddressContract.Model provideEditAddressModel(ApiService apiService) {
        return new EditAddressModel(apiService);
    }
}