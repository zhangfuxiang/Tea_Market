package com.delta.smt.ui.Personal.setting.advice_response.mvp;

import android.util.Log;

import com.delta.commonlibs.base.mvp.BasePresenter;
import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.commonlibs.di.scope.FragmentScope;
import com.delta.commonlibs.utils.GsonTools;
import com.delta.smt.entity.ImageHeaderBean;
import com.delta.smt.entity.ItemBean1;


import org.json.JSONObject;

import java.util.Map;

import javax.inject.Inject;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import rx.functions.Action1;

/**
 * Created by Fuxiang.Zhang on 2017/5/20.
 */

//@FragmentScope
@ActivityScope
public class AdviceResponsePresenter extends BasePresenter<AdviceResponseContract.Model, AdviceResponseContract.View> {


    @Inject
    public AdviceResponsePresenter(AdviceResponseContract.Model model, AdviceResponseContract.View mView) {
        super(model, mView);
    }

    public void submitAdvice(Map<String, String> queryMap){
        getModel().submitAdvice(queryMap).subscribe(new Action1<ItemBean1>() {
            @Override
            public void call(ItemBean1 itemBean1) {
                if (itemBean1.getApp_code()==22000) {
                    getView().submitAdvice(itemBean1.getResult());
                }else {
                    getView().showMessage(itemBean1.getApp_msg());
                }
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                try {
                    getView().showMessage("请求异常！");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void submitImage(String token, MultipartBody.Part params){
        getModel().submitImage(token,params).subscribe(new Action1<ResponseBody>() {
            @Override
            public void call(ResponseBody responseBody) {

                try {
                    JSONObject jsonObject = new JSONObject(responseBody.string().trim());
                    ImageHeaderBean mImageHeaderBean = GsonTools.changeGsonToBean(jsonObject.toString().trim(), ImageHeaderBean.class);
                    int appcode = jsonObject.getInt("app_code");
                    if (appcode == 22000) {
                        getView().submitImage(mImageHeaderBean.getResult().getImage().getId());
                        getView().showMessage("操作成功");
                    } else {
                        getView().showMessage(jsonObject.getString("app_msg"));
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                try {
                    getView().showMessage("请求异常！");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


}