package com.delta.smt.ui.Personal.store_manager.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.commonlibs.di.scope.FragmentScope;
import com.delta.smt.api.ApiService;
import com.delta.smt.ui.Personal.store_manager.mvp.StoreManagerContract;
import com.delta.smt.ui.Personal.store_manager.mvp.StoreManagerModel;

import dagger.Module;
import dagger.Provides;


/**
 * Created by Fuxiang.Zhang on 2017/4/24.
 */

@Module
public class StoreManagerModule {
    private StoreManagerContract.View mView;

    /**
     * 构建StoreManagerModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public StoreManagerModule(StoreManagerContract.View view) {
        this.mView = view;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    StoreManagerContract.View provideStoreManagerView() {
        return mView;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    StoreManagerContract.Model provideStoreManagerModel(ApiService apiService) {
        return new StoreManagerModel(apiService);
    }
}