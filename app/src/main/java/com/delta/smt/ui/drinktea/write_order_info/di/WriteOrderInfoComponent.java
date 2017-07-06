package com.delta.smt.ui.drinktea.write_order_info.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.ui.drinktea.write_order_info.WriteOrderInfoActivity;

import dagger.Component;


/**
 * Created by wushufeng on 2017/4/21.
 */

//@FragmentScope
@ActivityScope
@Component(modules = WriteOrderInfoModule.class, dependencies = AppComponent.class)
public interface WriteOrderInfoComponent {
    void inject(WriteOrderInfoActivity activity);
//    void inject(WriteOrderInfoFragment Fragment);
}