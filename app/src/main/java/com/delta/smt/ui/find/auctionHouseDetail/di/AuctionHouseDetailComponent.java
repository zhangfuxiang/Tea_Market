package com.delta.smt.ui.find.auctionHouseDetail.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.ui.find.auctionHouseDetail.AuctionHouseDetailActivity;

import dagger.Component;


/**
 * Created by wushufeng on 2017/3/20.
 */

//@FragmentScope
@ActivityScope
@Component(modules = AuctionHouseDetailModule.class, dependencies = AppComponent.class)
public interface AuctionHouseDetailComponent {
    void inject(AuctionHouseDetailActivity activity);
//    void inject(AuctionHouseDetailFragment Fragment);
}