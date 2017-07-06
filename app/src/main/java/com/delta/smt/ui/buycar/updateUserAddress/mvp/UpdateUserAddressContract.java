package com.delta.smt.ui.buycar.updateUserAddress.mvp;

import com.delta.commonlibs.base.mvp.IModel;
import com.delta.commonlibs.base.mvp.IView;
import com.delta.smt.entity.cart.DeleteUserAddress;
import com.delta.smt.entity.cart.UpdateUserAddress;

import rx.Observable;


/**
 * Created by wushufeng on 2017/5/11.
 */

public interface UpdateUserAddressContract {
    //对于经常使用的关于UI的方法可以定义到BaseView中,如显示隐藏进度条,和显示文字消息
    interface View extends IView {
        void onUpdateUserAddressSuccess(UpdateUserAddress updateUserAddress);

        void onUpdateUserAddressFailed(UpdateUserAddress updateUserAddress);

        void onUpdateUserAddressFailed(Throwable throwable);

        void onDeleteUserAddressSuccess(DeleteUserAddress deleteUserAddress);

        void onDeleteUserAddressFailed(DeleteUserAddress deleteUserAddress);

        void onDeleteUserAddressFailed(Throwable throwable);
    }

    //Model层定义接口,外部只需关心model返回的数据,无需关心内部细节,及是否使用缓存
    interface Model extends IModel {
        Observable<UpdateUserAddress> updateUserAddress(String token,
                                                        String merchant_id,
                                                        String location_id,
                                                        String name,
                                                        String phone,
                                                        String address,
                                                        String def,
                                                        String address_id);

        Observable<DeleteUserAddress> deleteUserAddress(String token,
                                                        String merchant_id,
                                                        String address_id);
    }
}