package com.delta.smt.ui.find.auctionHouseDetail.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.api.ApiService;
import com.delta.smt.ui.find.auctionHouseDetail.mvp.AuctionHouseDetailContract;
import com.delta.smt.ui.find.auctionHouseDetail.mvp.AuctionHouseDetailModel;

import dagger.Module;
import dagger.Provides;


/**
 * Created by wushufeng on 2017/3/20.
 */

@Module
public class AuctionHouseDetailModule {
    private AuctionHouseDetailContract.View mView;

    /**
     * 构建AuctionHouseDetailModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public AuctionHouseDetailModule(AuctionHouseDetailContract.View view) {
        this.mView = view;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    AuctionHouseDetailContract.View provideAuctionHouseDetailView() {
        return mView;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    AuctionHouseDetailContract.Model provideAuctionHouseDetailModel(ApiService apiService) {
        return new AuctionHouseDetailModel(apiService);
    }
}