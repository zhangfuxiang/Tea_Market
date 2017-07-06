package com.delta.smt;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.WindowManager;

import com.delta.commonlibs.utils.SpUtil;
import com.delta.commonlibs.utils.ToastUtils;
import com.delta.smt.base.BaseActivity;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.entity.StartResult;
import com.delta.smt.ui.login.loginc.LoginCActivity;
import com.delta.smt.ui.login.start.di.DaggerStartComponent;
import com.delta.smt.ui.login.start.di.StartModule;
import com.delta.smt.ui.login.start.mvp.StartContract;
import com.delta.smt.ui.login.start.mvp.StartPresenter;
import com.delta.smt.utils.SystemInfoUtils;


/**
 * Created by wushufeng on 2017/4/4.
 */

public class StartActivity extends BaseActivity<StartPresenter> implements StartContract.View {

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (!TextUtils.isEmpty(SpUtil.getStringSF(StartActivity.this, Constant.TOKEN))) {
                startActivity(new Intent(StartActivity.this, MainActivity.class));
                StartActivity.this.finish();
            } else {
                startActivity(new Intent(StartActivity.this, LoginCActivity.class));
                StartActivity.this.finish();
            }

        }
    };

    @Override
    protected void componentInject(AppComponent appComponent) {
        DaggerStartComponent.builder()
                .appComponent(appComponent)
                .startModule(new StartModule(this)) //请将StartModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected void initView() {
        //handler.sendEmptyMessageDelayed(1, 500);
    }

    @Override
    protected void initData() {
        /*getPresenter().start(Constant.CLIENT,
                Constant.CLIENT_VERSION,
                Constant.OS,
                Constant.OS_TOKEN,
                Constant.API_VERSION);*/
        WindowManager wm = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);

        Constant.WIDTH = wm.getDefaultDisplay().getWidth();
        Constant.HEIGHT = wm.getDefaultDisplay().getHeight();
        initBaseParameter(this);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_start;
    }

    @Override
    public void onStartSuccess(StartResult startResult) {
        /*startActivity(new Intent(StartActivity.this, LoginActivity.class));
        StartActivity.this.finish();*/
        handler.sendEmptyMessageDelayed(1, 500);
    }

    @Override
    public void onStartFailed(StartResult startResult) {
        if (!TextUtils.isEmpty(startResult.getApp_msg())) {
            ToastUtils.showMessage(StartActivity.this, startResult.getApp_msg());
        }
    }

    @Override
    public void onStartFailed(Throwable throwable) {
        if (!TextUtils.isEmpty(throwable.getMessage())) {
            ToastUtils.showMessage(StartActivity.this, throwable.getMessage());
        }
    }

    public void initBaseParameter(Context context) {
        Constant.CLIENT = SystemInfoUtils.getClientType();
        Constant.CLIENT_VERSION = SystemInfoUtils.getAppVersionName(context);
        Constant.OS = SystemInfoUtils.getOSType();
        //Constant.OS_TOKEN = SystemInfoUtils.getOSToken(context);
        Constant.API_VERSION = SystemInfoUtils.getApiVersion();
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_PHONE_STATE},
                    Constant.PERMISSIONS_REQUEST_READ_PHONE_STATE);
        } else {
            //
            Constant.OS_TOKEN = SystemInfoUtils.getOSToken(context);
            handler.sendEmptyMessageDelayed(1, 500);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case Constant.PERMISSIONS_REQUEST_READ_PHONE_STATE: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                    Constant.OS_TOKEN = SystemInfoUtils.getOSToken(this);

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Constant.OS_TOKEN = "";
                }
                //getPresenter().start();
                handler.sendEmptyMessageDelayed(1, 500);
                return;
            }
        }
    }
}