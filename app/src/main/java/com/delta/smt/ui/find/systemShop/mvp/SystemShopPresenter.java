package com.delta.smt.ui.find.systemShop.mvp;

import android.util.Log;

import com.delta.commonlibs.base.mvp.BasePresenter;
import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.entity.ShopCommodityListItem;
import com.delta.smt.entity.home_page.home_page_ads.classify_goods.ProductCategoryListResult;

import javax.inject.Inject;

import rx.functions.Action1;

/**
 * Created by Shufeng.Wu on 2017/3/23.
 */

//@FragmentScope
@ActivityScope
public class SystemShopPresenter extends BasePresenter<SystemShopContract.Model, SystemShopContract.View> {


    @Inject
    public SystemShopPresenter(SystemShopContract.Model model, SystemShopContract.View mView) {
        super(model, mView);
    }

    public void getCommodityList(String token,
                                 String page,
                                 String size,
                                 String allow_other_sale,
                                 String category_id,
                                 String order,
                                 String order_type
    ) {
        getModel().getCommodityList(token, page, size, allow_other_sale, category_id, order, order_type).subscribe(new Action1<ShopCommodityListItem>() {
            @Override
            public void call(ShopCommodityListItem shopCommodityListItem) {
                if (shopCommodityListItem.getApp_code().equals("22000")) {
                    Log.i(TAG, "call: ");
                    getView().onCommodityListSuccess(shopCommodityListItem);
                } else {
                    getView().onCommodityListFailed(shopCommodityListItem);
                }
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                getView().onCommodityListFailed(throwable);
            }
        });
    }

    public void searhGoods(String token,
                                 String page,
                                 String size,
                                 String keyWord
    ) {
        getModel().searchGoods(token, page, size, keyWord).subscribe(new Action1<ShopCommodityListItem>() {
            @Override
            public void call(ShopCommodityListItem shopCommodityListItem) {

                if (shopCommodityListItem.getApp_code().equals("22000")) {
                    Log.i(TAG, "call: ");
                    getView().onCommodityListSuccess(shopCommodityListItem);
                } else {
                    getView().onCommodityListFailed(shopCommodityListItem);
                }

            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                getView().onCommodityListFailed(throwable);
            }
        });
    }

    public void getCommodityClassify(String type, String as_tree) {
        getModel().getCommodityClassify(type, as_tree).subscribe(new Action1<ProductCategoryListResult>() {
            @Override
            public void call(ProductCategoryListResult productCategoryListResult) {
                if (productCategoryListResult.getApp_code().equals("22000")) {
                    Log.i(TAG, "call: ");
                    getView().onCommodityClassifySuccess(productCategoryListResult);
                } else {
                    getView().onCommodityClassifyFailed(productCategoryListResult);
                }
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                getView().onCommodityClassifyFailed(throwable);
            }
        });
    }

}