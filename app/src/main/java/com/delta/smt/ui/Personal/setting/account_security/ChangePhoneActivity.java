package com.delta.smt.ui.Personal.setting.account_security;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.delta.commonlibs.utils.IntentUtils;
import com.delta.commonlibs.utils.SpUtil;
import com.delta.commonlibs.utils.ToastUtils;
import com.delta.smt.Constant;
import com.delta.smt.R;
import com.delta.smt.base.BaseActivity;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.entity.UserInfo;
import com.delta.smt.ui.Personal.di.DaggerPresonalComponent;
import com.delta.smt.ui.Personal.di.PresonalModule;
import com.delta.smt.ui.Personal.mvp.PersonalContract;
import com.delta.smt.ui.Personal.mvp.PresonalPresenter;
import com.delta.smt.ui.find.FindToolBar;
import com.delta.smt.utils.StringUtil;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;

import butterknife.BindView;
import butterknife.OnClick;


public class ChangePhoneActivity extends BaseActivity<PresonalPresenter> implements PersonalContract.View {


    @BindView(R.id.toolbar_left_button)
    ImageView toolbarLeftButton;
    @BindView(R.id.tv_left_button_name)
    TextView tvLeftButtonName;
    @BindView(R.id.toolbar_left_button_arl)
    AutoRelativeLayout toolbarLeftButtonArl;
    @BindView(R.id.toolbarTitle)
    TextView mToolbarTitle;
    @BindView(R.id.toolbar_right_button)
    TextView mToolbarRightButton;
    @BindView(R.id.toolbar_right_button_iv)
    ImageView mToolbarLeftButton;
    @BindView(R.id.toolbar_right_button_iv_arl)
    AutoRelativeLayout toolbarRightButtonIvArl;
    @BindView(R.id.toolbar)
    FindToolBar toolbar;
    @BindView(R.id.tv_notice)
    TextView tvNotice;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_clear_cacher)
    TextView tvClearCacher;
    @BindView(R.id.tv_telephone)
    EditText tvTelephone;
    @BindView(R.id.ll_change_phone)
    AutoLinearLayout llChangePhone;
    @BindView(R.id.tv_account_bind)
    Button tvAccountBind;
    private String token;
    private String merchant_id;
    public static final int CHANGEPHONE = 1;
    public static final int CONFIRMPHONE = 2;
    private int current = CHANGEPHONE;

    @Override
    protected void componentInject(AppComponent appComponent) {
        DaggerPresonalComponent.builder().appComponent(appComponent).presonalModule(new PresonalModule(this)).build().inject(this);
//        DaggerAccountComponent.builder()
//                .appComponent(appComponent)
//                .accountModule(new AccountModule(this)) //请将AccountModule()第一个首字母改为小写
//                .build()
//                .inject(this);
    }

    @Override
    protected void initData() {
        token = SpUtil.getStringSF(this, Constant.TOKEN);

        merchant_id = SpUtil.getStringSF(this, Constant.MERCHANTID);
        Intent intent = getIntent();
        if (intent != null) {
            Bundle extras = intent.getExtras();
            if (extras != null) {
                int type = extras.getInt(Constant.CHANGEPHONESTATUE, 1);
                current = type;
            }

        }
    }

    @Override
    public void onResume() {
        getPresenter().getUseInfo(token, merchant_id);
        super.onResume();
    }

    @Override
    protected void initView() {
        switch (current) {
            case CHANGEPHONE:
                mToolbarTitle.setText("更换手机号");
                break;
            case CONFIRMPHONE:
                break;
        }


        mToolbarRightButton.setVisibility(View.INVISIBLE);
        mToolbarLeftButton.setImageResource(R.mipmap.ic_back);


    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_change_phone;
    }


//    @OnClick({R.id.toolbar_left_button_arl, tv_telephone, R.id.ll_change_phone, R.id.tv_change_password, R.id.tv_account_bind})
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.toolbar_left_button_arl:
//                finish();
//                break;
//            case tv_telephone:
//                break;
//            case R.id.ll_change_phone:
//                break;
//            case R.id.tv_change_password:
//                break;
//            case R.id.tv_account_bind:
//                break;
//        }
//    }

    @Override
    public void ShowUserInfoSuccess(UserInfo userInfo) {
        UserInfo.ResultEntity.UserEntity user = userInfo.getResult().getUser();
        tvNotice.setText("更换手机号,下次登录即可使用新手机号登录，当前手机号码" + user.getPhone());
//        mTvTelephone.setText(user.getPhone());
    }

    @Override
    public void showUserInfoError() {

    }

    @Override
    public void resetPasswordSuccess() {

    }

    @Override
    public void resetPasswordFailed(String app_msg) {

    }

    @Override
    public void checkPasswordSuccess() {

    }

    @Override
    public void checkPasswordFailed(String app_msg) {

    }


    @OnClick({R.id.toolbar_left_button_arl, R.id.tv_account_bind})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.toolbar_left_button_arl:
                finish();
                break;
            case R.id.tv_account_bind:
                String phone = tvTelephone.getText().toString();
                if (TextUtils.isEmpty(phone)) {
                    ToastUtils.showMessage(this, "电话号码不能为空！");
                    return;
                }

                if (!StringUtil.isMobile(phone)) {
                    ToastUtils.showMessage(this, "手机号码格式不正确！");
                    return;
                }
                IntentUtils.showIntent(this, ChangeNewPhoneActivity.class, new String[]{Constant.PHONE}, new String[]{phone});

                break;
        }
    }
}
