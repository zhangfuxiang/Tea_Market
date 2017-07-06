package com.delta.smt.ui.login.login;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.delta.commonlibs.utils.SpUtil;
import com.delta.commonlibs.utils.ToastUtils;
import com.delta.smt.Constant;
import com.delta.smt.MainActivity;
import com.delta.smt.R;
import com.delta.smt.base.BaseActivity;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.entity.UserLoginResult;
import com.delta.smt.ui.login.login.di.DaggerLoginComponent;
import com.delta.smt.ui.login.login.di.LoginModule;
import com.delta.smt.ui.login.login.mvp.LoginContract;
import com.delta.smt.ui.login.login.mvp.LoginPresenter;
import com.delta.smt.ui.login.register.RegisterActivity;
import com.delta.smt.ui.login.reset_password_1.ResetPasswordOneActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @description :
 * @autHor :  V.Wenju.Tian
 * @date : 2016/12/12 16:13
 */


public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.View {


    @BindView(R.id.phone_number)
    EditText et_userPhoneNumber;
    @BindView(R.id.password)
    EditText et_password;
    @BindView(R.id.register)
    TextView register;
    @BindView(R.id.forget_password)
    TextView forgetPassword;

    @Override
    protected void componentInject(AppComponent appComponent) {

        DaggerLoginComponent.builder().appComponent(appComponent).loginModule(new LoginModule(this)).build().inject(this);

    }

    @Override
    protected void initData() {


    }

    @Override
    protected void initView() {
        et_userPhoneNumber.clearFocus();
        et_password.clearFocus();
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_login;
    }


    @OnClick({R.id.btn_login, R.id.register, R.id.forget_password})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                String phone_number = et_userPhoneNumber.getText().toString();
                String password = et_password.getText().toString();
                if (TextUtils.isEmpty(phone_number)) {
                    ToastUtils.showMessage(LoginActivity.this, "手机号码不能为空！");
                    et_userPhoneNumber.requestFocus();
                    return;
                }

                if (!isMobilePhone(phone_number)) {
                    ToastUtils.showMessage(LoginActivity.this, "请输入正确格式的手机号码！");
                    et_userPhoneNumber.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    ToastUtils.showMessage(LoginActivity.this, "登录密码不能为空！");
                    et_password.requestFocus();
                    return;
                }

                getPresenter().login(phone_number, password);


                break;
            case R.id.register:
                startActivity(new Intent(this, RegisterActivity.class));
                break;
            case R.id.forget_password:
                startActivity(new Intent(this, ResetPasswordOneActivity.class));
                break;
        }
    }

    @Override
    public void loginSucess(UserLoginResult userLoginResult) {
        ToastUtils.showMessage(LoginActivity.this, "登录成功！");
        SpUtil.SetStringSF(LoginActivity.this, Constant.TOKEN, userLoginResult.getResult().getToken().getToken());
        Log.i(TAG, "loginSucess: " + userLoginResult.getResult().getToken().getToken());
        Log.i(TAG, "loginSucess: " + userLoginResult.getResult().getMerchant().getId());
        startActivity(new Intent(this, MainActivity.class));
        LoginActivity.this.finish();
    }

    @Override
    public void loginFailed(UserLoginResult userLoginResult) {
        ToastUtils.showMessage(LoginActivity.this, "登录失败！");
    }

    @Override
    public void loginFailed(Throwable throwable) {
        ToastUtils.showMessage(LoginActivity.this, throwable.getMessage());
    }

    public boolean isMobilePhone(String number) {
        String num = "[1]\\d{10}";
        if (TextUtils.isEmpty(number)) {
            return false;
        } else {
            return number.matches(num);
        }
    }

}
