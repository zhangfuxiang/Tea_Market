package com.delta.smt.ui.login.register;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.delta.commonlibs.utils.ToastUtils;
import com.delta.smt.Constant;
import com.delta.smt.R;
import com.delta.smt.base.BaseActivity;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.entity.RegisterResult;
import com.delta.smt.ui.find.FindToolBar;
import com.delta.smt.ui.login.register.di.DaggerRegisterComponent;
import com.delta.smt.ui.login.register.di.RegisterModule;
import com.delta.smt.ui.login.register.mvp.RegisterContract;
import com.delta.smt.ui.login.register.mvp.RegisterPresenter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by wushufeng on 2017/3/16.
 */

public class RegisterActivity extends BaseActivity<RegisterPresenter> implements RegisterContract.View {

    @BindView(R.id.toolbar)
    FindToolBar toolbar;

    @BindView(R.id.et_your_shop_name)
    EditText etYourShopName;
    @BindView(R.id.et_your_shop_address)
    EditText etYourShopAddress;
    @BindView(R.id.et_your_shop_owner_name)
    EditText etYourShopOwnerName;
    @BindView(R.id.et_your_shop_owner_phone)
    EditText etYourShopOwnerPhone;



    @Override
    protected void initView() {
        toolbar.setToolbarTitle("注册申请");
        toolbar.setToolbarLeftButton(R.mipmap.start_page_exit);
        toolbar.setToolbarRightButton("提交");
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void componentInject(AppComponent appComponent) {
        DaggerRegisterComponent.builder()
                .appComponent(appComponent)
                .registerModule(new RegisterModule(this)) //请将StartModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_login_register_test;
    }

    @OnClick({R.id.toolbar_left_button_arl, R.id.toolbar_right_button})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.toolbar_left_button_arl:

                finish();
                break;
            case R.id.toolbar_right_button:

                String shop_name = etYourShopName.getText().toString();
                String shop_password = etYourShopAddress.getText().toString();
                String shop_owner_name = etYourShopOwnerName.getText().toString();
                String shop_owner_phone = etYourShopOwnerPhone.getText().toString();
                if (TextUtils.isEmpty(shop_name)) {
                    ToastUtils.showMessage(RegisterActivity.this, "您的店铺名不能为空！");
                    etYourShopName.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(shop_password)) {
                    ToastUtils.showMessage(RegisterActivity.this, "密码不能为空！");
                    etYourShopAddress.requestFocus();
                    return;
                }

                if (shop_password.length() < 6) {
                    ToastUtils.showMessage(RegisterActivity.this, "密码不能少于六位！");
                    etYourShopAddress.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(shop_owner_name)) {
                    ToastUtils.showMessage(RegisterActivity.this, "联系人姓名不能为空！");
                    etYourShopOwnerName.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(shop_owner_phone)) {
                    ToastUtils.showMessage(RegisterActivity.this, "联系人电话不能为空！");
                    etYourShopOwnerName.requestFocus();
                    return;
                }

                if (!isMobilePhone(shop_owner_phone)) {
                    ToastUtils.showMessage(RegisterActivity.this, "请输入正确格式的手机号码！");
                    etYourShopOwnerPhone.requestFocus();
                    return;
                }
                Log.i(TAG, "onClick: " + Constant.CLIENT + " " + Constant.CLIENT_VERSION + " " + Constant.OS + " " + Constant.OS_TOKEN);
                getPresenter().register(Constant.CLIENT,
                        Constant.CLIENT_VERSION,
                        Constant.OS,
                        Constant.OS_TOKEN,
                        Constant.API_VERSION,
                        shop_name,
                        shop_owner_phone,
                        shop_password,
                        shop_owner_name);

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
    public void registerSucess(RegisterResult registerResult) {
        ToastUtils.showMessage(getApplication(), "注册成功！");
        finish();
    }

    @Override
    public void registerFailed(RegisterResult registerResult) {
        ToastUtils.showMessage(RegisterActivity.this, registerResult.getApp_msg());
    }

    @Override
    public void registerFailed(Throwable throwable) {

    }

}
