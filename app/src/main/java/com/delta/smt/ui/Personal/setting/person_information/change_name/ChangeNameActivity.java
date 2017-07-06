package com.delta.smt.ui.Personal.setting.person_information.change_name;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.delta.smt.R;
import com.delta.smt.base.BaseActivity;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.entity.ClearEditText;
import com.delta.smt.ui.find.FindToolBar;
import com.zhy.autolayout.AutoRelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by Fuxiang.Zhang on 2017/5/7.
 */

public class ChangeNameActivity extends BaseActivity {


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
    @BindView(R.id.et_name)
    ClearEditText mEtName;

    @Override
    protected void componentInject(AppComponent appComponent) {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mToolbarTitle.setText("姓名");
        mToolbarRightButton.setText("保存");
        mToolbarLeftButton.setImageResource(R.mipmap.start_page_exit);

    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_change_name;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.toolbar_left_button_arl, R.id.toolbar_right_button})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.toolbar_left_button_arl:
                finish();
                break;
            case R.id.toolbar_right_button:
                finish();
                break;
        }
    }
}