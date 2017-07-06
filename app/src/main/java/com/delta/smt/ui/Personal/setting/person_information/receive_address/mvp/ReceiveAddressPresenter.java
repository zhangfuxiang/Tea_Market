package com.delta.smt.ui.Personal.setting.person_information.receive_address.mvp;

import android.util.Log;

import com.delta.commonlibs.base.mvp.BasePresenter;
import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.commonlibs.di.scope.FragmentScope;
import com.delta.commonlibs.utils.GsonTools;
import com.delta.smt.entity.AddAddress;
import com.delta.smt.entity.ImageHeaderBean;
import com.delta.smt.entity.ItemBean;
import com.delta.smt.entity.ItemReceiveAddress;


import org.json.JSONObject;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import rx.Observable;
import rx.functions.Action1;

/**
 * Created by Fuxiang.Zhang on 2017/5/7.
 */

//@FragmentScope
@ActivityScope
public class ReceiveAddressPresenter extends BasePresenter<ReceiveAddressContract.Model, ReceiveAddressContract.View> {


    @Inject
    public ReceiveAddressPresenter(ReceiveAddressContract.Model model, ReceiveAddressContract.View mView) {
        super(model, mView);
    }

    public void getReceiveAddress(String token){
        getModel().getReceiveAddress(token).subscribe(new Action1<ResponseBody>() {
            @Override
            public void call(ResponseBody responseBody) {
                try {
                    JSONObject jsonObject = new JSONObject(responseBody.string().trim());
                    ItemReceiveAddress mItemReceiveAddress = GsonTools.changeGsonToBean(jsonObject.toString().trim(), ItemReceiveAddress.class);
                    int appcode = jsonObject.getInt("app_code");
                    if (appcode == 22000) {
                        getView().getReceiveAddress(mItemReceiveAddress.getResult().getList());
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
                    getView().showMessage(throwable.getMessage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void deleteAddress(String token,int id){
        getModel().deleteAddress(token,id).subscribe(new Action1<ResponseBody>() {
            @Override
            public void call(ResponseBody responseBody) {
                try {
                    JSONObject jsonObject = new JSONObject(responseBody.string().trim());
                    int appcode = jsonObject.getInt("app_code");
                    if (appcode == 22000) {
                        getView().deleteAddress();
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
                    getView().showMessage(throwable.getMessage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void editDefaultAddress(String token,String defaultAddress,int id){
        getModel().editDefaultAddress(token,defaultAddress,id).subscribe(new Action1<ResponseBody>() {
            @Override
            public void call(ResponseBody responseBody) {

                try {
                    JSONObject jsonObject = new JSONObject(responseBody.string().trim());
                    int appcode = jsonObject.getInt("app_code");
                    if (appcode == 22000) {
                        getView().editDefaultAddress();
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
                    getView().showMessage(throwable.getMessage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}