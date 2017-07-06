package com.delta.smt.ui.Personal.PayMerchant.mvp;

import com.delta.commonlibs.base.mvp.BasePresenter;
import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.entity.MerchantInfo;

import java.util.Map;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import rx.functions.Action1;

/**
 * Created by Fuxiang.Zhang on 2017/4/27.
 */

//@FragmentScope
@ActivityScope
public class PayMerchantPresenter extends BasePresenter<PayMerchantContract.Model, PayMerchantContract.View> {


    @Inject
    public PayMerchantPresenter(PayMerchantContract.Model model, PayMerchantContract.View mView) {
        super(model, mView);
    }


    public void pay(Map<String, String> stringStringMap) {

        getModel().pay(stringStringMap).subscribe(new Action1<ResponseBody>() {
            @Override
            public void call(ResponseBody s) {

            }
        });
    }

    public void getMerchantInfo(Map<String, String> stringStringMap) {

        getModel().getMerchantInfo(stringStringMap).subscribe(new Action1<MerchantInfo>() {
            @Override
            public void call(MerchantInfo merchantInfo) {
                if(merchantInfo.getApp_code()==22000){
                    getView().getMerchantInfoSuccess(merchantInfo);
                }else {
                    getView().getMerchantInfoFailed();
                }
            }
        });
    }
}