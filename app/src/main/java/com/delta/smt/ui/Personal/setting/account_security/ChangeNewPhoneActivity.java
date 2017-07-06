package com.delta.smt.ui.Personal.setting.account_security;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.delta.commonlibs.utils.GsonTools;
import com.delta.commonlibs.utils.IntentUtils;
import com.delta.commonlibs.utils.SpUtil;
import com.delta.commonlibs.utils.ToastUtils;
import com.delta.smt.Constant;
import com.delta.smt.R;
import com.delta.smt.base.BaseActivity;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.entity.SendCodeResult;
import com.delta.smt.entity.UserInfo;
import com.delta.smt.ui.Personal.setting.account_security.di.AccountModule;
import com.delta.smt.ui.Personal.setting.account_security.di.DaggerAccountComponent;
import com.delta.smt.ui.Personal.setting.account_security.mvp.AccountContract;
import com.delta.smt.ui.Personal.setting.account_security.mvp.AccountPresenter;
import com.delta.smt.ui.Personal.setting.account_security.resetChargePassword.ResetChargePasswordActivity;
import com.delta.smt.ui.find.FindToolBar;
import com.delta.smt.ui.login.reset_password_1.di.ResetPasswordOneModule;
import com.delta.smt.ui.login.reset_password_1.mvp.ResetPasswordOneConstract;
import com.delta.smt.utils.MapUtils;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.OnClick;

import static com.delta.smt.ui.Personal.setting.account_security.resetChargePassword.ResetChargePasswordActivity.RESETCHARGEPASSWORD;


public class ChangeNewPhoneActivity extends BaseActivity<AccountPresenter> implements AccountContract.View, ResetPasswordOneConstract.View {


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
    @BindView(R.id.btn_get_code)
    TextView btnGetCode;
    @BindView(R.id.tv_notice_phone)
    TextView tvNoticePhone;

    private String token;
    private String merchant_id;
    private String phone;
    private Timer timer;
    int total_second = 60;
    private TimerTask task;
    public static final int CHANGEPHONE = 1;
    public static final int CONFIRMPHONE = 2;
    private int current = CHANGEPHONE;

    @Override
    protected void componentInject(AppComponent appComponent) {
//        DaggerResetPasswordOneComponent.builder()
//                .appComponent(appComponent)
//                .resetPasswordOneModule(new ResetPasswordOneModule(this)) //请将StartModule()第一个首字母改为小写
//                .build()
//                .inject(this);
        DaggerAccountComponent.builder()
                .appComponent(appComponent)
                .resetPasswordOneModule(new ResetPasswordOneModule(this))
                .accountModule(new AccountModule(this))//请将AccountModule()第一个首字母改为小写
                .build()
                .inject(this);
    }


    @Override
    protected void initData() {

        token = SpUtil.getStringSF(this, Constant.TOKEN);
        phone = getIntent().getStringExtra(Constant.PHONE);
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

        super.onResume();
    }

    @Override
    protected void initView() {
        switch (current) {
            case CHANGEPHONE:
                mToolbarTitle.setText("更换手机号");

                break;
            case CONFIRMPHONE:
                mToolbarTitle.setText("安全验证");
                tvNotice.setText("系统已经向你的手机号发送了验证信息，输入验证码完成验证并保存");
                tvNoticePhone.setText("手机号码");
                String userinfo = SpUtil.getStringSF(this, Constant.USERINFO);
                UserInfo userInfo = GsonTools.changeGsonToBean(userinfo, UserInfo.class);
                phone = userInfo.getResult().getUser().getPhone();
                break;
        }
        tvName.setText(phone);
        mToolbarRightButton.setVisibility(View.INVISIBLE);
        mToolbarLeftButton.setImageResource(R.mipmap.ic_back);


    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_change_new_phone;
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
    public void sendCodeSuccess(SendCodeResult sendCodeResult) {

        btnGetCode.setText(total_second + "s");
        btnGetCode.setEnabled(false);
        btnGetCode.setTextColor(Color.rgb(204, 204, 204));
        timer = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {

                runOnUiThread(new Runnable() {      // UI thread
                    @Override
                    public void run() {
                        total_second--;
                        btnGetCode.setText(total_second + "s");
                        if (total_second == 0) {
                            timer.cancel();
                            task.cancel();
                            total_second = 60;
                            btnGetCode.setText("获取验证码");
                            btnGetCode.setEnabled(true);
                            btnGetCode.setTextColor(getResources().getColor(R.color.base_color));
                        }
                    }
                });
            }
        };
        timer.schedule(task, 1000, 1000);
    }

    @Override
    public void sendCodeFailed(SendCodeResult sendCodeResult) {

    }

    @Override
    public void sendCodeFailed(Throwable throwable) {

    }


    @OnClick({R.id.toolbar_left_button_arl, R.id.btn_get_code, R.id.tv_account_bind})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.toolbar_left_button_arl:
                finish();
                break;
            case R.id.btn_get_code:
                switch (current) {
                    case CHANGEPHONE:
                        getPresenter().sendCode(phone, "4");
                        break;
                    case CONFIRMPHONE:
                        getPresenter().sendCode(phone, "1");
                        break;
                }

                break;
            case R.id.tv_account_bind:

                if (TextUtils.isEmpty(tvTelephone.getText().toString())) {
                    ToastUtils.showMessage(this, "验证码不能为空");
                    return;
                }
                Map<String, String> stringStringMap = MapUtils.CreateQueryMap(this);
                stringStringMap.put("phone", phone);
                stringStringMap.put("code", tvTelephone.getText().toString());

                switch (current) {
                    case CHANGEPHONE:
                        getPresenter().changePhone(stringStringMap);
                        break;
                    case CONFIRMPHONE:
                        stringStringMap.put("type", "1");
                        getPresenter().confimCode(stringStringMap);
                        break;
                }


                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (timer != null) {
            timer.cancel();
        }
        if (task != null) {
            task.cancel();
        }
    }


    @Override
    public void changeSuccess() {
        switch (current) {
            case CHANGEPHONE:
                ToastUtils.showMessage(this, "更换成功");
                finish();
                break;
            case CONFIRMPHONE:
                Bundle bundle = new Bundle();
                bundle.putInt(Constant.PASSTYPE, RESETCHARGEPASSWORD);
                IntentUtils.showIntent(this, ResetChargePasswordActivity.class, bundle);
                break;
        }

    }

    @Override
    public void changeFailed() {
        switch (current) {
            case CHANGEPHONE:
                ToastUtils.showMessage(this, "更换失败，请重新输入");
                break;
            case CONFIRMPHONE:
                ToastUtils.showMessage(this, "验证失败！");
                break;
        }

    }

}
