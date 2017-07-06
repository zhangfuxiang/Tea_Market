package com.delta.smt.ui.TeaCircle;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.delta.commonlibs.utils.SpUtil;
import com.delta.smt.Constant;
import com.delta.smt.R;
import com.github.lzyzsd.jsbridge.BridgeHandler;
import com.github.lzyzsd.jsbridge.BridgeWebView;
import com.github.lzyzsd.jsbridge.CallBackFunction;
import com.luck.picture.lib.compress.Luban;
import com.luck.picture.lib.model.FunctionConfig;
import com.luck.picture.lib.model.FunctionOptions;
import com.luck.picture.lib.model.PictureConfig;
import com.yalantis.ucrop.entity.LocalMedia;

import java.io.File;
import java.util.List;

import static com.makeramen.roundedimageview.RoundedDrawable.TAG;


public class TeaCircleFragment extends Fragment {

    //final String URL = "http://tea.h5.test.sygcsoft.com/teabbs/html";
    final String URL = "http://laodongjianguan.chanlytech.com:8088/laodongjianguan/index.php/daohang/daohang/f";
    private BridgeWebView webView;
    private ValueCallback<Uri> mUploadMessage;// 表单的数据信息
    private ValueCallback<Uri[]> mUploadCallbackAboveL;
    private final static int FILECHOOSER_RESULTCODE = 1;// 表单的结果回调</span>
    private Uri imageUri;
    private String loginMessage;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1: {
                    webViewGoBack();
                }
                break;
            }
        }
    };

    private void webViewGoBack() {
        webView.goBack();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       // URL = getArguments().getString(Constant.WEBURL);
        View view = inflater.inflate(R.layout.fragment_tea_circle, container, false);
        loginMessage = SpUtil.getStringSF(getActivity(), Constant.LoginMessage);
        webView = (BridgeWebView) view.findViewById(R.id.webView_quan);

        webView.setWebViewClient(new myWebClient());
        webView.registerHandler("getUserInfo", new BridgeHandler() {
            @Override
            public void handler(String data, CallBackFunction function) {

                String str = "这是html返回给java的数据:" + data;
                // 例如你可以对原始数据进行处理
                str = str + ",Java经过处理后截取了一部分：" + str.substring(0, 5);
                Log.i(TAG, "handler = submitFromWeb, data from web = " + data);
                Toast.makeText(getActivity(), str, Toast.LENGTH_SHORT).show();
                //回调返回给Js
                function.onCallBack(loginMessage);
            }
        });

        webView.addJavascriptInterface(new Object() {

            @JavascriptInterface
            public String getUserInfo() {

                return loginMessage;

            }


        }, "native");
        final DisplayMetrics dm = new DisplayMetrics();
        WindowManager manager = (WindowManager) getActivity().getSystemService(Context.WINDOW_SERVICE);
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
        WebSettings settings = webView.getSettings();
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(true);

        FunctionOptions options = new FunctionOptions.Builder()
                .setType(FunctionConfig.TYPE_IMAGE)
                .setMaxB(202400)
                .setEnableQualityCompress(true) //是否启质量压缩
                .setCompress(true)
                .setSelectMode(FunctionConfig.MODE_SINGLE)
                .setGrade(Luban.THIRD_GEAR)
                .create();
        PictureConfig.getInstance().init(options);
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onShowFileChooser(WebView webView,
                                             ValueCallback<Uri[]> filePathCallback,
                                             FileChooserParams fileChooserParams) {
                mUploadCallbackAboveL = filePathCallback;
                // take();

                PictureConfig.getInstance().openPhoto(getActivity(), new PictureConfig.OnSelectResultCallback() {
                    @Override
                    public void onSelectSuccess(List<LocalMedia> list) {

                    }

                    @Override
                    public void onSelectSuccess(LocalMedia localMedia) {

                        mUploadCallbackAboveL.onReceiveValue(new Uri[]{Uri.fromFile(new File(localMedia.getCompressPath()))});
                        mUploadCallbackAboveL = null;
                    }
                });

                return true;
            }

            public void openFileChooser(ValueCallback<Uri> uploadMsg) {
                mUploadMessage = uploadMsg;
                openPhoto();
                // take();
            }

            public void openFileChooser(ValueCallback<Uri> uploadMsg, String acceptType) {
                mUploadMessage = uploadMsg;
                openPhoto();
            }

            public void openFileChooser(ValueCallback<Uri> uploadMsg, String acceptType, String capture) {
                mUploadMessage = uploadMsg;
                openPhoto();
            }
        });

        webView.setOnKeyListener(new View.OnKeyListener() {

            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
                    handler.sendEmptyMessage(1);
                    return true;
                }
                return false;
            }

        });
        webView.loadUrl(URL);
        //webView.loadUrl(URL);
        return view;
    }

    private void openPhoto() {
        PictureConfig.getInstance().openPhoto(getActivity(), new PictureConfig.OnSelectResultCallback() {
            @Override
            public void onSelectSuccess(List<LocalMedia> list) {

            }

            @Override
            public void onSelectSuccess(LocalMedia localMedia) {

                mUploadMessage.onReceiveValue(Uri.fromFile(new File(localMedia.getCompressPath())));
                mUploadMessage = null;
            }
        });
    }

    class myWebClient extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            // TODO Auto-generated method stub
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // TODO Auto-generated method stub

            view.loadUrl(url);
            return true;

        }

        @Override
        public void onPageFinished(WebView view, String url) {
            // TODO Auto-generated method stub
            super.onPageFinished(view, url);


        }
    }

    public void loadUrl(long id) {
        webView.loadUrl(URL + "?id=" + id + "&token" + SpUtil.getStringSF(getActivity(), Constant.TOKEN));
        //webView.loadUrl("https://www.baidu.com");
    }
}
