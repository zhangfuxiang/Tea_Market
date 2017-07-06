package com.delta.smt.ui.find.auctionHouseDetail.ProductPicTxtDetail.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.di.component.AppComponent;

import dagger.Component;


/**
 * Created by Fuxiang.Zhang on 2017/4/27.
 */

//@FragmentScope
@ActivityScope
@Component(modules = ProductPicTxtDetailComponentModule.class, dependencies = AppComponent.class)
public interface ProductPicTxtDetailComponent {
   // void inject(Pro activity);
//    void inject(OrderDetailFragment Fragment);
}