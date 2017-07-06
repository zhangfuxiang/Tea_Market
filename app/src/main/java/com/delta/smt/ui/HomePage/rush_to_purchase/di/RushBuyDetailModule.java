package com.delta.smt.ui.HomePage.rush_to_purchase.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.api.ApiService;
import com.delta.smt.ui.HomePage.rush_to_purchase.mvp.RushBuyDetailContract;
import com.delta.smt.ui.HomePage.rush_to_purchase.mvp.RushBuyDetailModel;
import com.delta.smt.ui.find.productDetail.mvp.ProductDetailContract;
import com.delta.smt.ui.find.productDetail.mvp.ProductDetailModel;

import dagger.Module;
import dagger.Provides;


/**
 * Created by wushufeng on 2017/3/25.
 */

@Module
public class RushBuyDetailModule {
    private RushBuyDetailContract.View mView;

    /**
     * 构建ProductDetailModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public RushBuyDetailModule(RushBuyDetailContract.View view) {
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