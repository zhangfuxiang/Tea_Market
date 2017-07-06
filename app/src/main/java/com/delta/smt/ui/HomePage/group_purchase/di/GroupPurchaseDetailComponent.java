package com.delta.smt.ui.HomePage.group_purchase.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.ui.HomePage.group_purchase.GroupPurchaseDetailActivity;
import com.delta.smt.ui.HomePage.rush_to_purchase.RushToBuyDetailActivity;

import dagger.Component;


/**
 * Created by wushufeng on 2017/3/25.
 */

//@FragmentScope
@ActivityScope
@Component(modules = GroupPurchaseDetailModule.class, dependencies = AppComponent.class)
public interface GroupPurchaseDetailComponent {
    void inject(GroupPurchaseDetailActivity activity);
}