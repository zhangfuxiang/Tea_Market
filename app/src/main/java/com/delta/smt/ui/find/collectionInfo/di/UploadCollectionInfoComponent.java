package com.delta.smt.ui.find.collectionInfo.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.ui.find.collectionInfo.UploadCollectionInfoActivity;

import dagger.Component;


/**
 * Created by Shufeng.Wu on 2017/3/22.
 */

//@FragmentScope
@ActivityScope
@Component(modules = UploadCollectionInfoModule.class, dependencies = AppComponent.class)
public interface UploadCollectionInfoComponent {
    void inject(UploadCollectionInfoActivity activity);
//    void inject(UploadCollectionInfoFragment Fragment);
}