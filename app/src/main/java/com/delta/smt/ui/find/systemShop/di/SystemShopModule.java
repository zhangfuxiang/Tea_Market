package com.delta.smt.ui.find.systemShop.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.api.ApiService;
import com.delta.smt.ui.find.systemShop.mvp.SystemShopContract;
import com.delta.smt.ui.find.systemShop.mvp.SystemShopModel;

import dagger.Module;
import dagger.Provides;


/**
 * Created by Shufeng.Wu on 2017/3/23.
 */

@Module
public class SystemShopModule {
    private SystemShopContract.View mView;

    /**
     * 构建SystemShopModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public SystemShopModule(SystemShopContract.View view) {
        this.mView = view;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    SystemShopContract.View provideSystemShopView() {
        return mView;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    SystemShopContract.Model provideSystemShopModel(ApiService apiService) {
        return new SystemShopModel(apiService);
    }
}