package com.delta.smt.ui.find;

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

public class FindToolBar extends Toolbar {

    private AutoRelativeLayout toolbarLeftButtonArl;
    private ImageView toolbarLeftButton;
    private TextView tvLeftButtonName;
    private TextView toolbarTitle;
    private TextView toolbarRightButton;
    private AutoRelativeLayout toolbarRightButtonIvArl;
    private ImageView toolbarRightButtonIv;

    public FindToolBar(Context context) {
        super(context);
    }

    public FindToolBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public FindToolBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        //绑定控件
        toolbarLeftButtonArl = (AutoRelativeLayout) findViewById(R.id.toolbar_left_button_arl);
        toolbarLeftButton = (ImageView) findViewById(R.id.toolbar_left_button);
        tvLeftButtonName = (TextView) findViewById(R.id.tv_left_button_name);
        toolbarTitle = (TextView) findViewById(R.id.toolbarTitle);
        toolbarRightButton = (TextView) findViewById(R.id.toolbar_right_button);
        toolbarRightButtonIvArl = (AutoRelativeLayout) findViewById(R.id.toolbar_right_button_iv_arl);
        toolbarRightButtonIv = (ImageView) findViewById(R.id.toolbar_right_button_iv);
    }

    public void setToolbarLeftButton(int id) {
        toolbarLeftButton.setVisibility(VISIBLE);
        toolbarLeftButton.setImageResource(id);
    }

    public void setTvLeftButtonName(String str) {
        tvLeftButtonName.setVisibility(VISIBLE);
        tvLeftButtonName.setText(str);
    }

    public void setToolbarTitle(String str) {
        toolbarTitle.setVisibility(VISIBLE);
        toolbarTitle.setText(str);
    }

    public void setToolbarRightButton(String str) {
        toolbarRightButton.setVisibility(VISIBLE);
        toolbarRightButton.setText(str);
    }

    public void setToolbarLeftButtonOnClickListener(OnClickListener onClickListener) {
        toolbarLeftButtonArl.setOnClickListener(onClickListener);
    }

    public void setToolbarRightButtonOnClickListener(OnClickListener onClickListener) {
        toolbarRightButton.setOnClickListener(onClickListener);
    }

    public void setToolbarRightButtonIvArlOnClickListener(OnClickListener listener) {
        toolbarRightButtonIvArl.setOnClickListener(listener);
    }

    public void setToolbarRightButtonIv(int id) {
        toolbarRightButtonIv.setVisibility(VISIBLE);
        toolbarRightButtonIv.setImageResource(id);
    }

}
