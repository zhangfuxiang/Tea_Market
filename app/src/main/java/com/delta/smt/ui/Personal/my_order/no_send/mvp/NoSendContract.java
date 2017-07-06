package com.delta.smt.ui.Personal.my_order.no_send.mvp;

import com.delta.commonlibs.base.mvp.IModel;
import com.delta.commonlibs.base.mvp.IView;
import com.delta.smt.entity.ItemNOSend;

import java.util.List;

import okhttp3.ResponseBody;
import rx.Observable;


/**
 * Created by Fuxiang.Zhang on 2017/4/25.
 */

public interface NoSendContract {
    //对于经常使用的关于UI的方法可以定义到BaseView中,如显示隐藏进度条,和显示文字消息
    interface View extends IView {
        void showMessage(String message);
        void getNoSendList(ItemNOSend.ResultBean NoSendData);
        void loadSucess(ItemNOSend.ResultBean Unpaymentdata);
    }

    //Model层定义接口,外部只需关心model返回的数据,无需关心内部细节,及是否使用缓存
    interface Model extends IModel {
        Observable<ResponseBody> getNoSendList(String token, String pay_status,String page,String size);
    }
}