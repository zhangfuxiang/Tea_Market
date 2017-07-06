package com.delta.smt.ui.Personal.Balance.mvp;

import com.delta.commonlibs.base.mvp.BasePresenter;
import com.delta.commonlibs.di.scope.ActivityScope;

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
public class BalancePresenter extends BasePresenter<BalanceContract.Model, BalanceContract.View> {


    @Inject
    public BalancePresenter(BalanceContract.Model model, BalanceContract.View mView) {
        super(model, mView);
    }


    public void withdraw(Map<String, String> stringObjectMap) {

        getModel().withdraw(stringObjectMap).subscribe(new Action1<ResponseBody>() {
            @Override
            public void call(ResponseBody responseBody) {
                try {
                    JSONObject jsonObject = new JSONObject(responseBody.string().trim());
                    int app_code = jsonObject.getInt("app_code");
                    if(app_code==22000){
                        getView().withdrawSuccess();
                    }else{
                        getView().withdrawFailed();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}