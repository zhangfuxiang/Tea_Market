package com.delta.smt.ui.drinktea.order_other_list.mvp;

import com.delta.commonlibs.base.mvp.IModel;
import com.delta.commonlibs.base.mvp.IView;
import com.delta.smt.entity.drinktea.ShopList;

import rx.Observable;


/**
 * Created by wushufeng on 2017/4/20.
 */

public interface OrderOtherListContract {
    //对于经常使用的关于UI的方法可以定义到BaseView中,如显示隐藏进度条,和显示文字消息
    interface View extends IView {
        void onGetShopListSuccess(ShopList shopList);

        void onGetShopListFailed(ShopList shopList);

        void onGetShopListFailed(Throwable throwable);

        void onGetShopListLoadMoreSuccess(ShopList shopList);

        void onGetShopListLoadMorefailed(ShopList shopList);

        void onGetShopListRefreshSuccess(ShopList shopList);

        void onGetShopListRefreshfailed(ShopList shopList);
    }

    //Model层定义接口,外部只需关心model返回的数据,无需关心内部细节,及是否使用缓存
    interface Model extends IModel {
        Observable<ShopList> getShopList(String token,
                                         String merchant_id,
                                         String page,
                                         String size,
                                         String keyword,
                                         String is_current);
    }
}