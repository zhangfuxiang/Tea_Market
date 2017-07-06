package com.delta.smt.ui.Personal.setting.person_information.receive_address.edit_address.mvp;

import com.delta.commonlibs.base.mvp.IModel;
import com.delta.commonlibs.base.mvp.IView;
import com.delta.smt.entity.AddAddress;
import com.delta.smt.entity.ItemAddressDetail;
import com.delta.smt.entity.ItemBean;
import com.delta.smt.entity.ItemLocation;

import okhttp3.ResponseBody;
import rx.Observable;


/**
 * Created by Fuxiang.Zhang on 2017/5/7.
 */

public interface EditAddressContract {
    //对于经常使用的关于UI的方法可以定义到BaseView中,如显示隐藏进度条,和显示文字消息
    interface View extends IView {
        void getLocation(int code);
        void showMessage(String message);
        void getAddressDetail(ItemAddressDetail.ResultBean.AddressBean addressBean);
        void editReceiveAddress();
        void deleteAddress();

    }

    //Model层定义接口,外部只需关心model返回的数据,无需关心内部细节,及是否使用缓存
    interface Model extends IModel {

        Observable<ResponseBody> getLocation();

        Observable<ResponseBody> getAddressDetail(String token,int id);

        Observable<ResponseBody> editReceiveAddress(String token,int location_id,
                                                  String name,String phone,
                                                 String address, String defaultAddress, int address_id);

        Observable<ResponseBody> deleteAddress(String token, int id);
    }
}