package com.delta.smt.ui.HomePage.productDetail.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.ui.HomePage.productDetail.ProductDetailActivity;

import dagger.Component;


/**
 * Created by wushufeng on 2017/3/25.
 */

//@FragmentScope
@ActivityScope
@Component(modules = ProductDetailModule.class, dependencies = AppComponent.class)
public interface ProductDetailComponent {
    void inject(ProductDetailActivity activity);
//    void inject(ProductDetailFragment Fragment);
}