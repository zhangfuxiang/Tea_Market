package com.delta.smt.ui.find.collectionInfo.mvp;

import com.delta.commonlibs.base.mvp.BasePresenter;
import com.delta.commonlibs.di.scope.ActivityScope;

import javax.inject.Inject;

/**
 * Created by Shufeng.Wu on 2017/3/22.
 */

//@FragmentScope
@ActivityScope
public class UploadCollectionInfoPresenter extends BasePresenter<UploadCollectionInfoContract.Model, UploadCollectionInfoContract.View> {


    @Inject
    public UploadCollectionInfoPresenter(UploadCollectionInfoContract.Model model, UploadCollectionInfoContract.View mView) {
        super(model, mView);
    }


}