package com.delta.smt.ui.Personal.my_order.no_send.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.commonlibs.di.scope.FragmentScope;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.ui.Personal.my_order.no_send.NoSendFragment;

import dagger.Component;


/**
 * Created by Fuxiang.Zhang on 2017/4/25.
 */

@FragmentScope
//@ActivityScope
@Component(modules = NoSendModule.class, dependencies = AppComponent.class)
public interface NoSendComponent {
//    void inject(NoSendActivity activity);
    void inject(NoSendFragment Fragment);
}