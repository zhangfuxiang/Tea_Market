package com.delta.smt.ui.find.confirmOrder.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.ui.find.confirmOrder.ConfirmOrderActivity;

import dagger.Component;


/**
 * Created by wushufeng on 2017/3/29.
 */

//@FragmentScope
@ActivityScope
@Component(modules = ConfirmOrderModule.class, dependencies = AppComponent.class)
public interface ConfirmOrderComponent {
    void inject(ConfirmOrderActivity activity);
//    void inject(ComfirmOrderFragment Fragment);
}