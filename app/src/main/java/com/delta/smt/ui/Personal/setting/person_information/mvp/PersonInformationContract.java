package com.delta.smt.ui.Personal.setting.person_information.mvp;

import com.delta.commonlibs.base.mvp.IModel;
import com.delta.commonlibs.base.mvp.IView;
import com.delta.smt.entity.ImageHeaderBean;
import com.delta.smt.entity.ItemUserInformation;

import java.io.File;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import rx.Observable;


/**
 * Created by Fuxiang.Zhang on 2017/5/7.
 */

public interface PersonInformationContract {
    //对于经常使用的关于UI的方法可以定义到BaseView中,如显示隐藏进度条,和显示文字消息
    interface View extends IView {
        void showMessage(String message);
        void getPersonInformation(ItemUserInformation.ResultBean.UserBean personInformation);
        void submitImage(int id);
        void updatePersonInformation();

    }

    //Model层定义接口,外部只需关心model返回的数据,无需关心内部细节,及是否使用缓存
    interface Model extends IModel {
        Observable<ResponseBody> getPersonInformation(String token);
        Observable<ResponseBody> updatePersonInformation(Map<String,String> querymap);

        Observable<ResponseBody> submitImage(String token, MultipartBody.Part params);
    }
}