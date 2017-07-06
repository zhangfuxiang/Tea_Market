package com.delta.smt.ui.Personal.Balance.withDraw;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.delta.commonlibs.utils.ToastUtils;
import com.delta.smt.Constant;
import com.delta.smt.R;
import com.delta.smt.base.BaseActivity;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.ui.Personal.Balance.di.BalanceModule;
import com.delta.smt.ui.Personal.Balance.di.DaggerBalanceComponent;
import com.delta.smt.ui.Personal.Balance.mvp.BalanceContract;
import com.delta.smt.ui.Personal.Balance.mvp.BalancePresenter;
import com.delta.smt.ui.buycar.confirmOrder.InputPasswordBottomDialog;
import com.delta.smt.ui.find.FindToolBar;
import com.delta.smt.utils.MapUtils;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * Created by Fuxiang.Zhang on 2017/4/27.
 */

public class WithdrawActivity extends BaseActivity<BalancePresenter> implements BalanceContract.View {


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
    @BindView(R.id.tv_alipay)
    TextView tvAlipay;
    @BindView(R.id.et_alipay)
    EditText etAlipay;
    @BindView(R.id.tv_alipay_name)
    TextView tvAlipayName;
    @BindView(R.id.et_alipay_name)
    EditText etAlipayName;
    @BindView(R.id.editText)
    EditText editText;
    @BindView(R.id.tv_blance)
    TextView tvBlance;
    @BindView(R.id.tv_all_withdraw)
    TextView tvAllWithdraw;
    @BindView(R.id.bt_pay)
    Button btPay;
    private String blance;
    private String account;
    private String name;

    @Override
    protected void componentInject(AppComponent appComponent) {
        DaggerBalanceComponent.builder().appComponent(appComponent).balanceModule(new BalanceModule(this)).build().inject(this);
//        DaggerOrderDetailComponent.builder()
//                .appComponent(appComponent).
//                (new AccountBindingModule(this)) //请将OrderDetailModule()第一个首字母改为小写
//                .build()
//                .inject(this);
    }

    @Override
    protected void initData() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {

            blance = bundle.getString(Constant.BLANCE);
        }

    }

    @Override
    protected void initView() {
        toolbarTitle.setText("提现");
        toolbarRightButton.setVisibility(View.GONE);
        toolbarLeftButton.setImageResource(R.mipmap.ic_back);
        if (blance != null) {
            tvBlance.setText("账户余额：￥" + blance);
        }

    }


    @Override
    protected int getContentViewId() {
        return R.layout.activity_withdraw_layout;
    }


    @OnClick({R.id.toolbar_left_button_arl, R.id.tv_all_withdraw, R.id.bt_pay})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.toolbar_left_button_arl:
                finish();
                break;
            case R.id.tv_all_withdraw:
                if (blance != null) {
                    withdraw(blance);
                }

                break;
            case R.id.bt_pay:
                String money = editText.getText().toString().trim();

                withdraw(money);
                break;
        }
    }

    private void withdraw(final String money) {
        account = etAlipay.getText().toString().trim();
        name = etAlipayName.getText().toString().trim();

        if (TextUtils.isEmpty(account)) {
            ToastUtils.showMessage(this, "支付宝账号不能为空");
            return;
        }
        if (TextUtils.isEmpty(name)) {
            ToastUtils.showMessage(this, "支付宝姓名不能为空");
            return;
        }
        if (TextUtils.isEmpty(money)) {
            ToastUtils.showMessage(this, "提现金额不能为空");
            return;
        }
        if (Long.valueOf(money) == 0) {
            ToastUtils.showMessage(this, "提现金额不能为0！");
            return;
        }
        if (Long.valueOf(money) > Long.valueOf(blance)) {
            ToastUtils.showMessage(this, "提现金额不能大于账户余额！");
            return;
        }
        InputPasswordBottomDialog dialog = new InputPasswordBottomDialog();
        dialog.setHeight(getWindowManager().getDefaultDisplay().getHeight() * 1250 / 1920);
        dialog.setCancelOutside(true);
        dialog.setDimAmount(0.8f);
        dialog.show(getSupportFragmentManager());
        dialog.setOnSignUpListener(new InputPasswordBottomDialog.OnSignUpListener() {
            @Override
            public void onSignUp(String pwd) {
                Map<String, String> stringObjectMap = MapUtils.CreateQueryMap(WithdrawActivity.this);
                stringObjectMap.put("pay_type", "1");
                stringObjectMap.put("pay_account", account);
                stringObjectMap.put("real_name", name);
                stringObjectMap.put("total", money);
                stringObjectMap.put("paypwd", pwd);
                getPresenter().withdraw(stringObjectMap);
            }
        });
        dialog.setOnDismissListener(new InputPasswordBottomDialog.OnDismissListener() {
            @Override
            public void onDismiss() {
                WithdrawActivity.this.finish();
            }
        });


    }


    @Override
    public void withdrawSuccess() {
        ToastUtils.showMessage(this, "提现申请成功！");
        finish();
    }

    @Override
    public void withdrawFailed() {
        ToastUtils.showMessage(this, "提现失败！");
    }
}
