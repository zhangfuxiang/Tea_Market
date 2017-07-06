package com.delta.smt.ui.find.productDetail;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.delta.smt.R;
import com.delta.smt.ui.find.auctionHouseDetail.AdaptiveViewPager;

/**
 * Created by wushufeng on 2017/3/21.
 */

public class ProductPicTxtDetailFragment extends Fragment {

    public WebView wvPicTxtDetail;
    AdaptiveViewPager vp;


    public ProductPicTxtDetailFragment() {
    }

    public void setAdaptiveViewPager(AdaptiveViewPager vp) {
        this.vp = vp;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_picture_text_detail, container, false);
        vp.setObjectForPosition(view, 0);
        wvPicTxtDetail = (WebView) view.findViewById(R.id.wv_pic_txt_detail);


        initWebView();
        return view;
    }

    private void initWebView() {
        wvPicTxtDetail.getSettings().setJavaScriptEnabled(true);
        wvPicTxtDetail.getSettings().setBuiltInZoomControls(false);
        wvPicTxtDetail.getSettings().setDisplayZoomControls(false);
        wvPicTxtDetail.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY); //取消滚动条白边效果
        wvPicTxtDetail.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        wvPicTxtDetail.getSettings().setDefaultTextEncodingName("UTF-8");
        wvPicTxtDetail.getSettings().setBlockNetworkImage(false);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            wvPicTxtDetail.getSettings().setMixedContentMode(wvPicTxtDetail.getSettings().MIXED_CONTENT_ALWAYS_ALLOW);  //注意安卓5.0以上的权限
        }
        //wvPicTxtDetail.loadDataWithBaseURL("http://avatar.csdn.net",getNewContent(IMAGE3),"text/html", "UTF-8", null);
    }

}
