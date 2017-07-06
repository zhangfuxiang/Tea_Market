package com.delta.smt.ui.buycar.addNewAddress.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.api.ApiService;
import com.delta.smt.ui.buycar.addNewAddress.mvp.AddNewAddressContract;
import com.delta.smt.ui.buycar.addNewAddress.mvp.AddNewAddressModel;

import dagger.Module;
import dagger.Provides;


/**
 * Created by wushufeng on 2017/5/7.
 */

@Module
public class AddNewAddressModule {
    private AddNewAddressContract.View mView;

    /**
     * 构建AddNewAddressModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public AddNewAddressModule(AddNewAddressContract.View view) {
        this.mView = view;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    AddNewAddressContract.View provideAddNewAddressView() {
        return mView;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    AddNewAddressContract.Model provideAddNewAddressModel(ApiService apiService) {
        return new AddNewAddressModel(apiService);
    }
}