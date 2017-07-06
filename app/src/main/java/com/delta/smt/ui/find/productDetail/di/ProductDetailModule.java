package com.delta.smt.ui.find.productDetail.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.api.ApiService;
import com.delta.smt.ui.find.productDetail.mvp.ProductDetailContract;
import com.delta.smt.ui.find.productDetail.mvp.ProductDetailModel;

import dagger.Module;
import dagger.Provides;


/**
 * Created by wushufeng on 2017/3/25.
 */

@Module
public class ProductDetailModule {
    private ProductDetailContract.View mView;

    /**
     * 构建ProductDetailModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public ProductDetailModule(ProductDetailContract.View view) {
        this.mView = view;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    ProductDetailContract.View provideProductDetailView() {
        return mView;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    ProductDetailContract.Model provideProductDetailModel(ApiService apiService) {
        return new ProductDetailModel(apiService);
    }
}