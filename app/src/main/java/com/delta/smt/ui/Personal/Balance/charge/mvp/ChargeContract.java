package com.delta.smt.ui.Personal.Balance.charge.mvp;

import com.delta.commonlibs.base.mvp.IModel;
import com.delta.commonlibs.base.mvp.IView;
import com.delta.smt.entity.ChargeResult;

import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;
import rx.Observable;


/**
 * Created by Fuxiang.Zhang on 2017/4/27.
 */

public interface ChargeContract {
    //对于经常使用的关于UI的方法可以定义到BaseView中,如显示隐藏进度条,和显示文字消息
    interface View extends IView {

        void getChargeListSucess(List<ChargeResult.ResultBean.MapBean> map);

        void getChargeListFailed(String app_msg);

        void chargeSuccess();

        void chargeFailed();
    }

    //Model层定义接口,外部只需关心model返回的数据,无需关心内部细节,及是否使用缓存
    interface Model extends IModel {

        Observable<ChargeResult> getChargeList(Map<String, String> queryMap);

        Observable<ResponseBody> chargePay(Map<String, String> queryMap);
    }
}