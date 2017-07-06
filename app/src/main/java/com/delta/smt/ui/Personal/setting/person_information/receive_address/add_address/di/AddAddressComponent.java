package com.delta.smt.ui.Personal.setting.person_information.receive_address.add_address.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.commonlibs.di.scope.FragmentScope;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.ui.Personal.setting.person_information.receive_address.add_address.AddAddressActivity;

import dagger.Component;


/**
 * Created by Fuxiang.Zhang on 2017/5/7.
 */

//@FragmentScope
@ActivityScope
@Component(modules = AddAddressModule.class, dependencies = AppComponent.class)
public interface AddAddressComponent {
    void inject(AddAddressActivity activity);
//    void inject(AddAddressFragment Fragment);
}