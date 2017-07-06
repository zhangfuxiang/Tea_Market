package com.delta.smt.ui.Personal.mvp;

import android.content.Context;
import android.util.Log;

import com.delta.commonlibs.base.mvp.BasePresenter;
import com.delta.commonlibs.utils.GsonTools;
import com.delta.commonlibs.utils.SpUtil;
import com.delta.smt.Constant;
import com.delta.smt.entity.UserInfo;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Map;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import rx.functions.Action1;

/**
 * Created by xy on 2017/3/18.
 */

public class PresonalPresenter extends BasePresenter<PersonalContract.Model, PersonalContract.View> {

    private Context context;

    @Inject
    public PresonalPresenter(PersonalContract.Model model, PersonalContract.View mView, Context context) {
        super(model, mView);
    }


    public void getUseInfo(String token, String merchant_id) {
        getModel().getUseInfo(token, merchant_id).subscribe(new Action1<UserInfo>() {
            @Override
            public void call(UserInfo userInfo) {

                if (userInfo.getApp_code() == 22000) {
                    getView().ShowUserInfoSuccess(userInfo);
                    SpUtil.SetStringSF(context, Constant.USERINFO, GsonTools.createGsonString(userInfo));
                } else {
                    getView().showUserInfoError();
                }
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {

                try {
                    getView().showUserInfoError();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void modifyChargePassword(Map<String, String> stringStringMap) {

        getModel().modifyChargePassword(stringStringMap).subscribe(new Action1<ResponseBody>() {
            @Override
            public void call(ResponseBody s) {
                try {
                    JSONObject jsonObject = new JSONObject(s.string().trim());
                    int app_code = jsonObject.getInt("app_code");
                    if (app_code == 22000) {
                        getView().resetPasswordSuccess();
                    } else {

                        getView().resetPasswordFailed(jsonObject.getString("app_msg"));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {

                Log.e("我的标签", "call: " + throwable.toString());
            }
        });
        ;
    }

    public void checkPayPwd(Map<String, String> stringStringMap) {
        getModel().checkPayPwd(stringStringMap).subscribe(new Action1<ResponseBody>() {
            @Override
            public void call(ResponseBody s) {

                try {
                    JSONObject jsonObject = new JSONObject(s.string().trim());
                    int app_code = jsonObject.getInt("app_code");
                    if (app_code == 22000) {
                        getView().checkPasswordSuccess();
                    } else {
                        getView().checkPasswordFailed(jsonObject.getString("app_msg"));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {

                Log.e("我的标签", "call: " + throwable.toString());
            }
        });
    }
}
