package com.delta.smt.base;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.multidex.MultiDex;
import android.util.Log;

import com.delta.commonlibs.di.module.AppModule;
import com.delta.commonlibs.di.module.ClientModule;
import com.delta.commonlibs.http.GlobeHttpHandler;
import com.delta.smt.Constant;
import com.delta.smt.app.App;
import com.delta.smt.di.module.ServiceModule;
import com.delta.smt.ui.Personal.setting.account_security.resetChargePassword.ResetChargePasswordActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 本项目由
 * mvp
 * +dagger2
 * +retrofit
 * +rxjava
 * +butterknife组成
 */
public abstract class BaseApplication extends Application {
    static private BaseApplication mApplication;
    protected final String TAG = this.getClass().getSimpleName();
    public LinkedList<BaseCommonActivity> mActivityList;
    private ClientModule mClientModule;
    private AppModule mAppModule;
    private ServiceModule serviceModule;

    /**
     * 返回上下文
     *
     * @return
     */
    public static Context getContext() {
        return mApplication;
    }

    /**
     * 退出所有activity
     */
    public static void killAll() {
        Intent intent = new Intent(BaseCommonActivity.ACTION_RECEIVER_ACTIVITY);
        intent.putExtra("type", "killAll");
        getContext().sendBroadcast(intent);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);
        //BuildConfig.LOG_DEBUG
        mApplication = this;
        this.mClientModule = ClientModule//用于提供okhttp和retrofit的单列
                .buidler()
                .baseurl(getBaseUrl())
                .globeHttpHandler(getHttpHandler())
                .interceptors(getInterceptors())
                .build();
        this.mAppModule = new AppModule(this);//提供application
        this.serviceModule = new ServiceModule();
    }

    /**
     * 提供基础url给retrofit
     *
     * @return
     */
    protected abstract String getBaseUrl();

    public ServiceModule getServiceModule() {
        return serviceModule;
    }

    public ClientModule getClientModule() {
        return mClientModule;
    }

    public AppModule getAppModule() {
        return mAppModule;
    }

    /**
     * 这里可以提供一个全局处理http响应结果的处理类,
     * 这里可以比客户端提前一步拿到服务器返回的结果,可以做一些操作,比如token超时,重新获取
     * 默认不实现,如果有需求可以重写此方法
     *
     * @return
     */

    public GlobeHttpHandler getHttpHandler() {
        return new GlobeHttpHandler() {
            @Override
            public Response onHttpResultResponse(String httpResult, Interceptor.Chain chain, Response response) {
                Log.i(TAG, "onHttpResultResponse: " + httpResult);
                System.out.println(httpResult);
                try {
                    JSONObject jsonObject = new JSONObject(httpResult);
                    int appcode = jsonObject.getInt("app_code");
                    if (appcode == 32003) {


                        App.getMainHander().post(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(BaseApplication.this, ResetChargePasswordActivity.class);
                                Bundle bundle = new Bundle();
                                bundle.putInt(Constant.PASSTYPE, 2);
                                intent.putExtras(bundle);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                BaseApplication.this.startActivity(intent);

                            }
                        });
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                //这里可以先客户端一步拿到每一次http请求的结果,可以解析成json,做一些操作,如检测到token过期后
                //重新请求token,并重新执行请求
//                try {
//                    JSONArray array = new JSONArray(httpResult);
//                    JSONObject object = (JSONObject) array.get(0);
//                    String login = object.getString("login");
//                    String avatar_url = object.getString("avatar_url");
//                    Timber.tag(TAG).w("result ------>" + login + "    ||   avatar_url------>" + avatar_url);
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//

                //这里如果发现token过期,可以先请求最新的token,然后在拿新的token去重新请求之前的http请求
                // create a new request and modify it accordingly using the new token
//                    Request newRequest = chain.request().newBuilder().header("token", newToken)
//                            .build();
//
//                    // retry the request
//
//                    response.body().close();
//                    try {
//                        return chain.proceed(newRequest);
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }

                //如果需要返回新的结果,则直接把response参数返回出去
                return response;
            }

            @Override
            public Request onHttpRequestBefore(Interceptor.Chain chain, Request request) {
                //如果需要再请求服务器之前做一些操作,则重新返回一个做过操作的的requeat如增加header,不做操作则返回request

                //return chain.request().newBuilder().header("token", tokenId)
//                .build();
                return request;
            }
        };
    }

    /**
     * 用来提供interceptor,如果要提供额外的interceptor可以让子application实现此方法
     *
     * @return
     */
    protected Interceptor[] getInterceptors() {
        return null;
    }

    /**
     * 返回一个存储所有存在的activity的列表
     *
     * @return
     */
    public LinkedList<BaseCommonActivity> getActivityList() {
        if (mActivityList == null) {
            mActivityList = new LinkedList<>();
        }
        return mActivityList;
    }
}
