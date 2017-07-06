package com.delta.smt.ui.Personal.my_order.all_content.mvp;

import com.delta.commonlibs.base.mvp.IModel;
import com.delta.commonlibs.base.mvp.IView;
import com.delta.smt.entity.ItemMyOrder;
import com.delta.smt.entity.ItemNOPayment;

import java.util.List;

import okhttp3.ResponseBody;
import rx.Observable;


/**
 * Created by Fuxiang.Zhang on 2017/4/25.
 */

public interface AllContentContract {
    interface View extends IView {
        void showMessage(String message);
        void getMyOrderList(ItemMyOrder.ResultBean MyOrderList);
        void loadSucess(ItemMyOrder.ResultBean MyOrderdata);
        void cancelOrder(String message);

    }

    //Model层定义接口,外部只需关心model返回的数据,无需关心内部细节,及是否使用缓存
    interface Model extends IModel {
        Observable<ResponseBody> getMyOrderList(String token, String pay_status,String page,String size);
        Observable<ResponseBody> cancelOrder(String token, String id);
    }
}