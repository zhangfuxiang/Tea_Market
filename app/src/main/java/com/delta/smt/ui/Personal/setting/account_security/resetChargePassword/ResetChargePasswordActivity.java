package com.delta.smt.ui.Personal.setting.account_security.resetChargePassword;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
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
import com.delta.smt.ui.Personal.setting.account_security.AccountActivity;
import com.delta.smt.ui.Personal.setting.account_security.ChangeNewPhoneActivity;
import com.delta.smt.ui.find.FindToolBar;
import com.delta.smt.utils.MapUtils;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

import static com.delta.commonlibs.utils.IntentUtils.showIntent;
import static com.delta.smt.ui.Personal.setting.account_security.ChangeNewPhoneActivity.CONFIRMPHONE;


public class ResetChargePasswordActivity extends BaseActivity<PresonalPresenter> implements PersonalContract.View {


    @BindView(R.id.tv_password_1)
    TextView tvPassword1;
    @BindView(R.id.tv_password_2)
    TextView tvPassword2;
    @BindView(R.id.tv_password_3)
    TextView tvPassword3;
    @BindView(R.id.tv_password_4)
    TextView tvPassword4;
    @BindView(R.id.tv_password_5)
    TextView tvPassword5;
    @BindView(R.id.tv_password_6)
    TextView tvPassword6;
    @BindView(R.id.tv_forget_password)
    TextView tvForgetPassword;
    @BindView(R.id.tv_number_1)
    TextView tvNumber1;
    @BindView(R.id.tv_number_2)
    TextView tvNumber2;
    @BindView(R.id.tv_number_3)
    TextView tvNumber3;
    @BindView(R.id.tv_number_4)
    TextView tvNumber4;
    @BindView(R.id.tv_number_5)
    TextView tvNumber5;
    @BindView(R.id.tv_number_6)
    TextView tvNumber6;
    @BindView(R.id.tv_number_7)
    TextView tvNumber7;
    @BindView(R.id.tv_number_8)
    TextView tvNumber8;
    @BindView(R.id.tv_number_9)
    TextView tvNumber9;
    @BindView(R.id.tv_number_0)
    TextView tvNumber0;
    @BindView(R.id.arl_number_backspace)
    AutoRelativeLayout arlNumberBackspace;
    @BindView(R.id.toolbar_left_button)
    ImageView toolbarLeftButton;
    @BindView(R.id.tv_left_button_name)
    TextView tvLeftButtonName;
    @BindView(R.id.toolbar_left_button_arl)
    AutoRelativeLayout toolbarLeftButtonArl;
    @BindView(R.id.toolbarTitle)
    TextView toolbarTitle;
    @BindView(R.id.toolbar_right_button)
    TextView toolbarRightButton;
    @BindView(R.id.toolbar_right_button_iv)
    ImageView toolbarRightButtonIv;
    @BindView(R.id.toolbar_right_button_iv_arl)
    AutoRelativeLayout toolbarRightButtonIvArl;
    @BindView(R.id.toolbar)
    FindToolBar toolbar;
    public final static int VALIDATECHARGEPASSWORD = 1;
    public final static int MODIFYCHARGEPASSWORD = 2;
    public final static int CONFIRMCHARGEPASSWORD = 3;
    public final static int RESETCHARGEPASSWORD = 4;
    @BindView(R.id.tv_notice)
    TextView tvNotice;


    private int currentType;
    private String firstPassword;
    private String oldPassword;
    private Bundle bundle;
    private Bundle bundle1;
    private String phone;

    @Override
    protected void initView() {

        switch (currentType) {
            case VALIDATECHARGEPASSWORD:
                toolbarTitle.setText("安全验证");
                break;
            case MODIFYCHARGEPASSWORD:
                toolbarTitle.setText("设置新的支付密码");
                oldPassword = bundle1.getString(Constant.OLDPASSWORD);
                tvNotice.setVisibility(View.VISIBLE);
                tvNotice.setText("设置新的支付密码，用于支付验证");
                tvForgetPassword.setVisibility(View.GONE);
                break;
            case CONFIRMCHARGEPASSWORD:
                toolbarTitle.setText("确认支付密码");
                oldPassword = bundle1.getString(Constant.OLDPASSWORD);
                tvNotice.setVisibility(View.VISIBLE);
                tvNotice.setText("再次输入新的支付密码用于确认");
                toolbarTitle.setText("确认支付密码");
                tvForgetPassword.setVisibility(View.GONE);
                break;
            case RESETCHARGEPASSWORD:
                // oldPassword = bundle1.getString(Constant.OLDPASSWORD);
                toolbarTitle.setText("设置支付密码");
                tvNotice.setVisibility(View.VISIBLE);
                tvNotice.setText("设置新的支付密码，用于验证");
                tvForgetPassword.setVisibility(View.GONE);
                break;


        }

        toolbarRightButton.setVisibility(View.INVISIBLE);
        toolbarLeftButton.setImageResource(R.mipmap.ic_back);
    }

    @Override
    protected void initData() {


        Intent intent = getIntent();
        if (intent != null) {
            bundle1 = intent.getExtras();
            if (bundle1 != null) {
                int intExtra = bundle1.getInt(Constant.PASSTYPE, 1);
                firstPassword = bundle1.getString(Constant.PASSWORD);
                currentType = intExtra;
            } else {
                currentType = VALIDATECHARGEPASSWORD;
            }

        } else {
            currentType = VALIDATECHARGEPASSWORD;
        }
        String token = SpUtil.getStringSF(this, Constant.TOKEN);

        String merchant_id = SpUtil.getStringSF(this, Constant.MERCHANTID);
        getPresenter().getUseInfo(token, merchant_id);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_reset_charge_password;
    }

    @Override
    protected void componentInject(AppComponent appComponent) {
        DaggerPresonalComponent.builder().appComponent(appComponent).presonalModule(new PresonalModule(this)).build().inject(this);
    }


//    @OnClick({R.id.iv_close, R.id.tv_password_1, R.id.tv_password_2, R.id.tv_password_3, R.id.tv_password_4, R.id.tv_password_5, R.id.tv_password_6, R.id.tv_forget_password, R.id.tv_number_1, R.id.tv_number_2, R.id.tv_number_3, R.id.tv_number_4, R.id.tv_number_5, R.id.tv_number_6, R.id.tv_number_7, R.id.tv_number_8, R.id.tv_number_9, R.id.tv_number_0, R.id.arl_number_backspace, R.id.tv_forget_password})
//    public void onClick2(View view) {
//        switch (view.getId()) {
//            case R.id.iv_close:
//                finish();
//                break;
//            case R.id.arl_number_backspace:
//                deleteWords();
//                break;
//            case R.id.tv_number_1:
//                inputWords("1");
//                break;
//            case R.id.tv_number_2:
//                inputWords("2");
//                break;
//            case R.id.tv_number_3:
//                inputWords("3");
//                break;
//            case R.id.tv_number_4:
//                inputWords("4");
//                break;
//            case R.id.tv_number_5:
//                inputWords("5");
//                break;
//            case R.id.tv_number_6:
//                inputWords("6");
//                break;
//            case R.id.tv_number_7:
//                inputWords("7");
//                break;
//            case R.id.tv_number_8:
//                inputWords("8");
//                break;
//            case R.id.tv_number_9:
//                inputWords("9");
//                break;
//            case R.id.tv_number_0:
//                inputWords("0");
//                break;
//            case R.id.tv_forget_password:
//                break;
//        }
//    }

    public void deleteWords() {
        if (!TextUtils.isEmpty(tvPassword6.getText().toString())) {
            tvPassword6.setText("");
            return;
        }
        if (!TextUtils.isEmpty(tvPassword5.getText().toString())) {
            tvPassword5.setText("");
            return;
        }
        if (!TextUtils.isEmpty(tvPassword4.getText().toString())) {
            tvPassword4.setText("");
            return;
        }
        if (!TextUtils.isEmpty(tvPassword3.getText().toString())) {
            tvPassword3.setText("");
            return;
        }
        if (!TextUtils.isEmpty(tvPassword2.getText().toString())) {
            tvPassword2.setText("");
            return;
        }
        if (!TextUtils.isEmpty(tvPassword1.getText().toString())) {
            tvPassword1.setText("");
            return;
        }
    }

    public void inputWords(String s) {
        if (TextUtils.isEmpty(tvPassword1.getText().toString())) {
            tvPassword1.setText(s);
            return;
        }
        if (TextUtils.isEmpty(tvPassword2.getText().toString())) {
            tvPassword2.setText(s);
            return;
        }
        if (TextUtils.isEmpty(tvPassword3.getText().toString())) {
            tvPassword3.setText(s);
            return;
        }
        if (TextUtils.isEmpty(tvPassword4.getText().toString())) {
            tvPassword4.setText(s);
            return;
        }
        if (TextUtils.isEmpty(tvPassword5.getText().toString())) {
            tvPassword5.setText(s);
            return;
        }
        if (TextUtils.isEmpty(tvPassword6.getText().toString())) {
            tvPassword6.setText(s);

            String password = tvPassword1.getText().toString() +
                    tvPassword2.getText().toString() +
                    tvPassword3.getText().toString() +
                    tvPassword4.getText().toString() +
                    tvPassword5.getText().toString() +
                    tvPassword6.getText().toString();
            bundle = new Bundle();
            switch (currentType) {
                case VALIDATECHARGEPASSWORD:

                    bundle.putInt(Constant.PASSTYPE, MODIFYCHARGEPASSWORD);

                    // getPresenter().
                    bundle.putString(Constant.OLDPASSWORD, password);
                    Map<String, String> stringStringMap = MapUtils.CreateQueryMap(this);
                    stringStringMap.put("pay_pwd", password);
                    getPresenter().checkPayPwd(stringStringMap);

                    break;
                case MODIFYCHARGEPASSWORD:
                    bundle.putInt(Constant.PASSTYPE, CONFIRMCHARGEPASSWORD);
                    bundle.putString(Constant.OLDPASSWORD, oldPassword);
                    bundle.putString(Constant.PASSWORD, password);
                    showIntent(this, ResetChargePasswordActivity.class, bundle);

                    break;
                case CONFIRMCHARGEPASSWORD:
                    if (password.equals(firstPassword)) {
                        Map<String, String> stringStringMap1 = MapUtils.CreateQueryMap(this);
                        stringStringMap1.put("pay_pwd", password);
                        if(oldPassword!=null){

                            stringStringMap1.put("old_pay_pwd", oldPassword);
                        }
                        getPresenter().modifyChargePassword(stringStringMap1);
                    } else {
                        ToastUtils.showMessage(this, "两次输入密码不一致，请重新输入");
                    }
                    break;
                case RESETCHARGEPASSWORD:
                    //// TODO: 2017/5/20 重置密码
                    Map<String, String> stringStringMap2 = MapUtils.CreateQueryMap(this);
                    stringStringMap2.put("pay_pwd", password);
                    //stringStringMap.put("old_pay_pwd", oldPassword);
                    getPresenter().modifyChargePassword(stringStringMap2);

                    break;

            }


            return;
        }
    }


    @OnClick({R.id.toolbar_left_button, R.id.tv_left_button_name, R.id.toolbar_left_button_arl, R.id.toolbarTitle, R.id.toolbar_right_button, R.id.toolbar_right_button_iv, R.id.toolbar_right_button_iv_arl, R.id.toolbar, R.id.tv_password_1, R.id.tv_password_2, R.id.tv_password_3, R.id.tv_password_4, R.id.tv_password_5, R.id.tv_password_6, R.id.tv_forget_password, R.id.tv_number_1, R.id.tv_number_2, R.id.tv_number_3, R.id.tv_number_4, R.id.tv_number_5, R.id.tv_number_6, R.id.tv_number_7, R.id.tv_number_8, R.id.tv_number_9, R.id.tv_number_0, R.id.arl_number_backspace})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.toolbar_left_button:
                break;
            case R.id.tv_left_button_name:
                break;
            case R.id.toolbar_left_button_arl:
                finish();
                break;
            case R.id.toolbarTitle:
                break;
            case R.id.toolbar_right_button:
                break;
            case R.id.toolbar_right_button_iv:
                break;
            case R.id.toolbar_right_button_iv_arl:
                break;
            case R.id.toolbar:
                break;
            case R.id.arl_number_backspace:
                deleteWords();
                break;
            case R.id.tv_number_1:
                inputWords("1");
                break;
            case R.id.tv_number_2:
                inputWords("2");
                break;
            case R.id.tv_number_3:
                inputWords("3");
                break;
            case R.id.tv_number_4:
                inputWords("4");
                break;
            case R.id.tv_number_5:
                inputWords("5");
                break;
            case R.id.tv_number_6:
                inputWords("6");
                break;
            case R.id.tv_number_7:
                inputWords("7");
                break;
            case R.id.tv_number_8:
                inputWords("8");
                break;
            case R.id.tv_number_9:
                inputWords("9");
                break;
            case R.id.tv_number_0:
                inputWords("0");
                break;
            case R.id.tv_forget_password:

                Bundle bundle = new Bundle();
                bundle.putInt(Constant.CHANGEPHONESTATUE, CONFIRMPHONE);
                if (phone != null) {
                    bundle.putString(Constant.PHONE, phone);
                    IntentUtils.showIntent(this, ChangeNewPhoneActivity.class, bundle);
                }

                break;
        }
    }


    @Override
    public void ShowUserInfoSuccess(UserInfo userInfo) {

        phone = userInfo.getResult().getUser().getPhone();
    }

    @Override
    public void showUserInfoError() {

    }

    @Override
    public void resetPasswordSuccess() {

        ToastUtils.showMessage(this, "重置成功！");
        IntentUtils.showIntent(this, AccountActivity.class);
        //finish();
    }

    @Override
    public void resetPasswordFailed(String app_msg) {
        if (!TextUtils.isEmpty(app_msg)) {

            ToastUtils.showMessage(this, app_msg);
        }
    }

    @Override
    public void checkPasswordSuccess() {
        showIntent(this, ResetChargePasswordActivity.class, bundle);
        finish();
    }

    @Override
    public void checkPasswordFailed(String app_msg) {
        if (!TextUtils.isEmpty(app_msg)) {

            ToastUtils.showMessage(this, app_msg);
        }
    }
}
