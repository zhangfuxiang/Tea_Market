package com.delta.smt.ui.Personal.my_order.no_payment.mvp;

import com.delta.commonlibs.base.mvp.BasePresenter;
import com.delta.commonlibs.di.scope.FragmentScope;
import com.delta.commonlibs.utils.GsonTools;
import com.delta.smt.Constant;
import com.delta.smt.entity.ItemBean;
import com.delta.smt.entity.ItemBean1;
import com.delta.smt.entity.ItemMyOrder;
import com.delta.smt.entity.ItemNOPayment;
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
public class NoPaymentPresenter extends BasePresenter<NoPaymentContract.Model, NoPaymentContract.View> {


    @Inject
    public NoPaymentPresenter(NoPaymentContract.Model model, NoPaymentContract.View mView) {
        super(model, mView);
    }

    public void getUnpaymentList(String token, String pay_status, String page, String size, final int stats){
        getModel().getUnpaymentList(token,pay_status,page,size).subscribe(new Action1<ResponseBody>() {
            @Override
            public void call(ResponseBody responseBody) {

                try {
                    JSONObject jsonObject = new JSONObject(responseBody.string().trim());


                    int appcode = jsonObject.getInt("app_code");
                    if (appcode == 22000) {
                        ItemNOPayment itemNOPayment= GsonTools.changeGsonToBean(jsonObject.toString().trim(),ItemNOPayment.class);
                        switch (stats){
                            case Constant.NOMAL:
                                getView().getUnpaymentList(itemNOPayment.getResult());
                                break;
                            case Constant.PUllTOREFRESH:
                                break;
                            case Constant.UPLOADMORE:
                                getView().loadSucess(itemNOPayment.getResult());
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

    public void cancelOrder(String token,String id){
        getModel().cancelOrder(token,id).subscribe(new Action1<ResponseBody>() {
            @Override
            public void call(ResponseBody responseBody) {

                try {
                    JSONObject jsonObject = new JSONObject(responseBody.string().trim());

                    int appcode = jsonObject.getInt("app_code");
                    if (appcode == 22000) {
                        ItemBean1 itemBean= GsonTools.changeGsonToBean(jsonObject.toString().trim(),ItemBean1.class);
                        getView().cancelOrder(itemBean.getResult());
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

    public void payOrder(Map<String, String> queryMap){
        getModel().payOrder(queryMap).subscribe(new Action1<ResponseBody>() {
            @Override
            public void call(ResponseBody responseBody) {

                try {
                    JSONObject jsonObject = new JSONObject(responseBody.string().trim());

                    int appcode = jsonObject.getInt("app_code");
                    if (appcode == 22000) {
                        ItemPaySuccess itemPaySuccess= GsonTools.changeGsonToBean(jsonObject.toString().trim(),ItemPaySuccess.class);
                        getView().payOrder("支付成功");
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