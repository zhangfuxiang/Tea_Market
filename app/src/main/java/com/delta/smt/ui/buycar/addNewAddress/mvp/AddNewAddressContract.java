package com.delta.smt.ui.buycar.addNewAddress.mvp;

import com.delta.commonlibs.base.mvp.IModel;
import com.delta.commonlibs.base.mvp.IView;
import com.delta.smt.entity.cart.AddressAreaResult;
import com.delta.smt.entity.cart.NewAddressResult;

import rx.Observable;


/**
 * Created by wushufeng on 2017/5/7.
 */

public interface AddNewAddressContract {
    //对于经常使用的关于UI的方法可以定义到BaseView中,如显示隐藏进度条,和显示文字消息
    interface View extends IView {
        void onAddUserAddressSuccess(NewAddressResult newAddressResult);

        void onAddUserAddressFailed(NewAddressResult newAddressResult);

        void onAddUserAddressFailed(Throwable throwable);

        void onAddressAreaSuccess(AddressAreaResult addressAreaResult);

        void onAddressAreaFailed(AddressAreaResult addressAreaResult);

        void onAddressAreaFailed(Throwable throwable);
    }

    //Model层定义接口,外部只需关心model返回的数据,无需关心内部细节,及是否使用缓存
    interface Model extends IModel {
        Observable<NewAddressResult> addUserAddress(String token,
                                                    String merchant_id,
                                                    String location_id,
                                                    String phone,
                                                    String name,
                                                    String address,
                                                    String def);

        Observable<AddressAreaResult> getAddressArea(String as_tree);
    }
}