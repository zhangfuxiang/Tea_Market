package com.delta.smt.ui.drinktea.choose_address.mvp;

import com.delta.commonlibs.base.mvp.IModel;
import com.delta.commonlibs.base.mvp.IView;
import com.delta.smt.entity.drinktea.UserAddress;

import rx.Observable;


/**
 * Created by wushufeng on 2017/4/22.
 */

public interface ChooseAddressContract {
    //对于经常使用的关于UI的方法可以定义到BaseView中,如显示隐藏进度条,和显示文字消息
    interface View extends IView {
        void onGetUserAddressListSuccess(UserAddress userAddress);

        void onGetUserAddressListFailed(UserAddress userAddress);

        void onGetUserAddressListFailed(Throwable throwable);
    }

    //Model层定义接口,外部只需关心model返回的数据,无需关心内部细节,及是否使用缓存
    interface Model extends IModel {

        Observable<UserAddress> getUserAddressList(String token, String merchant_id);
    }
}