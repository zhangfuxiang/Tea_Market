package com.delta.smt.ui.Personal.setting.person_information.receive_address.edit_address.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.commonlibs.di.scope.FragmentScope;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.ui.Personal.setting.person_information.receive_address.edit_address.EditAddressActivity;

import dagger.Component;


/**
 * Created by Fuxiang.Zhang on 2017/5/7.
 */

//@FragmentScope
@ActivityScope
@Component(modules = EditAddressModule.class, dependencies = AppComponent.class)
public interface EditAddressComponent {
    void inject(EditAddressActivity activity);
//    void inject(EditAddressFragment Fragment);
}