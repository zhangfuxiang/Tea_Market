package com.delta.smt.ui.Personal.Balance;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.delta.commonlibs.utils.IntentUtils;
import com.delta.commonlibs.utils.SpUtil;
import com.delta.smt.Constant;
import com.delta.smt.R;
import com.delta.smt.base.BaseActivity;
import com.delta.smt.common.CommonBaseAdapter;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.entity.ItemMyorderIn;
import com.delta.smt.entity.UserInfo;
import com.delta.smt.ui.Personal.Balance.BalanceDetail.BalanceDetailActivity;
import com.delta.smt.ui.Personal.Balance.charge.ChargeActivity;
import com.delta.smt.ui.Personal.Balance.withDraw.WithdrawActivity;
import com.delta.smt.ui.Personal.di.DaggerPresonalComponent;
import com.delta.smt.ui.Personal.di.PresonalModule;
import com.delta.smt.ui.Personal.mvp.PersonalContract;
import com.delta.smt.ui.Personal.mvp.PresonalPresenter;
import com.delta.smt.ui.find.FindToolBar;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

import static com.delta.smt.R.id.tv_shop;


/**
 * Created by Fuxiang.Zhang on 2017/4/27.
 */

public class BalanceActivity extends BaseActivity<PresonalPresenter> implements PersonalContract.View {


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
    @BindView(R.id.iv_shop)
    TextView ivShop;
    @BindView(tv_shop)
    TextView tvShop;
    @BindView(R.id.tv_recharge)
    TextView tvRecharge;
    @BindView(R.id.tv_withdraw)
    TextView tvWithdraw;
    private List<ItemMyorderIn> datas_in = new ArrayList<>();
    private CommonBaseAdapter<ItemMyorderIn> mAdapter_in;
    private String blance;
    private Bundle bundle;
    private String token;
    private String merchant_id;

    @Override
    protected void componentInject(AppComponent appComponent) {
        DaggerPresonalComponent.builder().appComponent(appComponent).presonalModule(new PresonalModule(this)).build().inject(this);
//        DaggerOrderDetailComponent.builder()
//                .appComponent(appComponent).
//                (new AccountBindingModule(this)) //请将OrderDetailModule()第一个首字母改为小写
//                .build()
//                .inject(this);
    }

    @Override
    protected void initData() {
        token = SpUtil.getStringSF(this, Constant.TOKEN);

        merchant_id = SpUtil.getStringSF(this, Constant.MERCHANTID);
        bundle = getIntent().getExtras();
        if (bundle != null) {

            blance = bundle.getString(Constant.BLANCE);
        }

    }

    @Override
    protected void initView() {
        toolbarTitle.setText("余额");
        toolbarRightButton.setText("余额明细");
        toolbarLeftButton.setImageResource(R.mipmap.ic_back);
        if (blance != null) {

        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        getPresenter().getUseInfo(token, merchant_id);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_balance_layout;
    }


    @OnClick({R.id.toolbar_left_button_arl, R.id.tv_recharge, R.id.tv_withdraw, R.id.toolbar_right_button})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.toolbar_left_button_arl:
                finish();
                break;
            case R.id.tv_recharge:

                startActivity(new Intent(this, ChargeActivity.class));

                break;
            case R.id.tv_withdraw:

                if (bundle != null) {
                    IntentUtils.showIntent(this, WithdrawActivity.class, bundle);
                }


                break;
            case R.id.toolbar_right_button:
                startActivity(new Intent(this, BalanceDetailActivity.class));
                break;
        }
    }

    @Override
    public void ShowUserInfoSuccess(UserInfo userInfo) {
        tvShop.setText(userInfo.getResult().getUser().getBalance());
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