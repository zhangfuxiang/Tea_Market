package com.delta.smt.ui.Personal.setting.person_information.receive_address.edit_address.mvp;

import android.util.Log;

import com.delta.commonlibs.base.mvp.BasePresenter;
import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.commonlibs.di.scope.FragmentScope;
import com.delta.commonlibs.utils.GsonTools;
import com.delta.smt.entity.AddAddress;
import com.delta.smt.entity.ItemAddressDetail;
import com.delta.smt.entity.ItemBean;
import com.delta.smt.entity.ItemLocation;
import com.google.gson.Gson;


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
public class EditAddressPresenter extends BasePresenter<EditAddressContract.Model, EditAddressContract.View> {


    @Inject
    public EditAddressPresenter(EditAddressContract.Model model, EditAddressContract.View mView) {
        super(model, mView);
    }

    public void getLocation(final String province, final String city,final String district){
        getModel().getLocation().subscribe(new Action1<ResponseBody>() {
            @Override
            public void call(ResponseBody responseBody) {
                try {
                    JSONObject jsonObject = new JSONObject(responseBody.string().trim());
                    ItemLocation itemLocation= GsonTools.changeGsonToBean(jsonObject.toString().trim(),ItemLocation.class);
                    int appcode = jsonObject.getInt("app_code");
                    if (appcode == 22000) {
                        //识别所在地区对应code
                        for (ItemLocation.ResultBean.ListBean mListBean : itemLocation.getResult().getList()) {
                            if (mListBean.getName().equals(province)) {
                                for (ItemLocation.ResultBean.ListBean.SubBeanX mSubBeanX : mListBean.getSub()) {
                                    if (mSubBeanX.getName().equals(city)||mSubBeanX.getName().equals("市辖区")) {
                                        for (ItemLocation.ResultBean.ListBean.SubBeanX.SubBean mSubBean : mSubBeanX.getSub()) {
                                            if (mSubBean.getName().equals(district)) {
                                                getView().getLocation(mSubBean.getCode());
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        Log.e(TAG, "call: 成功" );
                    } else {
                        getView().showMessage(jsonObject.getString("app_msg"));
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
/*
                if (22000==itemLocation.getApp_code()) {

                    //识别所在地区对应code
                    for (ItemLocation.ResultBean.ListBean mListBean : itemLocation.getResult().getList()) {
                        if (mListBean.getName().equals(province)) {
                            for (ItemLocation.ResultBean.ListBean.SubBeanX mSubBeanX : mListBean.getSub()) {
                                if (mSubBeanX.getName().equals(city)||mSubBeanX.getName().equals("市辖区")) {
                                    for (ItemLocation.ResultBean.ListBean.SubBeanX.SubBean mSubBean : mSubBeanX.getSub()) {
                                        if (mSubBean.getName().equals(district)) {
                                            getView().getLocation(mSubBean.getCode());
                                        }
                                    }
                                }
                            }
                        }
                    }
                    Log.e(TAG, "call: 成功" );
                } else {
                    getView().showMessage(itemLocation.getApp_msg());
                }*/
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {

            }
        });

    }

    public void getAddressDetail(final String token, final int id){


        getModel().getAddressDetail(token,id).subscribe(new Action1<ResponseBody>() {

            @Override
            public void call(ResponseBody responseBody) {
                try {
                    JSONObject jsonObject = new JSONObject(responseBody.string().trim());
                    ItemAddressDetail mItemAddressDetail = GsonTools.changeGsonToBean(jsonObject.toString().trim(), ItemAddressDetail.class);
                    int appcode = jsonObject.getInt("app_code");
                    if (appcode == 22000) {
                        getView().getAddressDetail(mItemAddressDetail.getResult().getAddress());
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

    public void editReceiveAddress(String token, int location_id, String name, String phone, final String address,
                                   String defaultAddress, int address_id){

        getModel().editReceiveAddress(token,location_id,name,
                phone,address,defaultAddress,address_id).subscribe(new Action1<ResponseBody>() {
            @Override
            public void call(ResponseBody responseBody) {

                try {
                    JSONObject jsonObject = new JSONObject(responseBody.string().trim());
                    AddAddress mItemAddressDetail = GsonTools.changeGsonToBean(jsonObject.toString().trim(), AddAddress.class);
                    int appcode = jsonObject.getInt("app_code");
                    if (appcode == 22000) {
                        getView().editReceiveAddress();
                    } else {
                        getView().showMessage(jsonObject.getString("app_msg"));
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

/*                if (addAddress.getApp_code()==22000) {
                    getView().editReceiveAddress();
                }else {
                    getView().showMessage(addAddress.getApp_msg());
                }*/
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
}