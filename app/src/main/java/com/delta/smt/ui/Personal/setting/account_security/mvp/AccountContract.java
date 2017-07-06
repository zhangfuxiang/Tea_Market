package com.delta.smt.ui.Personal.setting.account_security.mvp;

import com.delta.commonlibs.base.mvp.IModel;
import com.delta.commonlibs.base.mvp.IView;

import java.util.Map;

import okhttp3.ResponseBody;
import rx.Observable;


/**
 * Created by Fuxiang.Zhang on 2017/5/17.
 */

public interface AccountContract {
    //对于经常使用的关于UI的方法可以定义到BaseView中,如显示隐藏进度条,和显示文字消息
    interface View extends IView {

        void changeSuccess();


        void changeFailed();


    }

    //Model层定义接口,外部只需关心model返回的数据,无需关心内部细节,及是否使用缓存
    interface Model extends IModel {

        Observable<ResponseBody> changePhone(Map<String, String> stringStringMap);

        Observable<ResponseBody> confimCode(Map<String, String> stringStringMap);

        //Observable<String> modifyChargePassword(Map<String, String> stringStringMap);
    }
}