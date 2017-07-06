package com.delta.smt.ui.find.myGivePrice.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.ui.find.myGivePrice.MyGivePriceActivity;

import dagger.Component;


/**
 * Created by wushufeng on 2017/3/21.
 */

//@FragmentScope
@ActivityScope
@Component(modules = MyGivePriceModule.class, dependencies = AppComponent.class)
public interface MyGivePriceComponent {
    void inject(MyGivePriceActivity activity);
//    void inject(MyGivePriceFragment Fragment);
}