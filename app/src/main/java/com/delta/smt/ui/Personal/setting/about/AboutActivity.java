package com.delta.smt.ui.Personal.setting.about;

import android.os.Bundle;
import android.view.View;
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

public class AboutActivity extends BaseActivity {


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
    @BindView(R.id.tv_score)
    TextView mTvScore;
    @BindView(R.id.tv_version_num)
    TextView mTvVersionNum;
    @BindView(R.id.tv_version)
    AutoLinearLayout mTvVersion;
    @BindView(R.id.tv_user_protocol)
    TextView mTvUserProtocol;
    @BindView(R.id.tv_help)
    TextView mTvHelp;
    @BindView(R.id.tv_loaddown)
    TextView mTvLoaddown;
    @BindView(R.id.tv_clear_cacher)
    TextView mTvClearCacher;
    @BindView(R.id.tv_telephone_num)
    TextView mTvTelephoneNum;
    @BindView(R.id.tv_telephone)
    AutoLinearLayout mTvTelephone;
    @BindView(R.id.textView10)
    TextView mTextView10;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mToolbarTitle.setText("关于");
        mToolbarRightButton.setVisibility(View.INVISIBLE);
        mToolbarLeftButton.setImageResource(R.mipmap.ic_back);

    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_about;
    }

    @Override
    protected void componentInject(AppComponent appComponent) {

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