package com.delta.smt.app;


import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import com.delta.commonlibs.utils.SpUtil;
import com.delta.smt.BuildConfig;
import com.delta.smt.Constant;
import com.delta.smt.R;
import com.delta.smt.api.API;
import com.delta.smt.base.BaseApplication;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.di.component.DaggerAppComponent;
import com.delta.smt.utils.SystemInfoUtils;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

/**
 * Created by V.Wenju.Tian on 2016/11/29.
 */

public class App extends BaseApplication {

    public static List<String> images = new ArrayList<>();
    public static List<String> titles = new ArrayList<>();
    public static App app;

    private AppComponent appComponent;
    private static Handler mainHander;

    public static Retrofit getRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://tea.api.test.sygcsoft.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit;
    }

    public static Handler getMainHander() {
        return mainHander;
    }

    @Override
    public void onCreate() {
       // MultiDex.install(this);
        super.onCreate();
        ZXingLibrary.initDisplayOpinion(this);
        appComponent = DaggerAppComponent.builder().clientModule(getClientModule()).appModule(getAppModule()).serviceModule(getServiceModule()).build();
        SpUtil.SetStringSF(this, Constant.MERCHANTID, "2");
        app = this;
        mainHander = new Handler(Looper.getMainLooper());

        String[] urls = getResources().getStringArray(R.array.url);
        String[] tips = getResources().getStringArray(R.array.title);
        List list = Arrays.asList(urls);
        images = new ArrayList(list);
        List list1 = Arrays.asList(tips);
        titles = new ArrayList(list1);

        //initBaseParameter(this);
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());

        }

        // application 初始化

    }

    @Override
    protected String getBaseUrl() {
        return API.BASE_URL;
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public void initBaseParameter(Context context) {
        Constant.CLIENT = SystemInfoUtils.getClientType();
        Constant.CLIENT_VERSION = SystemInfoUtils.getAppVersionName(context);
        Constant.OS = SystemInfoUtils.getOSType();
        Constant.OS_TOKEN = SystemInfoUtils.getOSToken(context);
        Constant.API_VERSION = SystemInfoUtils.getApiVersion();

    }
}
