package com.delta.smt.ui.HomePage;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.delta.commonlibs.utils.SpUtil;
import com.delta.smt.R;
import com.delta.smt.base.BaseActivity;
import com.delta.smt.di.component.AppComponent;

import butterknife.BindView;

/**
 * Created by Shaoqiang.Zhang on 2017/5/15.
 */

public class WebViewActivity extends BaseActivity {

    @BindView(R.id.home_page_webview)
    WebView home_page_webview;

    String loginMessage = SpUtil.getStringSF(this, "login_message");

    @Override
    protected void initView() {

        String url=getIntent().getStringExtra("url");
        home_page_webview.setWebViewClient(new WebViewClient());
        home_page_webview.loadUrl(url);
        final DisplayMetrics dm = new DisplayMetrics();
        WindowManager manager = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        manager.getDefaultDisplay().getMetrics(dm);

        //点击后退按钮,让WebView后退一页(也可以覆写Activity的onKeyDown方法)
        home_page_webview.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    if (keyCode == KeyEvent.KEYCODE_BACK && home_page_webview.canGoBack()) {  //表示按返回键时的操作
                        home_page_webview.goBack();   //后退
                        return true;    //已处理
                    }
                }
                return false;
            }
        });

        loginMessage = SpUtil.getStringSF(this, "login_message");
        home_page_webview.getSettings().setJavaScriptEnabled(true);
        home_page_webview.addJavascriptInterface(new Object() {

            @JavascriptInterface
            public String getUserInfo() {
                return loginMessage;
            }
        }, "native");

    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_webview;
    }

    @Override
    protected void componentInject(AppComponent appComponent) {

    }
}
