package com.delta.smt.ui.Personal.Balance.charge.mvp;

import com.delta.commonlibs.base.mvp.BasePresenter;
import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.entity.ChargeResult;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Map;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import rx.functions.Action1;

/**
 * Created by Fuxiang.Zhang on 2017/4/27.
 */

//@FragmentScope
@ActivityScope
public class ChargePresenter extends BasePresenter<ChargeContract.Model, ChargeContract.View> {


    @Inject
    public ChargePresenter(ChargeContract.Model model, ChargeContract.View mView) {
        super(model, mView);
    }


    public void getChargeList(Map<String, String> queryMap) {

        getModel().getChargeList(queryMap).subscribe(new Action1<ChargeResult>() {
            @Override
            public void call(ChargeResult chargeResult) {

                if (chargeResult.getApp_code() == 22000) {
                    getView().getChargeListSucess(chargeResult.getResult().getMap());
                } else {
                    getView().getChargeListFailed(chargeResult.getApp_msg());
                }
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {

            }
        });
    }

    public void chargePay(Map<String, String> queryMap) {
        getModel().chargePay(queryMap).subscribe(new Action1<ResponseBody>() {
            @Override
            public void call(ResponseBody s) {

                try {
                    JSONObject jsonObject = new JSONObject(s.string().trim());
                    int app_code = jsonObject.getInt("app_code");
                    if (app_code == 22000) {
                        getView().chargeSuccess();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    try {
                        getView().chargeFailed();
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                try {
                    getView().chargeFailed();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}