package com.delta.smt.ui.find.collectionInfo.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.api.ApiService;
import com.delta.smt.ui.find.collectionInfo.mvp.UploadCollectionInfoContract;
import com.delta.smt.ui.find.collectionInfo.mvp.UploadCollectionInfoModel;

import dagger.Module;
import dagger.Provides;


/**
 * Created by Shufeng.Wu on 2017/3/22.
 */

@Module
public class UploadCollectionInfoModule {
    private UploadCollectionInfoContract.View mView;

    /**
     * 构建UploadCollectionInfoModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public UploadCollectionInfoModule(UploadCollectionInfoContract.View view) {
        this.mView = view;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    UploadCollectionInfoContract.View provideUploadCollectionInfoView() {
        return mView;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    UploadCollectionInfoContract.Model provideUploadCollectionInfoModel(ApiService apiService) {
        return new UploadCollectionInfoModel(apiService);
    }
}