package com.delta.smt.ui.Personal.AccountBinding;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.delta.smt.R;
import com.delta.smt.base.BaseActivity;
import com.delta.smt.common.CommonBaseAdapter;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.entity.ItemMyorderIn;
import com.delta.smt.ui.Personal.AccountBinding.mvp.AccountBindingContract;
import com.delta.smt.ui.Personal.AccountBinding.mvp.AccountBindingPresenter;
import com.delta.smt.ui.find.FindToolBar;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import me.shaohui.bottomdialog.BottomDialog;


/**
 * Created by Fuxiang.Zhang on 2017/4/27.
 */

public class AccountBindingActivity extends BaseActivity<AccountBindingPresenter> implements AccountBindingContract.View {


    public List<ItemMyorderIn> datas_in = new ArrayList<>();
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
    @BindView(R.id.textView12)
    TextView textView12;
    @BindView(R.id.tv_ali_no)
    TextView tvAliNo;
    @BindView(R.id.bt_ali_change)
    Button btAliChange;
    @BindView(R.id.bt_ali_unbind)
    Button btAliUnbind;
    @BindView(R.id.tv_ali_account)
    TextView tvAliAccount;
    @BindView(R.id.tv_weixin_no)
    TextView tvWeixinNo;
    @BindView(R.id.bt_weixin_change)
    Button btWeixinChange;
    @BindView(R.id.bt_unbind)
    Button btUnbind;
    @BindView(R.id.tv_account)
    TextView tvAccount;
    private CommonBaseAdapter<ItemMyorderIn> mAdapter_in;

    @Override
    protected void componentInject(AppComponent appComponent) {
//        DaggerOrderDetailComponent.builder()
//                .appComponent(appComponent).
//                (new AccountBindingModule(this)) //请将OrderDetailModule()第一个首字母改为小写
//                .build()
//                .inject(this);
    }

    @Override
    protected void initData() {
        datas_in.clear();

        for (int mI = 0; mI < 4; mI++) {
            datas_in.add(new ItemMyorderIn("武夷岩茶ZHP0860-125 2016春茶", 0, 0));
        }
    }

    @Override
    protected void initView() {
        toolbarTitle.setText("向商家付款");
        toolbarRightButton.setVisibility(View.INVISIBLE);
        toolbarLeftButton.setImageResource(R.mipmap.ic_back);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_account_layout;
    }




    @OnClick({R.id.toolbar_left_button, R.id.tv_left_button_name, R.id.toolbar_left_button_arl, R.id.toolbarTitle, R.id.toolbar_right_button, R.id.toolbar_right_button_iv, R.id.toolbar_right_button_iv_arl, R.id.toolbar, R.id.textView12, R.id.tv_ali_no, R.id.bt_ali_change, R.id.bt_ali_unbind, R.id.tv_ali_account, R.id.tv_weixin_no, R.id.bt_weixin_change, R.id.bt_unbind, R.id.tv_account})
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
            case R.id.textView12:
                break;
            case R.id.tv_ali_no:
                break;
            case R.id.bt_ali_change:
                BottomDialog.create(getSupportFragmentManager())
                        .setViewListener(new BottomDialog.ViewListener() {
                            @Override
                            public void bindView(View v) {
                                // // You can do any of the necessary the operation with the view

                            }
                        })
                        .setLayoutRes(R.layout.bottomdialog_unbind)
                        .setDimAmount(0.1f)            // Dialog window dim amount(can change window background color）, range：0 to 1，default is : 0.2f
                        .setCancelOutside(true)     // click the external area whether is closed, default is : true
                        .setTag("BottomDialog")     // setting the DialogFragment tag
                        .show();

                break;
            case R.id.bt_ali_unbind:
                BottomDialog.create(getSupportFragmentManager())
                        .setViewListener(new BottomDialog.ViewListener() {
                            @Override
                            public void bindView(View v) {
                                // // You can do any of the necessary the operation with the view

                            }
                        })
                        .setLayoutRes(R.layout.bottomdialog_unbind)
                        .setDimAmount(0.1f)            // Dialog window dim amount(can change window background color）, range：0 to 1，default is : 0.2f
                        .setCancelOutside(true)     // click the external area whether is closed, default is : true
                        .setTag("BottomDialog")     // setting the DialogFragment tag
                        .show();
                break;
            case R.id.tv_ali_account:
                break;
            case R.id.tv_weixin_no:
                break;
            case R.id.bt_weixin_change:
                break;
            case R.id.bt_unbind:
                break;
            case R.id.tv_account:
                break;
        }
    }
}