package com.delta.smt.ui.find.auctionHouse.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.api.ApiService;
import com.delta.smt.ui.find.auctionHouse.mvp.AuctionHouseContract;
import com.delta.smt.ui.find.auctionHouse.mvp.AuctionHouseModel;

import dagger.Module;
import dagger.Provides;


/**
 * Created by wushufeng on 2017/3/18.
 */

@Module
public class AuctionHouseModule {
    private AuctionHouseContract.View mView;

    /**
     * 构建AuctionHouseModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public AuctionHouseModule(AuctionHouseContract.View view) {
        this.mView = view;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    AuctionHouseContract.View provideAuctionHouseView() {
        return mView;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    AuctionHouseContract.Model provideAuctionHouseModel(ApiService apiService) {
        return new AuctionHouseModel(apiService);
    }
}