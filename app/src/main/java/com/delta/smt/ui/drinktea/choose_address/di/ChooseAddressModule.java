package com.delta.smt.ui.drinktea.choose_address.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.api.ApiService;
import com.delta.smt.ui.drinktea.choose_address.mvp.ChooseAddressContract;
import com.delta.smt.ui.drinktea.choose_address.mvp.ChooseAddressModel;

import dagger.Module;
import dagger.Provides;


/**
 * Created by wushufeng on 2017/4/22.
 */

@Module
public class ChooseAddressModule {
    private ChooseAddressContract.View mView;

    /**
     * 构建ChooseAddressModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public ChooseAddressModule(ChooseAddressContract.View view) {
        this.mView = view;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    ChooseAddressContract.View provideChooseAddressView() {
        return mView;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    ChooseAddressContract.Model provideChooseAddressModel(ApiService apiService) {
        return new ChooseAddressModel(apiService);
    }
}