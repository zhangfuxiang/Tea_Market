package com.delta.smt.ui.Personal.my_order.no_payment.order_detail.mvp;

import android.util.Log;

import com.delta.commonlibs.base.mvp.BasePresenter;
import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.commonlibs.di.scope.FragmentScope;
import com.delta.commonlibs.utils.GsonTools;
import com.delta.smt.entity.ItemBean1;
import com.delta.smt.entity.ItemMyOrder;
import com.delta.smt.entity.ItemOrderDetail;
import com.delta.smt.entity.ItemPaySuccess;


import org.json.JSONObject;

import java.util.Map;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import rx.functions.Action1;

/**
 * Created by Fuxiang.Zhang on 2017/4/27.
 */

//@FragmentScope
@ActivityScope
public class OrderDetailPresenter extends BasePresenter<OrderDetailContract.Model, OrderDetailContract.View> {


    @Inject
    public OrderDetailPresenter(OrderDetailContract.Model model, OrderDetailContract.View mView) {
        super(model, mView);
    }

    public void getOrderDetail(String token,String id){
        getModel().getOrderDetail(token,id).subscribe(new Action1<ResponseBody>() {
            @Override
            public void call(ResponseBody responseBody) {

                try {
                    JSONObject jsonObject = new JSONObject(responseBody.string().trim());
                    ItemOrderDetail itemOrderDetail= GsonTools.changeGsonToBean(jsonObject.toString().trim(),ItemOrderDetail.class);
                    int appcode = jsonObject.getInt("app_code");
                    if (appcode == 22000) {
                        getView().getOrderDetail(itemOrderDetail.getResult());
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
                    ItemBean1 itemBean= GsonTools.changeGsonToBean(jsonObject.toString().trim(),ItemBean1.class);
                    int appcode = jsonObject.getInt("app_code");
                    if (appcode == 22000) {
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