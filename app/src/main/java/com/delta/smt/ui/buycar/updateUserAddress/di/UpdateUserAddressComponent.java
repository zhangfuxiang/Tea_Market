package com.delta.smt.ui.find.updateUserAddress.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.ui.buycar.updateUserAddress.UpdateUserAddressActivity;
import com.delta.smt.ui.buycar.updateUserAddress.di.UpdateUserAddressModule;

import dagger.Component;


/**
 * Created by wushufeng on 2017/5/11.
 */

//@FragmentScope
@ActivityScope
@Component(modules = UpdateUserAddressModule.class, dependencies = AppComponent.class)
public interface UpdateUserAddressComponent {
    void inject(UpdateUserAddressActivity activity);
//    void inject(UpdateUserAddressFragment Fragment);
}