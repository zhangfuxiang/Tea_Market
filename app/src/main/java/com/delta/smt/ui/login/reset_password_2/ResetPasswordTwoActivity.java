package com.delta.smt.ui.login.reset_password_2;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.delta.commonlibs.utils.ToastUtils;
import com.delta.smt.R;
import com.delta.smt.base.BaseActivity;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.entity.ResetPwdResult;
import com.delta.smt.ui.find.FindToolBar;
import com.delta.smt.ui.login.reset_password_2.di.DaggerResetPasswordTwoComponent;
import com.delta.smt.ui.login.reset_password_2.di.ResetPasswordTwoModule;
import com.delta.smt.ui.login.reset_password_2.mvp.ResetPasswordTwoContract;
import com.delta.smt.ui.login.reset_password_2.mvp.ResetPasswordTwoPresenter;
import com.zhy.autolayout.AutoLinearLayout;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * Created by wushufeng on 2017/4/5.
 */

public class ResetPasswordTwoActivity extends BaseActivity<ResetPasswordTwoPresenter> implements ResetPasswordTwoContract.View {

    @BindView(R.id.toolbar)
    FindToolBar toolbar;
    @BindView(R.id.btn_save_code)
    AutoLinearLayout btn_SaveCode;
    @BindView(R.id.et_first_input_code)
    EditText etFirstInputCode;
    @BindView(R.id.et_second_input_code)
    EditText etSecondInputCode;

    String verification_code;
    String phone_number;

    @Override
    protected void componentInject(AppComponent appComponent) {
        DaggerResetPasswordTwoComponent.builder()
                .appComponent(appComponent)
                .resetPasswordTwoModule(new ResetPasswordTwoModule(this)) //请将ResetPasswordTwo2Module()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected void initView() {
        toolbar.setToolbarTitle("重置登录密码");
        toolbar.setToolbarLeftButton(R.mipmap.start_page_exit);

    }

    @Override
    protected void initData() {
        verification_code = getIntent().getStringExtra("verication_code");
        phone_number = getIntent().getStringExtra("phone_number");
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_reset_password_2;
    }


    @Override
    public void onResetPwdSuccess(ResetPwdResult resetPwdResult) {
        ToastUtils.showMessage(ResetPasswordTwoActivity.this, resetPwdResult.getResult());
        etFirstInputCode.clearFocus();
        etSecondInputCode.clearFocus();
        finish();
    }

    @Override
    public void onResetPwdFailed(ResetPwdResult resetPwdResult) {
        ToastUtils.showMessage(ResetPasswordTwoActivity.this, resetPwdResult.getResult());
        etFirstInputCode.clearFocus();
        etSecondInputCode.clearFocus();
    }

    @Override
    public void onResetPwdFailed(Throwable throwable) {
        ToastUtils.showMessage(ResetPasswordTwoActivity.this, throwable.getMessage());
        etFirstInputCode.clearFocus();
        etSecondInputCode.clearFocus();
    }

    @OnClick({R.id.toolbar_left_button_arl, R.id.btn_save_code})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.toolbar_left_button_arl:
                ResetPasswordTwoActivity.this.finish();
                break;
            case R.id.btn_save_code:
                String first_pwd = etFirstInputCode.getText().toString();
                String second_pwd = etSecondInputCode.getText().toString();
                if (TextUtils.isEmpty(first_pwd)) {
                    ToastUtils.showMessage(ResetPasswordTwoActivity.this, "新的密码不能为空！");
                    etFirstInputCode.requestFocus();
                    return;
                }
                if (first_pwd.length() < 6) {
                    ToastUtils.showMessage(ResetPasswordTwoActivity.this, "新的密码不能少于六位！");
                    etFirstInputCode.requestFocus();
                    return;
                }
                if (TextUtils.isEmpty(second_pwd)) {
                    ToastUtils.showMessage(ResetPasswordTwoActivity.this, "再次输入新的密码不能为空！");
                    etSecondInputCode.requestFocus();
                    return;
                }
                if (!first_pwd.equals(second_pwd)) {
                    ToastUtils.showMessage(ResetPasswordTwoActivity.this, "两次输入的密码不一致！");
                    etSecondInputCode.requestFocus();
                    return;
                }

                getPresenter().resetPwd(phone_number, first_pwd, verification_code);

                break;
        }

    }
}