package com.delta.smt.ui.HomePage.subjectActivity.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.api.ApiService;
import com.delta.smt.ui.HomePage.subjectActivity.mvp.SubjectActivityContract;
import com.delta.smt.ui.HomePage.subjectActivity.mvp.SubjectActivityModel;

import dagger.Module;
import dagger.Provides;


/**
 * Created by wushufeng on 2017/3/19.
 */

@Module
public class SubjectActivityModule {
    private SubjectActivityContract.View mView;

    /**
     * 构建SubjectActivityModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public SubjectActivityModule(SubjectActivityContract.View view) {
        this.mView = view;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    SubjectActivityContract.View provideSubjectActivityView() {
        return mView;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    SubjectActivityContract.Model provideSubjectActivityModel(ApiService apiService) {
        return new SubjectActivityModel(apiService);
    }
}