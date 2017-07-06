package com.delta.smt.ui.Personal.my_order.no_receive.mvp;

import com.delta.commonlibs.base.mvp.BasePresenter;
import com.delta.commonlibs.di.scope.FragmentScope;
import com.delta.commonlibs.utils.GsonTools;
import com.delta.smt.entity.ItemBean1;
import com.delta.smt.entity.ItemNOReceive;
import com.delta.smt.entity.ItemPaySuccess;


import org.json.JSONObject;

import java.util.Map;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import rx.functions.Action1;

/**
 * Created by Fuxiang.Zhang on 2017/4/25.
 */

@FragmentScope
//@ActivityScope
public class NoReceivePresenter extends BasePresenter<NoReceiveContract.Model, NoReceiveContract.View> {


    @Inject
    public NoReceivePresenter(NoReceiveContract.Model model, NoReceiveContract.View mView) {
        super(model, mView);
    }

    public void getNoReceiveList(String token,String pay_status){
        getModel().getNoReceiveList(token,pay_status).subscribe(new Action1<ResponseBody>() {
            @Override
            public void call(ResponseBody responseBody) {
                try {
                    JSONObject jsonObject = new JSONObject(responseBody.string().trim());

                    int appcode = jsonObject.getInt("app_code");
                    if (appcode == 22000) {
                        ItemNOReceive itemMyOrder= GsonTools.changeGsonToBean(jsonObject.toString().trim(),ItemNOReceive.class);
                        getView().getNoReceiveList(itemMyOrder.getResult().getList());
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

    public void confirmReceive(Map<String,String> queryMap){
        getModel().confirmReceive(queryMap).subscribe(new Action1<ResponseBody>() {
            @Override
            public void call(ResponseBody responseBody) {

                try {
                    JSONObject jsonObject = new JSONObject(responseBody.string().trim());

                    int appcode = jsonObject.getInt("app_code");
                    if (appcode == 22000) {
                        ItemBean1 itemBean1= GsonTools.changeGsonToBean(jsonObject.toString().trim(),ItemBean1.class);
                        getView().confirmReceive(itemBean1.getResult());
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