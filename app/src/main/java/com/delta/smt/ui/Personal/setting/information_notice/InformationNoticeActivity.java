package com.delta.smt.ui.Personal.setting.information_notice;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.delta.smt.R;
import com.delta.smt.base.BaseActivity;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.ui.find.FindToolBar;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by Fuxiang.Zhang on 2017/5/2.
 */

public class InformationNoticeActivity extends BaseActivity {


    @BindView(R.id.toolbar_left_button)
    ImageView mToolbarLeftButton;
    @BindView(R.id.tv_left_button_name)
    TextView mTvLeftButtonName;
    @BindView(R.id.toolbar_left_button_arl)
    AutoRelativeLayout mToolbarLeftButtonArl;
    @BindView(R.id.toolbarTitle)
    TextView mToolbarTitle;
    @BindView(R.id.toolbar_right_button)
    TextView mToolbarRightButton;
    @BindView(R.id.toolbar_right_button_iv)
    ImageView mToolbarRightButtonIv;
    @BindView(R.id.toolbar_right_button_iv_arl)
    AutoRelativeLayout mToolbarRightButtonIvArl;
    @BindView(R.id.toolbar)
    FindToolBar mToolbar;
    @BindView(R.id.tv_version_num)
    TextView mTvVersionNum;
    @BindView(R.id.tv_version)
    AutoLinearLayout mTvVersion;
    @BindView(R.id.ll_voice)
    AutoRelativeLayout mLlVoice;
    @BindView(R.id.ll_shake)
    AutoRelativeLayout mLlShake;

    @Override
    protected void componentInject(AppComponent appComponent) {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mToolbarTitle.setText("消息通知");
        mToolbarRightButton.setVisibility(View.INVISIBLE);
        mToolbarLeftButton.setImageResource(R.mipmap.ic_back);

    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_information_notice;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.toolbar_left_button_arl)
    public void onClick() {
        finish();
    }
}