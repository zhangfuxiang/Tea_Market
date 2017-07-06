package com.delta.smt.ui.login.reset_password_1;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.delta.commonlibs.utils.IntentUtils;
import com.delta.commonlibs.utils.ToastUtils;
import com.delta.smt.R;
import com.delta.smt.base.BaseActivity;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.entity.SendCodeResult;
import com.delta.smt.ui.find.FindToolBar;
import com.delta.smt.ui.login.reset_password_1.di.DaggerResetPasswordOneComponent;
import com.delta.smt.ui.login.reset_password_1.di.ResetPasswordOneModule;
import com.delta.smt.ui.login.reset_password_1.mvp.ResetPasswordOneConstract;
import com.delta.smt.ui.login.reset_password_1.mvp.ResetPasswordOnePresenter;
import com.delta.smt.ui.login.reset_password_2.ResetPasswordTwoActivity;
import com.zhy.autolayout.AutoLinearLayout;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by wushufeng on 2017/3/16.
 */

public class ResetPasswordOneActivity extends BaseActivity<ResetPasswordOnePresenter> implements ResetPasswordOneConstract.View {

    @BindView(R.id.phone_number)
    EditText phoneNumber;
    @BindView(R.id.verification_code)
    EditText smsCode;
    @BindView(R.id.toolbar)
    FindToolBar toolbar;

    @BindView(R.id.btn_next)
    AutoLinearLayout btnNext;

    @BindView(R.id.btn_get_code)
    TextView btnGetCode;

    Timer timer;
    TimerTask task;
    int total_second = 60;

    //@BindView(R.id.password)


    @Override
    protected void initView() {
        phoneNumber.clearFocus();
        toolbar.setToolbarTitle("验证手机号");
        toolbar.setToolbarLeftButton(R.mipmap.start_page_exit);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void componentInject(AppComponent appComponent) {
        DaggerResetPasswordOneComponent.builder()
                .appComponent(appComponent)
                .resetPasswordOneModule(new ResetPasswordOneModule(this)) //请将StartModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_reset_password_1;
    }

    @OnClick({R.id.toolbar_left_button_arl, R.id.toolbar_right_button, R.id.btn_next, R.id.btn_get_code})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.toolbar_left_button_arl:
                finish();
                break;
            case R.id.toolbar_right_button:
                finish();
                break;
            case R.id.btn_next:
                String phone_number = phoneNumber.getText().toString();
                String sms_code = smsCode.getText().toString();
                if (TextUtils.isEmpty(phone_number)) {
                    ToastUtils.showMessage(ResetPasswordOneActivity.this, "手机号不能为空！");
                    phoneNumber.requestFocus();
                    return;
                }

                if (!isMobilePhone(phone_number)) {
                    ToastUtils.showMessage(ResetPasswordOneActivity.this, "请输入正确格式的手机号码！");
                    phoneNumber.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(sms_code)) {
                    ToastUtils.showMessage(ResetPasswordOneActivity.this, "短信验证码不能为空！");
                    smsCode.requestFocus();
                    return;
                }


                IntentUtils.showIntent(ResetPasswordOneActivity.this, ResetPasswordTwoActivity.class, new String[]{"phone_number", "verication_code"}, new String[]{phone_number, sms_code});
                this.finish();
                break;
            case R.id.btn_get_code:
                String phone_number2 = phoneNumber.getText().toString();

                if (TextUtils.isEmpty(phone_number2)) {
                    ToastUtils.showMessage(ResetPasswordOneActivity.this, "手机号不能为空！");
                    phoneNumber.requestFocus();
                    return;
                }

                if (!isMobilePhone(phone_number2)) {
                    ToastUtils.showMessage(ResetPasswordOneActivity.this, "请输入正确格式的手机号码！");
                    phoneNumber.requestFocus();
                    return;
                }

                long phone_number2_shuzi = Long.parseLong(phone_number2);
                getPresenter().sendCode(phone_number2, "1");

                break;
        }
    }

    public boolean isMobilePhone(String number) {
        String num = "[1]\\d{10}";
        if (TextUtils.isEmpty(number)) {
            return false;
        } else {
            return number.matches(num);
        }
    }

    @Override
    public void sendCodeSuccess(SendCodeResult sendCodeResult) {

        ToastUtils.showMessage(ResetPasswordOneActivity.this, sendCodeResult.getResult());
        phoneNumber.clearFocus();
        smsCode.requestFocus();
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
        ToastUtils.showMessage(ResetPasswordOneActivity.this, sendCodeResult.getResult());
    }

    @Override
    public void sendCodeFailed(Throwable throwable) {
        ToastUtils.showMessage(ResetPasswordOneActivity.this, throwable.getMessage());
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
