package com.delta.smt.ui.Personal.setting.account_security.mvp;

import android.util.Log;

import com.delta.commonlibs.base.mvp.BasePresenter;
import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.commonlibs.utils.GsonTools;
import com.delta.smt.Constant;
import com.delta.smt.entity.ItemBean;
import com.delta.smt.entity.SendCodeResult;
import com.delta.smt.ui.login.reset_password_1.mvp.ResetPasswordOneConstract;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Map;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import rx.functions.Action1;

/**
 * Created by Fuxiang.Zhang on 2017/5/17.
 */

//@FragmentScope
@ActivityScope
public class AccountPresenter extends BasePresenter<AccountContract.Model, AccountContract.View> {


    private ResetPasswordOneConstract.Model resetPasswordOneModel;
    private ResetPasswordOneConstract.View resetPasswordView;

    @Inject
    public AccountPresenter(AccountContract.Model model, ResetPasswordOneConstract.Model resetPasswordOneModel,
                            ResetPasswordOneConstract.View resetPasswordView, AccountContract.View mView) {
        super(model, mView);
        this.resetPasswordOneModel = resetPasswordOneModel;
        this.resetPasswordView = resetPasswordView;
    }

    public void sendCode(String phone, String type) {
        resetPasswordOneModel.sendCode(Constant.CLIENT,
                Constant.CLIENT_VERSION,
                Constant.OS,
                Constant.OS_TOKEN,
                Constant.API_VERSION, phone, type).subscribe(new Action1<SendCodeResult>() {
            @Override
            public void call(SendCodeResult sendCodeResult) {

                Log.i(TAG, "call: " + sendCodeResult.getApp_code());
                if ("22000".equals(sendCodeResult.getApp_code())) {
                    resetPasswordView.sendCodeSuccess(sendCodeResult);
                } else {
                    resetPasswordView.sendCodeFailed(sendCodeResult);
                }


            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                resetPasswordView.sendCodeFailed(throwable);
            }
        });
    }

    public void changePhone(Map<String, String> stringStringMap) {

        getModel().changePhone(stringStringMap).subscribe(new Action1<ResponseBody>() {
            @Override
            public void call(ResponseBody s) {

                try {
                    JSONObject jsonObject = new JSONObject(s.string().trim());
                    int app_code = jsonObject.getInt("app_code");
                    if(app_code==22000){
                    //   ItemBean mItemBean= GsonTools.changeGsonToBean(s.string().trim(),ItemBean.class);
                        getView().changeSuccess();
                    }else{
                        getView().changeFailed();
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

            }
        });
    }


    public void confimCode(Map<String, String> stringStringMap) {
        getModel().confimCode(stringStringMap).subscribe(new Action1<ResponseBody>() {
            @Override
            public void call(ResponseBody s) {

                try {
                    JSONObject jsonObject = new JSONObject(s.string().trim());
                    int app_code = jsonObject.getInt("app_code");
                    if(app_code==22000){
                        getView().changeSuccess();
                    }else{
                        getView().changeFailed();
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
                Log.e("我的标签", "call: "+throwable.getMessage());
            }
        });
    }
}