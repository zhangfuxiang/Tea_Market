package com.delta.smt.ui.Personal.PayMerchant;

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
import com.delta.smt.common.CommonBaseAdapter;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.entity.ItemMyorderIn;
import com.delta.smt.entity.MerchantInfo;
import com.delta.smt.ui.Personal.PayMerchant.di.DaggerPayMerchantComponent;
import com.delta.smt.ui.Personal.PayMerchant.di.PayMerchantModule;
import com.delta.smt.ui.Personal.PayMerchant.mvp.PayMerchantContract;
import com.delta.smt.ui.Personal.PayMerchant.mvp.PayMerchantPresenter;
import com.delta.smt.ui.find.FindToolBar;
import com.delta.smt.utils.GlideUtils;
import com.delta.smt.utils.MapUtils;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * Created by Fuxiang.Zhang on 2017/4/27.
 */

public class PayMerchantActivity extends BaseActivity<PayMerchantPresenter> implements PayMerchantContract.View {


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
    ImageView ivShop;
    @BindView(R.id.tv_shop)
    TextView tvShop;
    @BindView(R.id.editText)
    EditText editText;
    @BindView(R.id.bt_pay)
    Button btPay;
    @BindView(R.id.tv_blance)
    TextView tvBlance;
    private List<ItemMyorderIn> datas_in = new ArrayList<>();
    private CommonBaseAdapter<ItemMyorderIn> mAdapter_in;
    private int merchanId;
    private String blanceMoney;

    @Override
    protected void componentInject(AppComponent appComponent) {
//        DaggerOrderDetailComponent.builder()
//                .appComponent(appComponent).
//                (new AccountBindingModule(this)) //请将OrderDetailModule()第一个首字母改为小写
//                .build()
//                .inject(this);
        DaggerPayMerchantComponent.builder().appComponent(appComponent).payMerchantModule(new PayMerchantModule(this)).build().inject(this);
    }

    @Override
    protected void initData() {

        merchanId = getIntent().getIntExtra(Constant.MERCHANTID, -1);
        blanceMoney = getIntent().getStringExtra(Constant.BLANCE);
        Map<String, String> stringStringMap = MapUtils.CreateQueryMap(this);
        stringStringMap.put("pay_merchant_id", String.valueOf(merchanId));
        getPresenter().getMerchantInfo(stringStringMap);
    }

    @Override
    protected void initView() {
        toolbarTitle.setText("向商家付款");
        toolbarRightButton.setVisibility(View.INVISIBLE);
        toolbarLeftButton.setImageResource(R.mipmap.ic_back);


    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_paymerchant_layout;
    }


    @OnClick({R.id.toolbar_left_button, R.id.iv_shop, R.id.tv_shop, R.id.bt_pay})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.toolbar_left_button:
                finish();
                break;
            case R.id.iv_shop:
                break;
            case R.id.tv_shop:
                break;
            case R.id.bt_pay:

                if (TextUtils.isEmpty(editText.getText().toString())) {
                    int money = Integer.valueOf(editText.getText().toString());
                    if (money < Integer.valueOf(blanceMoney)) {
                        ToastUtils.showMessage(this, "余额不足清充值");
                        return;
                    }
                    Map<String, String> stringStringMap = MapUtils.CreateQueryMap(this);
                    stringStringMap.put("pay_merchant_id", String.valueOf(merchanId));
                    stringStringMap.put("pay_type", "3");
                    stringStringMap.put("money",String.valueOf(money));
                    getPresenter().pay(stringStringMap);
                }
                //if(editText)

                break;
        }
    }


    @Override
    public void getMerchantInfoSuccess(MerchantInfo merchantInfo) {

        MerchantInfo.ResultEntity.MerchantEntity merchant = merchantInfo.getResult().getMerchant();
        String shop_title = merchant.getShop_title();

        tvShop.setText(shop_title);
        tvBlance.setText("账户余额：￥"+blanceMoney);
        GlideUtils.loadImageView(this,merchant.getImage_url(),ivShop);

    }

    @Override
    public void getMerchantInfoFailed() {


    }

}