package com.delta.smt.ui.Personal.setting.person_information.receive_address.mvp;

import com.delta.commonlibs.base.mvp.IModel;
import com.delta.commonlibs.base.mvp.IView;
import com.delta.smt.entity.AddAddress;
import com.delta.smt.entity.ItemBean;
import com.delta.smt.entity.ItemReceiveAddress;

import java.util.List;

import okhttp3.ResponseBody;
import rx.Observable;


/**
 * Created by Fuxiang.Zhang on 2017/5/7.
 */

public interface ReceiveAddressContract {
    //对于经常使用的关于UI的方法可以定义到BaseView中,如显示隐藏进度条,和显示文字消息
    interface View extends IView {
        void getReceiveAddress(List<ItemReceiveAddress.ResultBean.ListBean> itemReceiveAddress);
        void showMessage(String message);
        void deleteAddress();
        void editDefaultAddress();
    }

    //Model层定义接口,外部只需关心model返回的数据,无需关心内部细节,及是否使用缓存
    interface Model extends IModel {
        Observable<ResponseBody> getReceiveAddress(String token);
        Observable<ResponseBody> editDefaultAddress(String token,String defaultAddress,int id);
        Observable<ResponseBody> deleteAddress(String token,int id);
    }
}