package com.delta.smt.ui.buycar.myAddressList.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.ui.buycar.myAddressList.MyAddressListActivity;

import dagger.Component;


/**
 * Created by wushufeng on 2017/5/5.
 */

//@FragmentScope
@ActivityScope
@Component(modules = MyAddressListModule.class, dependencies = AppComponent.class)
public interface MyAddressListComponent {
    void inject(MyAddressListActivity activity);
//    void inject(MyAddressListFragment Fragment);
}