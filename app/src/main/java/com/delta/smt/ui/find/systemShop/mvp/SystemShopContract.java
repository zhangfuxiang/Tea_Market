package com.delta.smt.ui.find.systemShop.mvp;

import com.delta.commonlibs.base.mvp.IModel;
import com.delta.commonlibs.base.mvp.IView;
import com.delta.smt.entity.ShopCommodityListItem;
import com.delta.smt.entity.home_page.home_page_ads.classify_goods.ProductCategoryListResult;

import rx.Observable;


/**
 * Created by Shufeng.Wu on 2017/3/23.
 */

public interface SystemShopContract {
    //对于经常使用的关于UI的方法可以定义到BaseView中,如显示隐藏进度条,和显示文字消息
    interface View extends IView {
        void onCommodityListSuccess(ShopCommodityListItem item);

        void onCommodityListFailed(ShopCommodityListItem item);

        void onCommodityListFailed(Throwable throwable);

        void onCommodityClassifySuccess(ProductCategoryListResult item);

        void onCommodityClassifyFailed(ProductCategoryListResult item);

        void onCommodityClassifyFailed(Throwable throwable);
    }

    //Model层定义接口,外部只需关心model返回的数据,无需关心内部细节,及是否使用缓存
    interface Model extends IModel {
        Observable<ShopCommodityListItem> getCommodityList(String token,
                                                           String page,
                                                           String size,
                                                           String allow_other_sale,
                                                           String category_id,
                                                           String order,
                                                           String order_type);

        Observable<ShopCommodityListItem> searchGoods(String token,
                                                           String page,
                                                           String size,
                                                           String keyword);

        Observable<ProductCategoryListResult> getCommodityClassify(String type, String as_tree);
    }
}