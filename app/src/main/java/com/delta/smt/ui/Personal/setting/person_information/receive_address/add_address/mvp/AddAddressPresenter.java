package com.delta.smt.ui.Personal.setting.person_information.receive_address.add_address.mvp;

import android.util.Log;

import com.delta.commonlibs.base.mvp.BasePresenter;
import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.commonlibs.di.scope.FragmentScope;
import com.delta.commonlibs.utils.GsonTools;
import com.delta.smt.entity.AddAddress;
import com.delta.smt.entity.ItemLocation;
import com.delta.smt.ui.HomePage.modify_consignee.NewConsigneeActivity;


import org.json.JSONObject;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import rx.functions.Action0;
import rx.functions.Action1;

/**
 * Created by Fuxiang.Zhang on 2017/5/7.
 */

//@FragmentScope
@ActivityScope
public class AddAddressPresenter extends BasePresenter<AddAddressContract.Model, AddAddressContract.View> {


    @Inject
    public AddAddressPresenter(AddAddressContract.Model model, AddAddressContract.View mView) {
        super(model, mView);
    }

    public void addReceiveAddress(String token, String location_id,
                                  String phone, String name,
                                  final String address, String defaultAddress){
        getModel().addReceiveAddress(token,location_id,phone,name,address,defaultAddress)
                .subscribe(new Action1<ResponseBody>() {
                    @Override
                    public void call(ResponseBody responseBody) {

                        try {
                            JSONObject jsonObject = new JSONObject(responseBody.string().trim());
                            int appcode = jsonObject.getInt("app_code");
                            if (appcode == 22000) {
                                getView().addReceiveAddress();
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

                 }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {

                    }
                });

    }


}