package com.delta.smt.ui.buycar.updateUserAddress.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.api.ApiService;
import com.delta.smt.ui.buycar.updateUserAddress.mvp.UpdateUserAddressContract;
import com.delta.smt.ui.buycar.updateUserAddress.mvp.UpdateUserAddressModel;

import dagger.Module;
import dagger.Provides;


/**
 * Created by wushufeng on 2017/5/11.
 */

@Module
public class UpdateUserAddressModule {
    private UpdateUserAddressContract.View mView;

    /**
     * 构建UpdateUserAddressModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public UpdateUserAddressModule(UpdateUserAddressContract.View view) {
        this.mView = view;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    UpdateUserAddressContract.View provideUpdateUserAddressView() {
        return mView;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    UpdateUserAddressContract.Model provideUpdateUserAddressModel(ApiService apiService) {
        return new UpdateUserAddressModel(apiService);
    }
}