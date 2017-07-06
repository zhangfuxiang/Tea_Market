package com.delta.smt.ui.Personal.my_order.all_content.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.commonlibs.di.scope.FragmentScope;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.ui.Personal.my_order.all_content.AllContentFragment;

import dagger.Component;


/**
 * Created by Fuxiang.Zhang on 2017/4/25.
 */

@FragmentScope
//@ActivityScope
@Component(modules = AllContentModule.class, dependencies = AppComponent.class)
public interface AllContentComponent {
//    void inject(AllContentActivity activity);
    void inject(AllContentFragment Fragment);
}