package com.delta.smt.ui.HomePage.subjectActivity.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.ui.HomePage.subjectActivity.SubjectActivityActivity;

import dagger.Component;


/**
 * Created by wushufeng on 2017/3/19.
 */

//@FragmentScope
@ActivityScope
@Component(modules = SubjectActivityModule.class, dependencies = AppComponent.class)
public interface SubjectActivityComponent {
    void inject(SubjectActivityActivity activity);
//    void inject(SubjectActivityFragment Fragment);
}