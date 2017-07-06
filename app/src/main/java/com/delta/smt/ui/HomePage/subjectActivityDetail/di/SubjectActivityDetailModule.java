package com.delta.smt.ui.HomePage.subjectActivityDetail.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.api.ApiService;
import com.delta.smt.ui.HomePage.subjectActivityDetail.mvp.SubjectActivityDetailContract;
import com.delta.smt.ui.HomePage.subjectActivityDetail.mvp.SubjectActivityDetailModel;

import dagger.Module;
import dagger.Provides;


/**
 * Created by Shufeng.Wu on 2017/3/22.
 */

@Module
public class SubjectActivityDetailModule {
    private SubjectActivityDetailContract.View mView;

    /**
     * 构建SubjectActivityDetailModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public SubjectActivityDetailModule(SubjectActivityDetailContract.View view) {
        this.mView = view;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    SubjectActivityDetailContract.View provideSubjectActivityDetailView() {
        return mView;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    SubjectActivityDetailContract.Model provideSubjectActivityDetailModel(ApiService apiService) {
        return new SubjectActivityDetailModel(apiService);
    }
}