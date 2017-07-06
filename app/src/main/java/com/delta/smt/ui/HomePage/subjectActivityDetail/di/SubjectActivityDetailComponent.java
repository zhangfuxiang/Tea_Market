package com.delta.smt.ui.HomePage.subjectActivityDetail.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.ui.HomePage.subjectActivityDetail.SubjectActivityDetailActivity;

import dagger.Component;


/**
 * Created by Shufeng.Wu on 2017/3/22.
 */

//@FragmentScope
@ActivityScope
@Component(modules = SubjectActivityDetailModule.class, dependencies = AppComponent.class)
public interface SubjectActivityDetailComponent {
    void inject(SubjectActivityDetailActivity activity);
//    void inject(SubjectActivityDetailFragment Fragment);
}