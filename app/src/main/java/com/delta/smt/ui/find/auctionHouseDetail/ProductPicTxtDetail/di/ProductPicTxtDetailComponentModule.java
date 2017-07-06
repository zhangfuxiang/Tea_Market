package com.delta.smt.ui.find.auctionHouseDetail.ProductPicTxtDetail.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.api.ApiService;
import com.delta.smt.ui.find.auctionHouseDetail.ProductPicTxtDetail.mvp.ProductPicTxtDetailComponentContract;
import com.delta.smt.ui.find.auctionHouseDetail.ProductPicTxtDetail.mvp.ProductPicTxtDetailComponentModel;

import dagger.Module;
import dagger.Provides;


/**
 * Created by Fuxiang.Zhang on 2017/4/27.
 */

@Module
public class ProductPicTxtDetailComponentModule {
    private ProductPicTxtDetailComponentContract.View mView;

    /**
     * 构建OrderDetailModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public ProductPicTxtDetailComponentModule(ProductPicTxtDetailComponentContract.View view) {
        this.mView = view;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    ProductPicTxtDetailComponentContract.View provideOrderDetailView() {
        return mView;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    ProductPicTxtDetailComponentContract.Model provideOrderDetailModel(ApiService apiService) {
        return new ProductPicTxtDetailComponentModel(apiService);
    }
}