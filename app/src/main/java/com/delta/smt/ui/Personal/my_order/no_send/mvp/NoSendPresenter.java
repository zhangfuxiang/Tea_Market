package com.delta.smt.ui.Personal.my_order.no_send.mvp;

import com.delta.commonlibs.base.mvp.BasePresenter;
import com.delta.commonlibs.di.scope.FragmentScope;
import com.delta.commonlibs.utils.GsonTools;
import com.delta.smt.Constant;
import com.delta.smt.entity.ItemNOReceive;
import com.delta.smt.entity.ItemNOSend;


import org.json.JSONObject;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import rx.functions.Action1;

/**
 * Created by Fuxiang.Zhang on 2017/4/25.
 */

@FragmentScope
//@ActivityScope
public class NoSendPresenter extends BasePresenter<NoSendContract.Model, NoSendContract.View> {


    @Inject
    public NoSendPresenter(NoSendContract.Model model, NoSendContract.View mView) {
        super(model, mView);
    }

    public void getNoSendList(String token, String pay_status, String page, String size, final int stats){
        getModel().getNoSendList(token,pay_status,page,size).subscribe(new Action1<ResponseBody>() {
            @Override
            public void call(ResponseBody responseBody) {
                try {
                    JSONObject jsonObject = new JSONObject(responseBody.string().trim());
                    int appcode = jsonObject.getInt("app_code");
                    if (appcode == 22000) {

                        ItemNOSend itemMyOrder= GsonTools.changeGsonToBean(jsonObject.toString().trim(),ItemNOSend.class);
                        switch (stats){
                            case Constant.NOMAL:
                                getView().getNoSendList(itemMyOrder.getResult());
                                break;
                            case Constant.PUllTOREFRESH:
                                break;
                            case Constant.UPLOADMORE:
                                getView().loadSucess(itemMyOrder.getResult());
                                break;
                        }


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