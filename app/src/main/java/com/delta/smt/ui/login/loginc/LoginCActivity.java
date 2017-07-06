package com.delta.smt.ui.login.loginc;

import android.content.Intent;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.delta.commonlibs.utils.SpUtil;
import com.delta.commonlibs.utils.ToastUtils;
import com.delta.smt.Constant;
import com.delta.smt.MainActivity;
import com.delta.smt.R;
import com.delta.smt.base.BaseActivity;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.entity.SendCodeResult;
import com.delta.smt.entity.UserCLoginResult;
import com.delta.smt.entity.UserLoginSuccessObject;
import com.delta.smt.ui.find.FindToolBar;
import com.delta.smt.ui.login.UserRulesActivity;
import com.delta.smt.ui.login.loginc.di.DaggerLoginCComponent;
import com.delta.smt.ui.login.loginc.di.LoginCModule;
import com.delta.smt.ui.login.loginc.mvp.LoginCContract;
import com.delta.smt.ui.login.loginc.mvp.LoginCPresenter;
import com.google.gson.Gson;
import com.zhy.autolayout.AutoLinearLayout;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * Created by wushufeng on 2017/5/3.
 */

public class LoginCActivity extends BaseActivity<LoginCPresenter> implements LoginCContract.View {

    @BindView(R.id.toolbar)
    FindToolBar toolBar;
    @BindView(R.id.toolbar_left_button)
    ImageView toolbarLeftButton;
    @BindView(R.id.btn_login)
    AutoLinearLayout btnLogin;
    @BindView(R.id.tv_user_rules)
    TextView tvUserRules;
    @BindView(R.id.btn_get_code)
    TextView btnGetCode;

    Timer timer;
    TimerTask task;
    int total_second = 60;

    @BindView(R.id.phone_number)
    EditText etPhoneNumber;
    @BindView(R.id.verification_code)
    EditText etVerificationCode;
    @BindView(R.id.cb_read)
    CheckBox cbRead;

    @Override
    protected void componentInject(AppComponent appComponent) {
        DaggerLoginCComponent.builder()
                .appComponent(appComponent)
                .loginCModule(new LoginCModule(this)) //请将LoginCModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected void initView() {
        toolBar.setToolbarTitle("用户登录");
        toolBar.setToolbarLeftButton(R.mipmap.start_page_exit);
        etPhoneNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (etPhoneNumber.getText().toString().length() > 0 && etVerificationCode.getText().toString().length() > 0 && cbRead.isChecked()) {
                    btnLogin.setBackgroundResource(R.drawable.btn_login_selector);
                    btnLogin.setEnabled(true);
                } else {
                    btnLogin.setBackgroundResource(R.drawable.login_border);
                    btnLogin.setEnabled(false);
                }
            }
        });

        etVerificationCode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (etPhoneNumber.getText().toString().length() > 0 && etVerificationCode.getText().toString().length() > 0 && cbRead.isChecked()) {
                    btnLogin.setBackgroundResource(R.drawable.btn_login_selector);
                    btnLogin.setEnabled(true);
                } else {
                    btnLogin.setBackgroundResource(R.drawable.login_border);
                    btnLogin.setEnabled(false);
                }
            }
        });

        cbRead.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (etPhoneNumber.getText().toString().length() > 0 && etVerificationCode.getText().toString().length() > 0 && cbRead.isChecked()) {
                    btnLogin.setBackgroundResource(R.drawable.btn_login_selector);
                    btnLogin.setEnabled(true);
                } else {
                    btnLogin.setBackgroundResource(R.drawable.login_border);
                    btnLogin.setEnabled(false);
                }
            }
        });
        btnLogin.setEnabled(false);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_login_c;
    }


    @Override
    public void onSendCodeCSuccess(SendCodeResult sendCodeResult) {
        if (!TextUtils.isEmpty(sendCodeResult.getResult())) {
            ToastUtils.showMessage(LoginCActivity.this, sendCodeResult.getResult());
        }
        btnGetCode.setText(total_second + "s");
        btnGetCode.setEnabled(false);
        btnGetCode.setTextColor(Color.rgb(204, 204, 204));
        timer = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {

                runOnUiThread( new Runnable() {      // UI thread
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
    public void onSendCodeCFailed(SendCodeResult sendCodeResult) {
        if (!TextUtils.isEmpty(sendCodeResult.getApp_msg())) {
            ToastUtils.showMessage(LoginCActivity.this, sendCodeResult.getApp_msg());
        }
    }

    @Override
    public void onSendCodeCFailed(Throwable throwable) {
        if (!TextUtils.isEmpty(throwable.getMessage())) {
            ToastUtils.showMessage(LoginCActivity.this, throwable.getMessage());
        }
    }

    @Override
    public void onLoginCSuccess(UserCLoginResult userCLoginResult) {

        ToastUtils.showMessage(LoginCActivity.this, "登录成功！");

        UserLoginSuccessObject userLoginSuccessObject = new Gson().fromJson(new Gson().toJson(userCLoginResult.getResult()), UserLoginSuccessObject.class);
        SpUtil.SetStringSF(LoginCActivity.this, Constant.TOKEN, userLoginSuccessObject.getToken().getToken());
        startActivity(new Intent(this, MainActivity.class));
        LoginCActivity.this.finish();
    }

    @Override
    public void onLoginCFailed(UserCLoginResult userCLoginResult) {
        ToastUtils.showMessage(LoginCActivity.this, userCLoginResult.getApp_msg());
    }

    @Override
    public void onLoginCFailed(Throwable throwable) {
        ToastUtils.showMessage(LoginCActivity.this, throwable.getMessage());
        Log.i(TAG, "onLoginCFailed: " + throwable.getMessage());
    }

    @OnClick({R.id.toolbar_left_button_arl, R.id.btn_login, R.id.tv_user_rules, R.id.btn_get_code})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.toolbar_left_button_arl:
                this.finish();
                break;
            case R.id.btn_login:
                /*startActivity(new Intent(this, MainActivity.class));
                this.finish();*/
                if (TextUtils.isEmpty(etPhoneNumber.getText().toString())) {
                    ToastUtils.showMessage(LoginCActivity.this, "手机号不能为空！");
                    return;
                }
                if (TextUtils.isEmpty(etVerificationCode.getText().toString())) {
                    ToastUtils.showMessage(LoginCActivity.this, "短信验证码不能为空！");
                    return;
                }
                if (!cbRead.isChecked()) {
                    ToastUtils.showMessage(LoginCActivity.this, "用户服务协议未勾选！");
                    return;
                }
                getPresenter().loginC(etPhoneNumber.getText().toString(), etVerificationCode.getText().toString(), SpUtil.getStringSF(LoginCActivity.this, Constant.MERCHANTID));
                break;
            case R.id.tv_user_rules:
                startActivity(new Intent(this, UserRulesActivity.class));

                break;
            case R.id.btn_get_code:
                if (TextUtils.isEmpty(etPhoneNumber.getText().toString())) {
                    ToastUtils.showMessage(LoginCActivity.this, "手机号不能为空！");
                    return;
                }
                getPresenter().sendCodeC(SpUtil.getStringSF(LoginCActivity.this, Constant.MERCHANTID), etPhoneNumber.getText().toString(), 3 + "");

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
}