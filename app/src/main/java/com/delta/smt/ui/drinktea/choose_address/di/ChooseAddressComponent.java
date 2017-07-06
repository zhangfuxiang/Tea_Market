package com.delta.smt.ui.drinktea.choose_address.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.ui.drinktea.choose_address.ChooseAddressActivity;

import dagger.Component;


/**
 * Created by wushufeng on 2017/4/22.
 */

//@FragmentScope
@ActivityScope
@Component(modules = ChooseAddressModule.class, dependencies = AppComponent.class)
public interface ChooseAddressComponent {
    void inject(ChooseAddressActivity activity);
//    void inject(ChooseAddressFragment Fragment);
}