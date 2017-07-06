package com.delta.smt.ui.HomePage;

import android.content.Context;
import android.os.Build;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.delta.commonlibs.utils.SpUtil;
import com.delta.commonlibs.utils.ToastUtils;
import com.delta.smt.R;
import com.delta.smt.base.BaseActivity;
import com.delta.smt.di.component.AppComponent;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Shaoqiang.Zhang on 2017/5/23.
 */

public class NewsDetailActivity extends BaseActivity {

    @BindView(R.id.home_page_webview)
    WebView home_page_webview;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_left_button)
    ImageView leftButton;
    @BindView(R.id.toolbar_right_button)
    TextView rightButton;
    @BindView(R.id.toolbarTitle)
    TextView toolbarTitle;

    @OnClick(R.id.toolbar_left_button_arl)
    void back() {
        finish();
    }

    String loginMessage = SpUtil.getStringSF(this, "login_message");

    @Override
    protected void initView() {

        toolbarTitle.setText(getIntent().getStringExtra("title"));
        rightButton.setVisibility(View.INVISIBLE);
        leftButton.setImageResource(R.mipmap.ic_back);

        String url = getIntent().getStringExtra("url");
        final DisplayMetrics dm = new DisplayMetrics();
        WindowManager manager = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        manager.getDefaultDisplay().getMetrics(dm);

        home_page_webview.getSettings().setJavaScriptEnabled(true);
        home_page_webview.getSettings().setBuiltInZoomControls(true);
        home_page_webview.getSettings().setDisplayZoomControls(false);
        home_page_webview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY); //取消滚动条白边效果
        home_page_webview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        home_page_webview.getSettings().setDefaultTextEncodingName("UTF-8");
        home_page_webview.getSettings().setBlockNetworkImage(false);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            home_page_webview.getSettings().setMixedContentMode(home_page_webview.getSettings().MIXED_CONTENT_ALWAYS_ALLOW);  //注意安卓5.0以上的权限
        }

        home_page_webview.loadDataWithBaseURL("http://avatar.csdn.net",getNewContent(url),"text/html", "UTF-8", null);

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
        return R.layout.activity_news_detail;
    }

    @Override
    protected void componentInject(AppComponent appComponent) {

    }

    private String getNewContent(String htmltext){

        Document doc= Jsoup.parse(htmltext);
        Elements elements=doc.getElementsByTag("img");
        for (Element element : elements) {
            element.attr("width","100%").attr("height","auto");
        }

        return doc.toString();
    }
}
