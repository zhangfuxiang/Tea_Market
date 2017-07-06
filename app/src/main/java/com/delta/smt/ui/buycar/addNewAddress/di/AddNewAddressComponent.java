package com.delta.smt.ui.buycar.addNewAddress.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.ui.buycar.addNewAddress.AddNewAddressActivity;

import dagger.Component;


/**
 * Created by wushufeng on 2017/5/7.
 */

//@FragmentScope
@ActivityScope
@Component(modules = AddNewAddressModule.class, dependencies = AppComponent.class)
public interface AddNewAddressComponent {
    void inject(AddNewAddressActivity activity);
//    void inject(AddNewAddressFragment Fragment);
}