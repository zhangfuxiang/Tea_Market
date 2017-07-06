package com.delta.smt.ui.find.priceRecord.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.ui.find.priceRecord.PriceRecordActivity;

import dagger.Component;


/**
 * Created by Shufeng.Wu on 2017/3/21.
 */

//@FragmentScope
@ActivityScope
@Component(modules = PriceRecordModule.class, dependencies = AppComponent.class)
public interface PriceRecordComponent {
    void inject(PriceRecordActivity activity);
//    void inject(PriceRecordFragment Fragment);
}