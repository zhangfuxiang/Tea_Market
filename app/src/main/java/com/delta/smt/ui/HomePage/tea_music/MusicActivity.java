package com.delta.smt.ui.HomePage.tea_music;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.delta.smt.R;
import com.delta.smt.base.BaseActivity;
import com.delta.smt.di.component.AppComponent;

/**
 * Created by Shaoqiang.Zhang on 2017/5/5.
 */

public class MusicActivity extends BaseActivity {

    final String URL = "http://tea.h5.test.sygcsoft.com/music/";
    WebView webView;

    @Override
    protected void initView() {
        webView = (WebView) findViewById(R.id.music_web);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        final DisplayMetrics dm = new DisplayMetrics();
        WindowManager manager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        manager.getDefaultDisplay().getMetrics(dm);
        webView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        int point = (int) event.getX();
                        if (point > 0 && point < 50 || point > dm.widthPixels - 50 && point < dm.widthPixels) {
                            webView.requestDisallowInterceptTouchEvent(false);
                        } else {
                            webView.requestDisallowInterceptTouchEvent(true);
                        }
                        break;
                }

                return false;
            }
        });
        webView.loadUrl(URL);

        //点击后退按钮,让WebView后退一页(也可以覆写Activity的onKeyDown方法)
        webView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {  //表示按返回键时的操作

                        webView.goBack();   //后退
                        return true;    //已处理
                    }
                }
                return false;
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_music;
    }

    @Override
    protected void componentInject(AppComponent appComponent) {

    }

}
