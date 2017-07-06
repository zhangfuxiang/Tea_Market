package com.delta.smt.ui.buycar;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;

import com.delta.smt.R;
import com.zhy.autolayout.AutoRelativeLayout;

/**
 * Created by wushufeng on 2017/4/12.
 */

public class BuyCarToolBar extends Toolbar {

    private AutoRelativeLayout toolbarLeftButtonArl;
    private ImageView toolbarLeftButton;
    private TextView toolbarTitle;
    private AutoRelativeLayout toolbarRightButtonIvArl;

    public BuyCarToolBar(Context context) {
        super(context);
    }

    public BuyCarToolBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BuyCarToolBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        //绑定控件
        toolbarLeftButtonArl = (AutoRelativeLayout) findViewById(R.id.toolbar_left_button_arl);
        toolbarLeftButton = (ImageView) findViewById(R.id.toolbar_left_button);
        toolbarTitle = (TextView) findViewById(R.id.toolbarTitle);
        toolbarRightButtonIvArl = (AutoRelativeLayout) findViewById(R.id.toolbar_right_button_iv_arl);
    }

    public void setToolbarLeftButton(int id) {
        toolbarLeftButton.setVisibility(VISIBLE);
        toolbarLeftButton.setImageResource(id);
    }

    public void setToolbarTitle(String str) {
        toolbarTitle.setVisibility(VISIBLE);
        toolbarTitle.setText(str);
    }

    public void setToolbarLeftButtonOnClickListener(OnClickListener onClickListener) {
        toolbarLeftButtonArl.setOnClickListener(onClickListener);
    }

    public void setToolbarRightButtonIvArlOnClickListener(OnClickListener listener) {
        toolbarRightButtonIvArl.setOnClickListener(listener);
    }

}
