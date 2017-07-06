package com.delta.smt.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.delta.smt.app.App;

import java.util.LinkedList;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @description :不带Presenter的Activity
 * @autHor :  V.Wenju.Tian
 * @date : 2016/12/14 11:24
 */


public abstract class BaseCommonActivity extends AppCompatActivity {
    public static final String ACTION_RECEIVER_ACTIVITY = "com.delta.smt";
    public static final String IS_NOT_ADD_ACTIVITY_LIST = "is_add_activity_list";//是否加入到activity的list，管理
    private String TAG = getClass().getSimpleName();
    private BroadcastReceiver mBroadcastReceiver;
    private App application;
    private Unbinder bind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        application = ((App) getApplication());
        boolean isNotAdd = getIntent().getBooleanExtra(IS_NOT_ADD_ACTIVITY_LIST, false);
        synchronized (BaseCommonActivity.class) {
            if (!isNotAdd)
                application.getActivityList().add(this);
        }
        setContentView(getContentViewId());
        bind = ButterKnife.bind(this);

        initCData();
        initCView();
    }

    protected abstract void initCView();

    protected abstract void initCData();


    public App getMApplication() {
        return application;
    }


    @Override
    protected void onResume() {
        super.onResume();
        registReceiver();//注册广播
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregistReceriver();
    }

    @Override
    protected void onDestroy() {
        synchronized (BaseCommonActivity.class) {
            application.getActivityList().remove(this);
        }
        if (bind != Unbinder.EMPTY) {
            bind.unbind();
        }
        super.onDestroy();
    }

    protected abstract int getContentViewId();

    /**
     * 注册广播
     */
    public void registReceiver() {
        try {
            mBroadcastReceiver = new ActivityReceriver();
            IntentFilter filter = new IntentFilter(ACTION_RECEIVER_ACTIVITY);
            registerReceiver(mBroadcastReceiver, filter);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 解除注册广播
     */
    public void unregistReceriver() {
        if (mBroadcastReceiver == null) return;
        try {
            unregisterReceiver(mBroadcastReceiver);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void FullScreencall() {
        if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) { // lower api
            View v = this.getWindow().getDecorView();
            v.setSystemUiVisibility(View.GONE);
        } else if (Build.VERSION.SDK_INT >= 19) {
            //for new api versions.
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
            decorView.setSystemUiVisibility(uiOptions);
        }
    }

    /**
     * 用于处理当前activity需要
     */
    class ActivityReceriver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                switch (intent.getStringExtra("type")) {
                    case "startActivity"://启动activity
                        Intent content = intent.getExtras().getParcelable("content");
                        startActivity(content);
                        break;
                    case "showSnackbar"://显示snackbar
                        String text = intent.getStringExtra("content");
                        boolean isLong = intent.getBooleanExtra("long", false);
                        View view = BaseCommonActivity.this.getWindow().getDecorView().findViewById(android.R.id.content);
                        Snackbar.make(view, text, isLong ? Snackbar.LENGTH_LONG : Snackbar.LENGTH_SHORT).show();
                        break;
                    case "killAll":
                        LinkedList<BaseCommonActivity> copy;
                        synchronized (BaseCommonActivity.class) {
                            copy = new LinkedList<BaseCommonActivity>(application.getActivityList());
                        }
                        for (BaseCommonActivity baseActivity : copy) {
                            baseActivity.finish();
                        }
                        //		android.os.Process.killProcess(android.os.Process.myPid());
                        break;
                }
            }
        }
    }

}
