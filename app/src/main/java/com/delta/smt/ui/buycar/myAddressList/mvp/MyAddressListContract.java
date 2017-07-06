package com.delta.smt.ui.buycar.myAddressList.mvp;

import com.delta.commonlibs.base.mvp.IModel;
import com.delta.commonlibs.base.mvp.IView;
import com.delta.smt.entity.cart.DeleteUserAddress;
import com.delta.smt.entity.cart.UpdateUserAddress;
import com.delta.smt.entity.cart.UserAddressList;

import rx.Observable;


/**
 * Created by wushufeng on 2017/5/5.
 */

public interface MyAddressListContract {
    //对于经常使用的关于UI的方法可以定义到BaseView中,如显示隐藏进度条,和显示文字消息
    interface View extends IView {
        void onGetMyAddressListSuccess(UserAddressList userAddressList);

        void onGetMyAddressListFailed(UserAddressList userAddressList);

        void onGetMyAddressListFailed(Throwable throwable);

        void onDeleteUserAddressSuccess(DeleteUserAddress deleteUserAddress);

        void onDeleteUserAddressFailed(DeleteUserAddress deleteUserAddress);

        void onDeleteUserAddressFailed(Throwable throwable);

        void onUpdateUserAddressSuccess(UpdateUserAddress updateUserAddress);

        void onUpdateUserAddressFailed(UpdateUserAddress updateUserAddress);

        void onUpdateUserAddressFailed(Throwable throwable);
    }

    //Model层定义接口,外部只需关心model返回的数据,无需关心内部细节,及是否使用缓存
    interface Model extends IModel {
        Observable<UserAddressList> getMyAddressList(String token, String merchant_id);

        Observable<DeleteUserAddress> deleteUserAddress(String token, String merchant_id, String address_id);

        Observable<UpdateUserAddress> updateUserAddress(String token,
                                                        String merchant_id,
                                                        String location_id,
                                                        String name,
                                                        String phone,
                                                        String address,
                                                        String def,
                                                        String address_id);
    }
}