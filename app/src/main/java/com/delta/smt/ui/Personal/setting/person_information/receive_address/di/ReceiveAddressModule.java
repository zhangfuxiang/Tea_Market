package com.delta.smt.ui.Personal.setting.person_information.receive_address.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.commonlibs.di.scope.FragmentScope;
import com.delta.smt.api.ApiService;
import com.delta.smt.ui.Personal.setting.person_information.receive_address.mvp.ReceiveAddressContract;
import com.delta.smt.ui.Personal.setting.person_information.receive_address.mvp.ReceiveAddressModel;

import dagger.Module;
import dagger.Provides;


/**
 * Created by Fuxiang.Zhang on 2017/5/7.
 */

@Module
public class ReceiveAddressModule {
    private ReceiveAddressContract.View mView;

    /**
     * 构建ReceiveAddressModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public ReceiveAddressModule(ReceiveAddressContract.View view) {
        this.mView = view;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    ReceiveAddressContract.View provideReceiveAddressView() {
        return mView;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    ReceiveAddressContract.Model provideReceiveAddressModel(ApiService apiService) {
        return new ReceiveAddressModel(apiService);
    }
}