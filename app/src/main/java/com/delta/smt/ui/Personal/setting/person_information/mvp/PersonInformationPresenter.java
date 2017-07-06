package com.delta.smt.ui.Personal.setting.person_information.mvp;

import android.util.Log;

import com.delta.commonlibs.base.mvp.BasePresenter;
import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.commonlibs.utils.GsonTools;
import com.delta.commonlibs.utils.SpUtil;
import com.delta.smt.Constant;
import com.delta.smt.entity.ImageHeaderBean;
import com.delta.smt.entity.ItemUserInformation;
import com.delta.smt.ui.Personal.setting.person_information.PersonInformationActivity;


import org.json.JSONObject;

import java.io.File;
import java.util.Map;

import javax.inject.Inject;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import rx.functions.Action1;

/**
 * Created by Fuxiang.Zhang on 2017/5/7.
 */

//@FragmentScope
@ActivityScope
public class PersonInformationPresenter extends BasePresenter<PersonInformationContract.Model, PersonInformationContract.View> {



    @Inject
    public PersonInformationPresenter(PersonInformationContract.Model model, PersonInformationContract.View mView) {
        super(model, mView);
    }

    public void getPersonInformation(String token){
        getModel().getPersonInformation(token).subscribe(new Action1<ResponseBody>() {
            @Override
            public void call(ResponseBody responseBody) {
                try {
                    JSONObject jsonObject = new JSONObject(responseBody.string().trim());

                    int appcode = jsonObject.getInt("app_code");
                    if (appcode == 22000) {
                        ItemUserInformation mItemUserInformation = GsonTools.changeGsonToBean(jsonObject.toString().trim(), ItemUserInformation.class);
                        Log.e(TAG, "call: "+mItemUserInformation.getApp_code());
                        getView().getPersonInformation(mItemUserInformation.getResult().getUser());
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
/*        getModel().getPersonInformation(token).subscribe(new Action1<ItemUserInformation>() {
            @Override
            public void call(ItemUserInformation itemUserInformation) {
                if (itemUserInformation.getApp_code()==22000) {
                    getView().getPersonInformation(itemUserInformation.getResult().getUser());
                }else {
                    getView().showMessage(itemUserInformation.getApp_msg());
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
        });*/
    }

    public void updatePersonInformation(Map<String,String> querymap){

        getModel().updatePersonInformation(querymap).subscribe(new Action1<ResponseBody>() {
            @Override
            public void call(ResponseBody responseBody) {
                try {
                    JSONObject jsonObject = new JSONObject(responseBody.string().trim());

                    int appcode = jsonObject.getInt("app_code");
                    if (appcode == 22000) {
                        ItemUserInformation mItemUserInformation = GsonTools.changeGsonToBean(jsonObject.toString().trim(), ItemUserInformation.class);
                        //getView().getPersonInformation(mItemUserInformation.getResult().getUser());
                        getView().updatePersonInformation();
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

    public void submitImage(String token, MultipartBody.Part params){
        getModel().submitImage(token,params).subscribe(new Action1<ResponseBody>() {
            @Override
            public void call(ResponseBody responseBody) {

                try {
                    JSONObject jsonObject = new JSONObject(responseBody.string().trim());

                    int appcode = jsonObject.getInt("app_code");
                    if (appcode == 22000) {
                        ImageHeaderBean mImageHeaderBean = GsonTools.changeGsonToBean(jsonObject.toString().trim(), ImageHeaderBean.class);
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