package com.delta.smt.ui.find.auctionHouse.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.ui.find.auctionHouse.AuctionHouseActivity;

import dagger.Component;


/**
 * Created by wushufeng on 2017/3/18.
 */

//@FragmentScope
@ActivityScope
@Component(modules = AuctionHouseModule.class, dependencies = AppComponent.class)
public interface AuctionHouseComponent {
    void inject(AuctionHouseActivity activity);
//    void inject(AuctionHouseFragment Fragment);
}