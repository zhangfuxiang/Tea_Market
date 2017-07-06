package com.delta.smt.ui.HomePage.group_purchase.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.api.ApiService;
import com.delta.smt.ui.HomePage.rush_to_purchase.mvp.RushBuyDetailContract;
import com.delta.smt.ui.HomePage.rush_to_purchase.mvp.RushBuyDetailModel;

import dagger.Module;
import dagger.Provides;


/**
 * Created by wushufeng on 2017/3/25.
 */

@Module
public class GroupPurchaseDetailModule {
    private RushBuyDetailContract.View mView;

    /**
     * 构建ProductDetailModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public GroupPurchaseDetailModule(RushBuyDetailContract.View view) {
        this.mView = view;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    RushBuyDetailContract.View provideProductDetailView() {
        return mView;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    RushBuyDetailContract.Model provideProductDetailModel(ApiService apiService) {
        return new RushBuyDetailModel(apiService);
    }
}