package com.delta.smt.ui.Personal.setting.account_security.resetChargePassword;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.delta.commonlibs.utils.SpUtil;
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
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;

import butterknife.BindView;
import butterknife.OnClick;

import static com.delta.smt.R.id.tv_name;
import static com.delta.smt.R.id.tv_telephone;


public class ChangePasswordActivity extends BaseActivity<PresonalPresenter> implements PersonalContract.View {

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
    @BindView(tv_name)
    TextView mTvName;
    @BindView(R.id.tv_clear_cacher)
    TextView mTvClearCacher;
    @BindView(tv_telephone)
    TextView mTvTelephone;
    @BindView(R.id.ll_change_phone)
    AutoLinearLayout mLlChangePhone;
    @BindView(R.id.tv_change_password)
    TextView mTvChangePassword;
    @BindView(R.id.tv_account_bind)
    TextView mTvAccountBind;
    private String token;
    private String merchant_id;

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
    }

    @Override
    public void onResume() {
        getPresenter().getUseInfo(token, merchant_id);
        super.onResume();
    }

    @Override
    protected void initView() {
        mToolbarTitle.setText("账号与安全");
        mToolbarRightButton.setVisibility(View.INVISIBLE);
        mToolbarLeftButton.setImageResource(R.mipmap.ic_back);
        mTvLeftButtonName.setText("设置");

    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_change_phone;
    }


    @OnClick({R.id.toolbar_left_button_arl, tv_telephone, R.id.ll_change_phone, R.id.tv_change_password, R.id.tv_account_bind})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.toolbar_left_button_arl:
                finish();
                break;
            case tv_telephone:
                break;
            case R.id.ll_change_phone:

                break;
            case R.id.tv_change_password:
                break;
            case R.id.tv_account_bind:

                break;
        }
    }

    @Override
    public void ShowUserInfoSuccess(UserInfo userInfo) {
        UserInfo.ResultEntity.UserEntity user = userInfo.getResult().getUser();
        mTvName.setText(user.getName());
        mTvTelephone.setText(user.getPhone());
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
}
