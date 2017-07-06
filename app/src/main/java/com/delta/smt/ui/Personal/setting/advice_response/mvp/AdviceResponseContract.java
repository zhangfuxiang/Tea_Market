package com.delta.smt.ui.Personal.setting.advice_response.mvp;

import com.delta.commonlibs.base.mvp.IModel;
import com.delta.commonlibs.base.mvp.IView;
import com.delta.smt.entity.ItemBean;
import com.delta.smt.entity.ItemBean1;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import rx.Observable;


/**
 * Created by Fuxiang.Zhang on 2017/5/20.
 */

public interface AdviceResponseContract {
    //对于经常使用的关于UI的方法可以定义到BaseView中,如显示隐藏进度条,和显示文字消息
    interface View extends IView {

        void showMessage(String message);

        void submitAdvice(String message);

        void submitImage(int id);

    }

    //Model层定义接口,外部只需关心model返回的数据,无需关心内部细节,及是否使用缓存
    interface Model extends IModel {
        Observable<ItemBean1> submitAdvice(Map<String, String> queryMap);

        Observable<ResponseBody> submitImage(String token, MultipartBody.Part params);
    }
}