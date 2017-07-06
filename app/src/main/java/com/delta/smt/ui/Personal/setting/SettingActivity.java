package com.delta.smt.ui.Personal.setting;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.delta.commonlibs.utils.ACache;
import com.delta.commonlibs.utils.IntentUtils;
import com.delta.commonlibs.utils.SpUtil;
import com.delta.smt.Constant;
import com.delta.smt.R;
import com.delta.smt.base.BaseActivity;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.entity.DataCleanManager;
import com.delta.smt.ui.Personal.setting.about.AboutActivity;
import com.delta.smt.ui.Personal.setting.account_security.AccountActivity;
import com.delta.smt.ui.Personal.setting.advice_response.AdviceResponseActivity;
import com.delta.smt.ui.Personal.setting.clear_cache.ClearCacheBottomDialog;
import com.delta.smt.ui.Personal.setting.information_notice.InformationNoticeActivity;
import com.delta.smt.ui.Personal.setting.person_information.PersonInformationActivity;
import com.delta.smt.ui.find.FindToolBar;
import com.delta.smt.ui.login.loginc.LoginCActivity;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.delta.smt.base.BaseApplication.getContext;


/**
 * Created by Fuxiang.Zhang on 2017/4/27.
 */

public class SettingActivity extends BaseActivity {


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
    @BindView(R.id.tv_person_files)
    TextView mTvPersonFiles;
    @BindView(R.id.tv_security)
    TextView mTvSecurity;
    @BindView(R.id.tv_information)
    TextView mTvInformation;
    @BindView(R.id.tv_clear_cacher)
    TextView mTvClearCacher;
    @BindView(R.id.textView8)
    TextView mTextView8;
    @BindView(R.id.tv_advice)
    TextView mTvAdvice;
    @BindView(R.id.tv_about)
    TextView mTvAbout;
    @BindView(R.id.btn_logout)
    Button mBtnLogout;
    @BindView(R.id.ll_clear_cacher)
    AutoLinearLayout mLlClearCacher;


    @Override
    protected void initData() {
        String token = SpUtil.getStringSF(SettingActivity.this, Constant.TOKEN);
        Log.e("aaa", "initData: " + token);

    }

    @Override
    protected void initView() {
        mToolbarTitle.setText("设置");
        mToolbarRightButton.setVisibility(View.INVISIBLE);
        mToolbarLeftButton.setImageResource(R.mipmap.ic_back);
        try {
            mTextView8.setText(DataCleanManager.getTotalCacheSize(this));
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_setting;
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

    @OnClick({R.id.tv_person_files, R.id.tv_security, R.id.tv_information, R.id.ll_clear_cacher,
            R.id.tv_advice, R.id.tv_about, R.id.btn_logout, R.id.toolbar_left_button_arl})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_person_files:
                IntentUtils.showIntent(this, PersonInformationActivity.class);
                break;
            case R.id.tv_security:
                IntentUtils.showIntent(this, AccountActivity.class);
                break;
            case R.id.tv_information:
                IntentUtils.showIntent(this, InformationNoticeActivity.class);
                break;
            case R.id.ll_clear_cacher:
                final ClearCacheBottomDialog mDialog = new ClearCacheBottomDialog(getWindowManager().getDefaultDisplay().getHeight() * 545 / 1920, 0.8f, true);
                mDialog.show(getSupportFragmentManager());
                mDialog.setOnBottomDialogDimissListener(new ClearCacheBottomDialog.OnBottomDialogDimissListener() {
                    @Override
                    public void onDismiss() {
                        mDialog.dismiss();
                        DataCleanManager.clearAllCache(getContext());
                        try {
                            mTextView8.setText(DataCleanManager.getTotalCacheSize(getContext()));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                break;
            case R.id.tv_advice:
                IntentUtils.showIntent(this, AdviceResponseActivity.class);
                break;
            case R.id.tv_about:
                IntentUtils.showIntent(this, AboutActivity.class);
                break;
            case R.id.btn_logout:

                SpUtil.SetStringSF(SettingActivity.this, Constant.TOKEN, "");
                Intent mIntent = new Intent(this, LoginCActivity.class);
                mIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(mIntent);
                finish();
                break;
            case R.id.toolbar_left_button_arl:
                finish();
                break;
        }
    }















}